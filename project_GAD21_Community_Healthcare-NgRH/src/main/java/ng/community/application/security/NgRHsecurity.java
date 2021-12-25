package ng.community.application.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ng.community.application.configuration.Authentication_Service;



@Configuration
@EnableWebSecurity
public class NgRHsecurity extends WebSecurityConfigurerAdapter{
	private Boolean typeuser=false;
	@Autowired
	private DataSource datasource;
	
	@Bean
	public UserDetailsService userdetailservice() {
		return new Authentication_Service();
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
			
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationprovider() {
		DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider();
		
			authprovider.setUserDetailsService(userdetailservice());
			
		
		authprovider.setPasswordEncoder(passwordEncoder());
		return authprovider;
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationprovider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/api/registration","/api/consultation","/","/favicon.ico","/main.c737c403cf9edf86.js","/index.html","/polyfills.d1cd7a0f6edbaaab.js","/runtime.31ad056e5e0c3459.js","/scripts.d5c2dc4f591b00f0.js","/styles.3fbfbacd888bf7f7.css").permitAll()
			.anyRequest()
			.authenticated();
			
			
			
	}

}
