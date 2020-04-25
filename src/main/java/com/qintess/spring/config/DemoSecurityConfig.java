//package com.qintess.spring.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//
//@Configuration
//@EnableWebSecurity
//public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private DataSource dataSource;
//	
//	@Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//            .ignoring()
//            .antMatchers("/h2-console/**");
//    }
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.authorizeRequests()
////		.antMatchers("/").hasRole("EMPLOYEE")
////		.antMatchers("/leaders/**").hasRole("ADM")
////		.antMatchers("/bosses/**").hasRole("BOSS")
////		.and().formLogin()
////		.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll()
////		.and().logout().permitAll();
////	}
//
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		
//		auth.inMemoryAuthentication().withUser(users.username("John").password("123").roles("EMPLOYEE"))
//		.withUser(users.username("Buia").password("321").roles("EMPLOYEE","ADM"))
//		.withUser(users.username("Ruasaasa").password("132").roles("BOSS"));
//		
//	}
//
//}
