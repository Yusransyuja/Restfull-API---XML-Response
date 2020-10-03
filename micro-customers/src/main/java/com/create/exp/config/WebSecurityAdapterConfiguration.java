package com.create.exp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityAdapterConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	public WebSecurityConfig webSecurityConfig;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
//         	.authorizeRequests().anyRequest().permitAll();
        	.authorizeRequests().anyRequest().authenticated()
        	.and()
        	.httpBasic();
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication()
            .withUser(webSecurityConfig.getBasicAuthUserName())
            .password("{noop}" + webSecurityConfig.getBasicAuthPassword())
            .roles("APPS");
    }

}
