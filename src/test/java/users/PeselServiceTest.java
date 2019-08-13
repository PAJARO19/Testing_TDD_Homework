package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeselServiceTest {

    PeselService peselService;

    @BeforeEach
    void createPeselService() {
        peselService = new PeselService();
    }

    @ParameterizedTest
    @MethodSource("dataForIsValidTest")
    void isValidTest(String testCase, boolean expected) {
        boolean result = peselService.isValid(testCase);
        assertEquals(expected, result);
    }

    static Stream<Arguments> dataForIsValidTest() {
        return Stream.of(
                Arguments.arguments("44051401358", false),
                Arguments.arguments("1234", false),
                Arguments.arguments("12345678901", false),
                Arguments.arguments("123456789010912", false),
                Arguments.arguments("44051401458", true)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForGetDateOfBirthTest")
    void getDateofBirthTest(String testCase, LocalDate expected) {
        LocalDate result = peselService.getDateOfBirth(testCase);
        assertEquals(expected, result);
    }

    static Stream<Arguments> dataForGetDateOfBirthTest() {
        return Stream.of(
                Arguments.arguments("44051401458", LocalDate.of(1944, 05, 14))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForGetSexTest")
    void getSexTest(String testCase, Sex expected) {
        Sex result = peselService.getSex(testCase);
        assertEquals(expected, result);
    }

    static Stream<Arguments> dataForGetSexTest() {
        return Stream.of(
                Arguments.arguments("44051401458", Sex.MALE),
                Arguments.arguments("44051401448", Sex.FEMALE)
        );
    }

}