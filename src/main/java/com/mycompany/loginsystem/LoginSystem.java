/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsystem;
import java.util.Scanner;

public class LoginSystem {

// variables to store user details
private String username; private String password; private String firstName; private String lastName; private String cellphone;

// check if username is valid
public boolean checkUserName(String username) {

    // must contain "_" and be 5 characters or less
    if (username.contains("_") && username.length() <= 5) {
        return true;
    } else {
        return false;
    }
}

// check if password meets requirements
public boolean checkPasswordComplexity(String password) {

    // first check length
    if (password.length() < 8) {
        return false;
    }

    // all requirments are intially false
    boolean hasUpper = false;
    boolean hasNumber = false;
    boolean hasSpecial = false;

    // loop through each character
    for (int i = 0; i < password.length(); i++) {

        char ch = password.charAt(i); // get one character at a time

        // check uppercase
        if (Character.isUpperCase(ch)) {
            hasUpper = true;
        }

        // check number
        if (Character.isDigit(ch)) {
            hasNumber = true;
        }

        // check special character
        if (!Character.isLetterOrDigit(ch)) {
            hasSpecial = true;
        }
    }

    // all conditions must be true
    if (hasUpper && hasNumber && hasSpecial) {
        return true;
    } else {
        return false;
    }
}

// check cellphone number
public boolean checkCellphoneNumber(String cellphone) {

    // must start with +27 and be 12 characters
    if (cellphone.startsWith("+27") && cellphone.length() == 12) {
        return true;
    } else {
        return false;
    }
}

// method to register user
public String registerUser(String username, String password, String firstName, String lastName, String cellphone) {

    // check username
    if (!checkUserName(username)) {
        return "Username is not correctly formatted, please ensure it contains an underscore and is no more than 5 characters.";
    }

    // check password
    if (!checkPasswordComplexity(password)) {
     return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }

    // check cellphone
    if (!checkCellphoneNumber(cellphone)) {
        return "Cell phone number incorrectly formatted or does not contain international code.";
    }

    // if all correct, save details
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.cellphone = cellphone;

    return "User has been registered successfully.";
}

// method to check login
public boolean loginUser(String username, String password) {

    // compare entered values with stored ones
    if (username.equals(this.username) && password.equals(this.password)) {
        return true;
    } else {
        return false;
    }
}

// method to display login message
public String returnLoginStatus(boolean status) {

    if (status) {
        return "Welcome " + firstName + " " + lastName;
    } else {
        return "Username or password incorrect, please try again.";
    }
}
}




