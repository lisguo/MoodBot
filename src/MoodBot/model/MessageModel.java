package MoodBot.model;

public class MessageModel{
    String message;
    boolean isUser;
    
    public MessageModel(String message, boolean isUser){
        this.message = message;
        this.isUser = isUser;
    }
    
    public String getMessage(){
        return message;
    }
    public boolean getisUser(){
        return isUser;
    }
}