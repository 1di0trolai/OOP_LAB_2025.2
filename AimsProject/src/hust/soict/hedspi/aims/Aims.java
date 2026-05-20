package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Harry Potter and the Philosopher's Stone", "Fantasy", 18.36f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Harry Potter and the Chamber of Secrets", "Fantasy", 18.36f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban", "Fantasy",
                "J.K.Rowling", 18.36f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter and the Goblet of Fire", "Fantasy", "J.K.Rowling",
                18.36f, 444);

        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.addDigitalVideoDisc(dvd4);

        // Print cart
        anOrder.print();

        // Search by title
        anOrder.searchByTitle("Harry Potter");

        // Search by id
        anOrder.searchById(3);

        // Remove a DVD
        anOrder.removeDigitalVideoDisc(dvd4);

        // Print cart after removal
        anOrder.print();
    }
}
