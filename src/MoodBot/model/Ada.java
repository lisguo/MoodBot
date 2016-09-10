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
}