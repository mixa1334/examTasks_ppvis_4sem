package interfaces;

import Catalog.Catalog;
import document.Document;

public interface Administrator {
    void deleteDocument(Document document);

    void createCatalog(Catalog catalog, String name);

    void moveDocument(Document document, Catalog catalogFrom, Catalog catalogTo);
}
