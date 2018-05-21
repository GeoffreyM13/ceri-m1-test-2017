package fr.univavignon.rodeo;



import fr.univavignon.rodeo.api.IAnimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



public class IAnimalTest {

    @Mock
    private static IAnimal animal = null;

    @Before
    public static IAnimal gettestvalues(){

        IAnimal animal = mock(IAnimal.class);
        when(animal.getXP()).thenReturn(100);
        when(animal.isBoss()).thenReturn(true);
        when(animal.isEndangered()).thenReturn(true);
        when(animal.isSecret()).thenReturn(true);
        return animal;
    }
    @Before
    public void init(){
        animal = gettestvalues();
    }

    @Test
    static void testgetXP(){
        assertEquals (100, animal.getXP());

    }

    @Test
    static void testIsBoss(){
        assertTrue( animal.isBoss());
    }


    @Test
    static void testIsSecret(){
        assertTrue( animal.isSecret());
    }

    @Test
    static void testIsEndangered(){
        assertTrue( animal.isEndangered());
    }




}
