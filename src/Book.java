import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList; 

public class Book
{
    // What should a book contain?
    // Ideas: need to store text, need to store current reading position
    //        title, author?, source URL, ... 
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    Book()
    {
        // Empty book
    }

    public void printlines(int start, int length)
    {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i=start; i<start+length; i++)
        {
            if (i < text.size())
            {
                System.out.println(i + ": " + text.get(i));
            }
            else
            {
                System.out.println(i + ": line not in book.");     
            }
        }
    }
    public ArrayList<String> returnText()
    {
        return text;
    }
    public String returnLines(int start, int length){
        String returnVal = "";
        for(int i = start; i <start+length; i++){
            if(i < text.size())
            {
                returnVal += text.get(i);
                returnVal += "\n";
            }
            else{
                returnVal = "Line: " + i + " not in book.";
                return returnVal;
            }
        }
        return returnVal;
    }
    String getTitle()
    {
        return title;
    }
    void setTitle(String title)
    {
        this.title = title;
    }

    String getLine(int lineNumber)
    {
        return text.get(lineNumber);
    }

    public int getLineCount()
    {
        return text.size();
    }

    void appendLine(String line)
    {
        text.add(line);
    }

    public void readFromString(String title, String string)
    {
        // load a book from an input string.
        this.title = title;
        Scanner scanner = new Scanner(string);
        while (scanner.hasNext()) 
        {
            String line = scanner.nextLine();
            text.add(line);
        }
        scanner.close();
    }

    public void readFromUrl(String title, String url)
    {
        // load a book from a URL.
        // https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
        this.title = title;

        try {
            URL bookUrl = new URL(url);
            Scanner scanner = new Scanner(bookUrl.openStream());
            while (scanner.hasNext()) 
            {
                text.add(scanner.nextLine());
            }
            scanner.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    void writeToFile(String fileName, int start, int length)
    {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } 
          catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          try {
            FileWriter myWriter = new FileWriter(fileName);
            String writtenData = PigLatinTranslator.translate(returnLines(start, length));
            myWriter.write(writtenData);
            myWriter.close();
            System.out.println("Written to file: " + fileName);
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}