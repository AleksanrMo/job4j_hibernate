package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Author> authors = new HashSet<>();

   public static Book of(String name) {
       Book book = new Book();
       book.name = name;
       return book;
   }

   public void add(Author author) {
       this.authors.add(author);
   }
    public Set<Author> getBooks() {
        return authors;
    }

    public void setBooks(Set<Author> books) {
        this.authors = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
