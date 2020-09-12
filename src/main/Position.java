package main;

public enum Position {
    Goalkeeper ("GK"),
    Defender ("DF"),
    Midfielder ("CM"),
    Striker ("ST");

    private final String title;

    Position(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

