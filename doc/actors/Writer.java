package actors;

import Catalog.Catalog;
import document.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Writer implements interfaces.Writer {
    private final Catalog rootCatalog;

    public Writer(Catalog catalog) {
        this.rootCatalog = catalog;
    }

    @Override
    public Document createDocument(String title, String text) {
        return new Document(title, new Date(), System.getProperty("user.name"), text);
    }

    @Override
    public void updateTitle(Document document, String title) {
        document.setTitle(title);
    }

    @Override
    public void updateText(Document document, String text) {
        document.setText(text);
    }

    @Override
    public List<Document> findDocumentsByTitle(String title) {
        ArrayList<Document> result = new ArrayList<>();
        rootCatalog.findDocuments(document -> document.getTitle().equals(title)).forEach(pair -> result.add(pair.getKey()));
        return result;
    }
}
