package com.xiaobai.rpass.rememberpass.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Administrator on 2018/4/13.
 */
@Table(name = "Remember ")
public class Remember extends Model {
    @Column
    private String username;
    @Column
    private String password;


    public Remember(){
        super();
    }
    public Remember(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
