package MoodBot.model;

import java.util.ArrayList;

public class Contact{
    public String name;
    public ArrayList<String> messages;
    
    public Contact(String name){
        this.name = name;
        messages = new ArrayList<>();
    }
}