package springboot.sample.domain;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;

public class Member implements Serializable {
    private static final long serialVersionUID = -6386339813125021373L;

    @ApiModelProperty(value = "사용자 아이디")
    private String userId;
    @ApiModelProperty(value = "사용자 이름")
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
