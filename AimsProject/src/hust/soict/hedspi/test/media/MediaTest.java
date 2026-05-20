package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class MediaTest {
    public static void main(String[] args) {
        ArrayList<Media> mediae = new ArrayList<Media>();

        Book book = new Book("Clean Code", "Programming", 32.50f,
                "Code is clean when it can be understood and changed easily");
        book.addAuthorSilently("Robert C. Martin");

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Various Directors", "Queen", 29.95f);
        cd.addTrackSilently(new Track("Bohemian Rhapsody", 6));
        cd.addTrackSilently(new Track("We Will Rock You", 2));

        mediae.add(book);
        mediae.add(dvd);
        mediae.add(cd);

        System.out.println("=== Polymorphism with toString() ===");
        for (Media media : mediae) {
            System.out.println(media);
        }

        System.out.println("\n=== Sort by title then cost ===");
        Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
        for (Media media : mediae) {
            System.out.println(media);
        }

        System.out.println("\n=== Sort by cost then title ===");
        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
        for (Media media : mediae) {
            System.out.println(media);
        }
    }
}
