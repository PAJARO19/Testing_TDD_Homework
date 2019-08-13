package numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersStringToIntTest {

    NumbersStringToInt numbersStringToInt;

    @BeforeEach
    void createInstanceOfNumbers() {
        numbersStringToInt = new NumbersStringToInt();
    }

    @ParameterizedTest
    @MethodSource("dataForStringToIntTest")
    void stringToIntTest(String string, Integer expected) {
        Integer result = numbersStringToInt.stringToInt(string);
        assertEquals(expected, result);
    }

    static Stream<Arguments> dataForStringToIntTest() {
        return Stream.of(
                Arguments.arguments("I", 1),
                Arguments.arguments("II", 2),
                Arguments.arguments("III", 3),
                Arguments.arguments("IV", 4),
                Arguments.arguments("V", 5),
                Arguments.arguments("VI", 6),
                Arguments.arguments("VII", 7),
                Arguments.arguments("VIII", 8),
                Arguments.arguments("IX", 9),
                Arguments.arguments("X", 10),
                Arguments.arguments("XI", 11),
                Arguments.arguments("XII", 12),
                Arguments.arguments("XIII", 13),
                Arguments.arguments("XIV", 14),
                Arguments.arguments("XV", 15),
                Arguments.arguments("XVI", 16),
                Arguments.arguments("XVII", 17),
                Arguments.arguments("XVIII", 18),
                Arguments.arguments("XIX", 19),
                Arguments.arguments("XX", 20),
                Arguments.arguments("XLIII", 43),
                Arguments.arguments("XLIV", 44),
                Arguments.arguments("L", 50),
                Arguments.arguments("XCIV", 94),
                Arguments.arguments("C", 100),
                Arguments.arguments("CCCIII", 303),
                Arguments.arguments("CCCXXXIII", 333),
                Arguments.arguments("CD", 400),
                Arguments.arguments("CDXLIX", 449),
                Arguments.arguments("D", 500),
                Arguments.arguments("DCXLIV", 644),
                Arguments.arguments("CMXCIX", 999),
                Arguments.arguments("M", 1000),
                Arguments.arguments("MXLIX", 1049),
                Arguments.arguments("MMCMXCIX", 2999),
                Arguments.arguments("MMM", 3000),
                Arguments.arguments("Ilona", null),
                Arguments.arguments("napis", null),
                Arguments.arguments("NAPIS", null)
        );
    }
}