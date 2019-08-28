package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class UserServiceTestMockito {

    User user;
    PeselService peselService;
    UserService userService;

    @BeforeEach
    void createInstanceOfUserAndMockedPeselService() {
        peselService = Mockito.mock(PeselService.class);
        userService = new UserService(peselService, new DateService());
        user = new User();
    }

    //ten test nie przechodzi, rzuca fail message, tak ma być
    @Test
    void validateUserDataTest1() {
        Mockito.when(peselService.isValid("1234")).thenReturn(true);
        Mockito.when(peselService.getDateOfBirth("1234")).thenReturn(LocalDate.of(1944, 12, 12));
        Mockito.when(peselService.getSex("1234")).thenReturn(Sex.FEMALE);
        user.pesel = "1234";
        user.dateOfBirth = LocalDate.of(1944, 12, 12);
        user.sex = Sex.FEMALE;
        try {
            userService.validateUserData(user);
            fail("Exception hasn't been catched");
        } catch (IllegalArgumentException e) {
            assertEquals("Pesel is invalid", e.getMessage());
        }
    }

    @Test
    void validateUserDataTest2() {
        Mockito.when(peselService.isValid("1234")).thenReturn(false);
        Mockito.when(peselService.getDateOfBirth("1234")).thenReturn(LocalDate.of(1944, 12, 12));
        Mockito.when(peselService.getSex("1234")).thenReturn(Sex.FEMALE);
        user.pesel = "1234";
        user.dateOfBirth = LocalDate.of(1944, 12, 12);
        user.sex = Sex.FEMALE;
        try {
            userService.validateUserData(user);
            fail("Exception hasn't been catched");
        } catch (IllegalArgumentException e) {
            assertEquals("Pesel is invalid", e.getMessage());
        }
    }

    @Test
    void validateUserDataTest3() {
        Mockito.when(peselService.isValid("1234")).thenReturn(true);
        Mockito.when(peselService.getDateOfBirth("1234")).thenReturn(LocalDate.of(1944, 12, 12));
        Mockito.when(peselService.getSex("1234")).thenReturn(Sex.FEMALE);
        user.pesel = "1234";
        user.dateOfBirth = LocalDate.of(2012, 12, 12);
        user.sex = Sex.FEMALE;
        try {
            userService.validateUserData(user);
            fail("Exception hasn't been catched");
        } catch (IllegalArgumentException e) {
            assertEquals("Date of birth is inconsistent with pesel", e.getMessage());
        }
    }

    @Test
    void validateUserDataTest4() {
        Mockito.when(peselService.isValid("1234")).thenReturn(true);
        Mockito.when(peselService.getDateOfBirth("1234")).thenReturn(LocalDate.of(1944, 12, 12));
        Mockito.when(peselService.getSex("1234")).thenReturn(Sex.FEMALE);
        user.pesel = "1234";
        user.dateOfBirth = LocalDate.of(1944, 12, 12);
        user.sex = Sex.MALE;
        try {
            userService.validateUserData(user);
            fail("Exception hasn't been catched");
        } catch (IllegalArgumentException e) {
            assertEquals("Sex is inconsistent with pesel", e.getMessage());
        }
    }

    @Test
    void validateUserDataTest5() {
        Mockito.when(peselService.isValid("1234")).thenReturn(true);
        Mockito.when(peselService.getDateOfBirth("1234")).thenReturn(LocalDate.of(2020, 12, 12));
        Mockito.when(peselService.getSex("1234")).thenReturn(Sex.FEMALE);
        user.pesel = "1234";
        user.dateOfBirth = LocalDate.of(2020, 12, 12);
        user.sex = Sex.FEMALE;
        try {
            userService.validateUserData(user);
            fail("Exception hasn't been catched");
        } catch (IllegalArgumentException e) {
            assertEquals("Date of birth is after today", e.getMessage());
        }
    }
}