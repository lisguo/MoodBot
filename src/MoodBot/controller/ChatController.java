package MoodBot.controller;

import MoodBot.model.Contact;
import MoodBot.model.MessageModel;
import MoodBot.view.ChatWindowView;
import MoodBot.view.MoodBotView;

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
        
        chat.getMoodBotModel().getCurrContact().respond = true;
    }
    
    public void handleLogOff(){
        MoodBotView mainMenu = new MoodBotView();
        mainMenu.restartUI(chat.chatStage, "MOOD BOTS");
    }
    
    public void sendMessage(String message, boolean isUser){
        Contact currContact = chat.getMoodBotModel().getCurrContact();
        MessageModel m = new MessageModel(message, isUser);
        currContact.messages.add(m);
    }
    
}