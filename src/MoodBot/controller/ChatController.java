package MoodBot.controller;

import MoodBot.model.Contact;
import MoodBot.model.MessageModel;
import MoodBot.view.ChatWindowView;

public class ChatController{
    ChatWindowView chat;
    
    public ChatController(ChatWindowView view){
        chat = view;
    }
    public void handleSendMessage(){
        MessageModel m = new MessageModel(chat.textArea.getText(), true);
        Contact currContact = chat.getMoodBotModel().getCurrContact();
        currContact.messages.add(m);
        
        //Empty TextArea
        chat.textArea.setText("");
        chat.refreshMessages();
    }
    
}