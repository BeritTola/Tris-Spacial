package library.model.user;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import structure.model.user.Person;

public class PersonTest {
  @Test
  public void testPersonConstructor() {
    String name = "John Doe";
    String direccion = "123 Main Street";
    int CI = 123456789;
    String passwd = "securepassword";

    Person person = new Person(name, direccion, CI, passwd);

    assertEquals(name, person.getName());
    assertEquals(direccion, person.getAddress());
    assertEquals(CI, person.getCI());
    assertEquals(passwd, person.getPassword());
  }

  @Test
  public void testSetName() {
    String name = "John Doe";
    Person person = new Person(name, "Address", 123456789, "Password");

    String newName = "Jane Doe";
    person.setName(newName);

    assertEquals(newName, person.getName());
  }

  @Test
  public void testSetDireccion() {
    String direccion = "123 Main Street";
    Person person = new Person("John Doe", direccion, 123456789, "Password");

    String newDireccion = "456 Maple Avenue";
    person.setDireccion(newDireccion);

    assertEquals(newDireccion, person.getAddress());
  }

  @Test
  public void testSetCI() {
    int CI = 123456789;
    Person person = new Person("John Doe", "Address", CI, "Password");

    int newCI = 987654321;
    person.setCI(newCI);

    assertEquals(newCI, person.getCI());
  }

  @Test
  public void testSetPasswd() {
    String passwd = "securepassword";
    Person person = new Person("John Doe", "Address", 123456789, passwd);

    String newPasswd = "newpassword";
    person.setPasswd(newPasswd);

    assertEquals(newPasswd, person.getPassword());
  }
}
