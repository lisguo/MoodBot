package MoodBot.view;

import MoodBot.model.MessageModel;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MessageView extends Pane{
    public MessageView(MessageModel m){
        //STYLE
        boolean isUser = m.getisUser();
        if(isUser){
            this.getStyleClass().add("message_view_user");
        }
        else{
            this.getStyleClass().add("message_view_bot");
        }
        
        
        //Make message boxes bigger if message exceeds 80
        String text = m.getMessage();
        String newMessage = "";
        int increaseHeight = 1;
        int indexOfSpace;
        while(text.length() > 65){
            newMessage = newMessage + text.substring(0, 60);
            text = text.substring(60);
            
            indexOfSpace = text.indexOf(" ");
            newMessage = newMessage + text.substring(0, indexOfSpace) + "\n";
            text = text.substring(indexOfSpace);
            
            increaseHeight++;
        }
        //Get rest of string
        newMessage = newMessage + text;
            
        this.setHeight(USE_PREF_SIZE * increaseHeight);
        Label message = new Label (newMessage);
        this.getChildren().add(message);
        
    }
}