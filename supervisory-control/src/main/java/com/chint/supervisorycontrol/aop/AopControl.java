package com.chint.supervisorycontrol.aop;

import com.alibaba.fastjson.JSONObject;
import com.chint.supervisorycontrol.config.TokenConfig;
import com.chint.supervisorycontrol.constants.CommonConstants;
import com.chint.supervisorycontrol.constants.ResponseConstants;
import com.chint.supervisorycontrol.constants.ResponseMessage;
import com.chint.supervisorycontrol.exception.GlobalException;
import com.chint.supervisorycontrol.vo.BaseVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhouying3
 */
@Aspect
@Component
@AllArgsConstructor
public class AopControl {
    private final TokenConfig tokenConfig;

    @Around("execution(* com.chint.supervisorycontrol.controller.*.*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            throw new GlobalException(ResponseConstants.ERROR_CODE, ResponseConstants.NETWORK_ERROR_MESSAGE);
        }
        Object[] args = point.getArgs();
        //校验参数问题返回
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (!result.hasErrors()) {
                    break;
                }
                List<ObjectError> allErrors = result.getAllErrors();
                List<String> collect = allErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
                return ResponseMessage.fail(collect.toString());
            }
        }
        HttpServletRequest request = attributes.getRequest();
        //请求url 是login的时候不拦截
        String requestUrl = request.getRequestURL().toString();
        if (!requestUrl.contains(CommonConstants.LOGIN)) {
            //其余接口 获取token 并验证
            String token = request.getHeader(CommonConstants.TOKEN_HEADER_VALUE);
            if (StringUtils.isEmpty(token)) {
                return ResponseMessage.instance(ResponseConstants.INCORRECT_TOKEN_CODE, ResponseConstants.INCORRECT_TOKEN_MESSAGE);
            }
            //redis获取用户缓存数据
            JSONObject jsonObject = tokenConfig.getUserIdByToken(token);
            if (jsonObject == null) {
                return ResponseMessage.instance(ResponseConstants.INCORRECT_TOKEN_CODE, ResponseConstants.INCORRECT_TOKEN_MESSAGE);
            }
            for (Object arg : args) {
                if (arg instanceof BaseVO) {
                    BaseVO baseVO = (BaseVO) arg;
                    baseVO.setUserId(jsonObject.getLongValue("userId"));
                    baseVO.setUserType(jsonObject.getInteger("userType"));
                    baseVO.setAccountType(jsonObject.getInteger("accountType"));
//                    baseVO.setRelatedIds(jsonObject.getJSONArray("relatedUsers").toJavaList(Long.class));
                    break;
                }
            }
            //操作日志
        }
        return point.proceed(args);
    }
}
