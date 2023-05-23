package com.projectx.client;

import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

public class ProjectX extends Application {
    @Override
    public void start(Stage stage) throws IOException, UnirestException {
        LocalDate.now( ZoneId.of( "America/Montreal" ));
        FXMLLoader fxmlLoader = new FXMLLoader(ProjectX.class.getResource("main.fxml"));

        Parent root = fxmlLoader.load();
        stage.setTitle("Contracts");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}