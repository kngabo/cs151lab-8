import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Random;
import java.security.SecureRandom;

/**
 * This class represents an n-order Markov Chain model, where each 
 * state is a character. 
 * 
 * @author Your Name Here!
 */
public class MarkovChain {
    /* TODO: add your instance variables here. */

    /**
     * Create a new Markov model with the given order.
     * 
     * @param order The order of the Markov model.
     */
    public MarkovChain(int order) {
        /* TODO: implement this constructor */
    }

    /**
     * Trains the model on a given String by creating its transition function.
     * 
     * @param input The input String to use to train. The String must be at least
     *              {@code this.order} characters long.
     */
    public void train(String input) {
        // make sure the input is the correct length for this model
        assert (input.length() >= this.order);

        /* TODO: implement this method */
    }

    /**
     * Updates the counts for a given (history, nextCharacter) pair in the 
     * transition function of the model.
     * 
     * @param history The history String. This must be a String whose length is the
     *               {@code order} of the model.
     * @param nextCharacter The next character.
     */
    private void updateCount(String history, char nextCharacter) {
        // make sure the prefix is the correct length for this model
        assert (history.length() == this.order);
        
        /* TODO: implement this method */
    }

    /**
     * Generate a String of a given {@code length} starting with a given 
     * {@code start} String.
     * 
     * The {@code start} must have been given to the model as part of its
     * training data.
     * 
     * @param start A String of length {@code this.order} to use to start the 
     *              new String.
     * @param length The length of the generated String.
     * @param rand  A random number generator to use to generate the String.
     * 
     * @return The generated String
     */
    public String generate(String start, int length, Random rand) {
        /* TODO: implement this method */
    }

    /**
     * Run the text generation program.
     * 
     * The three command line arguments must be the order (a positive integer), the
     * output length (a positive integer), and a path to a training file.
     * 
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // make sure we have the correct number of command line arguments
        if (args.length != 3) {
            System.err.println("MarkovModel requires two parameters: order length file");
            System.exit(1);
        }

        // parse the command line arguments
        int order = Integer.parseInt(args[0]);
        int length = Integer.parseInt(args[1]);
        String filename = args[2];

        // read in the file
        String input = null;
        try {
            File file = new File(filename);
            input = Files.readString(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
            e.printStackTrace();
            System.exit(1);
        }

        // construct and train the model
        MarkovChain model = new MarkovChain(order);
        model.train(input);
        
        // generate new text
        SecureRandom rand = new SecureRandom();
        String start = input.substring(0, order);
        String generatedText = model.generate(start, length, rand);

        // print out the generated text
        System.out.println(generatedText);
    }
}
