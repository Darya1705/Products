package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    private Smartphone coreJava1 = new Smartphone();
    private Product product = new Product();
    private Smartphone Galaxy = new Smartphone(1, "SamsungGalaxyS", 15000, "Samsung");
    private Book PetCemetery = new Book(4, "PetCemetery", 350,"StephenKing");
    private Product Coffee = new Product(9, "С1", 50);

    @Test
    public void shouldSaveOneProduct() {
        repository.save(coreJava);

        Product[] expected = new  Product[]{coreJava};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
    
    @Test
    void findAll() {
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        Product[] expected = { Galaxy, PetCemetery, Coffee };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        //int idToRemove = 9;
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        repository.removeById(9);

        Product[] actual = repository.findAll();
        Product[] expected = {Galaxy, PetCemetery};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById2() {
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        repository.removeById(1);
        repository.removeById(4);
        repository.removeById(9);

        Product[] actual = repository.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
    @Test
    void add() {
        repository.save(Galaxy);
        repository.save(PetCemetery);
        repository.save(Coffee);

        Product[] actual = repository.findAll();
        Product[] expected = { Galaxy, PetCemetery, Coffee };

        assertArrayEquals(expected, actual);
    }

    @Test
    void add2() {
        repository.save(Galaxy);

        Product[] actual = repository.findAll();
        Product[] expected = { Galaxy };

        assertArrayEquals(expected, actual);
    }
}

