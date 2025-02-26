package com.qabotics.unit;

import com.qabotics.account.PasswordBlacklistService;
import com.qabotics.account.PasswordValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PasswordBlacklistTest {
    @Mock
    PasswordBlacklistService passwordBlacklistService;
    PasswordValidationService passwordValidationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        passwordValidationService = new PasswordValidationService(passwordBlacklistService);
    }

    @Test
    void givenCommonPassword_whenValidating_thenReturnFalse() {
        String password = "Password123!";
        when(passwordBlacklistService.isCommonPassword(password)).thenReturn(true);

        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertFalse(isValid);
        verify(passwordBlacklistService).isCommonPassword(password);
    }

    @Test
    void givenNonCommonPassword_whenValidating_thenReturnTrue() {
        String password = "Ab1!abcdef";
        when(passwordBlacklistService.isCommonPassword(password)).thenReturn(false);

        boolean isValid = passwordValidationService.isValid(password);
        Assertions.assertTrue(isValid);
        verify(passwordBlacklistService).isCommonPassword(password);
    }
}
