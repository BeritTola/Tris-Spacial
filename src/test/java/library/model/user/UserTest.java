package library.model.user;

import org.junit.Before;
import org.junit.Test;
import structure.model.user.User;
import structure.model.user.Rol;
import structure.model.material.Book;
import structure.model.material.Loan;
import structure.model.material.Material;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
  private static User user;

  @Before
  public void setUp() {
    user = new User("John Doe", "Address",
            123456789, "userpass", Rol.PROFESOR);
  }

  @Test
  public void testSetRol() {
    user.setRol(Rol.ESTUDIANTE);

    assertEquals(Rol.ESTUDIANTE, user.getRol());
  }

  @Test
  public void testAddAndRemoveLoan() {
    Material book = new Book("Book Title", "Editorial",
            "Genre", "Author", 5);
    Loan loan = new Loan(user, book, "2023-07-31");

    user.addLoan(loan);

    assertTrue(user.getMyloans().contains(loan.getFecha()));

    user.removeLoan(loan);

    assertFalse(user.getMyloans().contains(String.valueOf(loan)));
  }

  @Test
  public void testShowLoans() {
    Material book1 = new Book("Book 1", "Editorial",
            "Genre", "Author", 5);
    Material book2 = new Book("Book 2", "Editorial",
            "Genre", "Author", 3);
    Loan loan1 = new Loan(user, book1, "2023-07-31");
    Loan loan2 = new Loan(user, book2, "2023-08-01");
    user.addLoan(loan1);
    user.addLoan(loan2);

    user.showloans();
  }

  @Test
  public void testShowLoanDebt() {
    Material book1 = new Book("Book 1", "Editorial",
            "Genre", "Author", 5);
    Material book2 = new Book("Book 2", "Editorial",
            "Genre", "Author", 3);
    Loan loan1 = new Loan(user, book1, "2023-07-31");
    Loan loan2 = new Loan(user, book2, "2023-08-01");
    loan1.setState(false);
    loan1.setMulta(10);
    user.addLoan(loan1);
    user.addLoan(loan2);

    user.showLoanDebt("2023-07-31");
  }

  @Test
  public void testIsCIUnique() {
    List<User> userList = new ArrayList<>();
    User user1 = new User("User1", "Address",
            111111111, "user1pass", Rol.ESTUDIANTE);
    userList.add(user1);

    assertFalse(User.isCIUnique(userList, 111111111));
    assertTrue(User.isCIUnique(userList, 222222222));
  }

  @Test
  public void testGetLoanByTitle() {
    Material book1 = new Book("Book 1", "Editorial",
            "Genre", "Author", 5);
    Material book2 = new Book("Book 2", "Editorial",
            "Genre", "Author", 3);
    Loan loan1 = new Loan(user, book1, "2023-07-31");
    Loan loan2 = new Loan(user, book2, "2023-08-01");
    user.addLoan(loan1);
    user.addLoan(loan2);

    Loan foundLoan = user.getLoanByTitle("Book 1");

    assertEquals(loan1, foundLoan);
  }
}
