import java.lang.*;

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

  public static String translateWord(String input)
  {
    String testCases = "aeiou";
    String returnVal = "";
    int firstVowel = 300000000;
    input = input.toLowerCase();
    if(input.indexOf("a") < firstVowel && input.indexOf("a") != -1){
      firstVowel = input.indexOf("e");
    }
    if(input.indexOf("e") < firstVowel && input.indexOf("e") != -1){
      firstVowel = input.indexOf("e");
    }
    if(input.indexOf("i") < firstVowel && input.indexOf("i") != -1){
      firstVowel = input.indexOf("i");
    }
    if(input.indexOf("o") < firstVowel && input.indexOf("o") != -1){
      firstVowel = input.indexOf("o");
    }
    if(input.indexOf("u") < firstVowel && input.indexOf("u") != -1){
      firstVowel = input.indexOf("u");
    }
    if(input.indexOf("y") < firstVowel && input.indexOf("y") != -1){
      firstVowel = input.indexOf("y");
    }
    returnVal = input.substring(firstVowel, input.length()) + input.substring(0, firstVowel);
    if(testCases.contains(returnVal.substring(returnVal.length()-1, returnVal.length()))){
      return returnVal + "yay";
    }
    return returnVal + "ay";
  }

  // Add additonal private methods here.
  // For example, I had one like this:
  // private static String capitalizeFirstLetter(String input)

}