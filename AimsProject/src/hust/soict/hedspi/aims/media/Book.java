package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();
    private String content = "";

    public Book() {
        super();
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, String content) {
        super(title, category, cost);
        this.content = content;
    }

    public ArrayList<String> getAuthors() {
        return new ArrayList<String>(authors);
    }

    public void addAuthor(String authorName) {
        addAuthor(authorName, true);
    }

    public void addAuthorSilently(String authorName) {
        addAuthor(authorName, false);
    }

    private void addAuthor(String authorName, boolean notify) {
        if (authorName == null || authorName.trim().isEmpty()) {
            if (notify) {
                System.out.println("Invalid author name");
            }
            return;
        }

        if (!authors.contains(authorName)) {
            authors.add(authorName);
            if (notify) {
                System.out.println("The author has been added");
            }
        } else {
            if (notify) {
                System.out.println("The author already exists");
            }
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("The author has been removed");
        } else {
            System.out.println("The author does not exist");
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? "" : content;
    }

    public int getContentLength() {
        String trimmedContent = content == null ? "" : content.trim();
        if (trimmedContent.isEmpty()) {
            return 0;
        }
        return trimmedContent.split("\\s+").length;
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + authors + " - "
                + getContentLength() + " tokens: " + getCost() + " $";
    }
}
