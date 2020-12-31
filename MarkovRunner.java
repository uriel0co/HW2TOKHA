package part1;
import util.*;


/** Execute tests of MarkovRunner
 *
 *  Various variants are used to test the code using N=0,1,4,M
 *  where N is the number of letters.
 */
public class MarkovRunner {
	/**
	 * Generate random text of length M=500
	 * Process the training file to identify sequences
	 * @param trainingFilePath full path to the text file
	 */
	public void runMarkovZero(String trainingFilePath) {

		SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
		String st = seFileUtil.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setSeed(25);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}

	}


	public void runMarkovOne(String trainingFilePath) {

		SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
		String st = seFileUtil.asString();
		st = st.replace('\n', ' ');
		MarkovOne markov = new MarkovOne();
		markov.setSeed(25);
		markov.setTraining(st);
		for(int k=0; k < 3; k++) {
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}


	public void runMarkovFour(String trainingFilePath) {

		SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
		String st = seFileUtil.asString();
		st = st.replace('\n', ' ');
		MarkovFour markov = new MarkovFour();
		markov.setSeed(25);
		markov.setTraining(st);
		for(int k=0; k < 3; k++) {
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	public void runMarkovModel(String trainingFilePath) {

		SEFileUtil seFileUtil = new SEFileUtil(trainingFilePath);
		String st = seFileUtil.asString();
		st = st.replace('\n', ' ');
		MarkovModel markov = new MarkovModel();
		markov.setSeed(25);
		markov.setTraining(st);
		for(int k=0; k < 3; k++) {
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}

	public static void main(String[] args) {
		MarkovRunner markovRunner = new MarkovRunner();
		markovRunner.runMarkovZero(args[0]);
		markovRunner.runMarkovOne(args[0]);
		markovRunner.runMarkovFour(args[0]);
		markovRunner.runMarkovModel(args[0]);

	}

}