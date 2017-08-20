
public class NotSwitchingPlayer {

	private int winCount = 0;
	
	public int getWinCount() {
		return this.winCount;
	}
	
	public void incrementWinCount() {
		this.winCount++;
	}
	
	public double getWinPercentage(int playedGames) {
		return (double)(((double)this.winCount / (double)playedGames) * 100);
	}
	
}
