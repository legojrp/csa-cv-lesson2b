package com.codedotorg;
import java.io.*;

public class Player implements Serializable {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void incrementScore() {
        this.score++;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream(this.name + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Player load(String name) {
        Player player = null;
        try {
            FileInputStream fileIn = new FileInputStream(name + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            player = (Player) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Player class not found");
            c.printStackTrace();
            return null;
        }
        return player;
    }
}