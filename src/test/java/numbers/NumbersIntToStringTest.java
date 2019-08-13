package numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersIntToStringTest {

    NumbersIntToString numbersIntToString;

    @BeforeEach
    void createInstanceOf() {
        numbersIntToString = new NumbersIntToString();
    }

    @ParameterizedTest
    @MethodSource("dataForIntToStringTest")
    void intToStringTest(int number, String expected) {
        String result = numbersIntToString.intToString(number);
        assertEquals(expected, result);
    }

    static Stream<Arguments> dataForIntToStringTest() {
        return Stream.of(
                Arguments.arguments(1, "I"),
                Arguments.arguments(2, "II"),
                Arguments.arguments(3, "III"),
                Arguments.arguments(4, "IV"),
                Arguments.arguments(5, "V"),
                Arguments.arguments(6, "VI"),
                Arguments.arguments(7, "VII"),
                Arguments.arguments(8, "VIII"),
                Arguments.arguments(9, "IX"),
                Arguments.arguments(10, "X"),
                Arguments.arguments(11, "XI"),
                Arguments.arguments(12, "XII"),
                Arguments.arguments(13, "XIII"),
                Arguments.arguments(14, "XIV"),
                Arguments.arguments(15, "XV"),
                Arguments.arguments(16, "XVI"),
                Arguments.arguments(17, "XVII"),
                Arguments.arguments(18, "XVIII"),
                Arguments.arguments(19, "XIX"),
                Arguments.arguments(20, "XX"),
                Arguments.arguments(43, "XLIII"),
                Arguments.arguments(90, "XC"),
                Arguments.arguments(99, "XCIX"),
                Arguments.arguments(100, "C"),
                Arguments.arguments(567, "DLXVII"),
                Arguments.arguments(809, "DCCCIX"),
                Arguments.arguments(900, "CM"),
                Arguments.arguments(990, "CMXC"),
                Arguments.arguments(999, "CMXCIX"),
                Arguments.arguments(1000, "M"),
                Arguments.arguments(1500, "MD"),
                Arguments.arguments(1900, "MCM"),
                Arguments.arguments(2000, "MM"),
                Arguments.arguments(2999, "MMCMXCIX"),
                Arguments.arguments(3000, "MMM"),
                Arguments.arguments(3567, "MMMDLXVII"),
                Arguments.arguments(14567, "MMMMMMMMMMMMMMDLXVII")
        );
    }

}