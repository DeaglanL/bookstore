import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONValue;

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

        if (storeContents.isEmpty()){
            System.out.println("The store is empty");
        }
        else {
            storeContents.forEach((k, b) -> {
                System.out.print("ID: " + k + "\n" + "The author is " + b.getAuthor() + "\n" + "The books title is " + b.getName() + "\n");

            });
        }
    }

    public  void removeAll(){
        storeContents.clear();
    }

    public void ammendBook(Integer key, boolean partToChange, String newContents){
        if (partToChange)
        {
            storeContents.get(key).setName(newContents);
        }
        else
        {
            storeContents.get(key).setAuthor(newContents);
        }
    }

    public String convertToJson(){
       return JSONValue.toJSONString(storeContents);

    }

}

