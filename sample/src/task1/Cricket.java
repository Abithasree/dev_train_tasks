package task1;

public class Cricket implements Game{
	
	int nop; //no of players
	int t2p; //time to play
	String tn; //team name
	
	public Cricket( int nop, int t2p, String tn) {
		this.nop= nop;
		this.t2p= t2p;
		this.tn=tn;
	}
	
	public void play() {
		System.out.println("playing");
	}
	
	public void stop() {
		System.out.println("stopping");
	}
	
	public void resume() {
		System.out.println("resume");
	}

	@Override
	public int getNoOfPlayers() {
		// TODO Auto-generated method stub
		return nop;
	}

	@Override
	public int getTime2Play() {
		// TODO Auto-generated method stub
		return t2p;
	}

	@Override
	public String getTeamName() {
		// TODO Auto-generated method stub
		return tn;
	}

	@Override
	public void setNoofPlayers(int nop) {
		// TODO Auto-generated method stub
		this.nop=nop;
	}

	@Override
	public void setTime2Play(int t2p) {
		// TODO Auto-generated method stub
		this.t2p=t2p;
	}

	@Override
	public void SetTeamName(String tn) {
		// TODO Auto-generated method stub
		this.tn=tn;
	}
	
	
	

}
