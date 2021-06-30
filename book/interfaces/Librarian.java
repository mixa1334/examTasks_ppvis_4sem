package interfaces;

import book.Book;
import javafx.util.Pair;
import shelf.Shelf;

import java.util.List;
import java.util.Optional;

public interface Librarian {
    Optional<Pair<Book, List<Shelf>>> findBookByTitle(String title);

    void addBook(Shelf shelf, Book book);

    Optional<Pair<Book, List<Shelf>>> findBookByAuthor(String author);
}
