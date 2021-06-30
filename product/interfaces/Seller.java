package interfaces;

import javafx.util.Pair;
import product.Product;
import shelf.Shelf;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Seller {
    void createAndAddProductOnTheShelf(Shelf shelf, String name, String type, Date date);

    List<Pair<Product, Shelf>> findProductByName(String name);

    List<Product> findExpiredGoods();
}
