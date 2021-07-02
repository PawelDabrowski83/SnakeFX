package snake.model;

import java.io.Serializable;

public class Highscore implements Serializable, Comparable<Highscore> {
    private final String name;
    private final int score;

    public Highscore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Highscore o) {
        return Integer.compare(o.score, this.score);
    }
}
