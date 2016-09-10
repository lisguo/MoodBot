/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoodBot.controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import MoodBot.StartupConstants;
import MoodBot.model.Contact;
import MoodBot.view.ChatWindowView;
import MoodBot.view.ContactView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author BunnyRailgun
 */
public class MainMenuController {
    //GamePlayController gamePlayController = new GamePlayController();
    
    public void handleStartChat(Stage primaryStage){
       ChatWindowView chat = new ChatWindowView();
       chat.startUI(primaryStage);
    }
}
