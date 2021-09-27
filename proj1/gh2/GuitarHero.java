package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {

    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] guitarStrings = new GuitarString[37];

        int i = 0;
        while (i < keyboard.length()) {
            double concert = 440.0 * Math.pow(2.0, (i-24.0)/12.0);
            guitarStrings[i] = new GuitarString(concert);
            i += 1;
        }

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    guitarStrings[index].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (int j=0; j < keyboard.length(); j+=1) {
                sample += guitarStrings[j].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int k=0; k < keyboard.length(); k+=1) {
                guitarStrings[k].tic();
            }
        }
    }
}