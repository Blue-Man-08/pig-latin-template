import java.lang.*;
import java.util.ArrayList;
import java.util.List;
public class PigLatinTranslator
{
  public static Book translate(Book input)
  {
    Book translatedBook = new Book();

    // Add code here to populate translatedBook with a translation of the input book.
    // Curent do-nothing code will return an empty book.

    return translatedBook;
  }

  public static String translate(String input)
  {
    // System.out.println("Translate String: '" + input + "'");

    // Replace this code to translate a string input.
    // The input to this function could be any English string. 
    // A sentence, paragraph, or a single word. 
    // It should call translateWord at least once.
    String result = translateLine(input);
    return result;
  }
  public static String translateLine(String input){
    String returnPhrase = "";
    List<Integer> nonLetters = nonLetterPlace(input);
    for(int i = 0; i <= nonLetters.size(); i++){
      if(nonLetters.get(0) != 0 && i == 0){
        returnPhrase += PigLatinTranslator.translateWord(input.substring(0, nonLetters.get(i+1)));
      }
      returnPhrase += PigLatinTranslator.translateWord(input.substring(nonLetters.get(i), nonLetters.get(i+1)));
    }
    return returnPhrase;
    
  }

  public static String translateWord(String input)
  {
    String testCases = "aeiouyAEIOUY";
    String returnVal = "";
    int firstVowel = 3000;
    if(input.length() == 0){
      return "";
    }
    for( int i = 1; i <= input.length(); i++){
      if(testCases.contains(input.substring(i-1, i)) && firstVowel == 3000){
        firstVowel = i;
        System.out.println(i);
      } 
    }
    if(firstVowel == 3000){
      returnVal = input.substring(input.length()-1, input.length()) + input.substring(0, input.length()-1) + "ay";
    }
    returnVal = input.substring(firstVowel-1, input.length()) + input.substring(0, firstVowel-1);
    if(testCases.contains(returnVal.substring(returnVal.length()-1, returnVal.length()))){
      return returnVal + "yay";
    }
    return returnVal + "ay";
  }
  public static List<Integer> nonLetterPlace(String input){
    //returns index of spaces
    String testCases = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    List<Integer> spaceList = new ArrayList<Integer>();
    for(int i = 1; i <= input.length(); i++){
      if(!(testCases.contains(input.substring(i-1,i)))){
        spaceList.add(i-1);
      }
    }
    return spaceList;
  }
  //private static String preSpaces(){

  //}
  //private static String postSpaces(){

  //}
  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}