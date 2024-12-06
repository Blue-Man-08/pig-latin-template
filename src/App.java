public class App {
    public static void main(String[] args)
    {
        TestSuite.run();
        Book randj = new Book();
        randj.readFromUrl("Romeo and Juliet", "https://www.gutenberg.org/cache/epub/1513/pg1513.txt");
        randj.writeToFile("omeoRay nday ulietJay.txt", 0, randj.getLineCount());

        Book myBook = new Book();
        myBook.readFromUrl("A Cabinet Secret", "https://www.gutenberg.org/cache/epub/36892/pg36892.txt");
        myBook.writeToFile("Ayay abinetCay ecretSay.txt", 0, myBook.getLineCount());
    }
}

