package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media first, Media second) {
        int costCompare = Float.compare(second.getCost(), first.getCost());
        if (costCompare != 0) {
            return costCompare;
        }
        return compareTitle(first, second);
    }

    private int compareTitle(Media first, Media second) {
        String firstTitle = first.getTitle();
        String secondTitle = second.getTitle();

        if (firstTitle == null && secondTitle == null) {
            return 0;
        }
        if (firstTitle == null) {
            return -1;
        }
        if (secondTitle == null) {
            return 1;
        }
        return firstTitle.compareToIgnoreCase(secondTitle);
    }
}
