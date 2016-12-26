/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordlengths;

import edu.duke.*;
import java.util.HashMap;
import static jdk.nashorn.internal.objects.NativeString.indexOf;
/**
 *
 * @author Виктория
 */
public class WordLengths {
    
    private static FileResource fr = new FileResource();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        countWordLengths(fr);// TODO code application logic here
    }
    
    public static void countWordLengths(FileResource resource){
       HashMap<Integer, String> hashMapForWords = new HashMap<>();
       HashMap<Integer, Integer> hashMapForNumber = new HashMap<>();
        for (String message : resource.words()){
            int length = message.length();
            if (message.toUpperCase().codePointAt(0) < 65  || message.toUpperCase().codePointAt(0) > 90)
                if ((message.indexOf(message.codePointAt(0)) >= 0)) 
                    message = message.substring(1, length);
            
            if (message.toUpperCase().codePointAt(length - 1) < 65  || message.toUpperCase().codePointAt(length - 1) > 90)
                if ((message.indexOf(message.codePointAt(length - 1)) >= 0)) 
                    message = message.substring(0, length - 1);
            int i = 0;
            if (hashMapForWords.containsKey(message.length())){
                String newValue = hashMapForWords.get(message.length()) + ", " + message;
                hashMapForWords.put(message.length(), newValue);
                i = hashMapForNumber.get(message.length())+1;
                hashMapForNumber.put(message.length(), i);
            } else{
                hashMapForWords.put(message.length(), message);
                i = 1;
                hashMapForNumber.put(message.length(), i);
            }
        }
        
        hashMapForWords.entrySet().stream().forEach((entry) -> {
            System.out.println(" words of length " + entry.getKey() + " : "+ entry.getValue());
        });
        hashMapForNumber.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getValue() + " words of length " + entry.getKey());
        });
}
}
