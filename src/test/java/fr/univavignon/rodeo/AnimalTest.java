package fr.univavignon.rodeo;

import fr.univavignon.rodeo.api.Animal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest extends IAnimalTest {

    private static Animal animal;

     @Before
    public void init(){
        animal = new Animal("test", true, true, true, 100);
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
