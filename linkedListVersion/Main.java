package linkedListVersion;

public class Main {
  public static void main(String[] args) {
    Sock socks = new Sock();
    socks.addNewSock("Blue (Hole)");
    socks.addNewSock("Striped (Clean)");
    socks.addNewSock("Red (Clean)");
    socks.addNewSock("Green (Lost)");
    socks.addNewSock("Orange (Hole)");
    socks.addNewSock("Wavy (Lost)");
    socks.addNewSock("Purple (Lost)");
    socks.addNewSock("Red (Clean)");
    socks.addNewSock("Polka Dots (Clean)");
    socks.addNewSock("Black (Hole)");
    socks.addNewSock("Gray (Hole)");
    socks.addNewSock("Beige (Hole)");
    socks.addNewSock("Navy (Hole)");
    socks.addNewSock("Red (Clean)");
    socks.addNewSock("Burgundy (Lost)");
    socks.addNewSock("Pink (Lost)");
    socks.addNewSock("Brown (Hole)");

    socks.markDamaged(0);
    socks.markDamaged(4);
    socks.markDamaged(9);
    socks.markDamaged(10);

    socks.addNewSock("Yellow (Clean)");

    socks.discardSock("Hole");

    socks.removeSockByIndex(5);

    socks.markDamaged(15);

    socks.repairSocks(0);
    socks.repairSocks(4);
    socks.repairSocks(8);
    socks.repairSocks(9);

    socks.listAllSocks();

    socks.findLostSocks();

    System.out.println("\nMATCHING PAIR(S)");
    System.out.println("=".repeat(63));
    socks.findMatchingPair("Red");
    socks.findMatchingPair("Black");
    socks.findMatchingPair("Gray");
    socks.findMatchingPair("Blue");
    socks.findMatchingPair("Orange");
    socks.findMatchingPair("Polka Dots");

    socks.countTotalSocks();

    socks.countDamagedSocks();

    socks.clearDrawer();
  }
}
