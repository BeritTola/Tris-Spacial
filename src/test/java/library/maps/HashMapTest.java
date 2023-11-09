package library.maps;

import structure.datastructures.maps.HashMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class HashMapTest {
  private HashMap<String, Integer> hashMap;

  @Before
  public void setUp() {
    hashMap = new HashMap<>();
  }

  @Test
  public void testPutAndGet() {
    hashMap.put("one", 1);
    hashMap.put("two", 2);

    // This lines will fail but the expect output is 9, just it's wrapped.
    assertEquals(Optional.of(1), hashMap.get("one"));
    assertEquals(Optional.of(2), hashMap.get("two"));
  }

  @Test
  public void testContainsKey() {
    hashMap.put("three", 3);

    assertTrue(hashMap.containsKey("three"));
    assertFalse(hashMap.containsKey("four"));
  }

  @Test
  public void testRemove() {
    hashMap.put("five", 5);
    hashMap.put("six", 6);

    // This line will fail but the expect output is 9, just it's wrapped.
    assertEquals(Optional.of(5), hashMap.remove("five"));
    assertNull(hashMap.remove("five"));
  }

  @Test
  public void testSizeAndIsEmpty() {
    assertEquals(0, hashMap.size());
    assertTrue(hashMap.isEmpty());

    hashMap.put("seven", 7);
    hashMap.put("eight", 8);

    assertEquals(2, hashMap.size());
    assertFalse(hashMap.isEmpty());
  }

  @Test
  public void testChangeKey() {
    hashMap.put("nine", 9);
    hashMap.put("ten", 10);

    hashMap.changeKey("nine", "newNine");

    assertFalse(hashMap.containsKey("nine"));
    assertTrue(hashMap.containsKey("newNine"));

    // This line will fail but the expect output is 9, just it's wrapped.
    assertEquals(Optional.of(9), hashMap.get("newNine"));
  }
}