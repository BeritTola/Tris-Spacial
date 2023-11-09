package library.tree;

import org.junit.jupiter.api.Test;
import structure.datastructures.tree.BinaryTree;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

  @Test
  public void testAdd() {
    BinaryTree tree = new BinaryTree();
    assertTrue(tree.add(10));
    assertTrue(tree.add(5));
    assertTrue(tree.add(15));
    assertTrue(tree.add(7));
    assertTrue(tree.add(12));
    assertTrue(tree.add(10));
  }

  @Test
  public void testInorderTraversal() {
    BinaryTree tree = new BinaryTree();
    tree.add(10);
    tree.add(5);
    tree.add(15);
    tree.add(7);
    tree.add(12);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    tree.inorderTraversal(tree.getRoot());
    String expectedOutput = "node value: 5\nnode value: 7\nnode value: 10\nnode value: 12\nnode value: 15\n";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testBinarySearch() {
    BinaryTree tree = new BinaryTree();
    tree.add(10);
    tree.add(5);
    tree.add(15);
    tree.add(7);
    tree.add(12);

    assertTrue(tree.binarySearch(10)); // Root node
    assertTrue(tree.binarySearch(5)); // Left
    assertTrue(tree.binarySearch(15)); // Right
    assertTrue(tree.binarySearch(7));
    assertTrue(tree.binarySearch(12));

    assertFalse(tree.binarySearch(20));
  }

  @Test
  public void testRemove() {
    BinaryTree tree = new BinaryTree();
    tree.add(10);
    tree.add(5);
    tree.add(15);
    tree.add(7);
    tree.add(12);

    assertTrue(tree.remove(tree.getRoot(), null, 5));
    assertFalse(tree.binarySearch(5));

    assertTrue(tree.remove(tree.getRoot(), null, 15));
    assertFalse(tree.binarySearch(15));

    assertTrue(tree.remove(tree.getRoot(), null, 10));
    assertFalse(tree.binarySearch(10));
    assertTrue(tree.binarySearch(7));
    assertTrue(tree.binarySearch(12));
  }

  @Test
  public void testGetNodeValue() {
    BinaryTree tree = new BinaryTree();
    tree.add(10);
    tree.add(5);
    tree.add(15);
    tree.add(7);
    tree.add(12);

    assertEquals(10, tree.getNodeValue(10));
    assertEquals(5, tree.getNodeValue(5));
    assertEquals(15, tree.getNodeValue(15));
    assertEquals(7, tree.getNodeValue(7));
    assertEquals(12, tree.getNodeValue(12));

    assertThrows(IllegalArgumentException.class, () -> tree.getNodeValue(20));
  }
}