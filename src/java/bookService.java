import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

public class bookService {
    private Map<Integer, book> storeContents = new HashMap<Integer, book>();


    public void addBook(Integer key, String name , String author )
    {
        book newBook = new book(name, author);
        storeContents.put(key, newBook);
    }

    public void removeBook(Integer key){
        storeContents.remove(key);
    }

    public void printContents(){
        storeContents.forEach((k,b)-> {
            System.out.print("ID: " + k + "\n" + "The author is " + b.getAuthor() + "\n" + "The books title is " + b.getName() + "\n");

        });
    }

}


