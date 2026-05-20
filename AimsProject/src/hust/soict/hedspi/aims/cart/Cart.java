package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Invalid media");
            return;
        }

        if (itemsOrdered.contains(media)) {
            System.out.println("The media already exists in the cart");
            return;
        }

        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed");
        } else {
            System.out.println("Media not found in cart");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty");
        } else {
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i));
            }
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media with id " + id + " found in cart.");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found: " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media with title matching \"" + title + "\" found in cart.");
        }
    }

    public Media findMediaByTitle(String title) {
        if (title == null) {
            return null;
        }
        for (Media media : itemsOrdered) {
            String mediaTitle = media.getTitle();
            if (mediaTitle != null && mediaTitle.equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public int countDigitalVideoDiscs() {
        int count = 0;
        for (Media media : itemsOrdered) {
            if (media instanceof DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public List<Media> getItemsOrdered() {
        return Collections.unmodifiableList(itemsOrdered);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        addMedia(disc);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (dvdList == null) {
            return;
        }
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        removeMedia(disc);
    }
}
