package interfaces;

import Catalog.Catalog;
import document.Document;

import java.util.List;

public interface Secretary {
    void addDocumentToCatalog(Catalog catalog, Document document);

    List<Document> findDocumentsByAuthor(String author);

    List<Document> findDocumentsByTitle(String title);

    void removeDocument(Catalog catalog, Document document);
}
