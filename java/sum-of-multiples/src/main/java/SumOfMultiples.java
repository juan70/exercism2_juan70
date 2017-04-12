import java.util.Arrays;
import java.util.stream.IntStream;
import static java.util.function.Function.identity;


public class SumOfMultiples {

    private int hilim = 0;
    private int[] set = null;

    public SumOfMultiples(int n, int[] set) {
        hilim = n;
        this.set = set;
    }

    public int getSum() {
        /*
          It would be too easy to use a Set and some loops like this:

          (Don't forget
             import java.util.Set;
             import java.util.HashSet;
          )

        Set<Integer> multiples = new HashSet<>();
        for (int n : set) {
            for (int i = 0; i < hilim; i++) {
                if ((i % n) == 0) {
                    multiples.add(i);
                }
            }
        }

        int result = 0;
        for (int i : multiples.toArray(new Integer[0])) {
            result += i;
        };

        return result;
        */

        // Let's do this kind of thing instead:
        return Arrays.stream(set)
                     .mapToObj( n -> IntStream.range(1, hilim)
                                              .filter( i -> (i % n) == 0 ) )
                     .flatMapToInt( identity() )
                     .distinct()
                     .sum();
    }

}

