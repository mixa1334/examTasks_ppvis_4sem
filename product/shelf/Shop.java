package shelf;

import java.util.Deque;
import java.util.LinkedList;

public class Shop {
    private final Deque<Shelf> shelves;

    public Shop(Deque<Shelf> shelves) {
        this.shelves = shelves;
    }

    public Deque<Shelf> getShelves() {
        synchronized (this) {
            return new LinkedList<>(shelves);
        }
    }

    public void addShelf(Shelf shelf) {
        synchronized (this) {
            shelves.add(shelf);
        }
    }

    public void removeShelf(Shelf shelf) {
        synchronized (this) {
            shelves.remove(shelf);
        }
    }
}