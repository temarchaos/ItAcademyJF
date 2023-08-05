package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.dto;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Game;

public class PlayerDTO implements Comparable<PlayerDTO>{
	private int pk_PlayerID;
    private String playerName;
    private LocalDate registrationDate;
    private List<Game> games;
    private double winPercentage;
    
    public PlayerDTO() {
    	
    }

	public PlayerDTO(int pk_PlayerID, String playerName, LocalDate registrationDate, List<Game> games,
			double winPercentage) {
		this.pk_PlayerID = pk_PlayerID;
		this.playerName = playerName;
		this.registrationDate = registrationDate;
		this.games = games;
		this.winPercentage = winPercentage;
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

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
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
		return "- PlayerDTO [pk_PlayerID=" + pk_PlayerID + ", playerName=" + playerName + ", registrationDate="
				+ registrationDate + ",\ngames=" + games + ",\n\t winPercentage=" + df.format(winPercentage)+"%" + "]\n";
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