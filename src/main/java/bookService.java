import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
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
       ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(storeContents);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "Something broke";

    }

    public void convertJsonToMap(String json)
    {
        ObjectMapper om = new ObjectMapper();

        try {
           storeContents = om.readValue(json, new TypeReference<Map<Integer,Object>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

