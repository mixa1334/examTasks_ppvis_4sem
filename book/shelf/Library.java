package shelf;

import book.Book;

import java.util.Deque;
import java.util.LinkedList;

public class Library {
    private final Deque<Shelf> shelves;

    public Library(Deque<Shelf> shelves) {
        this.shelves = shelves;
    }

    public Deque<Shelf> getShelves() {
        synchronized (this) {
            return new LinkedList<>(shelves);
        }
    }

    public void addShelf(Shelf shelf) {
        synchronized (this) {
            this.shelves.add(shelf);
        }
    }

    public void deleteBook(Book book) {
        synchronized (this) {
            for (var temp : shelves) {
                temp.deleteBook(book);
            }
        }
    }
}
