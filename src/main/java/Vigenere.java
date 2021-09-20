import java.util.Scanner;

public class Vigenere {
    public static boolean isLetter(char ch){
        return ((ch>='a'&& ch<='z')||(ch>='A'&&ch<='Z'));
    }
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
    public static int letterToNumber(char ch){
        if (ch>='a'){
            return ch-'a';
        }
        else{
            return (ch-'A');
        }

    }
    public static int interpretKey(int index, String key){
        return letterToNumber(key.charAt(index));
    }
    public static String encryptVigenere(String message, String key) {
        String encrypted = "";
        int keyIndex=-1;
        for (int i=0;i<message.length();i++){
            char ch=message.charAt(i);
            if ( !(isLetter(ch))){
                encrypted+=ch;
            }
            else{
                keyIndex++;
                if (keyIndex==key.length()){
                    keyIndex=0;
                }
                encrypted+=nextLetter(ch,interpretKey(keyIndex,key));
            }
        }
        return encrypted;
    }

    public static String decryptVigenere(String message, String key) {
        String decrypted = "";
        int keyIndex=-1;
        for (int i=0;i<message.length();i++){
            char ch=message.charAt(i);
            if ( !(isLetter(ch))){
                decrypted+=ch;
            }
            else{
                keyIndex++;
                if (keyIndex==key.length()){
                    keyIndex=0;
                }
                decrypted+=lastLetter(ch,interpretKey(keyIndex,key));
            }
        }
        return decrypted;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
