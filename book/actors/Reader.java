package actors;

import book.Book;
import shelf.Library;
import shelf.Shelf;

import java.util.Iterator;
import java.util.Optional;

public class Reader implements interfaces.Reader {
    private final Library library;
    private Shelf shelf;

    public Reader(Library library, Shelf shelf) {
        this.library = library;
        this.shelf = shelf;
    }

    @Override
    public Optional<Book> findBookByAuthor(String author) {
        for (var book : shelf.getBooks()) {
            if (book.getAuthor().equals(author)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> findBookByTitle(String title) {
        for (var book : shelf.getBooks()) {
            if (book.getTitle().equals(title)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public void turnToOtherShelf() {
        Iterator<Shelf> it = library.getShelves().iterator();

        while (it.hasNext()) {
            Shelf temp = it.next();
            if (temp.equals(shelf)) {
                if (it.hasNext()) {
                    shelf = it.next();
                } else {
                    shelf = library.getShelves().getFirst();
                }
            }
        }
    }
}
