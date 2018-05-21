package fr.univavignon.rodeo;

import fr.univavignon.rodeo.api.IEnvironmentProvider;
import fr.univavignon.rodeo.api.IEnvironment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class IEnvironmentProviderTest {

    @Mock
    private IEnvironmentProvider environmentProvider;

    @Mock
    static
    IEnvironment environment = null;

    static List<String> environments = Arrays.asList("Moutains","Outback");

    static IEnvironmentProvider gettestvalues() {

        IEnvironmentProvider environmentProvider = mock(IEnvironmentProvider.class);
        environment = IEnvironmentTest.gettestvalues();

        when(environmentProvider.getEnvironment(null)).thenReturn((IEnvironment) new IllegalArgumentException());
        when(environmentProvider.getEnvironment("empty")).thenReturn(null);
        when(environmentProvider.getEnvironment("Moutains")).thenReturn(environment);
        when(environmentProvider.getAvailableEnvironments()).thenReturn(environments);

        return environmentProvider;
    }

    @Before
    public void init() {
        IEnvironmentProvider environmentProvider = gettestvalues();
    }

    @Test
    public void testGetEnvironmentNotExist() {
        assertNull(environmentProvider.getEnvironment("empty"));
    }

    @Test
    public void testGetEnvironment() {
        assertEquals(environment, environmentProvider.getEnvironment("Moutains"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetEnvironmentIsNull() {
        environmentProvider.getEnvironment(null);
    }

    @Test
    public void testGetAvailableEnvironments() {
        assertEquals(environments, environmentProvider.getAvailableEnvironments());
    }


}
