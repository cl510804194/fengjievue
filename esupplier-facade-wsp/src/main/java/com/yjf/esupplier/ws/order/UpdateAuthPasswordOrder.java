package com.yjf.esupplier.ws.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;

import java.util.Date;

public class UpdateAuthPasswordOrder extends ValidateOrderBase implements Order {
    private static final long serialVersionUID = -178649406303962968L;
    private String password;
    private String newPassword;
    private String newPassword2;
    private String isSetOne;
    private String isSetTwo;
    private String type;

    private String userBaseId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    public String getIsSetOne() {
        return isSetOne;
    }

    public void setIsSetOne(String isSetOne) {
        this.isSetOne = isSetOne;
    }

    public String getIsSetTwo() {
        return isSetTwo;
    }

    public void setIsSetTwo(String isSetTwo) {
        this.isSetTwo = isSetTwo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserBaseId() {
        return userBaseId;
    }

    public void setUserBaseId(String userBaseId) {
        this.userBaseId = userBaseId;
    }
}
