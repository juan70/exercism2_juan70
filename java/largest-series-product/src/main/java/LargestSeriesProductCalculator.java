import java.util.stream.IntStream;


public class LargestSeriesProductCalculator {

    private String numStr = null;

    public LargestSeriesProductCalculator(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String to search must be non-null.");
        }
        if (s.matches("^.*\\D.*$")) {
            throw new IllegalArgumentException("String to search may only contains digits.");
        }

        numStr = s;
    }


    // A helper function that multiplies all the digits within a string
    private long calcString(String s) {
        return s.chars()
               .mapToLong(Character::getNumericValue)
               .reduce(1, Math::multiplyExact);
    }

    public long calculateLargestProductForSeriesLength(int n) {
        if (n > numStr.length()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
        if (n < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        // Instead of generating a possibly long stream/list of values, a tail-recursive helper function would be great.
        // But I had troubles once with tail-recursion in Java, such as blowing the stack...
        return IntStream.rangeClosed(0, numStr.length() - n)
               .mapToLong(i -> calcString(numStr.substring(i, i + n)))
               .reduce(0, Long::max);
    }

}

