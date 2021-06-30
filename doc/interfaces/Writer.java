package interfaces;

import document.Document;

import java.util.List;

public interface Writer {
    Document createDocument(String title, String text);

    void updateTitle(Document document, String title);

    void updateText(Document document, String text);

    List<Document> findDocumentsByTitle(String title);
}
