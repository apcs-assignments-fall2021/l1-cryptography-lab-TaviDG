import java.util.Scanner;

public class Affine {
    public static int letterToNumber(char ch){
        if (ch>='a'){
            return ch-'a';
        }
        else{
            return (int) (ch-'A');
        }

    }
    public static boolean isLetter(char ch){
        return ((ch>='a'&& ch<='z')||(ch>='A'&&ch<='Z'));
    }
    public static char encryptChar(char ch, int key, int key2){
        int x = letterToNumber(ch);
        x = ((x*key)+key2)%26;
        if (ch>='a') {
            return (char) (x + 'a');
        }
        else{
            return (char)(x+'A');
        }
    }
    public static char decryptChar(char ch, int key, int key2){
        int x = letterToNumber(ch);
        x = (x-key2);
        if (x<0){
            x=25-x;
        }
        x= (int)(((double)x/key)+1);
        if (ch>='a') {
            return (char) (x + 'a');
        }
        else{
            return (char)(x+'A');
        }
    }
    public static String encryptAffine(String message) {
        String encrypted= "";
        for (int i = 0;i<(message.length());i++){
            char ch=' ';
            if (isLetter(message.charAt(i))){
                ch = (encryptChar(message.charAt(i),3,0));
            }
            else{
                ch=message.charAt(i);
            }
            encrypted+=ch;
        }
        return encrypted;
    }

    public static String decryptAffine(String message) {
        String decrypted= "";
        for (int i = 0;i<(message.length());i++){
            char ch= ' ';
            if (isLetter(message.charAt(i))){
                ch = decryptChar(message.charAt(i),3,0);

            }
            else{
                ch= message.charAt(i);
            }
            decrypted+=ch;
        }
        return decrypted;
    }

    public static String encryptAffineKeys(String message, int key1, int key2) {
        // REPLACE THIS WITH YOUR CODE
        return message;
    }

    public static int modularInverse(int x) {
        // REPLACE THIS WITH YOUR CODE
        return -1;
    }


    public static String decryptAffineKeys(String message, int key1, int key2) {
        // REPLACE THIS WITH YOUR CODE
        return message;
    }

    // Some basic testing code
    public static void main(String[] args) {
        System.out.println("Encrypt and Decrypt Basic Tests:");
        System.out.println(encryptAffine(("Hello, World!"))); // Vmhhq, Oqzhj!
        System.out.println(decryptAffine("Vmhhq, Oqzhj!")); // Hello, World!

        System.out.println();
        System.out.println("Modular Inverse Tests:");
        System.out.println(modularInverse(9)); // 3
        System.out.println(modularInverse(3)); // 9
        System.out.println(modularInverse(23)); // 17

        System.out.println();
        System.out.println("Affine Encrypt and Decrypt with Keys Tests:");
        System.out.println(encryptAffineKeys("hello", 5, 17)); // aluuj
        System.out.println(decryptAffineKeys("aluuj", 5, 17)); // hello
    }
}
