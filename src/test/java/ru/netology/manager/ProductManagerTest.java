package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    ProductManager managers = new ProductManager(repository);
    private Product product = new Product();
    private final Smartphone Galaxy = new Smartphone(1, "SamsungGalaxyS", 15000, "Samsung");
    private final Book PetCemetery = new Book(4, "PetCemetery", 350, "StephenKing");
    private final Product Coffee = new Product(9, "С1", 50);

    @Test
    public void add() {
        managers.add(Galaxy);
        managers.add(PetCemetery);
        managers.add(Coffee);

        Product[] expected = {Galaxy, PetCemetery, Coffee};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void add2() {
        managers.add(PetCemetery);
        managers.add(Coffee);

        Product[] expected = {PetCemetery, Coffee};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchBy() {
        managers.add(Galaxy);

        Product[] actual = managers.searchBy("SamsungGalaxyS");
        Product[] expected = new Product[]{Galaxy};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByPetCemetery() {
        managers.add(PetCemetery);

        Product[] expected = new Product[]{PetCemetery};
        Product[] actual = managers.searchBy("PetCemetery");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByCoffeePetCemetery() {
        managers.add(Coffee);

        Product[] expected = new Product[]{Coffee};
        Product[] actual = managers.searchBy("С1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthorPetCemetery() {

        Product[] expected = new Product[]{};
        Product[] actual = managers.searchBy("StephenKing");
        assertArrayEquals(expected, actual);
    }

}