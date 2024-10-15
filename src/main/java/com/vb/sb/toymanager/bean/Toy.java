package com.vb.sb.toymanager.bean;

/**
 * Bean to represent a toy object
 */
public class Toy implements Cloneable{
    private String name;
    private ToyType toyType;
    private Double price;

    /**
     * Private constructor to ensure instance created using Creator
     *
     * @param name
     * @param toyType
     * @param price
     */
    private Toy(String name, ToyType toyType, Double price) {
        this.name = name;
        this.toyType = toyType;
        this.price = price;
    }

    /**
     * static Builder method to create and return toy
     *
     * @param name
     * @param toyType
     * @param price
     * @return
     */
    public static Toy build(String name, ToyType toyType, Double price){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("No valid parameters for Toy creation");
        }

        return new Toy(name,toyType,price);
    }

    /**
     * Overloaded static builder method
     *
     * @param name
     * @param toyType
     * @param price
     * @return
     */
    public static Toy build(String name, String toyType, Double price){
        ToyType type = null;
        try{
            type = ToyType.valueOf(toyType);
        } catch(IllegalArgumentException ex){
            type = ToyType.OTHER;
        }

        return build(name,type,price);
    }

    /**
     * Overloaded static builder method
     *
     * @param name
     * @param toyType
     * @return
     */
    public static Toy build(String name, ToyType toyType){
        return build(name,toyType,0D);
    }

    /**
     * Overloaded static builder method
     *
     * @param name
     * @param toyType
     * @return
     */
    public static Toy build(String name, String toyType){
        return build(name, toyType,0D);
    }

    /**
     * Overloaded static builder method
     *
     * @param name
     * @return
     */
    public static Toy build(String name){
        return build(name, ToyType.OTHER,0D);
    }

    @Override
    public Toy clone() {
        return new Toy(this.name, this.toyType, this.price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToyType getToyType() {
        return toyType;
    }

    public void setToyType(ToyType toyType) {
        this.toyType = toyType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", toyType=" + toyType +
                '}';
    }
}
