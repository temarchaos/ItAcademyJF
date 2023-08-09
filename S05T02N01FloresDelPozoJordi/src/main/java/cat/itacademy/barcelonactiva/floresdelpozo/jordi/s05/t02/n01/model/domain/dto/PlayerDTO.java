package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.dto;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Role;

public class PlayerDTO implements Comparable<PlayerDTO>{
	private int pk_PlayerID;
    private String username;
    private String password;
    private LocalDate registrationDate;
    private List<Game> games;
    private Role role;
    private double winPercentage;
    
    public PlayerDTO() {
    	
    }

	public PlayerDTO(int pk_PlayerID, String username, String password, LocalDate registrationDate, List<Game> games,
			Role role, double winPercentage) {
		this.pk_PlayerID = pk_PlayerID;
		this.username = username;
		this.password = password;
		this.registrationDate = registrationDate;
		this.games = games;
		this.role = role;
		this.winPercentage = winPercentage;
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

	public void setUsername(String username) {
		this.username = username;
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

	public double getWinPercentage() {
		return winPercentage;
	}

	public void setWinPercentage(double winPercentage) {
		this.winPercentage = winPercentage;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		return "- PlayerDTO [pk_PlayerID=" + pk_PlayerID + ", username=" + username + ", password=" + password
				+ ", registrationDate=" + registrationDate + ", role=" + role + ",\ngames=" + games + ",\n\t winPercentage="
				+ df.format(winPercentage)+"%" + "]\n";
	}

	@Override
	public int compareTo(PlayerDTO other) {
		int winPercentageOrdered = Double.compare(other.getWinPercentage(), this.getWinPercentage());
		if (winPercentageOrdered != 0) {
			return winPercentageOrdered;			
		}
		
		return this.getRegistrationDate().compareTo(other.getRegistrationDate());
	}
}