package MoodBot.model;

import MoodBot.controller.ChatController;
import MoodBot.view.ChatWindowView;

public class Zaki extends Contact{
    
    public Zaki(){
        super("Zaki");
    }
    String greeting = "Hey, my name’s Zaki and welcome to MoodBots! "
            + "Here on MoodBots, you are given a team of computer bots and "
            + "human counselors who will work together to help you track and "
            + "maintain your mental well-being. I will be your primary bot buddy"
            + " who will be responsible for logging your daily moods based on "
            + "your chat responses on this app. On the side panel to the left "
            + "of this chat window, you will find your conversations with the "
            + "other members of the team.";
    
    @Override
    public void sayGreeting(){
        chatController.sendMessage(greeting, false);
    }
}