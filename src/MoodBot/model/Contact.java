package MoodBot.model;

import MoodBot.controller.ChatController;
import MoodBot.view.ChatWindowView;
import java.util.ArrayList;

public class Contact{
    public String name;
    public ArrayList<MessageModel> messages;
    public boolean isCurrentContact = false;
    
    
    public ChatController chatController;
    
    public Contact(String name){
        this.name = name;
        messages = new ArrayList<MessageModel>();
    }
    
    public void sayGreeting(){
        chatController.sendMessage("Hi there!", false);
    }
}