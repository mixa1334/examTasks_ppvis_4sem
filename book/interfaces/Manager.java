package interfaces;

import book.Book;
import shelf.Shelf;

public interface Manager {
    void addBook(Shelf shelf, Book book);

    void deleteBook(Book book);

    void createShelf(String name);
}
