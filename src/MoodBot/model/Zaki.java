package MoodBot.model;

import MoodBot.controller.ChatController;
import MoodBot.view.ChatWindowView;

public class Zaki extends Contact{
    
    public Zaki(){
        super("Zaki");
    }
    String greeting = "Hey, my name’s Zaki and welcome to MoodBots! Here on MoodBots, "
            + "you are given a team of computer bots and human counselors who will work "
            + "together to help you track and maintain your mental well-being. I will"
            + " be your primary bot buddy who will be responsible for logging your daily"
            + " moods based on your chat responses on this app. On the side panel"
            + " to the left of this chat window, you will find your conversations "
            + "with the other members of the team. You can respond "
            + "to my message to continue this conversation now, or check out your "
            + "other messages first. ";
    
    @Override
    public void sayGreeting(){
        chatController.sendMessage(greeting, false);
    }
    
    public void respond(){
            
            String userMessage = messages.get(messages.size()-1).getMessage();
            
            String response = "";
            
            
            if(situation.equals("Severe")){
                boolean confirm = bank.getConfirmation(userMessage);
                if(confirm){
                    response = "A counselor from Stony Brook's Counseling and Psychological Services is available at 631-632-6720";
                }
                else{
                    response = "I understand. Perhaps consider these alternative places to seek help: https://www.suicideforum.com";
                }
                situation.equals("Normal");
            }
            
            else if(bank.sayHi(userMessage)){
                response = "Hello there! How are you?";
            }
            else{
                int mood = bank.rateMood(userMessage);

                if(mood < 0){
                    if(mood > -5){
                        if(recommendMeditation){
                            response = "You know, when I have too much data processing "
                                    + "in my motherboard, I stop what I’m doing for a bit"
                                    + " to meditate. I know CAPS hosts Mindfulness "
                                    + "Meditation sessions three times a week. "
                                    + "Totally recommend trying it if you’re free"
                                    + " during one of those times.";
                            recommendMeditation = false;
                            response = "Do you want to talk?";
                        }
                    }
                    else if(mood > -10){
                        response = "You seem unhappy. Do you want to talk about it?";
                    }
                    else if(mood > -20){
                        response = "";
                    }
                    else{
                        situation = "Severe";
                        response = "You seem to be in a crisis, and as a friend, "
                                + "I highly encourage you to seek a professional. "
                                + "I know a person who you can contact right now. "
                                + "Do you want me to link you the contact information?";
                    }
                }
                else{
                    if(mood < 20){

                    }
                    else if(mood < 15){

                    }
                    else if(mood < 10){

                    }
                    else if(mood < 5){

                    }
                }
         }
            
            //Send response
                chatController.sendMessage(response, false);
                chatController.chat.refreshMessages();
    
    }
}