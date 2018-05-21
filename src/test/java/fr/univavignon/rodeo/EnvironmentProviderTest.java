package fr.univavignon.rodeo;

import fr.univavignon.rodeo.api.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EnvironmentProviderTest extends IEnvironmentProviderTest{

    private EnvironmentProvider environmentProvider;
    private List<IEnvironment> environments;

    @Before
    public void init() {
        environments = Arrays.asList(

                new Environment("Savannah", 1, Arrays.asList(
                        new Specie("Buffalo", 1, Arrays.asList(
                                new Animal(" Buffalo", false, false, false, 1),
                                new Animal("Buffi", true, true, false, 3),
                                new Animal("Bufflalo", false, false, true, 30)
                        )),
                        new Specie("Zebre", 2, Arrays.asList(
                                new Animal("Zebron", false, false, false, 1),
                                new Animal("Zerbonjames", true, true, false, 3),
                                new Animal("Testicul", false, false, true, 30)
                        )),
                        new Specie("Toro", 3, Arrays.asList(
                                new Animal("Cornu", false, false, false, 1),
                                new Animal("Cornufort", true, true, false, 3),
                                new Animal("Noidea", false, false, true, 30)
                        )),
                        new Specie("Bambi", 4, Arrays.asList(
                                new Animal(" Bambino", false, false, false, 1),
                                new Animal("Bambinbo", true, true, false, 3),
                                new Animal("Buble", false, false, true, 30)

                )),
                new Environment("Plage", 2, Arrays.asList(
                        new Specie("Toro", 1, Arrays.asList(
                                new Animal("Cornu", false, false, false, 1),
                                new Animal("Cornufort", true, true, false, 3),
                                new Animal("Noidea", false, false, true, 30))),
                        ))

                )));

        environmentProvider = new EnvironmentProvider();
    }

    @Test
    public void testGetEnvironmentNotExist() {
        assertNull(environmentProvider.getEnvironment("empty"));
    }

    @Test
    public void testGetEnvironment() {
        assertEquals(environments, environmentProvider.getEnvironment("Savannah");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetEnvironmentIsNull() {
        environmentProvider.getEnvironment(null);
    }

    @Test
    public void testGetAvailableEnvironments() {
        assertEquals(Arrays.asList("Plage"), environmentProvider.getAvailableEnvironments());
    }

}
