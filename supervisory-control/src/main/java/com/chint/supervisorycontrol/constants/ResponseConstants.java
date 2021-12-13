package com.chint.supervisorycontrol.constants;

/**
 * @author zhouying3
 * 返回状态信息常量
 */
public interface ResponseConstants {
    int SUCCESS_CODE = 200;
    String SUCCESS_MESSAGE = "操作成功";

    int LOGIN_NOT_CODE = 401;
    String LOGIN_NOT_MESSAGE = "用户未登录";

    int LOGIN_OTHER_CODE = 409;
    String LOGIN_OTHER_MESSAGE = "用户在其他地区登录";

    int LOGIN_UNAUTHORIZED_CODE = 403;
    String LOGIN_UNAUTHORIZED_MESSAGE = "没有权限访问，或者登录信息失效";

    int REQUEST_REPEAT_CODE = 499;
    String REQUEST_REPEAT_MESSAGE = "重复请求";

    int ERROR_CODE = 500;
    String ERROR_MESSAGE = "操作错误";

    int VALIDATE_ERROR_CODE = 510;
    String VALIDATE_ERROR_MESSAGE = "校验未通过";

    int FAIL_CODE = 511;
    String FAIL_MESSAGE = "操作失败";

    int LOGIN_IDENTIFYING_CODE = 512;
    String LOGIN_IDENTIFYING_MESSAGE = "验证码错误";

    int LOGIN_FAIL_CODE = 513;
    String LOGIN_FAIL_MESSAGE = "登录失败";

    int INCORRECT_USERNAME_OR_PASSWORD_CODE = 514;
    String INCORRECT_USERNAME_OR_PASSWORD_MESSAGE = "用户名 或 密码错误";

    int INCORRECT_TOKEN_CODE = 50014;
    String INCORRECT_TOKEN_MESSAGE = "登录失效";

    int INCORRECT_USER = 516;
    String INCORRECT_USER_MESSAGE = "无效用户";

    String GET_SUCCESS_MESSAGE = "获取成功";
    String GET_FAIL_MESSAGE = "获取失败";
    String ADD_SUCCESS_MESSAGE = "新增成功";
    String ADD_FAIL_MESSAGE = "新增失败";
    String UPDATE_SUCCESS_MESSAGE = "更新成功";
    String UPDATE_FAIL_MESSAGE = "更新失败";
    String DELETE_SUCCESS_MESSAGE = "删除成功";
    String DELETE_FAIL_MESSAGE = "删除成功";
    String NETWORK_ERROR_MESSAGE = "网络错误";
    String DUPLICATE_NAME_MESSAGE = "名字重复";
    String DUPLICATE_ROLE_NAME_MESSAGE = "角色名字重复";
    String DUPLICATE_EMAIL_OR_COMPANY_NAME_MESSAGE = "公司名或者邮箱重复";
    String WEEK_PASSWORD_MESSAGE = "弱密码";
    String NONE_RELATED_USERS = "没有查询到关联用户";
    String NONE_OPERATION_RIGHT = "没有操作权限";
    String UNABLE_DELETE_BIND_ROLE = "已绑定角色无法删除";

}