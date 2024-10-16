package com.vb.sb.toymanager.test.unit;

import com.vb.sb.toymanager.bean.Toy;
import com.vb.sb.toymanager.bean.ToyType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test class for ToyBean
 */
public class TestToyBean {

    @Test
    public void testToyCreateOnlyName(){
        String toyName = "Bat";
        Toy newToy = Toy.build(toyName);
        assertNotNull(newToy);
        assertEquals(toyName, newToy.getName());
        assertEquals(ToyType.OTHER, newToy.getToyType());
    }

    @Test
    public void failToyCreateNullName(){
        assertThrows(IllegalArgumentException.class, () -> {
            Toy newToy = Toy.build(null);
        });
    }

    @Test
    public void failToyCreateNoName(){
        assertThrows(IllegalArgumentException.class, () -> {
            Toy newToy = Toy.build("");
        });
    }

    @Test
    public void testToyCreateWithNameAndType(){
        String gunName = "Nerf Gun";
        Toy newToy = Toy.build(gunName).setToyType(ToyType.WEAPON);
        assertNotNull(newToy);
        assertEquals(gunName, newToy.getName());
        assertEquals(ToyType.WEAPON, newToy.getToyType());
        assertEquals(Double.valueOf(0D), newToy.getPrice());
    }

    @Test
    public void testToyCreateWithNameAndTypeAsString(){
        String gunName = "Nerf Gun";
        Toy newToy = Toy.build(gunName).setToyType("Weapon");
        assertNotNull(newToy);
        assertEquals(gunName, newToy.getName());
        assertEquals(ToyType.WEAPON, newToy.getToyType());
        assertEquals(Double.valueOf(0D), newToy.getPrice());
    }

    @Test
    public void testToyCreateWithNameAndUnavailableTypeAsString(){
        String gunName = "Nerf Gun";
        Toy newToy = Toy.build(gunName).setToyType("Tank");
        assertNotNull(newToy);
        assertEquals(gunName, newToy.getName());
        assertEquals(ToyType.OTHER, newToy.getToyType());
        assertEquals(Double.valueOf(0D), newToy.getPrice());
    }

    @Test
    public void testToyCreateWithNameAndNullType(){
        String gunName = "Nerf Gun";
        String toyType = null;
        Toy newToy = Toy.build(gunName).setToyType(toyType);
        assertNotNull(newToy);
        assertEquals(gunName, newToy.getName());
        assertEquals(ToyType.OTHER, newToy.getToyType());
        assertEquals(Double.valueOf(0D), newToy.getPrice());
    }

    @Test
    public void testToyCreateWithNameAndInvalidType(){
        String gunName = "Nerf Gun";
        Toy newToy = Toy.build(gunName).setToyType("INVALID");
        assertNotNull(newToy);
        assertEquals(gunName, newToy.getName());
        assertEquals(ToyType.OTHER, newToy.getToyType());
        assertEquals(Double.valueOf(0D), newToy.getPrice());
    }

    @Test
    public void testToyTypeModify(){
        String gunName = "Nerf Gun";
        Toy newToy = Toy.build(gunName).setToyType(ToyType.WEAPON);
        assertEquals(gunName, newToy.getName());
        assertEquals(ToyType.WEAPON, newToy.getToyType());

        newToy.setToyType(ToyType.BLOCK);
        assertEquals(ToyType.BLOCK, newToy.getToyType());
    }

    @Test
    public void testToyTypeModifyWithInvalidType(){
        String gunName = "Nerf Gun";
        Toy newToy = Toy.build(gunName).setToyType(ToyType.WEAPON);
        assertEquals(gunName, newToy.getName());
        assertEquals(ToyType.WEAPON, newToy.getToyType());

        newToy.setToyType("INVALID");
        assertEquals(ToyType.OTHER, newToy.getToyType());
    }

    @Test
    public void testToyCreateWithNameTypeAndPrice(){
        String gunName = "Nerf Gun";
        Double toyPrice = 3D;
        Toy newToy = Toy.build(gunName).setToyType(ToyType.WEAPON).setPrice(toyPrice);
        assertNotNull(newToy);
        assertEquals(gunName, newToy.getName());
        assertEquals(ToyType.WEAPON, newToy.getToyType());
        assertEquals(toyPrice, newToy.getPrice());
    }

    @Test
    public void testToyCreateWithNameTypeAndNegativePrice(){
        String gunName = "Nerf Gun";
        Double toyPrice = -3D;
        assertThrows(IllegalArgumentException.class, () -> {
            Toy newToy = Toy.build(gunName).setToyType(ToyType.WEAPON).setPrice(toyPrice);
        });
    }

    @Test
    public void testToyCreateWithNameTypeAndNullPrice(){
        String gunName = "Nerf Gun";
        Double toyPrice = null;
        Toy newToy = Toy.build(gunName).setToyType(ToyType.WEAPON).setPrice(toyPrice);
        assertNotNull(newToy);
        assertEquals(gunName, newToy.getName());
        assertEquals(ToyType.WEAPON, newToy.getToyType());
        assertEquals(Double.valueOf(0D), newToy.getPrice());
    }

    @Test
    public void testToyPriceModify(){
        String gunName = "Nerf Gun";
        Double toyPrice = 3D;
        Toy newToy = Toy.build(gunName).setToyType(ToyType.WEAPON).setPrice(toyPrice);
        assertEquals(gunName, newToy.getName());
        assertEquals(ToyType.WEAPON, newToy.getToyType());
        assertEquals(toyPrice, newToy.getPrice());

        Double newPrice = 5D;
        newToy.setPrice(newPrice);
        assertEquals(newPrice, newToy.getPrice());
    }

    @Test
    public void testToyPriceModifyWithNegativePrice(){
        String gunName = "Nerf Gun";
        Double toyPrice = 3D;
        Toy newToy = Toy.build(gunName).setToyType(ToyType.WEAPON).setPrice(toyPrice);
        assertEquals(gunName, newToy.getName());
        assertEquals(ToyType.WEAPON, newToy.getToyType());
        assertEquals(toyPrice, newToy.getPrice());

        Double newPrice = -5D;
        assertThrows(IllegalArgumentException.class, () -> {
            newToy.setPrice(newPrice);
        });
    }

    @Test
    public void testToyCloneIsSame(){
        String gunName = "Water Gun";
        Toy originalToy = Toy.build(gunName).setToyType(ToyType.WEAPON);
        Toy clonedToy = originalToy.clone();
        assertNotNull(clonedToy);
        assertEquals(originalToy.getName(), clonedToy.getName());
        assertEquals(originalToy.getToyType(), clonedToy.getToyType());
        assertEquals(originalToy.getPrice(), clonedToy.getPrice());
    }

    @Test
    public void testToyCloneModifiedClone(){
        String gunName = "Fighter Jet";
        Toy originalToy = Toy.build(gunName).setToyType(ToyType.VEHICLE);
        Toy clonedToy = originalToy.clone();
        clonedToy.setToyType(ToyType.BLOCK);
        clonedToy.setPrice(10D);
        assertNotNull(clonedToy);
        assertEquals(originalToy.getName(), clonedToy.getName());
        assertNotEquals(originalToy.getToyType(), clonedToy.getToyType());
        assertNotEquals(originalToy.getPrice(), clonedToy.getPrice());
    }
}
