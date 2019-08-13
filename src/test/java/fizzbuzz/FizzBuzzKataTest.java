package fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzKataTest {

    FizzBuzzKata fizzBuzzKata;

    @BeforeEach
    void createInstanceOfFizzBuzzKata() {
        fizzBuzzKata = new FizzBuzzKata();
    }

    @ParameterizedTest
    @MethodSource("dataForFizzBuzzKataMethodTest")
    void fizzBuzzKataMethodTest(int number, String expected) {
        String result = fizzBuzzKata.fizzBuzzKataMethod(number);
        assertEquals(expected, result);
    }

    static Stream<Arguments> dataForFizzBuzzKataMethodTest() {
        return Stream.of(
                Arguments.arguments(3, "Fizz"),
                Arguments.arguments(6, "Fizz"),
                Arguments.arguments(24, "Fizz"),
                Arguments.arguments(5, "Buzz"),
                Arguments.arguments(80, "Buzz"),
                Arguments.arguments(95, "Buzz"),
                Arguments.arguments(30, "FizzBuzz"),
                Arguments.arguments(60, "FizzBuzz"),
                Arguments.arguments(90, "FizzBuzz"),
                Arguments.arguments(4, "4"),
                Arguments.arguments(17, "17"),
                Arguments.arguments(97, "97")
        );
    }

}