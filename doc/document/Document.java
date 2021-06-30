package document;

import java.util.Date;

public class Document {
    private String title;
    private final Date date;
    private final String author;
    private String text;

    public Document(String title, Date date, String author, String text) {
        this.author = author;
        this.date = date;
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        synchronized (this) {
            return title;
        }
    }

    public void setTitle(String title) {
        synchronized (this) {
            this.title = title;
        }
    }

    public Date getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        synchronized (this) {
            return text;
        }
    }

    public void setText(String text) {
        synchronized (this) {
            this.text = text;
        }
    }
}
