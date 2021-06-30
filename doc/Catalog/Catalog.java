package Catalog;

import document.Document;
import document.DocumentException;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Catalog {
    private final String name;
    private final List<Document> documents;
    private final List<Catalog> catalogs;

    public Catalog(String name) {
        this.name = name;
        this.catalogs = new ArrayList<>();
        this.documents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Document> getDocuments() {
        synchronized (documents) {
            return new ArrayList<>(documents);
        }
    }

    public List<Catalog> getCatalogs() {
        synchronized (catalogs) {
            return new ArrayList<>(catalogs);
        }
    }

    public void addDocument(Document document) throws DocumentException {
        String title = document.getTitle();
        if (documents.stream().anyMatch(document1 -> document1.getTitle().equals(title))) {
            throw new DocumentException("Документ с таким именем существует");
        }
        synchronized (documents) {
            documents.add(document);
        }
    }

    public void deleteDocument(Document document) {
        synchronized (documents) {
            documents.remove(document);
        }
    }

    public void addCatalog(Catalog catalog) {
        synchronized (catalogs) {
            catalogs.add(catalog);
        }
    }

    public List<Pair<Document, Catalog>> findDocuments(Predicate<Document> predicate) {
        ArrayList<Pair<Document, Catalog>> result = new ArrayList<>();
        synchronized (documents) {
            documents.stream().filter(predicate).forEach(document -> result.add(new Pair<>(document, this)));
        }
        synchronized (catalogs) {
            for (var catalog : catalogs) {
                result.addAll(catalog.findDocuments(predicate));
            }
        }
        return result;
    }
}