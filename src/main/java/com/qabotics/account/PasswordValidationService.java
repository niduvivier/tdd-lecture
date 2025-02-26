package com.qabotics.account;

public class PasswordValidationService {
    public boolean isValid(String password) {
        if (password == null) throw new IllegalArgumentException("Password cannot be null");
        if (password.length() < 8) return false;

        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }
        return hasUppercase && hasDigit;
    }
}
