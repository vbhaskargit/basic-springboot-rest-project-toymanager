package com.vb.sb.toymanager.bean;

/**
 *  Enum for different toy types
 */
public enum ToyType {
    SOFT("Soft"),
    VEHICLE("Vehicle"),
    HUMAN_FIGURE("Human Figure"),
    NON_HUMAN_FIGURE("Non Human Figure"),
    ANIMAL_FIGURE("Animal Figure"),
    ARMS("Arms"),
    VIDEO_GAME("Video Game"),
    INDOOR("Indoor"),
    OUTDOOR_GAME_ARTICLE("Outdoor Game Item"),
    BLOCK("Block"),
    OTHER("Other");

    private final String name;

    /**
     *
     * @param iName
     */
    private ToyType(String iName){
        this.name = iName;
    }

    @Override
    public String toString() {
        return name;
    }
}
