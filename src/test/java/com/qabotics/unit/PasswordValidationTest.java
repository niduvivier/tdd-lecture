package com.qabotics.unit;

import com.qabotics.account.PasswordValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {
    PasswordValidationService passwordValidationService;

    @BeforeEach
    public void setUp() {
        passwordValidationService = new PasswordValidationService();
    }

    @Test
    void givenPasswordIsValid_whenValidating_thenReturnTrue() {
        String password = "Ab12345!";  // 8 characters, has uppercase.
        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertTrue(isValid);
    }

    @Test
    void givenPasswordRightAboveLengthRequirement_whenValidating_thenReturnTrue() {
        String password = "Ab123456!";  // 9 characters, has uppercase.
        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertTrue(isValid);
    }

    @Test
    void givenPasswordRightBelowLengthRequirement_whenValidating_thenReturnFalse() {
        String password = "Ab1234!";  // 7 characters, has uppercase.
        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertFalse(isValid);
    }

    @Test
    void givenPasswordWithoutUppercase_whenValidating_thenReturnFalse() {
        String password = "ab12345!";  // 8 characters, no uppercase.
        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertFalse(isValid);
    }

    @Test
    void givenPasswordWithoutDigit_whenValidating_thenReturnFalse() {
        String password = "Abcdefg!";  // 8 characters, no digit.
        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertFalse(isValid);
    }

    @Test
    public void givenPasswordIsNull_whenValidating_thenThrowsNullArgumentException() {
        String password = null;
        IllegalArgumentException e = Assertions.assertThrowsExactly(
                IllegalArgumentException.class,
                () -> passwordValidationService.isValid(password)
        );
        Assertions.assertEquals("Password cannot be null", e.getMessage());
    }

    @Test
    void givenPasswordWithoutSpecialCharacter_whenValidating_thenReturnFalse() {
        String password = "Ab12abcdef"; // Missing special character.
        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertFalse(isValid);
    }
}
