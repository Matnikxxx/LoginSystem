package com.mycompany.loginsystem;

import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;

public class LoginSystemTest {

LoginSystem system = new LoginSystem();
//username tests



@Test
public void testUsernameCorrect() {
    assertTrue(system.checkUserName("kyl_1"));
}

@Test
public void testUsernameIncorrect() {
    assertFalse(system.checkUserName("kyle!!!!!!!"));
}

//password tests
@Test
public void testPasswordCorrect() {
    assertTrue(system.checkPasswordComplexity("Ch&&sec@ke99!"));
}

@Test
public void testPasswordIncorrect() {
    assertFalse(system.checkPasswordComplexity("password"));
}

//cellphone tests

@Test
public void testCellphoneCorrect() {
    assertTrue(system.checkCellphoneNumber("+27838968976"));
}

@Test
public void testCellphoneIncorrect() {
    assertFalse(system.checkCellphoneNumber("08966553"));
}


//register tests
@Test
public void testRegisterSuccess() {
    String result = system.registerUser(
            "kyl_1",
            "Ch&&sec@ke99!",
            "Kyle",
            "Smith",
            "+27838968976"
    );

    assertEquals("User has been registered successfully.", result);
}

@Test
public void testRegisterUsernameFail() {
    String result = system.registerUser(
            "kyle!!!!!!!",
            "Ch&&sec@ke99!",
            "Kyle",
            "Smith",
            "+27838968976"
    );

    assertEquals(
        "Username is not correctly formatted, please ensure it contains an underscore and is no more than 5 characters.",
        result
    );
}
//login tests
@Test
public void testRegisterPasswordFail() {
    String result = system.registerUser(
            "kyl_1",
            "password",
            "Kyle",
            "Smith",
            "+27838968976"
    );

    assertEquals(
        "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
        result
    );
}

@Test
public void testRegisterCellphoneFail() {
    String result = system.registerUser(
            "kyl_1",
            "Ch&&sec@ke99!",
            "Kyle",
            "Smith",
            "08966553"
    );

    assertEquals(
        "Cell phone number incorrectly formatted or does not contain international code.",
        result
    );
}

//login message sent

@Test
public void testLoginSuccess() {
    system.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");

    boolean result = system.loginUser("kyl_1", "Ch&&sec@ke99!");

    assertTrue(result);
}

@Test
public void testLoginFail() {
    system.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");

    boolean result = system.loginUser("wrong", "wrong");

    assertFalse(result);
}



@Test
public void testLoginMessageSuccess() {
    system.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");

    String message = system.returnLoginStatus(true);

    assertEquals("Welcome Kyle Smith", message);
}

@Test
public void testLoginMessageFail() {
    String message = system.returnLoginStatus(false);

    assertEquals("Username or password incorrect, please try again.", message);
}
}