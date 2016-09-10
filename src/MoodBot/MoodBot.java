package MoodBot;

import java.io.File;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import MoodBot.view.MoodBotView;

/**
 * 
 * @author BunnyRailgun
 */
public class MoodBot extends Application {
    
    MoodBotView ui = new MoodBotView();
    String appTitle = "MOOD BOT";
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        ui.startUI(primaryStage, appTitle);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
