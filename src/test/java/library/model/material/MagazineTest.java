package library.model.material;

import org.junit.Test;
import structure.model.material.Magazine;

import static org.junit.Assert.assertEquals;

public class MagazineTest {
  @Test
  public void testMagazineConstructor() {
    String title = "National Geographic";
    String editorial = "NatGeo";
    String topic = "Nature";
    String publisher = "National Geographic Society";
    int numberCopies = 100;

    Magazine magazine = new Magazine(title, editorial, topic, publisher, numberCopies);

    assertEquals(title, magazine.getTitle());
    assertEquals(editorial, magazine.getEditorial());
    assertEquals(topic, magazine.getTopic());
    assertEquals(publisher, magazine.getPublisher());
    assertEquals(numberCopies, magazine.getNumberCopies());
  }

  @Test
  public void testTopicGetterAndSetter() {
    String topic = "Science";
    Magazine magazine = new Magazine("Title", "Editorial",
            "Topic", "Publisher", 10);

    magazine.setTopic(topic);

    assertEquals(topic, magazine.getTopic());
  }

  @Test
  public void testPublisherGetterAndSetter() {
    String publisher = "Scientific American";
    Magazine magazine = new Magazine("Title", "Editorial",
            "Topic", "Publisher", 10);

    magazine.setPublisher(publisher);

    assertEquals(publisher, magazine.getPublisher());
  }
}
