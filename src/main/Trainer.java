package main;

public class Trainer {
    private String name;
    private int skillLevel;

    public Trainer(String name, int skillLevel) {
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return name + " " + skillLevel;
    }
}
