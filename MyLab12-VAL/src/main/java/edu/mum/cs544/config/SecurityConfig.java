package edu.mum.cs544.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@ComponentScan("edu.mum.cs544")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .usersByUsernameQuery("select username, password, 1 from user where username=?")
                .authoritiesByUsernameQuery("select u.username, r.name from user u inner join user_authority ur on(u.id=ur.user_id) inner join authority r on(ur.authority_id=r.id) where u.username=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());

        /*
        //PA1: 4
        auth.inMemoryAuthentication()


                .withUser("admin").password("{noop}admin").roles("ADMIN").and()
                .withUser("user").password("{noop}user").roles("USER");

         */


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login", "/logout","/mylogin").permitAll()
                .antMatchers("/books/add","/books/update/*","/books/delete").hasRole("ADMIN")
                .anyRequest().authenticated() //all other urls can be access by any authenticated role
                .and()
                .formLogin() //enable form login instead of basic login
                .loginPage("/login")
                //by default
                //.failureUrl("/login?error=true")

                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutUrl("/logout")
                //by default
                // .logoutSuccessUrl("/login")
                .logoutSuccessUrl("/login")
                .and().csrf().disable();//Can not addnew or update using plain html form


    }

}
