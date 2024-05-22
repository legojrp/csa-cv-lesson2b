package com.codedotorg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) {
        RockPaperScissors game = new RockPaperScissors(primaryStage, 800, 600);
        Scene namePromptScene = game.createNamePromptScene();
        game.setSceneAndShow(namePromptScene);
    }

}
