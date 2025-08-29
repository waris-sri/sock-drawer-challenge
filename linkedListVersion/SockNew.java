package linkedListVersion;

public class SockNew {
  private final CustomLinkedList<Description> socks;

  public SockNew() {
    this.socks = new CustomLinkedList<>();
  }

  /** Add a new sock by raw description, e.g. "Red(Clean)" or "Blue (Hole)". */
  public void addNewSock(String rawDescription) {
    if (rawDescription == null) {
      System.out.println("Cannot add a null description.");
      return;
    }
    socks.add(new Description(rawDescription));
  }

  /** Mark one sock as damaged by index (0-based). */
  public void markDamaged(int index) {
    if (!inBounds(index)) {
      System.out.println("Index out of bounds");
      return;
    }
    socks.get(index).setDetail("Damaged");
  }

  /** Print every sock in the drawer with its index. */
  public void listAllSocks() {
    if (socks.size() == 0) {
      System.out.println("No socks in the drawer.");
      return;
    }
    for (int i = 0; i < socks.size(); i++) {
      System.out.println("#" + i + " " + socks.get(i));
    }
  }

  /** Find matching clean pair(s) by color and print their indices. */
  public void findMatchingPair(String color) {
    if (color == null || color.isEmpty()) {
      System.out.println("Please provide a color.");
      return;
    }
    CustomLinkedList<Integer> indices = new CustomLinkedList<>();
    for (int i = 0; i < socks.size(); i++) {
      Description d = socks.get(i);
      if ("clean".equalsIgnoreCase(d.getDetail()) && color.equalsIgnoreCase(d.getColor())) {
        indices.add(i);
      }
    }
    if (indices.size() >= 2) {
      // Print all indices that match (there could be more than one pair)
      System.out.print("Matched pair candidates (clean " + color + "): [");
      for (int i = 0; i < indices.size(); i++) {
        System.out.print(indices.get(i));
        if (i < indices.size() - 1)
          System.out.print(", ");
      }
      System.out.println("]");
    } else {
      System.out.println("No clean matching pair found for color: " + color);
    }
  }

  /** Repair one sock by index: Damaged -> Clean. */
  public void repairSocks(int index) {
    if (!inBounds(index)) {
      System.out.println("Index out of bounds");
      return;
    }
    Description d = socks.get(index);
    if ("damaged".equalsIgnoreCase(d.getDetail())) {
      d.setDetail("Clean");
      System.out.println("Sock #" + index + " repaired to Clean.");
    } else {
      System.out.println("Sock #" + index + " is not damaged (detail=" + d.getDetail() + ").");
    }
  }

  /** Remove a sock at a given index. */
  public void removeSockByIndex(int index) {
    if (!inBounds(index)) {
      System.out.println("Index out of bounds");
      return;
    }
    socks.removeAt(index);
    System.out.println("Removed sock at index " + index + ".");
  }

  /** List indices and details of 'Lost' socks. */
  public void findLostSocks() {
    CustomLinkedList<Integer> lostIndices = new CustomLinkedList<>();
    for (int i = 0; i < socks.size(); i++) {
      if ("lost".equalsIgnoreCase(socks.get(i).getDetail())) {
        lostIndices.add(i);
      }
    }
    if (lostIndices.size() == 0) {
      System.out.println("No lost socks found.");
    } else {
      System.out.print("Lost socks at indices: [");
      for (int i = 0; i < lostIndices.size(); i++) {
        System.out.print(lostIndices.get(i));
        if (i < lostIndices.size() - 1)
          System.out.print(", ");
      }
      System.out.println("]");
    }
  }

  /** Discard (remove) all socks that have a given detail, e.g. "Hole". */
  public void discardSock(String detail) {
    if (detail == null || detail.isEmpty()) {
      System.out.println("Please provide a detail to discard (e.g., \"Hole\").");
      return;
    }
    int removed = 0;
    // Iterate by index so we can safely remove while traversing
    int i = 0;
    while (i < socks.size()) {
      if (detail.equalsIgnoreCase(socks.get(i).getDetail())) {
        socks.removeAt(i);
        removed++;
        // do not increment i, as elements shift left
      } else {
        i++;
      }
    }
    System.out.println("Discarded " + removed + " sock(s) with detail: " + detail);
  }

  /** Print count of all socks. */
  public void countTotalSocks() {
    System.out.println("Total number of socks: " + socks.size());
  }

  /** Print count of damaged socks. */
  public void countDamagedSocks() {
    int damaged = 0;
    for (int i = 0; i < socks.size(); i++) {
      if ("damaged".equalsIgnoreCase(socks.get(i).getDetail())) {
        damaged++;
      }
    }
    System.out.println("Total number of damaged socks: " + damaged);
  }

  /** Remove everything from the drawer. */
  public void clearDrawer() {
    socks.clear();
  }

  // ---------- helpers ----------
  private boolean inBounds(int index) {
    return index >= 0 && index < socks.size();
  }
}
