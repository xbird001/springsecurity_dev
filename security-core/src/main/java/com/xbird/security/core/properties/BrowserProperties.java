package com.xbird.security.core.properties;

public class BrowserProperties {

    /**
     * 默认登录页面
     */
    private String loginpage = "/login.html";
    /**
     * 默认登录请求地址
     */
    private String loginurl = "/authentication/require";
    /**
     * 默认登录验证地址
     */
    private String loginprocess = "/authentication/form";
    /**
     * 默认跳转类型为JSON
     */
    private LoginResponseType loginResponseType = LoginResponseType.JSON;

    public String getLoginpage() {
        return loginpage;
    }

    public void setLoginpage(String loginpage) {
        this.loginpage = loginpage;
    }

    public String getLoginurl() {
        return loginurl;
    }

    public void setLoginurl(String loginurl) {
        this.loginurl = loginurl;
    }

    public String getLoginprocess() {
        return loginprocess;
    }

    public void setLoginprocess(String loginprocess) {
        this.loginprocess = loginprocess;
    }

    public LoginResponseType getLoginResponseType() {
        return loginResponseType;
    }

    public void setLoginResponseType(LoginResponseType loginResponseType) {
        this.loginResponseType = loginResponseType;
    }
}
