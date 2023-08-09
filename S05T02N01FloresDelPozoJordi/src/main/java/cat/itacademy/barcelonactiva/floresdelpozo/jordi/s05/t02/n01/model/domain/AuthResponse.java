package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain;

public class AuthResponse {
	private Player player;
    private String token;
    
    public AuthResponse(Player player, String token) {
        this.player = player;
        this.token = token;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	@Override
	public String toString() {
		return "PlayerWithToken [player=" + player + ", token=" + token + "]";
	}
}