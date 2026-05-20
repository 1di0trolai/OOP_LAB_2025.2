package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        addMedia(media, true);
    }

    public void addMediaSilently(Media media) {
        addMedia(media, false);
    }

    private void addMedia(Media media, boolean notify) {
        if (media == null) {
            if (notify) {
                System.out.println("Invalid media");
            }
            return;
        }

        if (itemsInStore.contains(media)) {
            if (notify) {
                System.out.println("The media already exists in the store");
            }
            return;
        }

        itemsInStore.add(media);
        if (notify) {
            System.out.println("The media has been added to the store");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media has been removed from the store");
        } else {
            System.out.println("Media not found in the store");
        }
    }

    public Media findMediaByTitle(String title) {
        if (title == null) {
            return null;
        }
        for (Media media : itemsInStore) {
            String mediaTitle = media.getTitle();
            if (mediaTitle != null && mediaTitle.equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i));
            }
        }
        System.out.println("***************************************************");
    }

    public List<Media> getItemsInStore() {
        return Collections.unmodifiableList(itemsInStore);
    }

    public void addDVD(DigitalVideoDisc dvd) {
        addMedia(dvd);
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        removeMedia(dvd);
    }
}
