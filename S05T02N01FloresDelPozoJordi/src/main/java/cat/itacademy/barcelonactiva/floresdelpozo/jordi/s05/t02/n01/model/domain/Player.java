package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "players", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Player implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pk_PlayerID;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "registration_date", columnDefinition = "DATE")
	private LocalDate registrationDate;
	
	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Game> games = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;

	public Player() {
		
	}
	
	public Player(int pk_PlayerID, String username, String password, LocalDate registrationDate, List<Game> games,
			Role role) {
		this.pk_PlayerID = pk_PlayerID;
		this.username = username;
		this.password = password;
		this.registrationDate = registrationDate;
		this.games = games;
		this.role = role;
	}

	public int getPk_PlayerID() {
		return pk_PlayerID;
	}

	public void setPk_PlayerID(int pk_PlayerID) {
		this.pk_PlayerID = pk_PlayerID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String playerName) {
		this.username = playerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Player [pk_PlayerID=" + pk_PlayerID + ", username=" + username + ", password=" + password
				+ ", registrationDate=" + registrationDate + ", games=" + games + ", role=" + role + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}