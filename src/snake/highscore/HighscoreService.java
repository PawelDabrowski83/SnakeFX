package snake.highscore;

import snake.model.Highscore;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HighscoreService {
    public static final String HIGHSCORE_FILE_PATH = "files/highscore.obj";
    List<Highscore> highscoreList;

    public List<Highscore> getHighscoreList() {
        getListFromFile();
        return highscoreList;
    }

    public void getListFromFile() {
        highscoreList = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE_PATH));
            highscoreList = (List<Highscore>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveHighscore(Highscore highscore) {
        highscoreList.add(highscore);
        saveHighscoreFile();
    }

    private void saveHighscoreFile() {
        try {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE_PATH));
            ous.writeObject(highscoreList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Highscore> getSortedList() {
        return (LinkedList<Highscore>) getHighscoreList().stream().sorted().collect(Collectors.toList());
    }
}
