import java.util.List;

public class MainEntry {

	/*
	 * The Monty Hall problem is a class probability brain teaser based
	 * loosely on the show Let's Make a Deal. In it, there are 3 doors
	 * to choose from, one of which contains a prize behind it and the other
	 * two of which are losing doors containing nothing. There is a game
	 * show host who asks the player to choose a door. After the door is chosen,
	 * and knowing which door contains a winner, he then opens a losing
	 * door and asks the player if he would like to switch his choice.
	 * 
	 * This program aims to prove that switching your choice yields a 
	 * 33.3% increase in your odds of winning, regardless of any door you
	 * initially choose. Many people might think that switching will make
	 * no difference, as all doors yield a 33.3% chance of winning, but
	 * it has been statistically proven that you should switch. The greater
	 * the test input sample (you can manipulate this in the main method),
	 * the closer to the calculated odds you get in the output
	 */
	public static void main(String[] args) {
		
		ProblemGenerator generator = new ProblemGenerator();
		// input the number of games you want the generator to play
		generator.generateProblems(10000000);
		// get the win percentages
		List<Double> percentages = generator.getPercentages();
		System.out.println("Switching doors win percentage: " + percentages.get(0) + "%");
		System.out.println("Not switching doors win percentage: " + percentages.get(1) + "%");
	}

}
