package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class CartTest {
        public static void main(String[] args) {
                Cart cart = new Cart();

                // Create DVDs
                DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                                "Animation", "Roger Allers", 87, 19.95f);
                DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                                "Science Fiction", "George Lucas", 124, 24.95f);
                DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                                "Animation", 18.99f);

                // Test addDigitalVideoDisc(disc)
                System.out.println("=== Test: Add single DVD ===");
                cart.addDigitalVideoDisc(dvd1);

                // Test addDigitalVideoDisc(dvd1, dvd2)
                System.out.println("\n=== Test: Add two DVDs ===");
                cart.addDigitalVideoDisc(dvd2, dvd3);

                // Test addDigitalVideoDisc(dvdArray)
                System.out.println("\n=== Test: Add array of DVDs ===");
                DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen",
                                "Animation", "Chris Buck", 102, 19.99f);
                DigitalVideoDisc dvd5 = new DigitalVideoDisc("Interstellar",
                                "Science Fiction", "Christopher Nolan", 169, 29.99f);
                DigitalVideoDisc[] dvdArr = { dvd4, dvd5 };
                cart.addDigitalVideoDisc(dvdArr);

                // Test print
                System.out.println("\n=== Test: Print Cart ===");
                cart.print();

                // Test searchById
                System.out.println("\n=== Test: Search by ID (id=2) ===");
                cart.searchById(2);

                // Test searchByTitle
                System.out.println("\n=== Test: Search by title (\"Lion\") ===");
                cart.searchByTitle("Lion");

                // Test searchByTitle - not found
                System.out.println("\n=== Test: Search by title (\"Avatar\") ===");
                cart.searchByTitle("Avatar");

                // Test removeDigitalVideoDisc
                System.out.println("\n=== Test: Remove dvd3 (Aladin) ===");
                cart.removeDigitalVideoDisc(dvd3);
                cart.print();

                // Test remove DVD not in cart
                System.out.println("\n=== Test: Remove DVD not in cart ===");
                DigitalVideoDisc dvdNotInCart = new DigitalVideoDisc("Moana");
                cart.removeDigitalVideoDisc(dvdNotInCart);
        }
}
