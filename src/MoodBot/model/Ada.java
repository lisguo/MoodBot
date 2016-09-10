package MoodBot.model;

import MoodBot.controller.ChatController;
import MoodBot.view.ChatWindowView;

public class Ada extends Contact{
    
    public Ada(){
        super("Ada");
    }
    String greeting = "Hi, Human. I’m Ada, and I will be your personal trainer. "
            + "My mission is to guide your thinking habits in a positive and "
            + "healthy direction. Did you know that humans are estimated to"
            + " have 60,000-70,000 thoughts per day? And the majority of them "
            + "have a tendency to be negative! That’s a lot of thoughts to deal"
            + " with, so you can only imagine how easy it is to get stuck in a "
            + "cycle of negative feels. Let’s start with a fun activity for today!"
            + " What are five things you love about your life? This list can"
            + " include anything--for example, I love:\n" +
    "1. the colour of my outfit\n" +
    "2. my amazing bot friends\n" +
    "3. technology\n" +
    "4. that kitty cats exist in this world\n" +
    "5. that I am alive and free of viruses and malwares";
    
    @Override
    public void sayGreeting(){
        chatController.sendMessage(greeting, false);
    }
    public void respond(){
            
            String userMessage = messages.get(messages.size()-1).getMessage();
            
            String response = "Umm I can't understand you.";
            
            
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
                response = "Hey theere! :)";
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
                        response = "Aw. That's terrible. :(. Wanna talk about stuff?";
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