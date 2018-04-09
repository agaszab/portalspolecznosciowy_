package com.example.zaj261;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    } */
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/login").permitAll().
                    anyRequest().authenticated().and()
                    .formLogin()
                        .loginPage("/login")
    .and()
    .csrf().disable();
}
    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        UserDetails user = User.withDefaultPasswordEncoder().username ("user").password("123").roles("USER").build();
        auth.inMemoryAuthentication().withUser(user);
    }
}
