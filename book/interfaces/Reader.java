package interfaces;

import book.Book;

import java.util.Optional;

public interface Reader {
    Optional<Book> findBookByAuthor(String author);

    Optional<Book> findBookByTitle(String title);

    void turnToOtherShelf();
}
