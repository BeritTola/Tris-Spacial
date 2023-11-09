package library.model.material;

import org.junit.Test;
import structure.model.material.Book;

import static org.junit.Assert.assertEquals;

public class BookTest {
  @Test
  public void testBookConstructor() {
    String title = "The Great Gatsby";
    String editorial = "Penguin";
    String genre = "Fiction";
    String author = "F. Scott Fitzgerald";
    int numberCopies = 10;

    Book book = new Book(title, editorial, genre, author, numberCopies);

    assertEquals(title, book.getTitle());
    assertEquals(editorial, book.getEditorial());
    assertEquals(genre, book.getGenre());
    assertEquals(author, book.getAuthor());
    assertEquals(numberCopies, book.getNumberCopies());
  }

  @Test
  public void testGenreGetterAndSetter() {
    String genre = "Thriller";
    Book book = new Book("Title", "Editorial", "Genre",
            "Author", 5);

    book.setGenre(genre);

    assertEquals(genre, book.getGenre());
  }

  @Test
  public void testAuthorGetterAndSetter() {
    String author = "J.K. Rowling";
    Book book = new Book("Title", "Editorial", "Genre",
            "Author", 5);

    book.setAuthor(author);

    assertEquals(author, book.getAuthor());
  }
}
