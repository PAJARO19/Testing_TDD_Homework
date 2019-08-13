package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class UserServiceTest {

    User user;
    UserService userService = new UserService(new PeselService(), new DateService());

    @BeforeEach
    void createInstanceOfUser() {
        user = new User();
    }

    @Test
    void validateUserDataTest1() {
        user.pesel = "123456";
        try {
            userService.validateUserData(user);
            fail("Exception hasn't been catched");
        } catch (IllegalArgumentException e) {
            assertEquals("Pesel is invalid", e.getMessage());
        }
    }

    @ParameterizedTest
    @MethodSource("dataForValidateUserDataTest2")
    void validateUserDataTest2(String pesel, LocalDate dateOfBirth) {
        user.pesel = pesel;
        user.dateOfBirth = dateOfBirth;
        try {
            userService.validateUserData(user);
        } catch (IllegalArgumentException e) {
            assertEquals("Date of birth is inconsistent with pesel", e.getMessage());
        }
    }

    static Stream<Arguments> dataForValidateUserDataTest2() {
        return Stream.of(
                Arguments.arguments("44051401458", LocalDate.of(1945, 05, 14)),
                Arguments.arguments("84011201654", LocalDate.of(1985, 1, 12))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidateUserDataTest3")
    void validateUserData3(String pesel, LocalDate dateOfBirth, Sex sex) {
        user.pesel = pesel;
        user.dateOfBirth = dateOfBirth;
        user.sex = sex;
        try {
            userService.validateUserData(user);
        } catch (IllegalArgumentException e) {
            assertEquals("Sex is inconsistent with pesel", e.getMessage());
        }
    }

    static Stream<Arguments> dataForValidateUserDataTest3() {
        return Stream.of(
                Arguments.arguments("44051401458", LocalDate.of(1944, 05, 14), Sex.FEMALE),
                Arguments.arguments("84011201654", LocalDate.of(1984, 1, 12), Sex.FEMALE)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidateUserData4")
    void validateUserDataTest4(String pesel, LocalDate dateOfBirth, Sex sex) {
        user.pesel = pesel;
        user.dateOfBirth = dateOfBirth;
        user.sex = sex;
        try {
            userService.validateUserData(user);
            fail("Nie rzucam wyjatkiem");
        } catch (IllegalArgumentException e) {
            assertEquals("Date of birth is after today", e.getMessage());
        }
    }

    static Stream<Arguments> dataForValidateUserData4() {
        return Stream.of(
                Arguments.arguments("20251401458", LocalDate.of(2020, 05, 14), Sex.MALE),
                Arguments.arguments("84011201654", LocalDate.of(1984, 1, 12), Sex.MALE)
                //w 2 przypadku wyświetli fail message, tak ma być
        );
    }

}