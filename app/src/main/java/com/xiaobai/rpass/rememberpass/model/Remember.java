package com.xiaobai.rpass.rememberpass.model;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/13.
 */
@Table(name = "Remember ",id = "ID")
public class Remember extends Model implements Serializable {



    @Column
    private String useThis;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String remake;
    @Column
    private  String rememberTime;

    public String getRememberTime() {

        return rememberTime;
    }

    public void setRememberTime(String rememberTime) {
        this.rememberTime = rememberTime;
    }

    public Remember(){
        super();
    }
    public Remember(String useThis,String username, String password,String remake,String rememberTime) {
        this.username = username;
        this.password = password;
        this.remake=remake;
        this.useThis=useThis;
        this.rememberTime=rememberTime;
    }
    public String getRemake() {

        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }



    public String getPassword() {

        return password;
    }
    public String getUseThis() {
        return useThis;
    }

    public void setUseThis(String useThis) {
        this.useThis = useThis;
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
    public static boolean deleteById(Long id){

       Remember.delete(Remember.class,id);
        return  true;
    }
}
