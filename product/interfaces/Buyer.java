package interfaces;

import product.Product;
import shelf.Shelf;

import java.util.Optional;

public interface Buyer {
    Optional<Product> findProductOnShelf(Shelf shelf, String type);

    void takeProductsFromOtherShelves();
}
