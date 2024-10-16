package com.vb.sb.toymanager.bean;

/**
 * Bean to represent a toy object
 */
public class Toy implements Cloneable{
    private final String name;
    private ToyType toyType = ToyType.OTHER;
    private Double price = 0D;

    /**
     * Private constructor to ensure instance created using Creator
     */
    private Toy(String name) {
        this.name = name;
    }

    /**
     * static Builder method to create and return toy
     *
     * @param name
     * @return
     */
    public static Toy build(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("No valid parameters for Toy creation");
        }

        return new Toy(name);
    }

    /**
     * Setter with enabling chaining
     *
     * @param toyType
     * @return
     */
    public Toy setToyType(ToyType toyType) {
        if(toyType == null){
            toyType = ToyType.OTHER;
        }

        this.toyType = toyType;

        return this;
    }

    /**
     * Setter with enabling chaining
     *
     * @param toyType
     * @return
     */
    public Toy setToyType(String toyType) {
        if(toyType == null || toyType.isEmpty()){
            return setToyType(ToyType.OTHER) ;
        }

        ToyType type = ToyType.fromName(toyType);
        return setToyType(type) ;
    }

    /**
     * Setter with enabling chaining
     *
     * @param iPrice
     * @return
     */
    public Toy setPrice(Double iPrice) {
        if(iPrice == null) {
            //reset old price too if any
            iPrice = 0D;
        }

        if(iPrice < 0D){
            throw new IllegalArgumentException("No valid price value provided.");
        }

        this.price = iPrice;

        return this;
    }

    @Override
    public Toy clone() {
        return new Toy(this.name)
                .setToyType(this.toyType)
                .setPrice(this.price);
    }

    public String getName() {
        return name;
    }

    public ToyType getToyType() {
        return toyType;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Toy)){
            return false;
        }

        Toy other = (Toy) obj;
        return this.name.equals(other.name)
                && this.toyType.equals(other.toyType)
                && this.price.equals(other.price);
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", toyType=" + toyType +
                ", price=" + price +
                '}';
    }
}
