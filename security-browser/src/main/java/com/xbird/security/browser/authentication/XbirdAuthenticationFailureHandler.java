package com.xbird.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xbird.security.core.properties.LoginResponseType;
import com.xbird.security.core.properties.SecurityPerproties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("xbirdAuthenticationFailureHandler")
public class XbirdAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityPerproties securitProperties;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if(LoginResponseType.JSON.equals(securitProperties.getBrowserProperties().getLoginResponseType())) {
            //直接返回没有授权登陆
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json;chartset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(exception));
        } else {
            super.onAuthenticationFailure(request,response,exception);
        }
    }
}
