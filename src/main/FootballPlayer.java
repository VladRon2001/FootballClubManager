package main;

public class FootballPlayer {
    private final String name;
    private final int age;
    private int ratingScore;
    private final Position position;

    public FootballPlayer(String name, int age, int ratingScore, Position position) {
        this.age = age;
        this.name = name;
        this.ratingScore = ratingScore;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public int calculateCost() {
        return 5000*(45-age)*ratingScore;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " "
                + ratingScore + " "
                + position.getTitle() + " "
                + age;
    }
}
