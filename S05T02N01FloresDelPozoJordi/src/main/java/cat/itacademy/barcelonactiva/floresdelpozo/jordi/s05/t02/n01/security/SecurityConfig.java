package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf ->
					csrf.disable())
				.authorizeHttpRequests(authRequest ->
					authRequest
					.requestMatchers(
						"/players/login",
						"/players"
						)
					.permitAll()
					.requestMatchers(
							"/dicegame/playerLogin",
							"/dicegame/newPlayer",
							"/dicegame/login",
							"/dicegame/create-player",
							"/dicegame/player",
							"/dicegame/createGame")
					.permitAll()
					.anyRequest().authenticated())
				.sessionManagement(sessionManager ->
					sessionManager
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
}