package task1;
import java.util.*;



public class GameClass {
public static void main(String args[]) {
	Cricket c = new Cricket(11,2,"teamA");
	Football f = new Football(11,3,"teamb");
	Hockey h = new Hockey(9,2,"teamc");
	c.play();
	f.stop();
	h.resume();
	
	System.out.println(c.getNoOfPlayers());
	 c.setNoofPlayers(12);
	 System.out.println(c.getNoOfPlayers());
	 

	 List<Cricket> cricketList = new ArrayList<>();

	 cricketList.add(new Cricket(11, 240, "Team1"));
	 cricketList.add(new Cricket(11, 240, "Team2"));
	 cricketList.add(new Cricket(11, 240, "Team3"));
	 cricketList.add(new Cricket(11, 240, "Team4"));
	 cricketList.add(new Cricket(11, 240, "Team5"));

	 
     System.out.println("List of Cricket Team Names:");
     for (Cricket cricket : cricketList) {
         System.out.println(cricket.getTeamName());
     }
	 
     List<Football> footballList = new ArrayList<>();
     footballList.add(new Football(11, 90, "Andhra"));
     footballList.add(new Football(11, 90, "TamilNadu"));
     footballList.add(new Football(11, 90, "Kerala"));
     footballList.add(new Football(11, 90, "Assam"));
     footballList.add(new Football(11, 90, "bengal"));
     footballList.add(new Football(11, 90, "Arunachal"));
     footballList.add(new Football(11, 90, "Bihar"));
     footballList.add(new Football(11, 90, "TeamH"));
     footballList.add(new Football(11, 90, "TeamI"));
     footballList.add(new Football(11, 90, "TeamJ"));
     
     for(Football fl: footballList ) {
    	 String ftn=fl.getTeamName();
    	 if (ftn.charAt(0)=='A') {
    	 System.out.println(ftn);}
     }
}
}
