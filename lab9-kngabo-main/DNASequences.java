import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * The DNASequences class trains a first-order Markov chain model for
 * generating DNA sequences.
 * 
 * @author Your Name Here!
 */
public class DNASequences {
    /** The transitions from each starting character. */
    private Map<Character, Transitions<Character>> transitions;

    /** A sequence of 1000 nucleotides (generated from https://www.bioinformatics.org/sms2/random_dna.html). */
    private static final String DNA = "AAATACGGATAGGCACAATCTTTTTCGATCCACTGTAAGGCTGAAAAATATTCGGAAATGGGTTTTAAGGTCCATCCGGCCTCATAATCAATGTGAGCTACCCAAACCACTATTGTTTAACCCGATATGAGCCCTAGTTCTTAGGTGTACCTTGCTAAGTTCGAGCATATCCGAGTTATAACCTGGTGTATGCTCCTTATAATGATGTTTGCATACCTCGCAGAGTCATCCGCATCACGGTAGAAATTGCGATCGCATCAATGCTCTCAATGCCCTATGCTTCATAGATTGTACACACACTGTTTCTACCTGGTTCTATAGCTAGGGGGTACAAATGCACAAGGCCCGTAAACAAACCAAGCATCGATGTTCTTGACGTTTTCGAGCATCATTACGCATCCTTGGGCAAGAAAATAGACGTATGGTGCCGGCCATATATCTAATCTTAGACTACCTGCCCCATCCCATACATGCTCTTACTTGGTGCGTTGAAGTCTGAGTCGGTAGAGTCAGGGTGTCTGTGCAAAGCATGGTTGGTATAACGAGAATGGCACTAAGTAACCAACGCAAGGGCAGATTCGGCCTCATATTCATGGGGATAACCTCCCCAGCTTTCTACTCTTTTACCAGTCTCCGTTGATATTTCTAGACAGCGGGCATTCTCGATTTTCTACTGAACGGGATATTATGGTCGTGTTCCACGAACAAGCTGCAGCAGCCCCTTGTAACCAAGGAGACATCCGAACAGGAGAAGTGCCCCATGAGCTTTCGGCGAGGTTAACAGGGCATCTATCATTATGATAGCGGTCACGACATCGTGTATTGAATCCCATCGTAGCGCCACGCTTCTGACCGTCGCGCGCATTTTGCCAGTAATGCTTTCATTGCTGAAACTTGTGTTCGGGTCTCGTCGTAGCATGGACGTCTGCTTCCGGCCCGGGATAAGGCTTTATGTCAGTGCAAAGTGGTCAGGGTTTCTAGGTGGCAATAGTGTGTATCA";

    /**
     * Creates a new DNASequences object.
     */
    public DNASequences() {
        this.transitions = new HashMap<Character, Transitions<Character>>();
        for (char current : new char[]{'A', 'C', 'G', 'T'}) {
            this.transitions.put(current, new Transitions<Character>());
        }
    }

    /**
     * Trains the Markov Chain model of a given DNA sequence.
     * 
     * @param sequence The DNA sequence to use for training
     */
    public void trainCounts(String sequence) {
        for (int i = 0; i < sequence.length() - 1; i++) {
            char current = sequence.charAt(i);
            char next = sequence.charAt(i + 1);
            Transitions<Character> trans = this.transitions.get(current);
            if (trans != null) {
                trans.addTransition(next);
            }
        }
    }

    /**
     * Generates a random DNA sequence of a given {@code length} starting with
     * a given {@code start} character.
     * 
     * @param start The first character of the sequence
     * @param length The desired length of the sequence
     * @param rand A {@link Random} number generator
     * 
     * @return A randomly generated DNA sequence String 
     */
    private String generate(char start, int length, Random rand) {
        String string = "" + start;
        char current = start;

        for (int i = 1; i < length; i++) {
            Transitions<Character> trans = transitions.get(current);
            if (trans != null) {
                char next = trans.generateNextState(rand);
                string += next;
                current = next;
            }
        }

        return string.toString();
    }

    /**
     * Prints the probabilities of all transitions in the learned model.
     */
    private void printTransitions() {
        for (Map.Entry<Character, Transitions<Character>> entry : transitions.entrySet()) {
            char current = entry.getKey();
            Transitions<Character> counts = entry.getValue();

            for (Map.Entry<Character, Integer> transition : counts.counts.entrySet()) {
                char next = transition.getKey();
                double prob = ((double) transition.getValue()) / counts.totalCount;
                System.out.println(current + " to " + next + ": " + prob);
            }
        }
    }

    /**
     * Runs the program.
     * 
     * @param args The command line arguments (unused)
     */
    public static void main(String[] args) {
        // create and train a new DNA sequences object
        DNASequences model = new DNASequences();
        model.trainCounts(DNA);

        // print the transition probabilities
        model.printTransitions();

        // generate some random text
        SecureRandom rand = new SecureRandom();
        String generatedText = model.generate('A', 30, rand);
        System.out.println(generatedText);
    }   
}
