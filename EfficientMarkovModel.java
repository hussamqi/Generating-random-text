import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by hussa on 01/07/2017.
 */
public class EfficientMarkovModel extends AbstractMarkovModel{
    HashMap<String,ArrayList<String>> map  = new HashMap<String,ArrayList<String>>();
    public EfficientMarkovModel(int n1 )
    {
        myRandom = new Random();
        n = n1;
    }
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public String getRandomText(int numChars){
        buildMap();
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-n);
        String key = myText.substring(index , index+n);
        sb.append(key);
        for(int k=0; k < numChars -n ; k++){
            ArrayList<String> follows = map.get(key);
            if (follows.size() == 0) break;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }

        return sb.toString();
    }

    public String toString() {
        return "EfficientMarkovModel of order " + n + ".";
    }

    public void buildMap()
    {
        for(int k=0; k < myText.length() -n+1 ; k++){
            String key = myText.substring(k,k+n);
            if (!map.containsKey(key)) map.put(key , getFollows(key));
        }
//        System.out.println(map);
        printHashMapInfo();
    }

    public void printHashMapInfo()
    {
        int size = 0;
        System.out.println(map.size());
        for (String key : map.keySet())
        {
            if (map.get(key).size() > size) size = map.get(key).size();
        }
        System.out.println("The max size of arraylist is " + size);
    }

}
