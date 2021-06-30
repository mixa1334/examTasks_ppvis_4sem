package actors;

import Catalog.Catalog;
import document.Document;
import document.DocumentException;

import java.util.ArrayList;
import java.util.List;

public class Secretary implements interfaces.Secretary {
    private final Catalog rootCatalog;

    public Secretary(Catalog rootCatalog) {
        this.rootCatalog = rootCatalog;
    }

    @Override
    public void addDocumentToCatalog(Catalog catalog, Document document) {
        try {
            catalog.addDocument(document);
        } catch (DocumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Document> findDocumentsByAuthor(String author) {
        ArrayList<Document> result = new ArrayList<>();
        rootCatalog.findDocuments(document -> document.getAuthor().equals(author)).forEach(pair -> result.add(pair.getKey()));
        return result;
    }

    @Override
    public List<Document> findDocumentsByTitle(String title) {
        ArrayList<Document> result = new ArrayList<>();
        rootCatalog.findDocuments(document -> document.getTitle().equals(title)).forEach(pair -> result.add(pair.getKey()));
        return result;
    }

    @Override
    public void removeDocument(Catalog catalog, Document document) {
        catalog.deleteDocument(document);
    }
}