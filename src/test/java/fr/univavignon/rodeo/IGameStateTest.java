package fr.univavignon.rodeo;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public interface IGameStateTest {

    @Mock
    IAnimal animal;

    @Mock
    ISpecie specie;

    @Mock
    IGameState gameState;

    @Before
    public void init() {

        animal = IAnimalTest.gettestvalues();
        specie = ISpecieTest.gettestvalues();
        gameState = gettestvalues();
    }

    static IGameState gettestvalues() {

        gameState = mock(IGameState.class);
        when(gameState.getSpecieLevel(specie)).thenReturn(SpecieLevel.MASTER);
        when(gameState.getProgression()).thenReturn(50);
        when(gameState.getSpecieLevel(null)).thenThrow(new IllegalArgumentException());


        doThrow(IllegalStateException.class).when(gameState).exploreArea();
        doThrow(IllegalArgumentException.class).when(gameState).catchAnimal(null);
        doThrow(IllegalStateException.class).when(gameState).catchAnimal(animal);
        doThrow(IllegalArgumentException.class).when(gameState).getSpecieLevel(null);
        return gameState;

    }

    @Test()
    public void testGetSpecieLevelMaster() {
        SpecieLevel specieLevel = gameState.getSpecieLevel(specie);
        assertEquals(SpecieLevel.MASTER, specieLevel);

    }

    @Test
    public void testGetProgression() {
        assertEquals(50, gameState.getProgression());
    }


    @Test (expected=IllegalArgumentException.class)
    public void testGetSpecieLevelIsNull() {
        gameState.getSpecieLevel(null);
    }

    @Test (expected=IllegalStateException.class)
    public void testExploreArea() {
        gameState.exploreArea();
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCatchAnimalIsNull() {
        gameState.catchAnimal(null);
    }

    @Test (expected=IllegalStateException.class)
    public void testCatchAnimal() {
        gameState.catchAnimal(animal);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetSpecieLevelNull() {
        gameState.getSpecieLevel(null);
    }





}
