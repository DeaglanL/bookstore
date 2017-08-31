public class runner {

    public static void main(String [] args) {
        String saved;
        bookService bookStore = new bookService();

        bookStore.addBook(1, "Of mice and men", "John Steinbeck");
        bookStore.addBook(2, "The hobbit", "JRR Tolkien");

        System.out.println(bookStore.convertToJson());

        saved = bookStore.convertToJson();

        bookStore.printContents();

        System.out.println("\n \n Removing of mice and men \n \n");

        bookStore.removeBook(1);

        bookStore.printContents();

        System.out.println("\n \n Changing the hobbit \n \n");

        bookStore.ammendBook(2, true, "The return of the king");

        bookStore.printContents();

        System.out.println("\n \n Removing all \n \n");

        bookStore.removeAll();

        bookStore.printContents();

        bookStore.convertJsonToMap(saved);

        System.out.println(bookStore.convertToJson());
    }
}

