package arora.gurdeep.weightwatchers;

import java.util.Random;
import java.util.TreeSet;

// Print 500 random numbers and print nth smallest amongst them.
// Since it wasn't specified, assuming all 500 random numbers to be between 0 and 1000
public class Question3 {

    // Total random numbers to generate. This can be changed.
    private static final int TOTAL_RANDOM_NUMBERS = 500;

    // Since it was not specified, I'v taken upper range for random number to be 10,000
    // If you want to change it, please ensure that this number is >= TOTAL_RANDOM_NUMBERS
    private static final int MAX_RANDOM_NUMBER = 10000;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("This program requires nth smallest integer as the input parameter." + System.lineSeparator() + "Please run it as \"java arora.gurdeep.weightwatchers.Question3 <n>\"");
            System.exit(0);
        }
        try {
            int n = Integer.parseInt(args[0]);
            if (n < 1 || n > TOTAL_RANDOM_NUMBERS) {
                System.err.println("The parameter n must be a +ve integer between 1 and " + TOTAL_RANDOM_NUMBERS);
            } else {

                TreeSet<Integer> set = new TreeSet<>();

                // Initiate a random number generator with seed as current time in millis
                Random random = new Random(System.currentTimeMillis());
                while (set.size() != TOTAL_RANDOM_NUMBERS) {
                    set.add(1 + random.nextInt(MAX_RANDOM_NUMBER));
                }

                // Print all randoms
                System.out.print("Generated random numbers are: ");
                set.forEach(num -> {
                    System.out.print(num);
                    if (!num.equals(set.last())) {
                        System.out.print(", ");
                    }
                });
                System.out.println();

                // Find nth smallest
                System.out.println("The nth smallest random for n = " + n + " is: " + set.toArray()[n - 1]);
            }
        } catch (NumberFormatException ex) {
            System.err.println("The parameter n must be a +ve integer between 1 and " + TOTAL_RANDOM_NUMBERS);
        }
    }
}
