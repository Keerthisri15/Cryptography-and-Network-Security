import java.util.*;
import java.io.*;

public class CaesarCipher
{
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String plaintext, int caeserKey) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);

            if (Character.isLetter(currentChar)) {
                char encryptedChar = encryptChar(currentChar, caeserKey);
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(currentChar);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int caeserKey) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);

            if (Character.isLetter(currentChar)) {
                char decryptedChar = decryptChar(currentChar, caeserKey);
                plaintext.append(decryptedChar);
            } else {
                plaintext.append(currentChar);
            }
        }
        return plaintext.toString();
    }

    private static char encryptChar(char inputChar, int caeserKey) {
        char base = Character.isUpperCase(inputChar) ? 'A' : 'a';
        int charIndex = (inputChar - base + caeserKey) % 26;
        if (charIndex < 0) {
            charIndex += 26;
        }
        return (char) (base + charIndex);
    }

    private static char decryptChar(char inputChar, int caeserKey) {
        char base = Character.isUpperCase(inputChar) ? 'A' : 'a';
        int charIndex = (inputChar - base - caeserKey) % 26;
        if (charIndex < 0) {
            charIndex += 26;
        }
        return (char) (base + charIndex);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the PLAIN TEXT for Encryption: ");
        String plaintext = br.readLine();

        System.out.println("Enter the CAESERKEY between 0 and 25:");
        int caeserKey = Integer.parseInt(br.readLine());

        System.out.println("ENCRYPTION");
        String ciphertext = encrypt(plaintext, caeserKey);
        System.out.println("CIPHER TEXT: " + ciphertext);

        System.out.println("DECRYPTION");
        String decryptedText = decrypt(ciphertext, caeserKey);
        System.out.println("PLAIN TEXT: " + decryptedText);
    }
}
