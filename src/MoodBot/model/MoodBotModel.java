package MoodBot.model;

public class MoodBotModel{
    Contact currContact;
    int moodLevel = 0; // negative = bad, positive = good
    
    public void setCurrContact(Contact c){
        currContact = c;
    }
    
    public Contact getCurrContact(){
            return currContact;
    }
}