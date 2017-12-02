import java.util.Random;

public class Item {
	String idea=null;
	Item (int age){
		String[] ideas = new String[3];
		if (age==0) {
			ideas[0] = "child clothes";
			ideas[1] = "child bike";
			ideas[2] = "child toys";
		}
		if(age==1) {
			ideas[0] = "computer games";
			ideas[1] = "bicycle";
			ideas[2] = "books";
		}
		if(age==2) {
			ideas[0] = "shoes";
			ideas[1] = "cosmetics";
			ideas[2] = "whisky";
		}
		Random rand = new Random();
		idea=ideas[rand.nextInt(ideas.length-1)];
	}
}
