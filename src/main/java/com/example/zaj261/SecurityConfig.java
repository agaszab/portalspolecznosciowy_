package com.example.zaj261;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
   private DataSource dataSource;

    /*    @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
        } */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/rejestracja").permitAll()
                .antMatchers("/meet.jpg").permitAll()
                .antMatchers("/bg1.jpg").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/koduj").permitAll()
                .antMatchers("/kontakt").permitAll()
                .antMatchers("/wszyscy/*").permitAll()
                .antMatchers("/panel/*").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/");


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from user where username=?")
                .authoritiesByUsernameQuery("select username, role from user_role where username=?");

//        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("123").roles("ADMIN").build();
//        auth.inMemoryAuthentication().withUser(user);
    }
   /* @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
        UserDetails user = User.withDefaultPasswordEncoder().username ("user").password("123").roles("ADMIN").build();
        auth.inMemoryAuthentication().withUser(user);
    } */
}



