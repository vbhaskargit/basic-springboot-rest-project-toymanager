package com.vb.sb.toymanager.store;

import com.vb.sb.toymanager.bean.Toy;
import com.vb.sb.toymanager.bean.ToyType;
import jakarta.annotation.PostConstruct;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Aspect
public class ToyStorage {
    private final List<Toy> toys = new ArrayList<>();

    /**
     * Add default toys
     */
    @PostConstruct
    private void intializeStorage(){
        addToy("Light Saber", ToyType.ARMS,10D);
        addToy("Fighter Plane", ToyType.BLOCK,20D);
    }

    /**
     *
     * @param newToy
     */
    public void addToy(Toy newToy){
        if(newToy != null){
            toys.add(newToy);
        }
    }

    /**
     *
     * @param name
     * @param type
     * @param price
     */
    public void addToy(String name, String type, Double price){
        toys.add(Toy.build(name,type,price));
    }

    /**
     *
     * @param name
     * @param type
     * @param price
     */
    public void addToy(String name, ToyType type, Double price){
        toys.add(Toy.build(name,type,price));
    }

    /**
     * Get all toy objects
     * @return
     */
    public List<Toy> getAllToys(){
        List<Toy> returnList = new ArrayList<>();
        Collections.copy(returnList,toys);
        return returnList;
    }

    /**
     * Get all toy names
     *
     * @return
     */
    public List<String> getAllToyNames(){
        return toys.stream().map(Toy::getName).toList();
    }

    /**
     * removes all toys except default ones
     *
     */
    public void reset(){
        toys.clear();
        intializeStorage();
    }
}
