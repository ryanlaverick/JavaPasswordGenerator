package com.ryanlaverick;

import com.ryanlaverick.generator.PasswordGenerator;

import java.util.Scanner;

public class Main {

    //TODO Comment code, implement system for user to store passwords (MySQL) in accordance with usernames?
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Use numeric characters in password: ");
        String stringUsesNumeric = scanner.next();
        boolean usesNumeric = getResult(stringUsesNumeric);

        System.out.println(" ");
        System.out.println("Use symbol characters in password: ");
        String stringUsesSymbol = scanner.next();
        boolean usesSymbolic = getResult(stringUsesSymbol);

        System.out.println(" ");
        System.out.println("Use alphabetical characters in password: ");
        String stringUsesAlphabetical = scanner.next();
        boolean usesAlphabetical = getResult(stringUsesAlphabetical);

        PasswordGenerator passwordGenerator = new PasswordGenerator(usesNumeric, usesSymbolic, usesAlphabetical);

        System.out.println(" ");
        System.out.println("Password length: ");
        String len = scanner.next();
        int passwordLength = isInt(len) ? Integer.parseInt(len) : 10;
        if (!isInt(len)) {
            System.out.println(" ");
            System.out.println("Password length unparsable, defaulting to 10 (TEN)..");
        }

        String password = passwordGenerator.generate(passwordLength);
        System.out.println(" ");
        System.out.println("Password profile: ");
        System.out.println("    -> Uses NUMERIC characters: " + usesNumeric);
        System.out.println("    -> Uses SYMBOLIC characters: " + usesSymbolic);
        System.out.println("    -> Uses ALPHABETICAL characters: " + usesAlphabetical);
        System.out.println("    -> Password length: " + passwordLength);
        System.out.println(" ");
        System.out.println("Generated password: " + password);
    }

    private static boolean isInt(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch(NumberFormatException ex) {
            return false;
        }
    }

    private static boolean getResult(String string) {
        string = string.toLowerCase();

        switch(string) {
            case "true":
            case "y":
            case "yes":
                return true;
            default:
                return false;
        }
    }
}
