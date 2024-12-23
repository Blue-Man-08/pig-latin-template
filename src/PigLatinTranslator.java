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
    return translateLine(input);
    // String Lines[] = input.split("\n")
    // String result += = translateLine(input);
    // return result;
  }
  public static String translateLine(String input){
    // "tryants, in paris, my goats. "
    //  01234567890123456789012345678
    //  00000000001111111111222222222
    // "yrantsay, inay arispay, ymay oatsgay."
    input += " ";
    String returnPhrase = "";
    List<Integer> nonLetters = nonLetterPlace(input);
    boolean passall = false;
    String addVal = "";
    boolean firstPass = true;
    boolean nextIs = false;
    for(int i = 0; i <= nonLetters.size(); i++)
    {
      addVal = "";
      passall = false;
      if(!firstPass && i < nonLetters.size()-1){
        returnPhrase += input.substring(nonLetters.get(i), nonLetters.get(i)+1);
        nextIs = false;
      }
      if(nonLetters.get(0) == 0 && firstPass){
        if(i < nonLetters.size()-1){
          if(nonLetters.get(i) == nonLetters.get(i+1)-1){
            nextIs = true;
          }
        }
        returnPhrase += input.substring(nonLetters.get(i), nonLetters.get(i)+1);
        passall = true;
        firstPass = false;
      }
      if(!passall && !nextIs){
        if(firstPass){
          addVal = translateWord(input.substring(0, nonLetters.get(0)));
          returnPhrase += addVal;
          firstPass = false;
          returnPhrase += input.substring(nonLetters.get(i), nonLetters.get(i)+1);
          nextIs = false;

        }
        if(i < nonLetters.size()-1){
          if(nonLetters.get(i) == nonLetters.get(i+1)-1){
            nextIs = true;
          }
        }
        if(!nextIs && i < nonLetters.size()-1){
          addVal = translateWord(input.substring(nonLetters.get(i)+1, nonLetters.get(i+1)));
          returnPhrase += addVal;
        }
        }
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
    if(firstVowel == 3000 && input.length() > 2){
      returnVal = input.substring(1, input.length()) + input.substring(0, 1) + "ay";
      return returnVal;
    }
    if(firstVowel == 3000 && input.length() <= 2){
      returnVal = input + "ay";
      return returnVal;
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