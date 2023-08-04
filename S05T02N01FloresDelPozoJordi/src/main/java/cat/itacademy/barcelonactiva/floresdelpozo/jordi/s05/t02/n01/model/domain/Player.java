package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pk_PlayerID;
	
	@Column(name = "player_name")
	private String playerName;
	
	@Column(name = "registration_date")
	private LocalDate registrationDate;
	
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

	public void setPk_PlayerID(int pk_PlayerID) {
		this.pk_PlayerID = pk_PlayerID;
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

	@Override
	public String toString() {
		return "Player [pk_PlayerID=" + pk_PlayerID + ", playerName=" + playerName + ", registrationDate="
				+ registrationDate + "]";
	}
}