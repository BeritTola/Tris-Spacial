package library.tree.BPlusTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structure.datastructures.TreeBPlus.BPlusTree;
import structure.model.material.Loan;
import structure.model.material.Material;
import structure.model.material.Reservation;
import structure.model.user.Rol;
import structure.model.user.User;

import static org.junit.jupiter.api.Assertions.*;

class GPlusTreeTest {
    @Test
    public void testInsertAndSearch() {
        BPlusTree<Integer, String> bPlusTree = new BPlusTree<>(3, String::compareTo);

        bPlusTree.insert(1, "One");
        bPlusTree.insert(3, "Three");
        bPlusTree.insert(2, "Two");

        assertEquals("One", bPlusTree.search(1));
        assertEquals("Two", bPlusTree.search(2));
        assertEquals("Three", bPlusTree.search(3));
        assertNull(bPlusTree.search(4));
    }

    @Test
    public void testSearchRange() {
        BPlusTree<Integer, String> bPlusTree = new BPlusTree<>(3, String::compareTo);

        bPlusTree.insert(1, "One");
        bPlusTree.insert(3, "Three");
        bPlusTree.insert(2, "Two");
        bPlusTree.insert(4, "Four");

        assertEquals("[Four]", bPlusTree.searchRange(4, 4).toString());
        assertEquals("[One, Two, Three, Four]", bPlusTree.searchRange(1, 4).toString());
        assertEquals("[Three, Four]", bPlusTree.searchRange(3, 4).toString());
        assertEquals("[Two, Three]", bPlusTree.searchRange(2, 3).toString());
    }

    @Test
    public void testFind() {
        BPlusTree<Integer, String> bPlusTree = new BPlusTree<>(3, String::compareTo);

        bPlusTree.insert(1, "One");
        bPlusTree.insert(3, "Three");
        bPlusTree.insert(2, "Two");

        assertTrue(bPlusTree.find(1, "One"));
        assertFalse(bPlusTree.find(1, "Two"));
        assertFalse(bPlusTree.find(4, "Four"));
    }

    @Test
    public void testSortedValues() {
        BPlusTree<Integer, String> bPlusTree = new BPlusTree<>(3, String::compareTo);

        bPlusTree.insert(1, "One");
        bPlusTree.insert(3, "Three");
        bPlusTree.insert(2, "Two");
        bPlusTree.insert(4, "Four");

        assertEquals("[One, Two, Three, Four]", bPlusTree.getSortedValues().toString());
    }
}
