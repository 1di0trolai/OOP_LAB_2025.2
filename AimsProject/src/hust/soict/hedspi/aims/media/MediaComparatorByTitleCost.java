package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media first, Media second) {
        int titleCompare = compareTitle(first, second);
        if (titleCompare != 0) {
            return titleCompare;
        }
        return Float.compare(second.getCost(), first.getCost());
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
