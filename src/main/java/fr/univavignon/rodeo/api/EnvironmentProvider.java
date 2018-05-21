package fr.univavignon.rodeo.api;

import java.util.*;

public class EnvironmentProvider implements IEnvironmentProvider{

    private static List<IEnvironment> Env = Arrays.asList(

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



    private Map<String, Boolean> availableEnv;

    public EnvironmentProvider(){
        availableEnv = new HashMap <String,Boolean>();

        for (IEnvironment environment : Env){
            availableEnv.put(environment.getName(),true);
        }
    }

    @Override
    public List<String> getAvailableEnvironments() {

        Vector<String> result = new Vector<>();
        availableEnv.forEach((key, value) -> {
            if (value)
                result.add(key);
        });

        return result;
    }

    @Override
    public IEnvironment getEnvironment(String name) throws IllegalArgumentException {

        if (name == null) throw new IllegalArgumentException();

        for (IEnvironment env : Env) {
            if (env.getName().equals(name))
                return env;
        }
        return null;
    }
}
