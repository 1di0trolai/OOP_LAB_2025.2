package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        System.out.println("=== Before swap ===");
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

        swap(jungleDVD, cinderellaDVD);
        System.out.println("\n=== After swap(jungleDVD, cinderellaDVD) ===");
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("\n=== After changeTitle(jungleDVD, cinderellaDVD.getTitle()) ===");
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
    }

    // This swap does NOT actually swap the references in the caller
    // because Java is pass-by-value
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // This changes the title because it modifies the object's internal state
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
