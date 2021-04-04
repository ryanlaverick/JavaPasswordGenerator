package com.ryanlaverick.generator;

import java.util.concurrent.ThreadLocalRandom;

public class PasswordGenerator {
    private char[] charArray;

    //TODO Allow users to specify what characters they wish to include or exclude from each PasswordCharacters set?

    public PasswordGenerator(boolean usesNumericCharacters, boolean usesSymbolicCharacters, boolean usesAlphabeticalCharacters) {
        String charactersToUse = "";
        charactersToUse = usesNumericCharacters ? charactersToUse.concat(PasswordCharacters.NUMERIC.getCharacters()) : charactersToUse.concat("");
        charactersToUse = usesSymbolicCharacters ? charactersToUse.concat(PasswordCharacters.SYMBOLIC.getCharacters()) : charactersToUse.concat("");
        charactersToUse = usesAlphabeticalCharacters ? charactersToUse.concat(PasswordCharacters.ALPHABETICAL.getCharacters()) : charactersToUse.concat("");

        charArray = charactersToUse.toCharArray();
    }

    public String generate(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i <= length; i++) {
            int randomPosition = ThreadLocalRandom.current().nextInt(charArray.length);
            char selectedCharacter = charArray[randomPosition];

            stringBuilder.append(selectedCharacter);
        }

        return stringBuilder.toString().trim();
    }
}
