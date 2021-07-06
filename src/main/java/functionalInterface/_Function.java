package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        int increment = increment(0);
        System.out.println(increment);

        // Functions takes 1 arg prod 1 result
        Integer increment2 = incrementByOneFunction.apply(0);
        System.out.println(increment2);

        Function<Integer, Integer> results = incrementByOneFunction.andThen(multiplyBy10Function); // use two  functions
        System.out.println(results.apply(2));

        // BiFunction takes 2 arg prod 1 result
        System.out.println(incrementByOneAndMultiply(2, 100));
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(2, 100));

    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function =
            number -> number * 10;

    static int increment(int number) {
        return number + 1;
    }

    // BiFunction way
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (toIncrementByOne, toMultiplyBy) -> (toIncrementByOne + 1) * toMultiplyBy;

    // Regular way
    static int incrementByOneAndMultiply(int number, int toMultiplyBy) {
        return (number + 1) * toMultiplyBy;
    }
}
