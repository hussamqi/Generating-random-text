import edu.duke.FileResource;

/**
 * Created by hussa on 01/07/2017.
 */
public class main {
    public static void main(String[] args)
    {
        MarkovRunnerWithInterface x = new MarkovRunnerWithInterface();
        EfficientMarkovModel y= new EfficientMarkovModel(5);
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        x.runModel(y , st ,10 , 615);

    }
}
