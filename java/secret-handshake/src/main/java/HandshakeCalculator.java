import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;


final class HandshakeCalculator {

    // Just for convenience
    private static int pow2(int n) {
        return (int)Math.pow(2, n);
    }

    private final static int NUMBER_OF_SIGNALS = Signal.values().length;
    private final static int REVERSE_SIGNAL = pow2(NUMBER_OF_SIGNALS);

    private boolean isReversed(int n) {
        return (n & REVERSE_SIGNAL) == REVERSE_SIGNAL;
    }

    public List<Signal> calculateHandshake(int n) {
        List<Signal> result = new ArrayList<>();

        // Keep only the significant digits
        int code = n & (REVERSE_SIGNAL - 1);

        IntStream.range(0, NUMBER_OF_SIGNALS)
                 .map( i -> isReversed(n) ? NUMBER_OF_SIGNALS - 1 - i : i )
                 .filter( j -> (n & pow2(j)) != 0 )
                 .forEach( j -> result.add(Signal.values()[j]) );

        /* The equivalent imperative code
        for (int i = 0; i < NUMBER_OF_SIGNALS; i++) {
            int j = isReversed(n) ? NUMBER_OF_SIGNALS - 1 - i : i;
            int mask = pow2(j);
            if ((n & mask) != 0) {
                result.add(Signal.values()[j]);
            }
        }
        */

        return result;
    }

}

