import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ProblemGenerator {

	SwitchingPlayer sp;
	NotSwitchingPlayer nsp;
	int testSize = 0;
	
	public ProblemGenerator() {
		sp = new SwitchingPlayer();
		nsp = new NotSwitchingPlayer();
	}
	
	public void generateProblems(int gamesTestSize) {
		testSize = gamesTestSize;
		// run the generator according to the input test size
		for(int i = 0; i < gamesTestSize; i++) {
			// pick a door between 1 and 3 for both the player who will
			// be switching doors, and the player who won't be switching doors
			int pickedDoor = ThreadLocalRandom.current().nextInt(1, 4);
			// random door between 1 and 3 which contains the winner
			// the other values are losing doors
			int winnerDoor = ThreadLocalRandom.current().nextInt(1, 4);
			// the game show host then opens a door which is not the winner,
			// and is not the door that the player has chosen
			int openedDoor = 0;
			if(winnerDoor == 1 && pickedDoor == 1) {
				openedDoor = ThreadLocalRandom.current().nextInt(2, 4);
			}
			else if(winnerDoor == 1 && pickedDoor == 2) {
				openedDoor = 3;
			}
			else if(winnerDoor == 1 && pickedDoor == 3) {
				openedDoor = 2;
			}
			else if(winnerDoor == 2 && pickedDoor == 1) {
				openedDoor = 3;
			}
			else if(winnerDoor == 2 && pickedDoor == 2) {
				List<Integer> availableDoors = new ArrayList<Integer>();
				availableDoors.add(1);
				availableDoors.add(3);
				Collections.shuffle(availableDoors);
				openedDoor = availableDoors.get(0);
			}
			else if(winnerDoor == 2 && pickedDoor == 3) {
				openedDoor = 1;
			}
			else if(winnerDoor == 3 && pickedDoor == 1) {
				openedDoor = 2;
			}
			else if(winnerDoor == 3 && pickedDoor == 2) {
				openedDoor = 1;
			}
			else if(winnerDoor == 3 && pickedDoor == 3) {
				openedDoor = ThreadLocalRandom.current().nextInt(1, 3);
			}
			// there are two doors remaining, one with a winner and one
			// with a loser. The game show host will now ask the player
			// if they would like to switch doors, only the SwitchingPlayer
			// will switch. The NotSwitchingPlayer will keep their choice
			int switchedPlayerDoor = 0;
			if(pickedDoor == 1 && openedDoor == 2) {
				switchedPlayerDoor = 3;
			}
			else if(pickedDoor == 1 && openedDoor == 3) {
				switchedPlayerDoor = 2;
			}
			else if(pickedDoor == 2 && openedDoor == 1) {
				switchedPlayerDoor = 3;
			}
			else if(pickedDoor == 2 && openedDoor == 3) {
				switchedPlayerDoor = 1;
			}
			else if(pickedDoor == 3 && openedDoor == 1) {
				switchedPlayerDoor = 2;
			}
			else if(pickedDoor == 3 && openedDoor == 2) {
				switchedPlayerDoor = 1;
			}
			// the game show host now reveals the door with the winner
			if(pickedDoor == winnerDoor) {
				nsp.incrementWinCount();
			}
			else if(switchedPlayerDoor == winnerDoor) {
				sp.incrementWinCount();
			}
		}
	}
	
	public List<Double> getPercentages() {
		return Arrays.asList(sp.getWinPercentage(testSize), nsp.getWinPercentage(testSize));
	}
}
