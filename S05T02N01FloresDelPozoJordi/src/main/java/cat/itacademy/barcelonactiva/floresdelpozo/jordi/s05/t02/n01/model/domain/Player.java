package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "players", uniqueConstraints = @UniqueConstraint(columnNames = "player_name"))
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pk_PlayerID;
	
	@Column(name = "player_name", unique = true)
	private String playerName;
	
	@Column(name = "registration_date", columnDefinition = "DATE")
	private LocalDate registrationDate;
	
	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Game> games = new ArrayList<>();
	
	public Player() {
		
	}

	public Player(int pk_PlayerID, String playerName, LocalDate registrationDate) {
		this.pk_PlayerID = pk_PlayerID;
		this.playerName = playerName;
		this.registrationDate = registrationDate;
	}

	public int getPk_PlayerID() {
		return pk_PlayerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public List<Game> getGames(){
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "Player [pk_PlayerID=" + pk_PlayerID + ", playerName=" + playerName + ", registrationDate="
				+ registrationDate + ", games=" + games + "]";
	}
}