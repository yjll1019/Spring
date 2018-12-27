package net.skhu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.skhu.service.MyAuthenticationProvider;

//Spring Security 설정을 위한 config 클래스 
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired MyAuthenticationProvider myAuthenticationProvider;
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/res/**"); // /res/** 패턴의 url은 보안검사 무시
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/admin/**").access("ROLE_ADMIN")
		.antMatchers("/professor/**").access("ROLE_PROFESSOR")
		.antMatchers("/guest/**").permitAll() // /guest/**패턴의 url은 모든 사용자에게 허용된다.
		.antMatchers("/").permitAll()
		.antMatchers("/**").authenticated(); // /** 패턴의 url은 로그인된 사용자에게만 허용된다.
		
		http.csrf().disable(); //csrf 공격 검사를 하지 않겠다.
		
		http.formLogin().loginPage("/guest/login")
		.loginProcessingUrl("/guest/login/processing")
		.failureUrl("/guest/login?error")
		.defaultSuccessUrl("/user/index", true)
		.usernameParameter("loginId")
		.passwordParameter("passwd");
		
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout_processing"))
		.invalidateHttpSession(true);
		
		http.authenticationProvider(myAuthenticationProvider);
	}
}
