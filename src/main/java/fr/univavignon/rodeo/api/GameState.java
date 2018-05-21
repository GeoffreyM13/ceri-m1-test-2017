package fr.univavignon.rodeo.api;

public class GameState implements IGameState{

    private SpecieLevel level;
    private int progress;
    private String name;

    public GameState(SpecieLevel level, int progress, String name){

        this.level = level;
        this.progress = progress;
        this.name = name;

    }
    @Override
    public void exploreArea() throws IllegalStateException {

    }

    @Override
    public void catchAnimal(IAnimal animal) throws IllegalArgumentException, IllegalStateException {

        if (animal == null) throw new IllegalArgumentException();

    }

    @Override
    public SpecieLevel getSpecieLevel(ISpecie specie) throws IllegalArgumentException {

        if (specie ==null) throw new IllegalArgumentException();

        return level;
    }

    @Override
    public int getProgression() {
        return progress;
    }

    @Override
    public String getName() {
        return name;
    }
}
