package com.spacefox.frida.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private final String[] resources = {"/res/**", "/css/**", "/js/**", "/img/**"};
    private final String[] freeAccessPages = {"/", "/trampolineHalls", "/discounts", "/contacts"};

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(resources);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
// todo убрать
//                .and().formLogin().defaultSuccessUrl("/", false)

                .antMatchers(freeAccessPages).permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/recordsManagement/**").hasRole("EMPLOYEE")
                .antMatchers("/recordsManagement/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login").failureUrl("/login?error=true")
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                    .permitAll();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("select login, password, active from jh_user where login=?")
//                .authoritiesByUsernameQuery(
////                        "select u.login, r.roles from jh_user u inner join user_roles r on u.publicid = r.user_id where u.login=?");
//                        "select u.login, u.role from jh_user u where u.login=?");
//    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("us").password("1").roles("GUEST");
//        auth.inMemoryAuthentication().withUser("odmen").password("1").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("emp").password("1").roles("EMPLOYEE");
//    }

        @Bean
        public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("us").password("1").roles("GUEST").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("odmen").password("1").roles("ADMIN").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("emp").password("1").roles("EMPLOYEE").build());
        return manager;
    }

}
