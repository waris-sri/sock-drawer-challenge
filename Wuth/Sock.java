package Lect3;

import java.util.ArrayList;

public class Sock {
    ArrayList<Description> socks;

    public Sock() {
        socks = new ArrayList<>();
    }

    public void markDamaged(int index) {
        if(index < socks.size()) {
            socks.get(index).setDetail("Damaged");
        } else {
            System.out.println("Index out of bounds");
        }
    }

    public void listAllSocks() {
        System.out.println("Socks:");
        for (int i = 0; i < socks.size(); i++) {
            System.out.println("\tIndex: " + i + socks.get(i).toString());
        }
    }

    public void findMatchingPair(String color) {
        ArrayList<Integer> index = new ArrayList<>();
        for(int i = 0; i < socks.size(); i++) {
            if(socks.get(i).getDetail().toLowerCase().equals("clean") && socks.get(i).getColor().toLowerCase().equals(color.toLowerCase())) {
                index.add(i);
            }
        }
        if(!index.isEmpty()) {
            System.out.println("Matched pair: " + index.toString().substring(1, index.toString().length()-1));
        } else {
            System.out.println("No such matching pair");
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
        ArrayList<Description> lost = new ArrayList<>();
        for(int i = 0; i < socks.size(); i++) {
            if(socks.get(i).getDetail().toLowerCase().equals("lost")) {
                lost.add(socks.get(i));
            }
        }
        System.out.println("Lost Socks:");
        for (int i = 0; i < lost.size(); i++) {
            System.out.println("\tIndex: " + i + lost.get(i).toString());
        }
    }

    public void discardSock(String description) {
        for(int i = 0; i < socks.size(); i++) {
            if(socks.get(i).getDetail().toLowerCase().equals(description.toLowerCase())) {
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
        for(int i = 0; i < socks.size(); i++) {
            if(socks.get(i).getDetail().toLowerCase().equals("damaged")) {
                damaged++;
            }
        }
        System.out.println("Total number of damaged socks: " + damaged);
    }

    public void clearDrawer() {
        socks.clear();
    }
}
