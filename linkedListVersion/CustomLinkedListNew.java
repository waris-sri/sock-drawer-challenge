package linkedListVersion;

public class CustomLinkedListNew<T> {

  private static class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
      this.data = data;
    }
  }

  private Node<T> first; // head
  private int size;

  public CustomLinkedListNew() {
    this.first = null;
    this.size = 0;
  }

  /** Add to the end (tail). */
  public void add(T data) {
    Node<T> n = new Node<>(data);
    if (first == null) {
      first = n;
    } else {
      Node<T> curr = first;
      while (curr.next != null)
        curr = curr.next;
      curr.next = n;
    }
    size++;
  }

  /** Add to the front (head). */
  public void addFirst(T data) {
    Node<T> n = new Node<>(data);
    n.next = first;
    first = n;
    size++;
  }

  /** Remove and return the first element; return null if empty. */
  public T removeFirst() {
    if (first == null)
      return null;
    T val = first.data;
    first = first.next;
    size--;
    return val;
  }

  /** Remove the element at index (0-based). Returns true if removed. */
  public boolean removeAt(int index) {
    if (index < 0 || index >= size)
      return false;
    if (index == 0) {
      removeFirst();
      return true;
    }
    Node<T> prev = first;
    for (int i = 0; i < index - 1; i++)
      prev = prev.next;
    Node<T> target = prev.next;
    prev.next = target.next;
    size--;
    return true;
  }

  /** Remove the first element equal to target (using equals). */
  public boolean removeFirstMatch(T target) {
    if (first == null)
      return false;
    if ((first.data == null && target == null) ||
        (first.data != null && first.data.equals(target))) {
      removeFirst();
      return true;
    }
    Node<T> prev = first;
    Node<T> curr = first.next;
    while (curr != null) {
      if ((curr.data == null && target == null) ||
          (curr.data != null && curr.data.equals(target))) {
        prev.next = curr.next;
        size--;
        return true;
      }
      prev = curr;
      curr = curr.next;
    }
    return false;
  }

  /**
   * Get element at index (0-based). Throws IndexOutOfBoundsException if invalid.
   */
  public T get(int index) {
    checkIndex(index);
    Node<T> curr = first;
    for (int i = 0; i < index; i++)
      curr = curr.next;
    return curr.data;
  }

  /** Set element at index and return old value. */
  public T set(int index, T value) {
    checkIndex(index);
    Node<T> curr = first;
    for (int i = 0; i < index; i++)
      curr = curr.next;
    T old = curr.data;
    curr.data = value;
    return old;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void clear() {
    // Allow GC to collect nodes
    Node<T> curr = first;
    while (curr != null) {
      Node<T> next = curr.next;
      curr.next = null;
      curr.data = null;
      curr = next;
    }
    first = null;
    size = 0;
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
  }

  @Override
  public String toString() {
    if (first == null)
      return "[]";
    StringBuilder sb = new StringBuilder("[");
    Node<T> curr = first;
    while (curr != null) {
      sb.append(String.valueOf(curr.data));
      curr = curr.next;
      if (curr != null)
        sb.append(" -> ");
    }
    sb.append("]");
    return sb.toString();
  }

  // Simple smoke test
  public static void main(String[] args) {
    CustomLinkedList<Integer> myIntegerList = new CustomLinkedList<>();
    myIntegerList.add(5);
    myIntegerList.add(6);
    myIntegerList.add(1);
    myIntegerList.add(4);
    myIntegerList.addFirst(99);
    System.out.println(myIntegerList.toString()); // [99 -> 5 -> 6 -> 1 -> 4]
    myIntegerList.removeAt(2);
    System.out.println(myIntegerList.toString()); // [99 -> 5 -> 1 -> 4]
    System.out.println("get(2)=" + myIntegerList.get(2)); // 1
    myIntegerList.set(2, 123);
    System.out.println(myIntegerList.toString()); // [99 -> 5 -> 123 -> 4]
    System.out.println("size=" + myIntegerList.size());
  }
}
