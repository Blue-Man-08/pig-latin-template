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
    String result = translateWord(input);
    return result;
  }
  public static String translateLine(String input){
    
    return output;
  }

  public static String translateWord(String input)
  {
    String testCases = "aeiouy";
    String returnVal = "";
    int firstVowel = 3000;
    input = input.toLowerCase();
    System.out.println(PigLatinTranslator.spacePlace(input));
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
  public static List<Integer> spacePlace(String input){
    //returns index of spaces
    List<Integer> spaceList = new ArrayList<Integer>();
    for(int i = 1; i <= input.length(); i++){
      if(input.substring(i-1,i).equals(" ")){
        spaceList.add(i-1);
      }
    }
    return spaceList;
  }
  private static String preSpaces(){

  }
  private static String postSpaces(){

  }
  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}