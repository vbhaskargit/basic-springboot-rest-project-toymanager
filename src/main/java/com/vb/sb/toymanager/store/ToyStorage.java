package com.vb.sb.toymanager.store;

import com.vb.sb.toymanager.bean.Toy;
import com.vb.sb.toymanager.bean.ToyType;
import jakarta.annotation.PostConstruct;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Aspect
public class ToyStorage {
    private final List<Toy> toys = new ArrayList<>();

    /**
     * Add default toys
     */
    @PostConstruct
    private void intializeStorage(){
        addToy("Light Saber", ToyType.WEAPON,10D);
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
        toys.add(Toy.build(name).setToyType(type).setPrice(price));
    }

    /**
     *
     * @param name
     * @param type
     * @param price
     */
    public void addToy(String name, ToyType type, Double price){
        toys.add(Toy.build(name).setToyType(type).setPrice(price));
    }

    /**
     * Get all toy objects
     * @return
     */
    public List<Toy> getAllToys(){
        List<Toy> returnList = new ArrayList<>(toys.size());
        //Ensure the destination list is the same size
        //returnList.addAll(Collections.nCopies(toys.size(), null));
        //copy() only creates shallow copy
        //Collections.copy(returnList,toys);
        for (Toy toy : toys) {
            returnList.add(toy.clone());
        }

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
