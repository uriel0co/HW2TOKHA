package part1;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that creates text through the Markov chain - uses a 4 chars length substring
 */
public class MarkovFour {
    private String myText;
    private Random myRandom;

    /**
     * Class's constructor creates a random variable
     */
    public MarkovFour() {
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
     *
     * Creates  substrings of 4 chars length.
     *
     * Maintains an Arraylist containing already found sub strings as keys,
     * and using "getFollows" method, retains a set of characters which appears after the key.
     *
     * Creates a new text of numChars length, that consists of characters that appear as values in the ArrayList
     * - stored in the sb variable.
     *
     * @param numChars
     * @return sb.toString - new text of numChars length
     */
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()- 4);
        String myTextSubstring = myText.substring(index, index+4);
        sb.append(myTextSubstring);
        ArrayList newList;
        for(int k=4; k < numChars; k++){
            String subString = sb.substring(sb.length() - 4, sb.length());
            newList = getFollows(subString);
            if (!newList.isEmpty()){
                int newIndex = myRandom.nextInt(newList.size());
                sb.append(newList.get(newIndex));
            }
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
                        char myTextIndex = myText.charAt(i + j);
                        char keyIndex = key.charAt(j);
                        if (myTextIndex == keyIndex) {
                            counter++;
                        }
                    }
                }
                if (counter == key.length()) {
                    myTextArray.add(String.valueOf(myText.charAt(i + key.length())));
                }
                counter = 0;
            }
        }
        return myTextArray;
    }
}