package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    private static final int MAX_ITEMS = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_ITEMS) {
            itemsInStore[qtyInStore++] = dvd;
            System.out.println("The disc has been added to the store");
        } else {
            System.out.println("The store is full");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The disc has been removed from the store");
                return;
            }
        }
        System.out.println("DVD not found in the store");
    }
}
