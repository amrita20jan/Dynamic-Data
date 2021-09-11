package com.dynamic.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dynamic.data.security.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConnfigure extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService myUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//http.csrf().disable();
		auth.userDetailsService(myUserDetailsService);
		
	}

	
	  @Bean public PasswordEncoder passwordEncoder() 
	  { 
		  return NoOpPasswordEncoder.getInstance();
		  
	  }
	 
	
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
 
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		//httpSecurity.requiresChannel().antMatchers("/secure*").requiresSecure();
		  httpSecurity.requiresChannel().antMatchers("/secure/**").requiresSecure()
		  .and().httpBasic().and().csrf().disable().
		  exceptionHandling().and().sessionManagement()
		  .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
