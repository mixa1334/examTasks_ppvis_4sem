package shelf;

import book.Book;
import book.BookException;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private final String name;
    private final List<Book> books;

    public Shelf(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        synchronized (this) {
            return new ArrayList<>(books);
        }
    }

    public void addBook(Book book) throws BookException {
        synchronized (this) {
            for (var bk : books) {
                if (bk.getAuthor().equals(book.getAuthor()) && bk.getTitle().equals(book.getTitle())) {
                    throw new BookException("Книга с таким автором/заголовком уже существует на этой полке");
                }
            }
            books.add(book);
        }
    }

    public void deleteBook(Book book) {
        synchronized (this) {
            books.remove(book);
        }
    }
}
