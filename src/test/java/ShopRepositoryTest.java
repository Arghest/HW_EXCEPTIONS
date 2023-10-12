import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void removeAnExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(001, "Плед", 900);
        Product product2 = new Product(002, "Наволочка", 400);
        Product product3 = new Product(003, "Простыня", 600);
        Product product4 = new Product(004, "Ночник", 600);
        Product product5 = new Product(005, "Акула из Икеи", 1000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
        repository.remove(004);
        Product[] actual = repository.findAll();
        Product[] exp = {product1, product2, product3, product5};

        Assertions.assertArrayEquals(actual, exp);
    }

    @Test
    public void removeANonExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(001, "Плед", 900);
        Product product2 = new Product(002, "Наволочка", 400);
        Product product3 = new Product(003, "Простыня", 600);
        Product product4 = new Product(004, "Ночник", 600);
        Product product5 = new Product(005, "Акула из Икеи", 1000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
        //  repository.remove(044);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.remove(044)
        );
    }

}