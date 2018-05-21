package fr.univavignon.rodeo;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public interface IGameStateProviderTest {


    @Mock
     IGameStateProvider gameStateProvider;

    @Mock
    IGameState gameState;

    @Before
    public void init() {
        gameStateProvider = gettestvalues();
    }

    static IGameStateProviderTest gettestvalues()
    {
        IGameStateProvider gameStateProvider = mock(IGameStateProvider.class);
        when(gameStateProvider.get("try")).thenReturn(gameState);

        return (IGameStateProviderTest) gameStateProvider;
    }

    @Test
    public void testget() {
        assertEquals(gameState,gameStateProvider.get("try"));
    }
}
