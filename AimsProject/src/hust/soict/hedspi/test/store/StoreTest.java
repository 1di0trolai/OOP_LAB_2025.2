package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
        public static void main(String[] args) {
                Store store = new Store();

                // Create DVDs
                DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                                "Animation", "Roger Allers", 87, 19.95f);
                DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                                "Science Fiction", "George Lucas", 124, 24.95f);
                DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                                "Animation", 18.99f);

                // Test addDVD
                System.out.println("=== Test: Add DVDs to store ===");
                store.addDVD(dvd1);
                store.addDVD(dvd2);
                store.addDVD(dvd3);

                // Test removeDVD
                System.out.println("\n=== Test: Remove dvd2 (Star Wars) from store ===");
                store.removeDVD(dvd2);

                // Test remove DVD not in store
                System.out.println("\n=== Test: Remove DVD not in store ===");
                DigitalVideoDisc dvdNotInStore = new DigitalVideoDisc("Moana");
                store.removeDVD(dvdNotInStore);
        }
}
