package interfaces;

import product.Product;
import shelf.Shelf;

import java.util.List;

public interface Manager {
    void addShelf(String name, List<String> types);

    void deleteShelf(Shelf shelf);

    List<Product> findExpiredGoods();

    List<Product> findProductsByType(String type);
}
