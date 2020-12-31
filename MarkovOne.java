package part1;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that creates text through the Markov chain - uses a single char length substring
 */
public class MarkovOne {
    private String myText;
    private Random myRandom;

    /**
     * Class's constructor creates a random variable
     */
    public MarkovOne() {
        myRandom = new Random();
    }

    /**
     * generates a random variable stored in myRandom
     * @param seed - random num generator
     */
    public void setSeed(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }


    /**
     * Creates substrings of 1 char length.
     *
     * Maintains an Arraylist containing already found sub strings as keys,
     * and using "getFollows" method, retains a set of characters which appears after the key.
     *
     * Creates a new text of numChars length, that consists of characters that appear as values in the ArrayList
     * - stored in the sb variable.
     *
     * @param numChars
     * @return @return sb.toString - new text of numChars length
     */
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        sb.append(myText.charAt(index));
        ArrayList newList;
        for(int k=1; k < numChars; k++){
            newList = getFollows(String.valueOf(sb.charAt(k-1)));
            int newiIndex = myRandom.nextInt(newList.size());
            sb.append(newList.get(newiIndex));
        }
        return sb.toString();
    }


    /**
     *get aas a key a certain sub string key, finds in myText all of the characters following the key,
     * and returns them as a list
     *
     * @param key - substring of myText
     * @return myTextArray
     */
    public ArrayList getFollows(String key){
        ArrayList<String> myTextArray = new ArrayList<String>();
        if (myText.toLowerCase().contains(key.toLowerCase())){
            int counter = 0;
            for (int i = 0; i < myText.length(); i++) {
                for (int j = 0; j < key.length(); j++) {
                    if ((i + key.length()) < myText.length()) {
                        if (myText.charAt(i + j) == key.charAt(j)) {
                            counter++;
                        }
                    }
                }
                if (counter == key.length()){
                    myTextArray.add(String.valueOf(myText.charAt(i + key.length())));
                }
                counter = 0;
            }
        }
        return myTextArray;
    }
}