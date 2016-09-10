package MoodBot.view;

import MoodBot.StartupConstants;
import MoodBot.model.Contact;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatWindowView{
    
    
    public void startUI(Stage primaryStage){
        BorderPane chatPane = new BorderPane();
        chatPane.getStyleClass().add("chat_pane");
        
        FlowPane menuBar = new FlowPane();
        menuBar.getStyleClass().add("menu_bar");
        
        VBox contacts = new VBox();
        contacts.getStyleClass().add("contacts");
        
        ScrollPane scrollContacts = new ScrollPane(contacts);
        scrollContacts.getStyleClass().add("scroll_contacts");
        
        VBox chatWindow = new VBox();
        chatWindow.getStyleClass().add("chat_window");
        
        
        Scene chatScene = new Scene(chatPane);
        chatScene.getStylesheets().add(StartupConstants.STYLE_SHEET_UI);//SET STYLESHEET
        
        //Create menu bar
        Button logOff = new Button("Log Off");
        menuBar.getChildren().add(logOff);
        chatPane.setTop(menuBar);
        
        //Create Contacts
        Contact Zaki = new Contact("Zaki");
        ContactView ZakiView = new ContactView(Zaki);
        contacts.getChildren().add(ZakiView);
        scrollContacts.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollContacts.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        chatPane.setLeft(scrollContacts);
        
        //Create ChatWindow
        
        //Create Messages
        VBox messages = new VBox();
        messages.getStyleClass().add("messages");
        ScrollPane scrollMessages = new ScrollPane(messages);
        scrollMessages.getStyleClass().add("scroll_messages");
        
        //Create Input window
        HBox inputBox = new HBox();
        inputBox.getStyleClass().add("input_box");
        
        TextArea textArea = new TextArea();
        Button sendButton = new Button("Send");
        sendButton.getStyleClass().add("send_button");
        
        //Add to input box
        inputBox.getChildren().add(textArea);
        inputBox.getChildren().add(sendButton);
        
        //Add to chat window
        chatWindow.getChildren().add(messages);
        chatWindow.getChildren().add(inputBox);
        
        //Add chat window to chat pane
        chatPane.setCenter(chatWindow);
        
        
        
        
        //Set scene
        primaryStage.setScene(chatScene);
        
    }
}