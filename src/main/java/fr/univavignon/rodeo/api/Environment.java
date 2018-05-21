package fr.univavignon.rodeo.api;

import java.util.List;

public class Environment  implements  IEnvironment{

    private List<ISpecie> species;
    private String name;
    private int nbAreas;

    public Environment (List<ISpecie> species, String name, int nbAreas){

        this.species = species;
        this.name = name;
        this.nbAreas = nbAreas;
    }

    @Override
    public int getAreas() {
        return nbAreas;
    }

    @Override
    public List<ISpecie> getSpecies() {
        return species;
    }

    @Override
    public String getName() {
        return name;
    }
}
