/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class user {
    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    // create object
    LoginSystem user = new LoginSystem();

    // ===== REGISTRATION =====
    System.out.println("=== Registration ===");

    System.out.print("Enter username: ");
    String usernameInput = scan.nextLine();

    System.out.print("Enter password: ");
    String passwordInput = scan.nextLine();

    System.out.print("Enter first name: ");
    String firstNameInput = scan.nextLine();

    System.out.print("Enter last name: ");
    String lastNameInput = scan.nextLine();

    System.out.print("Enter cellphone number: ");
    String cellphoneInput = scan.nextLine();

    // call register method
    String message = user.registerUser(usernameInput, passwordInput, firstNameInput, lastNameInput, cellphoneInput);

    // show result
    System.out.println(message);

    //login
    if (message.equals("User has been registered successfully.")) {

        System.out.println("\n=== Login ===");

        System.out.print("Enter username: ");
        String loginUsername = scan.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = scan.nextLine();

        // check login
        boolean result = user.loginUser(loginUsername, loginPassword);

        // display message
        System.out.println(user.returnLoginStatus(result));
    }

    scan.close(); // close scanner
}
}
    

