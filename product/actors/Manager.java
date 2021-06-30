package actors;

import product.Product;
import shelf.Shelf;
import shelf.Shop;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Manager implements interfaces.Manager {
    private final Shop shop;

    public Manager(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void addShelf(String name, List<String> types) {
        shop.addShelf(new Shelf(name, types));
    }

    @Override
    public void deleteShelf(Shelf shelf) {
        shop.removeShelf(shelf);
    }

    @Override
    public List<Product> findExpiredGoods() {
        Date currentDate = new Date();
        return shop.getShelves().stream().flatMap(shelf -> shelf.getProducts().stream())
                .filter(product -> product.getExpirationDate().before(currentDate)).collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsByType(final String type) {
        return shop.getShelves().stream().flatMap(shelf -> shelf.getProducts().stream())
                .filter(product -> product.getType().equals(type)).collect(Collectors.toList());
    }
}
