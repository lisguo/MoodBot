package MoodBot;

public class KeywordBank{
    
    
    public static String[] sadBank = {":(", ":’(", "T.T",
        "sad", "cry", "cried", "crying", "depress", 
        "depressed", "depressing", "horrible", "horribly", "unwell",
        "sick", "cloudy", "rainy", "hazy", "foggy", "alone", "lonely",
        "solitude", "melancholy", "melancholic", "low", "down", "worry", 
        "worried", "worrying", "stress", "stressed", "stressing", "drained"};
    
    public static String[] severeBank = {"die", "kill myself", "cut myself", 
    "blood", "suicide", "end it all", "jump off a building", "hang myself", 
    "there is no point"};

    public static String[] confirmBank = {"yes", "sure", "ok", "okay", "fine"};
    public static String[] denialBank = {"no", "don't", "nah", "not really"};
    
    public int rateMood(String userMessage) {
        int mood = 0;
        for(String word : sadBank){
            if(userMessage.contains(word))
                mood--;
        }
        for(String word : severeBank){
            if(userMessage.contains(word))
                mood -= 20;
        }
        return mood;
    }
    
    public boolean getConfirmation(String userMessage){
        for(String word : confirmBank){
            if(userMessage.contains(word))
                return true;
        }
        for(String word : denialBank){
            if(userMessage.contains(word))
                return true;
        }
        return false;
    }
    
    
    
}