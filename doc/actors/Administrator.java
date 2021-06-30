package actors;

import Catalog.Catalog;
import document.Document;
import document.DocumentException;

public class Administrator implements interfaces.Administrator {
    private final Catalog rootCatalog;

    public Administrator(Catalog catalog) {
        this.rootCatalog = catalog;
    }

    @Override
    public void deleteDocument(Document document) {
        rootCatalog.findDocuments(document1 -> document1 == document)
                .forEach(pair -> pair.getValue().deleteDocument(pair.getKey()));
    }

    @Override
    public void createCatalog(Catalog catalog, String name) {
        catalog.addCatalog(new Catalog(name));
    }

    @Override
    public void moveDocument(Document document, Catalog catalogFrom, Catalog catalogTo) {
        try {
            catalogTo.addDocument(document);
            catalogFrom.deleteDocument(document);
        } catch (DocumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
