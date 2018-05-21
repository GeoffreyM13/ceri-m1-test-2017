package fr.univavignon.rodeo.api;

import java.util.List;


public class Specie implements ISpecie{

    private List<IAnimal> animals;
    private int area;
    private String name;

    public  Specie (String name, int area,List<IAnimal> animals){

        this.animals = animals;
        this.area = area;
        this.name = name;
    }

    @Override
    public int getArea() {
        return area;
    }

    @Override
    public List<IAnimal> getAnimals() {
        return animals;
    }

    @Override
    public String getName() {
        return name;
    }
}
