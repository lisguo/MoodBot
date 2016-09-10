package MoodBot.view;

import MoodBot.StartupConstants;
import MoodBot.controller.ChatController;
import MoodBot.model.Ada;
import MoodBot.model.Contact;
import MoodBot.model.MessageModel;
import MoodBot.model.MoodBotModel;
import MoodBot.model.Zaki;
import javafx.geometry.Pos;
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
    
    public BorderPane chatPane;
    public FlowPane menuBar;
    public VBox contacts;
    public ScrollPane scrollContacts;
    public Button sendButton;
    public VBox chatWindow;
    public Button logOff;
    public VBox messages;
    public TextArea textArea;
    
    MoodBotModel model;
    public Stage chatStage;
    
    ChatController chatController = new ChatController(this);
    private ScrollPane scrollMessages;
    
    public void startUI(Stage primaryStage, MoodBotModel model){
        chatStage = primaryStage;
        
        this.model = model;
        
        chatPane = new BorderPane();
        chatPane.getStyleClass().add("chat_pane");
        
        menuBar = new FlowPane();
        menuBar.getStyleClass().add("menu_bar");
        
        contacts = new VBox();
        contacts.getStyleClass().add("contacts");
        
        scrollContacts = new ScrollPane(contacts);
        scrollContacts.getStyleClass().add("scroll_contacts");
        
        chatWindow = new VBox();
        chatWindow.getStyleClass().add("chat_window");
        
        
        Scene chatScene = new Scene(chatPane);
        chatScene.getStylesheets().add(StartupConstants.STYLE_SHEET_UI);//SET STYLESHEET
        
        //Create menu bar
        logOff = new Button("Log Off");
        menuBar.getChildren().add(logOff);
        chatPane.setTop(menuBar);
        
        populateContacts();
        
        scrollContacts.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollContacts.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        chatPane.setLeft(scrollContacts);
        
        //Create ChatWindow
        
        //Create Messages
        messages = new VBox();
        messages.getStyleClass().add("messages");
        scrollMessages = new ScrollPane(messages);
        scrollMessages.getStyleClass().add("scroll_messages");
        
        scrollMessages.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollMessages.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        messages.setAlignment(Pos.TOP_CENTER);
        
        //Create Input window
        HBox inputBox = new HBox();
        inputBox.getStyleClass().add("input_box");
        
        textArea = new TextArea();
        sendButton = new Button("Send");
        sendButton.getStyleClass().add("send_button");
        
        //Add to input box
        inputBox.getChildren().add(textArea);
        inputBox.getChildren().add(sendButton);
        
        //Add to chat window
        chatWindow.getChildren().add(scrollMessages);
        chatWindow.getChildren().add(inputBox);
        
        //Add chat window to chat pane
        chatPane.setCenter(chatWindow);
        
        //Set scene
        primaryStage.setScene(chatScene);
        
        //Initiate conversation
        initConversation(model.getCurrContact());
        
        refreshMessages();
        
        
    }
    
    public MoodBotModel getMoodBotModel(){
        return model;
    }
         
    public void refreshMessages(){
        //Remove all messageview
        messages.getChildren().clear();
        for (MessageModel m : model.getCurrContact().messages){
            MessageView view = new MessageView(m);
            messages.getChildren().add(view);
        }
        scrollMessages.setVvalue(scrollMessages.getVmax());
    }
    
    
    public void initEventHandlers(){
        sendButton.setOnAction(e ->{
            chatController.handleSendMessage();
        });
        
        logOff.setOnAction(e ->{
            chatController.handleLogOff();
        });
    }
    
    public void initConversation(Contact currContact){
        currContact.chatController = chatController;
        currContact.sayGreeting();
    }
    
    public void populateContacts(){
        //Create Contacts
        Contact Zaki = new Zaki();
        ContactView ZakiView = new ContactView(Zaki, model, this);
        contacts.getChildren().add(ZakiView);
        model.setCurrContact(Zaki);
        Zaki.isCurrentContact = true;
        
        Contact Ada = new Ada();
        ContactView AdaView = new ContactView(Ada, model,this);
        contacts.getChildren().add(AdaView);
        
        refreshContacts();
        
    }
    
    public void refreshContacts(){
        for(int i = 0; i < contacts.getChildren().size(); i++){
            ContactView contact = (ContactView) contacts.getChildren().get(i);
            contact.getStyleClass().clear();
            if(contact.contactName.equals(model.getCurrContact().name)){
                contact.getStyleClass().add("selected_contact");
            }
            else{
                contact.getStyleClass().add("contact_view");
            }
        }
    }
}