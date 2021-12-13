package com.chint.supervisorycontrol.vo.workorderVO;

import com.chint.supervisorycontrol.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


/**
 * @author zhouying3
 */
@Getter
@Setter
@ToString
public class RemoveWorkOrderVO extends BaseVO {
    /**
     * 工单ID
     */
    @ApiModelProperty(value = "工单ID",example = "1")
    @Min(value = 2,message = "工单ID>2")
    private Long workerOrderId;


    @ApiModelProperty(value = "名字",example = "名字")
    @NotBlank(message = "名字NOTNULL")
    private String name;
}
