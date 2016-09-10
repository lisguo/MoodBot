package MoodBot.model;

import MoodBot.KeywordBank;
import MoodBot.controller.ChatController;
import MoodBot.view.ChatWindowView;
import java.util.ArrayList;

public class Contact{
    public String name;
    public ArrayList<MessageModel> messages;
    public boolean isCurrentContact = false;
    public boolean respond;
    public KeywordBank bank;
    String situation = "Normal";
    
    public boolean recommendMeditation = true;
    
    
    public ChatController chatController;
    public ChatWindowView chatWindow;
   
    public Contact(String name){
        this.name = name;
        messages = new ArrayList<MessageModel>();
        bank = new KeywordBank();
    }
    
    public void sayGreeting(){
        chatController.sendMessage("Hi there!", false);
    }
      public void respond(){
          
      }
}