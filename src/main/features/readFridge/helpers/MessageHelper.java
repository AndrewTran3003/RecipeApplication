package features.readFridge.helpers;

public class MessageHelper {
    public static String invalidFormat(String input){
        return "An error occurred while parsing the input \""+ input+"\". Make sure the string is properly formatted";
    }
}
