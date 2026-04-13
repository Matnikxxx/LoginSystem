package com.mycompany.loginsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginSystemTest {

    private LoginSystem loginSystem;

    @BeforeEach
    void setUp() {
        loginSystem = new LoginSystem();
    }

    // username Tests
    @Test
    void testValidUsername() {
        assertTrue(loginSystem.checkUserName("a_bcd"));
    }

    @Test
    void testUsernameTooLong() {
        assertFalse(loginSystem.checkUserName("abc_def"));
    }

    @Test
    void testUsernameMissingUnderscore() {
        assertFalse(loginSystem.checkUserName("abcde"));
    }

    //password Tests
    void testValidPassword() {
        assertTrue(loginSystem.checkPasswordComplexity("Abcdef1!"));
    }

    @Test
    void testPasswordTooShort() {
        assertFalse(loginSystem.checkPasswordComplexity("A1!b"));
    }

    @Test
    void testPasswordMissingUppercase() {
        assertFalse(loginSystem.checkPasswordComplexity("abcdef1!"));
    }

    @Test
    void testPasswordMissingNumber() {
        assertFalse(loginSystem.checkPasswordComplexity("Abcdefg!"));
    }

    @Test
    void testPasswordMissingSpecialCharacter() {
        assertFalse(loginSystem.checkPasswordComplexity("Abcdefg1"));
    }

    // cellphone Tests 
    @Test
    void testValidCellphone() {
        assertTrue(loginSystem.checkCellphoneNumber("+27831234567"));
    }

    @Test
    void testCellphoneMissingCountryCode() {
        assertFalse(loginSystem.checkCellphoneNumber("0831234567"));
    }

    @Test
    void testCellphoneWrongLength() {
        assertFalse(loginSystem.checkCellphoneNumber("+27831234"));
    }

    // Registration Tests
    @Test
    void testSuccessfulRegistration() {
        String result = loginSystem.registerUser("a_bcd", "Abcdef1!", "John", "Doe", "+27831234567");
        assertEquals("User has been registered successfully.", result);
    }

    @Test
    void testRegistrationInvalidUsername() {
        String result = loginSystem.registerUser("abcd", "Abcdef1!", "John", "Doe", "+27831234567");
        assertTrue(result.contains("Username is not correctly formatted"));
    }

    @Test
    void testRegistrationInvalidPassword() {
        String result = loginSystem.registerUser("a_bcd", "abcdefg1", "John", "Doe", "+27831234567");
        assertTrue(result.contains("Password is not correctly formatted"));
    }

    @Test
    void testRegistrationInvalidCellphone() {
        String result = loginSystem.registerUser("a_bcd", "Abcdef1!", "John", "Doe", "0831234567");
        assertTrue(result.contains("Cell phone number incorrectly formatted"));
    }

    // login Tests 
    @Test
    void testSuccessfulLogin() {
        loginSystem.registerUser("a_bcd", "Abcdef1!", "John", "Doe", "+27831234567");
        assertTrue(loginSystem.loginUser("a_bcd", "Abcdef1!"));
    }

    @Test
    void testFailedLoginWrongUsername() {
        loginSystem.registerUser("a_bcd", "Abcdef1!", "John", "Doe", "+27831234567");
        assertFalse(loginSystem.loginUser("wrong", "Abcdef1!"));
    }

    @Test
    void testFailedLoginWrongPassword() {
        loginSystem.registerUser("a_bcd", "Abcdef1!", "John", "Doe", "+27831234567");
        assertFalse(loginSystem.loginUser("a_bcd", "wrongpass"));
    }

    //Login Status Message Tests 
    @Test
    void testReturnLoginStatusSuccess() {
        loginSystem.registerUser("a_bcd", "Abcdef1!", "John", "Doe", "+27831234567");
        assertEquals("Welcome John Doe", loginSystem.returnLoginStatus(true));
    }

}