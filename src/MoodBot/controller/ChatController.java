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
        sendMessage(chat.textArea.getText(), true);
        
        //Empty TextArea
        chat.textArea.setText("");
        chat.refreshMessages();
    }
    
    public void sendMessage(String message, boolean isUser){
        Contact currContact = chat.getMoodBotModel().getCurrContact();
        MessageModel m = new MessageModel(message, isUser);
        currContact.messages.add(m);
    }
    
}