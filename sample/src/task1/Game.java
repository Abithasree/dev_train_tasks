package task1;

public interface Game {
	int getNoOfPlayers();
	int getTime2Play();
	String getTeamName();
	void setNoofPlayers(int nop);
	void setTime2Play(int t2p);
	void SetTeamName(String tn);
	
	void play();
	void stop();
	void resume();
	
}
