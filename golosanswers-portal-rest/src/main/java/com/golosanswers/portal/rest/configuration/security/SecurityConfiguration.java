package com.golosanswers.portal.rest.configuration.security;

import com.golosanswers.portal.RestNavigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UnauthorizedEntryPoint unauthorizedEntryPoint;

	@Autowired
	private TokenComponent tokenComponent;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Value("${spring.security.origins.allow}")
	private String allowOrigins;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {

		builder.authenticationProvider(authenticationProvider);
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManager();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry
					.addMapping(RestNavigation.ALL_PATTERN_EXT)
					.allowedHeaders("*")
					.allowCredentials(false)
					.allowedOrigins(allowOrigins);
			}
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new GolosanswersPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/* For disabling jwt-token authorization*/
		http.csrf().disable().authorizeRequests().anyRequest().permitAll();
		/*http
			.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint)
			.and()
				.authorizeRequests()
					.antMatchers(RestNavigation.AUTHENTICATE).permitAll()
					.antMatchers(RestNavigation.HEALTH + RestNavigation.ALL_PATTERN_EXT).permitAll()
					.antMatchers(HttpMethod.OPTIONS, RestNavigation.ALL_PATTERN_EXT).permitAll()
					.antMatchers(HttpMethod.GET, RestNavigation.ALL_PATTERN_EXT).permitAll()
					.anyRequest().authenticated()
			.and()
				.addFilterBefore(new TokenAuthenticationFilter(tokenComponent, userDetailsService), UsernamePasswordAuthenticationFilter.class);*/
	}

	@Override
	public void configure(WebSecurity web) throws Exception {

		web
			.ignoring()
				.antMatchers(RestNavigation.AUTHENTICATE);
	}
}
