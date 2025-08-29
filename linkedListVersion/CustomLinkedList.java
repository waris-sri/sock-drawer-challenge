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
  public Node<T> first;
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

  public void append(T data) {
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
    size++;
  }

  // add right after the head node
  public void addFirst(T data) {
    Node<T> newNode = new Node<>(data);
    newNode.next = first;
    first = newNode;
    size++;
  }

  public T delFirst() {
    if (first == null) {
      return null;
    }
    T deletedVal = first.data;
    first = first.next;
    size--;
    return deletedVal;
  }

  public boolean delAt(int idx) {
    if (idx < 0 || idx >= size) {
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
    size--;
    return true;
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

  public static void main(String[] args) {
    CustomLinkedList<Integer> myIntegerList = new CustomLinkedList<>();
    myIntegerList.append(5);
    myIntegerList.append(6);
    myIntegerList.append(1);
    myIntegerList.append(4);
    myIntegerList.append(7);
    myIntegerList.append(12);
    myIntegerList.append(59);
    myIntegerList.append(9);
    myIntegerList.append(42);
    System.out.println(myIntegerList.toString());
  }
}
