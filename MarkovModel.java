import java.util.ArrayList;
import java.util.Random;

/**
 * Created by hussa on 01/07/2017.
 */
public class MarkovModel extends AbstractMarkovModel{

    public MarkovModel(int n1 )
    {
        myRandom = new Random();
        n = 3;
    }
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public String getRandomText(int numChars){
        setRandom(25);
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-n);
        String key = myText.substring(index , index+n);
        sb.append(key);
        for(int k=0; k < numChars -n ; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) break;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }

        return sb.toString();
    }

}
