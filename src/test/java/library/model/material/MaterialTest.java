package library.model.material;

import org.junit.Test;
import structure.model.material.Material;

import static org.junit.Assert.assertEquals;

public class MaterialTest {
  @Test
  public void testMaterialConstructor() {
    String title = "Sample Material";
    String editorial = "Sample Editorial";
    int numberCopies = 50;

    Material material = new Material(title, editorial, numberCopies);

    assertEquals(title, material.getTitle());
    assertEquals(editorial, material.getEditorial());
    assertEquals(numberCopies, material.getNumberCopies());
  }

  @Test
  public void testTitleGetterAndSetter() {
    String title = "New Title";
    Material material = new Material("Title", "Editorial", 10);

    material.setTitle(title);

    assertEquals(title, material.getTitle());
  }

  @Test
  public void testEditorialGetterAndSetter() {
    String editorial = "New Editorial";
    Material material = new Material("Title", "Editorial", 10);

    material.setEditorial(editorial);

    assertEquals(editorial, material.getEditorial());
  }

  @Test
  public void testNumberCopiesGetterAndSetter() {
    int numberCopies = 20;
    Material material = new Material("Title", "Editorial", 10);

    material.setNumberCopies(numberCopies);

    assertEquals(numberCopies, material.getNumberCopies());
  }

  @Test
  public void testAddCopies() {
    int initialCopies = 5;
    Material material = new Material("Title", "Editorial", initialCopies);

    material.addCopies();

    assertEquals(initialCopies + 1, material.getNumberCopies());
  }
}
