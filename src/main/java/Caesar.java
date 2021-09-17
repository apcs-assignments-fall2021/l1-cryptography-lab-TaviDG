import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static char nextLetter(char ch, int shift) {
        int x = ch+shift;
        if (x>'Z'&& ch<'a'){
            x-=26;
        }
        else if (x>'z'){
            x-=26;
        }
        return (char) (x);

    }
    public static char lastLetter(char ch, int shift) {
        int x = ch-shift;
        if (x<'a'&& ch>'Z'){
            x+=26;
        }
        else if (x<'A'){
            x+=26;
        }
        return (char) (x);

    }
    public static boolean isLetter(char ch){
        return ((ch>='a'&& ch<='z')||(ch>='A'&&ch<='Z'));
    }
    public static String encryptCaesar(String message) {
        String encrypted= "";
        for (int i = 0;i<(message.length());i++){
            char ch=' ';
            if (isLetter(message.charAt(i))){
                ch = nextLetter(message.charAt(i),3);
            }
            else{
                ch=message.charAt(i);
            }
            encrypted+=ch;
        }
        return encrypted;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String decrypted= "";
        for (int i = 0;i<(message.length());i++){
            char ch= ' ';
            if (isLetter(message.charAt(i))){
                ch = lastLetter(message.charAt(i),3);

            }
            else{
                ch= message.charAt(i);
            }
            decrypted+=ch;
        }
        return decrypted;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String encrypted= "";
        if (key>26){
            key%=26;
        }
        for (int i = 0;i<(message.length());i++){
            char ch=' ';
            if (isLetter(message.charAt(i))){
                ch = nextLetter(message.charAt(i),key);
            }
            else{
                ch=message.charAt(i);
            }
            encrypted+=ch;
        }
        return encrypted;

    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String decrypted= "";
        if (key>26){
            key%=26;
        }
        for (int i = 0;i<(message.length());i++){
            char ch= ' ';
            if (isLetter(message.charAt(i))){
                ch = lastLetter(message.charAt(i),key);

            }
            else{
                ch= message.charAt(i);
            }
            decrypted+=ch;
        }
        return decrypted;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
