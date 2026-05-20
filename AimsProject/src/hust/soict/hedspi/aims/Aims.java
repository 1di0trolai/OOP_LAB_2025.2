package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        seedStore(store);

        while (true) {
            showMenu();
            int choice = readInt();
            switch (choice) {
            case 1:
                viewStore(store, cart);
                break;
            case 2:
                updateStore(store);
                break;
            case 3:
                seeCurrentCart(cart);
                break;
            case 0:
                System.out.println("Goodbye.");
                return;
            default:
                System.out.println("Invalid choice");
                break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void seedStore(Store store) {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book("Effective Java", "Programming", 45.00f,
                "Write clear programs by understanding objects classes methods and collections");
        book.addAuthorSilently("Joshua Bloch");

        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Various Directors", "Queen", 29.95f);
        cd.addTrackSilently(new Track("Bohemian Rhapsody", 6));
        cd.addTrackSilently(new Track("We Will Rock You", 2));
        cd.addTrackSilently(new Track("Don't Stop Me Now", 4));

        store.addMediaSilently(dvd);
        store.addMediaSilently(book);
        store.addMediaSilently(cd);
    }

    private static void viewStore(Store store, Cart cart) {
        while (true) {
            store.print();
            storeMenu();
            int choice = readInt();
            switch (choice) {
            case 1:
                showMediaDetails(store, cart);
                break;
            case 2:
                addMediaToCartFromStore(store, cart);
                break;
            case 3:
                playMediaFromStore(store);
                break;
            case 4:
                seeCurrentCart(cart);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice");
                break;
            }
        }
    }

    private static void showMediaDetails(Store store, Cart cart) {
        Media media = readMediaFromStore(store);
        if (media == null) {
            return;
        }

        displayMediaDetails(media);
        while (true) {
            mediaDetailsMenu();
            int choice = readInt();
            switch (choice) {
            case 1:
                addMediaToCart(media, cart);
                break;
            case 2:
                playMedia(media);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice");
                break;
            }
        }
    }

    private static void addMediaToCartFromStore(Store store, Cart cart) {
        Media media = readMediaFromStore(store);
        if (media != null) {
            addMediaToCart(media, cart);
        }
    }

    private static void addMediaToCart(Media media, Cart cart) {
        cart.addMedia(media);
        if (media instanceof DigitalVideoDisc) {
            System.out.println("Number of DVDs in cart: " + cart.countDigitalVideoDiscs());
        }
    }

    private static void playMediaFromStore(Store store) {
        Media media = readMediaFromStore(store);
        if (media != null) {
            playMedia(media);
        }
    }

    private static void updateStore(Store store) {
        while (true) {
            System.out.println("Update store:");
            System.out.println("--------------------------------");
            System.out.println("1. Add media");
            System.out.println("2. Remove media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = readInt();
            switch (choice) {
            case 1:
                Media media = createMediaFromInput();
                if (media != null) {
                    store.addMedia(media);
                }
                break;
            case 2:
                Media mediaToRemove = readMediaFromStore(store);
                if (mediaToRemove != null) {
                    store.removeMedia(mediaToRemove);
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice");
                break;
            }
        }
    }

    private static void seeCurrentCart(Cart cart) {
        while (true) {
            cart.print();
            cartMenu();
            int choice = readInt();
            switch (choice) {
            case 1:
                filterCart(cart);
                break;
            case 2:
                sortCart(cart);
                break;
            case 3:
                removeMediaFromCart(cart);
                break;
            case 4:
                playMediaFromCart(cart);
                break;
            case 5:
                cart.clear();
                System.out.println("An order has been created");
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice");
                break;
            }
        }
    }

    private static void filterCart(Cart cart) {
        System.out.println("Filter by:");
        System.out.println("1. Id");
        System.out.println("2. Title");
        int choice = readInt();
        switch (choice) {
        case 1:
            cart.searchById(readInt("Enter id: "));
            break;
        case 2:
            cart.searchByTitle(readRequiredLine("Enter title: "));
            break;
        default:
            System.out.println("Invalid choice");
            break;
        }
    }

    private static void sortCart(Cart cart) {
        System.out.println("Sort by:");
        System.out.println("1. Title then cost");
        System.out.println("2. Cost then title");
        int choice = readInt();
        switch (choice) {
        case 1:
            cart.sortByTitleCost();
            cart.print();
            break;
        case 2:
            cart.sortByCostTitle();
            cart.print();
            break;
        default:
            System.out.println("Invalid choice");
            break;
        }
    }

    private static void removeMediaFromCart(Cart cart) {
        Media media = readMediaFromCart(cart);
        if (media != null) {
            cart.removeMedia(media);
        }
    }

    private static void playMediaFromCart(Cart cart) {
        Media media = readMediaFromCart(cart);
        if (media != null) {
            playMedia(media);
        }
    }

    private static Media createMediaFromInput() {
        System.out.println("Choose media type:");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.println("0. Back");

        int choice = readInt();
        switch (choice) {
        case 1:
            return createBookFromInput();
        case 2:
            return createDvdFromInput();
        case 3:
            return createCdFromInput();
        case 0:
            return null;
        default:
            System.out.println("Invalid choice");
            return null;
        }
    }

    private static Book createBookFromInput() {
        String title = readRequiredLine("Title: ");
        String category = readRequiredLine("Category: ");
        float cost = readFloat("Cost: ");
        String content = readLine("Content: ");
        Book book = new Book(title, category, cost, content);

        String authors = readLine("Authors, separated by comma: ");
        if (!authors.isEmpty()) {
            String[] authorList = authors.split(",");
            for (String author : authorList) {
                book.addAuthor(author.trim());
            }
        }
        return book;
    }

    private static DigitalVideoDisc createDvdFromInput() {
        String title = readRequiredLine("Title: ");
        String category = readRequiredLine("Category: ");
        String director = readRequiredLine("Director: ");
        int length = readInt("Length: ");
        float cost = readFloat("Cost: ");
        return new DigitalVideoDisc(title, category, director, length, cost);
    }

    private static CompactDisc createCdFromInput() {
        String title = readRequiredLine("Title: ");
        String category = readRequiredLine("Category: ");
        String artist = readRequiredLine("Artist: ");
        String director = readRequiredLine("Director: ");
        float cost = readFloat("Cost: ");
        CompactDisc cd = new CompactDisc(title, category, director, artist, cost);

        int numberOfTracks = readInt("Number of tracks: ");
        for (int i = 0; i < numberOfTracks; i++) {
            System.out.println("Track " + (i + 1) + ":");
            String trackTitle = readRequiredLine("Title: ");
            int trackLength = readInt("Length: ");
            cd.addTrack(new Track(trackTitle, trackLength));
        }
        return cd;
    }

    private static Media readMediaFromStore(Store store) {
        String title = readRequiredLine("Enter media title: ");
        Media media = store.findMediaByTitle(title);
        if (media == null) {
            System.out.println("No media with title \"" + title + "\" found in store.");
        }
        return media;
    }

    private static Media readMediaFromCart(Cart cart) {
        String title = readRequiredLine("Enter media title: ");
        Media media = cart.findMediaByTitle(title);
        if (media == null) {
            System.out.println("No media with title \"" + title + "\" found in cart.");
        }
        return media;
    }

    private static void displayMediaDetails(Media media) {
        System.out.println("Media details:");
        System.out.println(media);
        if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            for (Track track : cd.getTracks()) {
                System.out.println(track);
            }
        }
    }

    private static void playMedia(Media media) {
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played");
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    private static String readRequiredLine(String prompt) {
        while (true) {
            String value = readLine(prompt);
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Value cannot be empty");
        }
    }

    private static int readInt() {
        return readInt(null);
    }

    private static int readInt(String prompt) {
        if (prompt != null) {
            System.out.print(prompt);
        }
        try {
            return Integer.parseInt(SCANNER.nextLine().trim());
        } catch (NumberFormatException exception) {
            return -1;
        }
    }

    private static float readFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Float.parseFloat(SCANNER.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println("Invalid number");
            }
        }
    }
}
