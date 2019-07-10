package edu.mum.cs544.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //PA1: 4
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()


                .withUser("admin").password("{noop}admin").roles("ADMIN").and()
                .withUser("user").password("{noop}user").roles("USER");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login", "/logout").permitAll()
                .antMatchers("/books/add","/books/update/*","/books/delete").hasRole("ADMIN")
                .anyRequest().authenticated() //all other urls can be access by any authenticated role
                .and()
                .formLogin() //enable form login instead of basic login
                //.loginPage("/login")
                //.failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .and().csrf().disable();//Can not addnew or update using plain html form


    }

}
