package linkedListVersion;

class Node<T> {
  public T data;
  public Node<T> next;

  public Node(T data) {
    this.data = data;
    this.next = null;
  }
}

public class CustomLinkedList<T> {
  public Node<T> first; // first node with data; assume no dummy head
  public int size;

  // constructor
  public CustomLinkedList() {
    this.first = null;
    this.size = 0;
  }

  // constructor
  public CustomLinkedList(T data) {
    this.first = new Node<>(data);
  }

  public void add(T data) {
    Node<T> newNode = new Node<>(data);
    if (first == null) {
      first = newNode;
    } else {
      Node<T> last = first;
      while (last.next != null) {
        last = last.next;
      }
      last.next = newNode;
    }
    this.size++;
  }

  // add right after the head node
  public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);
    newNode.next = first;
    first = newNode;
    this.size++;
  }

  public T delFirst() {
    if (first == null) {
      return null;
    }
    T deletedVal = first.data;
    first = first.next;
    this.size--;
    return deletedVal;
  }

  public boolean remove(int idx) {
    if (idx < 0 || idx >= this.size) {
      return false;
    }
    if (idx == 0) {
      delFirst();
      return true;
    }
    Node<T> curr = first; // at index 0
    for (int i = 0; i < idx - 1; i++) {
      curr = curr.next; // now at index `idx - 1`
    }
    Node<T> target = curr.next; // target is at index `idx`
    curr.next = target.next; // skip target node (links node at idx-1 to idx+1`)
    this.size--;
    return true;
  }

  public T get(int idx) {
    if (idx < 0 || idx >= this.size) {
      throw new IndexOutOfBoundsException(
          "\n\tYou tried to access index " + idx + " while the size is " + this.size + ".");
    }
    Node<T> curr = first;
    for (int i = 0; i < idx; i++) {
      curr = curr.next;
    }
    return curr.data;
  }

  public int size() {
    return this.size;
  }

  @Override
  public String toString() {
    String result = "";
    Node<T> curr = first;
    while (curr.next != null) {
      result += curr.data + " → ";
      curr = curr.next;
    }
    result += curr.data;
    return result;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void clear() {
    first = null;
    size = 0;
  }

  // test
  public static void main(String[] args) {
    CustomLinkedList<Integer> integers = new CustomLinkedList<>();
    integers.add(5);
    integers.add(6);
    integers.add(8);
    integers.add(9);
    integers.add(3);
    integers.add(4);
    integers.add(2);
    integers.add(1);
    integers.addFirst(0);
    integers.addFirst(99);
    integers.delFirst();
    integers.remove(2);
    System.out.println(integers.toString());
    integers.remove(3);
    System.out.println(integers.toString());
    System.out.println(integers.get(5));
    System.out.println(integers.get(99));
  }
}