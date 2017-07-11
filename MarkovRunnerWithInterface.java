
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size , int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		int seed = 25;
		
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size,seed);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size,seed);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size,seed);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size,seed);

    }

    public void testHashMap()
	{
		EfficientMarkovModel markov = new EfficientMarkovModel(2);
		runModel(markov,"yes-this-is-a-thin-pretty-pink-thistle" , 50 , 42);
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

	public void compareMethods()
	{
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 1000;
		int seed = 42;
		MarkovModel a = new MarkovModel(2);
		EfficientMarkovModel b = new EfficientMarkovModel(2);
		long  a1 = System.nanoTime();
		runModel(a,st , size , seed);
		long a2 = System.nanoTime();
		runModel(b,st , size , seed);
		Long b2 = System.nanoTime();
		System.out.println((a2-a1) + " " + (b2-a2));

	}
}
