
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int n;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }

    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);

    protected ArrayList<String> getFollows(String key)
    {
        ArrayList<String> list = new ArrayList<String>();
//        System.out.println(n);
        for (int i = 0 ; i < myText.length()-n ; ++i)
        {
            if ( myText.substring(i,i+key.length()).equals(key)) list.add(Character.toString(myText.charAt(i+key.length())));
        }
        return list;
    }

//    @Override
    public String toString() {
        return "MarkovModel of order " + n + ".";
    }
}

