package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private long expirationTime;
	
	public String getToken(UserDetails player) {
		return getToken(new HashMap<>(), player);
	}
	
	private String getToken(Map<String, Object> extraClaims, UserDetails player) {
		Date now = new Date(System.currentTimeMillis());
		Date expirationDate = new Date(now.getTime() + expirationTime);
		return Jwts
				.builder()
				.setSubject(player.getUsername())
				.setIssuedAt(now)
				.setExpiration(expirationDate)
				.signWith(getKey(), SignatureAlgorithm.HS256)
				.compact();
				
	}
	
	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public String getUsernameFromToken(String token) {
		return getClaim(token, Claims::getSubject);
	}
	
	private Claims getAllClaims(String token) {
		return Jwts
			.parserBuilder()
			.setSigningKey(getKey())
			.build()
			.parseClaimsJws(token)
			.getBody();	
	}
	
	public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
		Claims claims = getAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Date getExpiration(String token) {
		return getClaim(token, Claims::getExpiration);
	}
	
	private boolean isTokenExpired(String token) {
		return getExpiration(token).before(new Date());
	}
}