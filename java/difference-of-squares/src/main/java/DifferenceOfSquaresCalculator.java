import java.util.stream.IntStream;


public final class DifferenceOfSquaresCalculator {

    private int square(int n) {
        return n * n;
    }

    public int computeSquareOfSumTo(int n) {
        return square( IntStream.rangeClosed(1, n).sum() );
    }

    public int computeSumOfSquaresTo(int n) {
        return IntStream.rangeClosed(1, n)
                        .map( x -> square(x) )
                        .sum();
    }

    public int computeDifferenceOfSquares(int n) {
        return computeSquareOfSumTo(n) - computeSumOfSquaresTo(n);
    }

}

