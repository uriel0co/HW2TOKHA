package part1;
import java.util.Random;

/**
 * A class that creates random text simulates a Markov chain
 */
public class MarkovZero {
	private String myText;
	private Random myRandom;

	/**
	 * Classe's constructor creates a random variable
	 */
	public MarkovZero() {
		myRandom = new Random();
	}

	/**
	 * generates a random variable stored in myRandom
	 * @param seed
	 */
	public void setSeed(int seed){
		myRandom = new Random(seed);
	}

	public void setTraining(String s){
		myText = s.trim();
	}
	/**
	 * Creates a random new text of numChars length.
	 *
	 * @param numChars
	 * @return
	 */
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0; k < numChars; k++){
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));
		}

		return sb.toString();
	}

}