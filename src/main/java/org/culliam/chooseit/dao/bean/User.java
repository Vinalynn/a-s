package org.culliam.chooseit.dao.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-2-26
 * Time: ÉÏÎç10:53
 */
public class User {
    private BigDecimal userId;
    private String email;
    private String password;
    private int state;
    private Timestamp create_date;
    private int sexType;

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getCreateDate() {
        return create_date;
    }

    public void setCreateDate(Timestamp create_date) {
        this.create_date = create_date;
    }

    public int getSexType() {
        return sexType;
    }

    public void setSexType(int sexType) {
        this.sexType = sexType;
    }
}
