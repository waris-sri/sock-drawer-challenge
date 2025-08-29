import java.util.LinkedList;

public class Sock {
    AniquaList<Description> socks;

    public Sock() {
        socks = new AniquaList<>();
    }

    public void markDamaged(int index) {
        if (index < socks.size()) {
            socks.get(index).setDetail("Damaged");
        } else {
            System.out.println("Index out of bounds");
        }
    }

    public void listAllSocks() {
        System.out.println("All Socks:");
        for (int i = 0; i < socks.size(); i++) {
            System.out.println("\tIndex: " + i + socks.get(i).toString());
        }
    }

    public void findMatchingPair(String color) {
        AniquaList<Integer> index = new AniquaList<>();
        for (int i = 0; i < socks.size(); i++) {
            if (socks.get(i).getDetail().equalsIgnoreCase("clean") && socks.get(i).getColor().equalsIgnoreCase(color)) {
                index.add(i);
            }
        }
        if (!index.isEmpty()) {
            System.out.print("Matched pair: ");
            for (int i = 0; i < index.size(); i++) {
                System.out.print(index.get(i) + " ");
            }
            System.out.println();
        } else {
            System.out.println("No such matching pair");
        }
    }

    public void addNewSock(String description) {
        socks.add(new Description(description)); // -------------------------------------------------
    }

    public void repairSocks(int index) {
        socks.get(index).setDetail("Clean");
    }

    public void removeSockByIndex(int index) {
        socks.remove(index); // -------------------------------------------------
    }

    public void findLostSocks() {
        AniquaList<Description> lost = new AniquaList<>();
        for (int i = 0; i < socks.size(); i++) {
            if (socks.get(i).getDetail().equalsIgnoreCase("lost")) {
                lost.add(socks.get(i));
            }
        }
        System.out.println("Lost Socks:");
        for (int i = 0; i < lost.size(); i++) {
            System.out.println("\tIndex: " + i + lost.get(i).toString());
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
        System.out.println("Total number of socks currently in drawer: " + socks.size());
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
