package MoodBot.view;


import MoodBot.model.Contact;
import MoodBot.model.MoodBotModel;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ContactView extends VBox{
    public String contactName;
    public String lastMessage;
    public Contact contact;
    public MoodBotModel botModel;
    public ChatWindowView chatWindow;
    
    public ContactView(Contact c, MoodBotModel m, ChatWindowView chat){
        chatWindow = chat;
        botModel = m;
        contact = c;
        contactName = c.name;
        lastMessage = "";
        
        Label nameLabel = new Label(contactName);
        nameLabel.getStyleClass().add("contact_view_contact_name");
        
        Label lastMessageLabel = new Label(lastMessage);
        lastMessageLabel.getStyleClass().add("contact_view_last_message");
        
        getChildren().add(nameLabel);
        getChildren().add(lastMessageLabel);
        
        this.setOnMouseClicked(e ->{
            contact.isCurrentContact = true;
            botModel.setCurrContact(contact);
            chatWindow.refreshContacts();
            
            if(contact.messages.isEmpty()){
                chatWindow.initConversation(contact);
            }
            
            chatWindow.refreshMessages();
        });
    }
}