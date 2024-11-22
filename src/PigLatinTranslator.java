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
    String result = translateLine(input);
    return result;
  }
  public static String translateLine(String input){
    input = input+" ";
    String returnPhrase = "";
    List<Integer> nonLetters = nonLetterPlace(input);
    System.out.println(nonLetters);
    for(int i = 0; i < nonLetters.size(); i++){
      System.out.println("top");
      if(nonLetters.get(0) != 0 && i == 0){
        returnPhrase += PigLatinTranslator.translateWord(input.substring(0, nonLetters.get(i)));
        System.out.println("x" + input.substring(0, nonLetters.get(i)) + "x");
      }
      if(nonLetters.get(i) != nonLetters.get(i+1)-1 && i != 0){
        returnPhrase += PigLatinTranslator.translateWord(input.substring(nonLetters.get(i-1)+1, nonLetters.get(i)));
        System.out.println("again!");
        System.out.println("xg" + input.substring(nonLetters.get(i-1)+1, nonLetters.get(i)) + "xg");
        System.out.println("xt"+ PigLatinTranslator.translateWord(input.substring(nonLetters.get(i-1)+1, nonLetters.get(i))) + "xt");
        System.out.println(returnPhrase+"g");
      }
      if(nonLetters.get(i) == nonLetters.get(i+1)-1){
        int x = i;
        while(nonLetters.get(x) == nonLetters.get(x+1)-1){
          System.out.println("defhere!");
          System.out.println(returnPhrase);
          returnPhrase += input.substring(nonLetters.get(x), nonLetters.get(x)+1);
          System.out.println(x);
          System.out.println(returnPhrase);
          x++;
        }
      }
      else{
        returnPhrase += input.substring(nonLetters.get(i), nonLetters.get(i)+1);
        System.out.println("xf"+ input.substring(nonLetters.get(i), nonLetters.get(i)+1) + "xf");
        System.out.println("here!");
        System.out.println(returnPhrase + "f");
        }
      
      if(i == nonLetters.size()-2){
        return returnPhrase;
      }
      System.out.println(returnPhrase + "x");
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
        //System.out.println(i);
      } 
    }
    if(firstVowel == 3000){
      returnVal = input.substring(1, input.length()) + input.substring(0, 1) + "ay";
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

}