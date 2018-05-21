package fr.univavignon.rodeo;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public interface ISpecieTest {

    @Mock
    ISpecie specie;

    public static List<IAnimal> listAnimal= IntStream
            .range(0,2)
            .mapToObj(i -> IAnimalTest.gettestvalues())
            .collect(Collectors.toList());

    public static ISpecie gettestvalues() {

        ISpecie specie = mock(ISpecie.class);
        when(specie.getArea()).thenReturn(50);
        when(specie.getAnimals()).thenReturn(listAnimal);
        return specie;

    }

    @Before
    public void init() {
        specie = gettestvalues();
    }

    @Test
    public void testGetArea(){
        assertEquals(50, specie.getArea());

    }

    @Test
    public void testGetAnimals(){
        assertEquals(listAnimal,specie.getAnimals());
    }
}
