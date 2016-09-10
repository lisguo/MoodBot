package MoodBot.view;

import MoodBot.model.MessageModel;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MessageView extends Pane{
    public MessageView(MessageModel m){
        Label message = new Label (m.getMessage());
        this.getChildren().add(message);
        
        //STYLE
        boolean isUser = m.getisUser();
        if(isUser){
            this.getStyleClass().add("message_view_user");
        }
        else{
            this.getStyleClass().add("message_view_bot");
        }
    }
}