package structure.datastructures.maps;

public class HashNode<K, V> {
  final int hashCode;
  K key;
  V value;
  HashNode<K, V> next;

  public HashNode(K key, V value, int hashCode) {
    this.key = key;
    this.value = value;
    this.hashCode = hashCode;
  }

  public V getValue() {
    return value;
  }

  public K getKey() {
    return key;
  }
}
