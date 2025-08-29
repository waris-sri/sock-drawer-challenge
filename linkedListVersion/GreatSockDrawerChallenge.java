package linkedListVersion;

// Person 6
public class GreatSockDrawerChallenge {
  public static void main(String[] args) {
    Sock socks = new Sock();
    socks.addNewSock("Red (Clean)");
    socks.addNewSock("Blue (Hole)");
    socks.addNewSock("Striped (Clean)");
    socks.addNewSock("Green (Lost)");
    socks.addNewSock("Polka (Clean)");
    socks.addNewSock("Black (Hole)");

    // Person 1
    socks.markDamaged(4);
    socks.listAllSocks();

    // Person 2
    socks.findMatchingPair("Red");
    socks.addNewSock("Yellow (Clean)");

    // Person 3
    socks.repairSocks(4);
    socks.removeSockByIndex(5);

    // Person 4
    socks.findLostSocks();
    socks.discardSock("Hole");

    // Person 5
    socks.countTotalSocks();
    socks.countDamagedSocks();
    socks.clearDrawer();
  }
}
