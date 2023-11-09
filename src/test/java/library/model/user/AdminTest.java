package library.model.user;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import structure.datastructures.maps.HashMap;
import structure.model.material.Material;
import structure.model.user.Admin;
import structure.model.user.Person;
import structure.model.user.Rol;
import structure.model.user.User;

public class AdminTest {
  private Admin admin;

  @Before
  public void setUp() {
    HashMap<String, Material> booklist = new HashMap<>();
    admin = new Admin("Admin Name", "Admin Address", 123456, "adminpass", booklist);
  }

  @Test
  public void testEditEditorial() {
    Material book = new Material("Book Title", "Book Editorial", 5);
    HashMap<String, Material> booklist = new HashMap<>();
    booklist.put(book.getTitle(), book);
    admin.editEditorial(booklist, "Book Title", "New Book Editorial");

    assertEquals("New Book Editorial", booklist.get("Book Title").getEditorial());
  }

  @Test
  public void testEditNumeroCopias() {
    Material book = new Material("Book Title", "Book Editorial", 5);
    HashMap<String, Material> booklist = new HashMap<>();
    booklist.put(book.getTitle(), book);
    admin.editNumeroCopias(booklist, "Book Title", 10);

    assertEquals(10, booklist.get("Book Title").getNumberCopies());
  }

  @Test
  public void testEditDireccion() {
    HashMap<String, Person> users = new HashMap<>();
    User user = new User("User Name", "User Address", 789012, "userpass", Rol.ESTUDIANTE);
    users.put(user.getName(), user);

    admin.editDireccion(users, "User Name", "New User Address");

    assertEquals("New User Address", users.get("User Name").getAddress());
  }

  @Test
  public void testEditCI() {
    HashMap<String, Person> users = new HashMap<>();
    User user = new User("User Name", "User Address", 789012, "userpass", Rol.ESTUDIANTE);
    users.put(user.getName(), user);

    admin.editCI(users, "User Name", "987654");

    assertEquals(987654, users.get("User Name").getCI());
  }

  @Test
  public void testEditPassword() {
    HashMap<String, Person> users = new HashMap<>();
    User user = new User("User Name", "User Address", 789012, "userpass", Rol.ESTUDIANTE);
    users.put(user.getName(), user);

    admin.editPassword(users, "User Name", "newpass");

    assertEquals("newpass", users.get("User Name").getPassword());
  }

  @Test
  public void testEditRol() {
    HashMap<String, Person> users = new HashMap<>();
    User user = new User("User Name", "User Address", 789012, "userpass", Rol.ESTUDIANTE);
    users.put(user.getName(), user);

    admin.editRol(users, "User Name", "Profesor");

    assertEquals(Rol.PROFESOR, ((User) users.get("User Name")).getRol());
  }
}
