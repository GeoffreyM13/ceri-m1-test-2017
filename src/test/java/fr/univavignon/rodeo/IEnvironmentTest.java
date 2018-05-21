package fr.univavignon.rodeo;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public interface IEnvironmentTest {

    @Mock
    IEnvironment environment;

    List<ISpecie> Species= IntStream
            .range(0,4)
            .mapToObj(i -> ISpecieTest.gettestvalues())
            .collect(Collectors.toList());


    static IEnvironment gettestvalues()
    {
        IEnvironment environment = mock(IEnvironment.class);

        when(environment.getAreas()).thenReturn(0);
        when(environment.getSpecies()).thenReturn(Species);
        return environment;
    }

    @Before
    static void init() {
        IEnvironment environment = gettestvalues();
    }
    @Test
    public void testGetAreas()
    {
        assertEquals(environment.getAreas(),50);
    }


    @Test
    public void testGetSpecies()
    {
        assertEquals(environment.getSpecies(),Species);
    }
