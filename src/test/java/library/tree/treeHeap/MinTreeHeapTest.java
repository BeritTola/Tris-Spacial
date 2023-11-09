package library.tree.treeHeap;


import structure.datastructures.treeHeap.MinTreeHeap;
import structure.model.material.Book;
import org.junit.After;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MinTreeHeapTest {
  private MinTreeHeap<Book> minTreeHeapBook;
  private Book minBookParameter;

  @Test
  public void maxTitle() {
    minTreeHeapBook = new MinTreeHeap<>(Comparator.comparing(Book::getTitle));

    minTreeHeapBook.insert(new Book("Huesos", "1", "",
            "", 5));
    minTreeHeapBook.insert(new Book("Micky", "2", "",
            "", 6));

    minBookParameter = minTreeHeapBook.getMin();
    assertEquals("Huesos", minBookParameter.getTitle());
  }

  @Test
  public void maxEditorial() {
    minTreeHeapBook = new MinTreeHeap<>(Comparator.comparing(Book::getEditorial));

    minTreeHeapBook.insert(new Book("", "F", "",
            "", 5));
    minTreeHeapBook.insert(new Book("", "Z", "",
            "", 6));

    minBookParameter = minTreeHeapBook.getMin();
    assertEquals("Z", minBookParameter.getEditorial());
  }

  @Test
  public void maxGenre() {
    minTreeHeapBook = new MinTreeHeap<>(Comparator.comparing(Book::getGenre));

    minTreeHeapBook.insert(new Book("", "", "Infantil",
            "", 5));
    minTreeHeapBook.insert(new Book("", "", "Adultos",
            "", 6));

    minBookParameter = minTreeHeapBook.getMin();
    assertEquals("Infantil", minBookParameter.getGenre());
  }

  @Test
  public void maxAuthor() {
    minTreeHeapBook = new MinTreeHeap<>(Comparator.comparing(Book::getAuthor));

    minTreeHeapBook.insert(new Book("", "", "",
            "Huesos", 5));
    minTreeHeapBook.insert(new Book("", "", "",
            "Lucia", 6));

    minBookParameter = minTreeHeapBook.getMin();
    assertEquals("Lucia", minBookParameter.getAuthor());
  }

  @Test
  public void maxNumberOfCopies() {
    minTreeHeapBook = new MinTreeHeap<>(Comparator.comparing(Book::getNumberCopies));

    minTreeHeapBook.insert(new Book(" ", "", "",
            "", 3));
    minTreeHeapBook.insert(new Book("", "", "",
            "", 7));

    minBookParameter = minTreeHeapBook.getMin();
    assertEquals(7, minBookParameter.getNumberCopies(), 0.01);
  }

  @After
  public void tearDown() {
    minTreeHeapBook = null;
  }
}
