package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserServiceTestMockito {

    User user = Mockito.mock(User.class);
    UserService userService = Mockito.mock(UserService.class);

    @BeforeEach
    void createInstanceOfUser() {
        user = Mockito.mock(User.class);
    }

    @Test
    void validateUserDataTest1() {
        user.pesel = "123456";
        Mockito.doThrow(IllegalArgumentException.class).when(userService).validateUserData(user);
        assertThatThrownBy(() -> userService.validateUserData(user))
                .isInstanceOf(IllegalArgumentException.class);
        Mockito.verify(userService, Mockito.times(1)).validateUserData(user);
    }

    @ParameterizedTest
    @MethodSource("dataForValidateUserDataTest2")
    void validateUserDataTest2(String pesel, LocalDate dateOfBirth) {
        user.pesel = pesel;
        user.dateOfBirth = dateOfBirth;
        Mockito.doThrow(IllegalArgumentException.class).when(userService).validateUserData(user);
        assertThatThrownBy(() -> userService.validateUserData(user))
                .isInstanceOf(IllegalArgumentException.class);
        Mockito.verify(userService, Mockito.times(1)).validateUserData(user);
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
        Mockito.doThrow(IllegalArgumentException.class).when(userService).validateUserData(user);
        assertThatThrownBy(() -> userService.validateUserData(user))
                .isInstanceOf(IllegalArgumentException.class);
        Mockito.verify(userService, Mockito.times(1)).validateUserData(user);
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
        Mockito.doThrow(IllegalArgumentException.class).when(userService).validateUserData(user);
        assertThatThrownBy(() -> userService.validateUserData(user))
                .isInstanceOf(IllegalArgumentException.class);
        Mockito.verify(userService, Mockito.times(1)).validateUserData(user);
    }

    static Stream<Arguments> dataForValidateUserData4() {
        return Stream.of(
                Arguments.arguments("20251401458", LocalDate.of(2020, 05, 14), Sex.MALE),
                Arguments.arguments("84011201654", LocalDate.of(1984, 1, 12), Sex.MALE)
                //w przeciwieństwie do testu bez użycia mocka, w 2 przypadku nie wyświetli fail message, tak ma być
        );
    }
}