package springboot.sample.domain;

import java.io.Serializable;

public class Member implements Serializable {
    private static final long serialVersionUID = -6386339813125021373L;

    private String userId;
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
