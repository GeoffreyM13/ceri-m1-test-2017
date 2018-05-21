package fr.univavignon.rodeo.api;

public class Animal implements IAnimal {

    private final String name;
    private int xp;
    private boolean secret, endangered, boss;

    public Animal (String name, boolean secret, boolean endangered, boolean boss, int xp){

        this.name = name;
        this.xp = xp;
        this.secret = secret;
        this.endangered = endangered;
        this.boss = boss;
    }

    @Override
    public int getXP() {
        return xp;
    }

    @Override
    public boolean isSecret() {
        return secret;
    }

    @Override
    public boolean isEndangered() {
        return endangered;
    }

    @Override
    public boolean isBoss() {
        return boss;
    }

    @Override
    public String getName() {
        return name;
    }
}
