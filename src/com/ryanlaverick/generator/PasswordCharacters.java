package com.ryanlaverick.generator;

public enum PasswordCharacters {
    NUMERIC("0123456789"),
    SYMBOLIC("`¬!£$%^&*()-_=+[{}];:'@#~,<.>/?"),
    ALPHABETICAL("abcdefghijklmnopqrstuvwxyz");

    private String characters;
    PasswordCharacters(String characters) {
        this.characters = characters;
    }

    public String getCharacters() {
        return characters;
    }

    public char[] getCharArray() {
        return characters.toCharArray();
    }
}
