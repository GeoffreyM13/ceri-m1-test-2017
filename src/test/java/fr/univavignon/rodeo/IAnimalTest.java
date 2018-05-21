package fr.univavignon.rodeo;



import fr.univavignon.rodeo.api.IAnimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



public interface IAnimalTest {

    @Mock
     IAnimal animal = null;

    @Before
    static IAnimal gettestvalues(){

        IAnimal animal = mock(IAnimal.class);
        when(animal.getXP()).thenReturn(100);
        when(animal.isBoss()).thenReturn(true);
        when(animal.isEndangered()).thenReturn(true);
        when(animal.isSecret()).thenReturn(true);
        return animal;
    }
    @Before
    default void init(){
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
