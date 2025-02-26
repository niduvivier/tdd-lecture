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
        String password = "Ab123456";  // 8 characters, has uppercase.
        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertTrue(isValid);
    }

    @Test
    void givenPasswordRightAboveLengthRequirement_whenValidating_thenReturnTrue() {
        String password = "Ab1234567";  // 9 characters, has uppercase.
        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertTrue(isValid);
    }

    @Test
    void givenPasswordRightBelowLengthRequirement_whenValidating_thenReturnFalse() {
        String password = "Ab12345";  // 7 characters, has uppercase.
        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertFalse(isValid);
    }

    @Test
    void givenPasswordWithoutUppercase_whenValidating_thenReturnFalse() {
        String password = "ab123456";  // 8 characters, no uppercase.
        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertFalse(isValid);
    }

    @Test
    void givenPasswordWithoutDigit_whenValidating_thenReturnFalse() {
        String password = "Abcdefgh";  // 8 characters, no digit.
        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertFalse(isValid);
    }
}
