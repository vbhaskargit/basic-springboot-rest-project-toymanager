package com.vb.sb.toymanager.test.unit;

import com.vb.sb.toymanager.bean.Toy;
import com.vb.sb.toymanager.bean.ToyType;
import com.vb.sb.toymanager.store.ToyStorage;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for ToyStorage class
 */
public class TestToyStorage {

    private ToyStorage toyStorage = null;

    /**
     * Initialize the storage before each test
     */
    @BeforeEach
    public void initStorage() {
        toyStorage = new ToyStorage();
        toyStorage.reset();
    }

    /**
     * Test case to check if the toy storage is initialized with default toys
     */
    @Test
    public void testInitializeStorage() {
        List<Toy> fullList = toyStorage.getAllToys();
        assertNotNull(fullList);
        assertFalse(fullList.isEmpty());
        assertEquals(2, fullList.size());
    }

    /**
     * Test case to check if a toy is added to the storage
     */
    @Test
    public void testAddToy() {
        int storageSizeBefore = toyStorage.getAllToys().size();
        String toyName = "Test Toy";
        Double toyPrice = 7D;
        toyStorage.addToy(Toy.build(toyName)
                .setToyType(ToyType.HUMAN_FIGURE)
                .setPrice(toyPrice));
        assertEquals(storageSizeBefore + 1, toyStorage.getAllToys().size());
        Toy fromStorage = toyStorage.getAllToys().get(storageSizeBefore);
        assertNotNull(fromStorage);
        assertEquals(toyName, fromStorage.getName());
        assertEquals(ToyType.HUMAN_FIGURE, fromStorage.getToyType());
        assertEquals(toyPrice, fromStorage.getPrice());
    }

    /**
     * Test to add toy using toy details
     */
    @Test
    public void testAddToyUsingDetails() {
        int storageSizeBefore = toyStorage.getAllToys().size();
        String toyName = "Rocket";
        Double toyPrice = 23D;
        toyStorage.addToy(toyName, ToyType.OUTDOOR_GAME_ARTICLE, toyPrice);
        assertEquals(storageSizeBefore + 1, toyStorage.getAllToys().size());
        Toy fromStorage = toyStorage.getAllToys().get(storageSizeBefore);
        assertNotNull(fromStorage);
        assertEquals(toyName, fromStorage.getName());
        assertEquals(ToyType.OUTDOOR_GAME_ARTICLE, fromStorage.getToyType());
        assertEquals(toyPrice, fromStorage.getPrice());
    }

    /**
     * Test to add a new toy with details and toy type as string
     */
    @Test
    public void testAddToyUsingDetailsAndStringType() {
        int storageSizeBefore = toyStorage.getAllToys().size();
        String toyName = "Tiger";
        toyStorage.addToy(toyName, ToyType.ANIMAL_FIGURE.toString(), null);
        assertEquals(storageSizeBefore + 1, toyStorage.getAllToys().size());
        Toy fromStorage = toyStorage.getAllToys().get(storageSizeBefore);
        assertNotNull(fromStorage);
        assertEquals(toyName, fromStorage.getName());
        assertEquals(ToyType.ANIMAL_FIGURE, fromStorage.getToyType());
        assertEquals(Double.valueOf(0D), fromStorage.getPrice());
    }

    /**
     * Test to get all toy names
     */
    @Test
    public void testGetAllToyNames() {
        List<String> toyNamesFromList = toyStorage.getAllToys()
                                                    .stream()
                                                    .map(Toy::getName)
                                                    .toList();
        List<String> toyNames = toyStorage.getAllToyNames();
        assertEquals(toyNamesFromList, toyNames);
    }

    @Test
    public void testGetAllToyModifyClonedObjects(){
        Toy firstToy = toyStorage.getAllToys().get(0);

        //Modify the object we got, should be a copy of original
        firstToy.setToyType(ToyType.ANIMAL_FIGURE);
        firstToy.setPrice(firstToy.getPrice() + 100D);

        Toy firstToyRefetch = toyStorage.getAllToys().get(0);
        assertNotEquals(firstToy, firstToyRefetch);
        assertEquals(firstToy.getName(), firstToyRefetch.getName());
        assertNotEquals(firstToy.getToyType(), firstToyRefetch.getToyType());
        assertNotEquals(firstToy.getPrice(), firstToyRefetch.getPrice());
    }

    /**
     * Test to reset the storage
     */
    @Test
    public void testResetStorage() {
        String toyName = "Tiger";
        toyStorage.addToy(toyName, "Animal Figure", null);
        toyStorage.reset();
        List<Toy> fullList = toyStorage.getAllToys();
        assertNotNull(fullList);
        assertFalse(fullList.isEmpty());
        assertEquals(2, fullList.size());
    }
}
