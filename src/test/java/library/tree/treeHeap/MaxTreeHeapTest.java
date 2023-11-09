package library.tree.treeHeap;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structure.datastructures.treeHeap.MaxTreeHeap;
import structure.model.material.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MaxTreeHeapTest {
  private MaxTreeHeap<Book> maxTreeHeapBook;
  private MaxTreeHeap<Integer> maxTreeHeapInteger;
  private MaxTreeHeap<Book> maxTreeSearch;
  private Book maxBookParameter;
  private Book huesosBook;
  private Book mickyBook;


  @BeforeEach
  public void setUp() {
    maxTreeSearch = new MaxTreeHeap<>(Comparator.comparing(Book::getTitle));
    Comparator<Integer> comparator = Comparator.naturalOrder();
    maxTreeHeapInteger = new MaxTreeHeap<>(comparator);
    huesosBook = new Book("Huesos", "F", "Infantil", "Huesos", 3);
    mickyBook = new Book("Micky", "Z", "Adultos", "Lucia", 7);
  }

  @Test
  public void testGetMaxByTitle() {
    maxTreeHeapBook = new MaxTreeHeap<>(Comparator.comparing(Book::getTitle));
    maxTreeHeapBook.insert(huesosBook);
    maxTreeHeapBook.insert(mickyBook);
    maxBookParameter = maxTreeHeapBook.getMax();

    Assertions.assertEquals("Micky", maxBookParameter.getTitle());
  }

  @Test
  public void testGetMaxByEditorial() {
    maxTreeHeapBook = new MaxTreeHeap<>(Comparator.comparing(Book::getEditorial));
    maxTreeHeapBook.insert(huesosBook);
    maxTreeHeapBook.insert(mickyBook);
    maxBookParameter = maxTreeHeapBook.getMax();

    Assertions.assertEquals("Z", maxBookParameter.getEditorial());
  }

  @Test
  public void testGetMaxByGenre() {
    maxTreeHeapBook = new MaxTreeHeap<>(Comparator.comparing(Book::getGenre));
    maxTreeHeapBook.insert(huesosBook);
    maxTreeHeapBook.insert(mickyBook);
    maxBookParameter = maxTreeHeapBook.getMax();

    Assertions.assertEquals("Infantil", maxBookParameter.getGenre());
  }

  @Test
  public void testGetMaxByAuthor() {
    maxTreeHeapBook = new MaxTreeHeap<>(Comparator.comparing(Book::getAuthor));
    maxTreeHeapBook.insert(huesosBook);
    maxTreeHeapBook.insert(mickyBook);
    maxBookParameter = maxTreeHeapBook.getMax();

    Assertions.assertEquals("Lucia", maxBookParameter.getAuthor());
  }

  @Test
  public void testGetMaxByNumberOfCopies() {
    maxTreeHeapBook = new MaxTreeHeap<>(Comparator.comparing(Book::getNumberCopies));
    maxTreeHeapBook.insert(huesosBook);
    maxTreeHeapBook.insert(mickyBook);
    maxBookParameter = maxTreeHeapBook.getMax();

    Assertions.assertEquals(7, maxBookParameter.getNumberCopies());
  }

  @Test
  public void testInsertRandomOrder() {
    maxTreeHeapInteger.insert(3);
    maxTreeHeapInteger.insert(1);
    maxTreeHeapInteger.insert(5);
    maxTreeHeapInteger.insert(2);
    maxTreeHeapInteger.insert(4);

    Assertions.assertEquals(Integer.valueOf(5), maxTreeHeapInteger.getMax());
    Assertions.assertEquals(Integer.valueOf(4), maxTreeHeapInteger.getMax());
    Assertions.assertEquals(Integer.valueOf(3), maxTreeHeapInteger.getMax());
    Assertions.assertEquals(Integer.valueOf(2), maxTreeHeapInteger.getMax());
    Assertions.assertEquals(Integer.valueOf(1), maxTreeHeapInteger.getMax());
  }

  @Test
  public void testInsertAscendingOrder() {
    maxTreeHeapInteger.insert(1);
    maxTreeHeapInteger.insert(2);
    maxTreeHeapInteger.insert(3);
    maxTreeHeapInteger.insert(4);
    maxTreeHeapInteger.insert(5);

    Assertions.assertEquals(Integer.valueOf(5), maxTreeHeapInteger.getMax());
    Assertions.assertEquals(Integer.valueOf(4), maxTreeHeapInteger.getMax());
    Assertions.assertEquals(Integer.valueOf(3), maxTreeHeapInteger.getMax());
    Assertions.assertEquals(Integer.valueOf(2), maxTreeHeapInteger.getMax());
    Assertions.assertEquals(Integer.valueOf(1), maxTreeHeapInteger.getMax());
  }

  @Test
  public void testGetMaxEmptyHeap() {
    Assertions.assertNull(maxTreeHeapInteger.getMax());
  }

  @Test
  public void testInsertNullElement() {
    maxTreeHeapInteger.insert(null);
    Assertions.assertNull(maxTreeHeapInteger.getMax());
  }

  @Test
  public void testInsertDuplicateElements() {
    maxTreeHeapInteger.insert(5);
    maxTreeHeapInteger.insert(10);
    maxTreeHeapInteger.insert(15);
    maxTreeHeapInteger.insert(10);

    List<Integer> expected = Arrays.asList(15, 10, 10, 5);
    List<Integer> actual = new ArrayList<>();

    while (!maxTreeHeapInteger.isEmpty()) {
      actual.add(maxTreeHeapInteger.getMax());
    }

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void testSearchByFunction() {
    maxTreeSearch.insert(huesosBook);
    maxTreeSearch.insert(mickyBook);
    Assertions.assertEquals(huesosBook, maxTreeSearch.searchByFunction(Book::getTitle, "Huesos").get(0));
  }

  @Test
  public void testSearchByFunctionMethodIfTheElementDoesNotExists() {
    Assertions.assertEquals(new ArrayList<>(), maxTreeSearch.searchByFunction(Book::getTitle, ""));
  }

  @Test
  public void testSearchByFunctionMethodIfTheElementIsNull() {
    Assertions.assertEquals(new ArrayList<>(), maxTreeSearch.searchByFunction(Book::getTitle, null));
  }

  @Test
  public void testSearchByFunctionMethodIfTheFunctionIsNull() {
    Assertions.assertEquals(new ArrayList<>(), maxTreeSearch.searchByFunction(null, "Bones"));
  }

  @Test
  public void testSearchByFunctionMethodIfTheFunctionAndItemAreNull() {
    Assertions.assertEquals(new ArrayList<>(), maxTreeSearch.searchByFunction(null, null));
  }

  @Test
  public void testSearchMethodForAGeneric() {
    maxTreeSearch.insert(huesosBook);
    maxTreeSearch.insert(mickyBook);
    List<Book> founded = maxTreeSearch.search(huesosBook);
    Assertions.assertEquals(huesosBook, founded.get(0));
  }

  @Test
  public void testSearchMethodIfTheParamIsNull() {
    Assertions.assertEquals(new ArrayList<Book>(), maxTreeSearch.search(null));
  }

  @Test
  public void testSearchMethodIfTheElementDoesNotExists() {
    List<Book> expected = new ArrayList<>();
    Assertions.assertEquals(expected, maxTreeSearch.search(huesosBook));
  }

  @AfterEach
  public void tearDown() {
    maxTreeHeapBook = null;
    maxTreeHeapInteger = null;
    maxTreeSearch = null;
  }
}
