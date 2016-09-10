package MoodBot.view;


import MoodBot.model.Contact;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ContactView extends VBox{
    public String contactName;
    public String lastMessage;
    
    public ContactView(Contact contact){
        contactName = contact.name;
        lastMessage = "";
        
        Label nameLabel = new Label(contactName);
        nameLabel.getStyleClass().add("contact_view_contact_name");
        
        Label lastMessageLabel = new Label(lastMessage);
        lastMessageLabel.getStyleClass().add("contact_view_last_message");
        
        getChildren().add(nameLabel);
        getChildren().add(lastMessageLabel);
    }
}