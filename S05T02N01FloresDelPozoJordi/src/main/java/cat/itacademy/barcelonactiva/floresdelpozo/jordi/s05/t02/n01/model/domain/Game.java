package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {
	private static final int NUM_DICES = 2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pk_GameID;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;
	
	@ElementCollection
	@CollectionTable(name = "game_dices", joinColumns = @JoinColumn(name = "game_id"))
    @Column(name = "dice_value")
	private List<Integer> dicesValues;
	
	@Column(name = "won")
	private boolean won;
	
	public Game(List<Integer> dicesValues, boolean won) {
		if (dicesValues.size() != NUM_DICES) {
            throw new IllegalArgumentException("El nombre de valors de daus ha de ser igual a " + NUM_DICES);
        }
		
		this.dicesValues = new ArrayList<>(dicesValues);
		this.won = won;
	}

	public List<Integer> getDicesValues() {
		return dicesValues;
	}

	public void setDicesValues(List<Integer> dicesValues) {
		if (dicesValues.size() != NUM_DICES) {
            throw new IllegalArgumentException("El nombre de valors de daus ha de ser igual a " + NUM_DICES);
        }
		
		this.dicesValues = dicesValues;
	}

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	@Override
	public String toString() {
		return "Game [dicesValues=" + dicesValues + ", won=" + won + "]";
	}
}