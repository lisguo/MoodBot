package MoodBot.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import MoodBot.StartupConstants;
import MoodBot.controller.MainMenuController;

/**
 *
 * @author BunnyRailgun
 */
public class MoodBotView {
    Stage primaryStage;
    Scene primaryScene;
    MainMenuController mainMenuController = new MainMenuController();
    
    //UI
    BorderPane mainMenu;
    
    //TOP OF BORDER
    FlowPane toolBar;
    Button about;
    
    //CENTER OF BORDER
    VBox menuButtons;
    Button startChat;
    
    
    public void startUI(Stage initPrimaryStage, String appName){
        primaryStage = initPrimaryStage;
        initWindow(appName);      
    }    
    private void initWindow(String windowTitle) {
	// SET THE WINDOW TITLE
        primaryStage = new Stage();
	primaryStage.setTitle(windowTitle);
        

	// GET THE SIZE OF THE SCREEN
	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();

	// AND USE IT TO SIZE THE WINDOW
	primaryStage.setX(bounds.getMinX()/2);
	primaryStage.setY(bounds.getMinY());
	primaryStage.setWidth(bounds.getWidth()/2);
	primaryStage.setHeight(bounds.getHeight());
        //Set UI
        mainMenu = new BorderPane();
        primaryScene = new Scene(mainMenu);
        primaryScene.getStylesheets().add(StartupConstants.STYLE_SHEET_UI);//SET STYLESHEET
        mainMenu.getStyleClass().add("main_menu");
        
        
        //ENTER BUTTONS FOR TITLE HERE
        menuButtons = new VBox();
        menuButtons.getStyleClass().add("menu_buttons_vbox");
        startChat = new Button("CHAT");
        startChat.getStyleClass().add("menu_button");
        menuButtons.getChildren().addAll(startChat);
        
        //SET TOP AND CENTER
        mainMenu.setCenter(menuButtons);
        
        //SET SCENE AND SHOW
        primaryStage.setScene(primaryScene);
        primaryStage.show();

        //HANDLERS
        startChat.setOnMouseClicked(e->{
            mainMenuController.handleStartChat(primaryStage);
        });
    }
}
