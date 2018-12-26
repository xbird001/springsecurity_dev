package com.xbird.security.core.properties;

/**
 * 登录成功响应类型
 */
public enum LoginResponseType {

    /**
     * 登录成功后返回JSON
     */
    JSON,
    /**
     * 登录成功后按照默认的方式进行跳转(即按照之前拦截的url进行跳转)
     */
    REDIRECT;
}
