
import com.sun.istack.internal.NotNull;

import javax.persistence.*;


@Entity
@Table(name="book")
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true)
    private String id;
    @NotNull
    @Column(name="Title", length = 255, nullable = false)
    private String name;
    @NotNull
    @Column(name="Author", length = 255, nullable = false)
    private String author;

    public book(String id, String name, String author){
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "\n \"Title\": " + name + "\n \"Author\": " + author;
    }
}

