package structure.datastructures.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HashMap<K, V> {
  private ArrayList<HashNode<K, V>> bucketArray;
  private int numBuckets;
  private int size;

  public HashMap() {
    bucketArray = new ArrayList<>();
    numBuckets = 10;
    size = 0;

    for (int i = 0; i < numBuckets; i++) {
      bucketArray.add(null);
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  private final int hashCode(K key) {
    return Objects.hashCode(key);
  }

  private int getBucketIndex(K key) {
    int hashCode = hashCode(key);
    int index = hashCode % numBuckets;
    index = index < 0 ? index * -1 : index;

    return index;
  }

  public V remove(K key) {
    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);
    HashNode<K, V> head = bucketArray.get(bucketIndex);

    HashNode<K, V> prev = null;
    while (head != null) {
      if (head.key.equals(key) && hashCode == head.hashCode) {
        break;
      }

      prev = head;
      head = head.next;
    }

    if (head == null) {
      return null;
    }

    size--;

    if (prev != null) {
      prev.next = head.next;
    } else {
      bucketArray.set(bucketIndex, head.next);
    }
    return head.value;
  }

  public V get(K key) {
    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);

    HashNode<K, V> head = bucketArray.get(bucketIndex);

    while (head != null) {
      if (head.key.equals(key) && head.hashCode == hashCode) {
        return head.value;
      }
      head = head.next;
    }

    return null;
  }

  public void parallelAdd(K key, V value) {
    int numThreads = 8;
    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

    try {
      for (int i = 0; i < numThreads; i++) {
        final int threadIndex = i;
        executorService.submit(() -> {
          add(key, value);
        });
      }
    } finally {
      executorService.shutdown();
    }
  }

  public boolean parallelContains(K key) {
    int numThreads = 8;
    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

    try {
      List<Future<Boolean>> results = new ArrayList<>();
      for (int i = 0; i < numThreads; i++) {
        final int threadIndex = i;
        Future<Boolean> result = executorService.submit(() -> {
          return contains(key);
        });
        results.add(result);
      }

      for (Future<Boolean> result : results) {
        try {
          if (result.get()) {
            return true;
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    } finally {
      executorService.shutdown();
    }

    return false;
  }


  public void add(K key, V value) {
    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);
    HashNode<K, V> head = bucketArray.get(bucketIndex);

    while (head != null) {
      if (head.key.equals(key) && head.hashCode == hashCode) {
        head.value = value;
        return;
      }
      head = head.next;
    }

    size++;
    head = bucketArray.get(bucketIndex);
    HashNode<K, V> newNode = new HashNode<K, V>(key, value, hashCode);
    newNode.next = head;
    bucketArray.set(bucketIndex, newNode);

    if ((1.0 * size) / numBuckets >= 0.7) {
      ArrayList<HashNode<K, V>> temp = bucketArray;
      bucketArray = new ArrayList<>();
      numBuckets = 2 * numBuckets;
      size = 0;
      for (int i = 0; i < numBuckets; i++) {
        bucketArray.add(null);
      }
      for (HashNode<K, V> headNode : temp) {
        while (headNode != null) {
          add(headNode.key, headNode.value);
          headNode = headNode.next;
        }
      }
    }
  }

  public boolean contains(K key) {
    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);
    HashNode<K, V> head = bucketArray.get(bucketIndex);

    while (head != null) {
      if (head.key.equals(key) && head.hashCode == hashCode) {
        return true;
      }
      head = head.next;
    }
    return false;
  }

  public List<HashNode<K, V>> getAllEntries() {
    List<HashNode<K, V>> entries = new ArrayList<>();
    for (HashNode<K, V> headNode : bucketArray) {
      HashNode<K, V> current = headNode;
      while (current != null) {
        entries.add(current);
        current = current.next;
      }
    }
    return entries;
  }

  public void changeKey(K oldKey, K newKey) {
    if (contains(oldKey)) {
      int oldBucketIndex = getBucketIndex(oldKey);
      int newBucketIndex = getBucketIndex(newKey);
      int oldHashCode = hashCode(oldKey);
      int newHashCode = hashCode(newKey);

      if (oldBucketIndex == newBucketIndex && oldHashCode == newHashCode) {
        HashNode<K, V> node = bucketArray.get(oldBucketIndex);
        while (node != null) {
          if (node.key.equals(oldKey) && node.hashCode == oldHashCode) {
            node.key = newKey;
            return;
          }
          node = node.next;
        }
      } else {
        V value = remove(oldKey);
        add(newKey, value);
      }
    }
  }

  public void put(K key, V value) {
    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);
    HashNode<K, V> head = bucketArray.get(bucketIndex);

    while (head != null) {
      if (head.key.equals(key) && head.hashCode == hashCode) {
        head.value = value;
        return;
      }
      head = head.next;
    }

    size++;
    head = bucketArray.get(bucketIndex);
    HashNode<K, V> newNode = new HashNode<K, V>(key, value, hashCode);
    newNode.next = head;
    bucketArray.set(bucketIndex, newNode);

    if ((1.0 * size) / numBuckets >= 0.7) {
      ArrayList<HashNode<K, V>> temp = bucketArray;
      bucketArray = new ArrayList<>();
      numBuckets = 2 * numBuckets;
      size = 0;
      for (int i = 0; i < numBuckets; i++) {
        bucketArray.add(null);
      }
      for (HashNode<K, V> headNode : temp) {
        while (headNode != null) {
          put(headNode.key, headNode.value);
          headNode = headNode.next;
        }
      }
    }
  }

  public boolean containsKey(K key) {
    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);
    HashNode<K, V> head = bucketArray.get(bucketIndex);

    while (head != null) {
      if (head.key.equals(key) && head.hashCode == hashCode) {
        return true;
      }
      head = head.next;
    }
    return false;
  }
}
