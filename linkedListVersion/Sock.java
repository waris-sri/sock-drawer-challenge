package linkedListVersion;

public class Sock extends CustomLinkedList<Description> {
  CustomLinkedList<Description> socks;
  private int lostSockCount = 0;

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
    System.out.println("\nALL SOCKS (" + socks.size + ")");
    System.out.println("=".repeat(63));
    for (int i = 0; i < socks.size(); i++) {
      System.out.println("Index: " + i + socks.get(i).toString());
    }
  }

  public void findMatchingPair(String color) {
    CustomLinkedList<Integer> index = new CustomLinkedList<>();
    for (int i = 0; i < socks.size(); i++) {
      if ((socks.get(i).getDetail().equalsIgnoreCase("clean")
          || socks.get(i).getDetail().equalsIgnoreCase("clean (repaired)"))
          && socks.get(i).getColor().equalsIgnoreCase(color)) {
        index.add(i);
      }
    }
    if (!index.isEmpty()) {
      System.out.printf("%10s:\tIndex %s\n", color, index.toString());
    } else {
      System.out.printf("%s: %s\n", color, "(No such match)");
    }
  }

  public void addNewSock(String description) {
    socks.add(new Description(description));
  }

  // only repair if the sock is damaged; lost socks can't be repaired
  public void repairSocks(int index) {
    if (index < 0 || index >= socks.size()) {
      System.out.println("Index out of bounds!");
      return;
    }
    Description d = socks.get(index);
    if ("damaged".equalsIgnoreCase(d.getDetail())) {
      d.setDetail("Clean (repaired)");
    }
  }

  public void removeSockByIndex(int index) {
    socks.remove(index);
  }

  public void findLostSocks() {
    CustomLinkedList<Description> lost = new CustomLinkedList<>();
    for (int i = 0; i < socks.size(); i++) {
      if ("lost".equalsIgnoreCase(socks.get(i).getDetail())) {
        lost.add(socks.get(i));
        lostSockCount++;
      }
    }
    System.out.println("\nLOST SOCKS (" + lostSockCount + ")");
    System.out.println("=".repeat(63));
    for (int i = 0; i < lost.size(); i++) {
      System.out.println("Index: " + i + lost.get(i).toString());
    }
  }

  // removes the FIRST occurrence of the specified sock
  public void discardSock(String description) {
    for (int i = 0; i < socks.size(); i++) {
      if (socks.get(i).getDetail().equalsIgnoreCase(description)) {
        socks.remove(i);
        break;
      }
    }
  }

  // don't count lost socks
  public void countTotalSocks() {
    int total = socks.size - lostSockCount;
    System.out.println("\nTotal number of socks currently in drawer: " + total);
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
