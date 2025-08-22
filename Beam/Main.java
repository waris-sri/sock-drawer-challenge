import java.util.*;

/*
 * ALL SOCKS:
 * RED, LOST
 * ORANGE, LOST
 * YELLOW, CLEAN
 * GREEN, HOLE
 * BLUE, CLEAN
 * INDIGO, CLEAN
 * VIOLET, HOLE
 * (Desc contains LOST, CLEAN, HOLE)
 * (HOLE is changed to DAMAGED [count in Desc])
 */

class Sock {
  private String color;
  private String status;

  public Sock(String color, String status) {
    this.color = color;
    this.status = status;
  }

  String getColor() {
    return this.color;
  }

  String getStatus() {
    return this.status;
  }

  // this intersects with the repairSock() method
  void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return color + " (" + status + ")";
  }
}

class Drawer {
  private ArrayList<Sock> drawer = new ArrayList<>();

  /* QUESTION 1 (BEAM)*/
  public boolean markDamaged(int index) {
    if (index < 0 || index >= drawer.size()) {
      return false;
    } else {
      drawer.get(index).setStatus("Damaged");
      return true;
    }
  }

  public void listAllSocks() {
    if (drawer.isEmpty()) {
      System.out.println("Drawer is empty!");
      return;
    } else {
      for (int i = 0; i < drawer.size(); i++) {
        System.out.printf("%d. %s%n\n", i, drawer.get(i));
      }
    }
  }

  public void addNewSock(Sock s) {
    drawer.add(s);
  }
}

public class Main {
  public static void main(String[] args) {}
}
