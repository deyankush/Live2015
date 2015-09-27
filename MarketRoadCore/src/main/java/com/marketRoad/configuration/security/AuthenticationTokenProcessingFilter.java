package com.marketRoad.configuration.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;


public class AuthenticationTokenProcessingFilter  extends GenericFilterBean {
	public static final String auth_token = "X-AUTH-TOKEN";
	static final Logger logger = Logger.getLogger(AuthenticationTokenProcessingFilter.class);
	
	@Autowired
	private final TokenAuthenticationService tokenAuthenticationService;
	
	protected AuthenticationTokenProcessingFilter(TokenAuthenticationService taService) {
		this.tokenAuthenticationService = taService;
	}
	
	 public void doFilter(ServletRequest request, ServletResponse response,
	            FilterChain chain) throws IOException, ServletException {
		 	HttpServletRequest req = (HttpServletRequest)request;
		 	Authentication auth = tokenAuthenticationService.getAuthentication(req);
            SecurityContextHolder.getContext().setAuthentication(
            		auth);
            
            //TODO: Remove all this Token found and not valid token code. Just authenticate token and take it forward.
	        String tok = req.getHeader(AuthenticationTokenProcessingFilter.auth_token);
	       
	        if (!tok.isEmpty()) {
	            String strToken = tok; // grab the first "token" parameter
	            System.out.println("Token: " + strToken);
	            HttpServletResponse resp = (HttpServletResponse)response;	            
	            
	            
	            if ((auth != null) && (auth.isAuthenticated())) {
	            	System.out.println("valid token found");
	                resp.setHeader(this.auth_token, strToken);
	             // continue thru the filter chain
	    	        chain.doFilter(request, response);
	            }else{
	            	System.out.println("invalid token");
	            }
	        } else {
	        	System.out.println("no token found");
	        }
	     	     	        
	 }
}
