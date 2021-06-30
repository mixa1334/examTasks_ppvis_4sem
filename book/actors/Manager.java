package actors;

import book.Book;
import book.BookException;
import shelf.Library;
import shelf.Shelf;

public class Manager implements interfaces.Manager {
    private final Library library;

    public Manager(Library library) {
        this.library = library;
    }

    @Override
    public void addBook(Shelf shelf, Book book) {
        try {
            shelf.addBook(book);
        } catch (BookException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteBook(Book book) {
        library.deleteBook(book);
    }

    @Override
    public void createShelf(String name) {
        library.addShelf(new Shelf(name));
    }
}
