package com.qabotics.account;

public class PasswordValidationService {

    private final PasswordBlacklistService blacklistService;

    public PasswordValidationService(PasswordBlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }

    public boolean isValid(String password) {
        if (password == null) throw new IllegalArgumentException("Password cannot be null");
        if (password.length() < 10) return false;

        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        if (!(hasUppercase && hasDigit && hasSpecial))
            return false;

        return !blacklistService.isCommonPassword(password);
    }
}
