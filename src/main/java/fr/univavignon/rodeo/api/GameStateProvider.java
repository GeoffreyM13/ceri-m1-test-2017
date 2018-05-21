package fr.univavignon.rodeo.api;

import java.util.LinkedList;
import fr.univavignon.rodeo.api.IGameState;


public class GameStateProvider implements  IGameStateProvider{

    LinkedList<IGameState> gameStates;

    public GameStateProvider(){
        super();
        this.gameStates = new LinkedList<IGameState>();
    }

    @Override
    public void save(IGameState gameState) {
        this.gameStates.add(gameState);
    }

    @Override
    public IGameState get(String name) throws IllegalArgumentException {

        if(name==null) throw new IllegalArgumentException();

        IGameState game = null;

        for (IGameState gs : gameStates){

            if(gs.getName().equals(name)) game = gs;
        }


        return game;
    }
}
