package linkedListVersion;

public class Sock extends CustomLinkedList<Description> {
  CustomLinkedList<Description> socks;

  public Sock() {
    this.socks = new CustomLinkedList<>();
  }

  public void markDamaged(int index) {
    if (index < socks.size()) {
      socks.get(index).setDetail("Damaged");
    } else {
      System.out.println("Index out of bounds!");
    }
  }

  public void listAllSocks() {
    System.out.println("ALL SOCKS");
    System.out.println("=".repeat(55));
    for (int i = 0; i < socks.size(); i++) {
      System.out.println("Index: " + i + socks.get(i).toString());
    }
  }

  public void findMatchingPair(String color) {
    CustomLinkedList<Integer> index = new CustomLinkedList<>();
    for (int i = 0; i < socks.size(); i++) {
      if (socks.get(i).getDetail().equalsIgnoreCase("clean")
          && socks.get(i).getColor().equalsIgnoreCase(color)) {
        index.add(i);
      }
    }
    if (!index.isEmpty()) {
      System.out.println("\nMatched pair(s): " + index.toString());
    } else {
      System.out.println("\nNo such matching pair(s).");
    }
  }

  public void addNewSock(String description) {
    socks.add(new Description(description));
  }

  public void repairSocks(int index) {
    socks.get(index).setDetail("Clean");
  }

  public void removeSockByIndex(int index) {
    socks.remove(index);
  }

  public void findLostSocks() {
    CustomLinkedList<Description> lost = new CustomLinkedList<>();
    for (int i = 0; i < socks.size(); i++) {
      if ("lost".equalsIgnoreCase(socks.get(i).getDetail())) {
        lost.add(socks.get(i));
      }
    }
    System.out.println("\nLOST SOCKS");
    System.out.println("=".repeat(55));
    for (int i = 0; i < lost.size(); i++) {
      System.out.println("Index: " + i + lost.get(i).toString());
    }
  }

  public void discardSock(String description) {
    for (int i = 0; i < socks.size(); i++) {
      if (socks.get(i).getDetail().equalsIgnoreCase(description)) {
        socks.remove(i);
        break;
      }
    }
  }

  public void countTotalSocks() {
    System.out.println("\nTotal number of socks currently in drawer: " + socks.size());
  }

  public void countDamagedSocks() {
    int damaged = 0;
    for (int i = 0; i < socks.size(); i++) {
      if (socks.get(i).getDetail().equalsIgnoreCase("damaged")) {
        damaged++;
      }
    }
    System.out.println("Total number of damaged socks: " + damaged);
  }

  public void clearDrawer() {
    socks.clear();
  }
}
