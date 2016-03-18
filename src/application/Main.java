package application;

import com.mashape.unirest.http.exceptions.UnirestException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * View and Controller class. 
 * Main function is called here. 
 *  
 * @author alisoncheu
 *
 */
public class Main extends Application {
	private static GridPane gp = new GridPane();
	private TextField input, done; 
	private Button yodaButton, minionButton, pirateButton, valleyGirlButton,LOLCatButton; 
	
	@Override
	public void start(Stage primaryStage) {
		setupGridPane();
		setupButtons(); 
		try {
			Scene scene = new Scene(gp,600,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Talk ??? to Me");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets up for how scene should look. 
	 */
	public void setupGridPane(){
		gp.setAlignment(Pos.BASELINE_CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(15,25,25,25));
		BackgroundImage bi = new BackgroundImage(new Image("background.png"), null, null, null, null);
		gp.setBackground(new Background(bi));

		Text instruct = new Text("Enter the text which you wish to translate.");
		instruct.setFont(new Font("Tahoma", 20));
		gp.add(instruct, 0, 0, 2, 1);

		input = new TextField();
		input.setPromptText("Blah blah blah...");
		input.setPrefSize(300, 50);
		gp.add(input, 0, 1);

		done = new TextField();
		done.setPromptText("Translation comes out here...");
		done.setEditable(false);
		gp.add(done, 0, 3);
	}
	
	/**
	 * Setup format for buttons. 
	 */
	public void setupButtons(){
		setUpYodaButton(); 
		setUpMinionButton();
		setUpPirateButton();
		setUpValleyGirlButton(); 
		setUpLOLCatButton(); 
		TilePane tileButtons = new TilePane(Orientation.HORIZONTAL);
		tileButtons.setVgap(10);
		tileButtons.setHgap(10);
		tileButtons.getChildren().addAll(yodaButton, minionButton, pirateButton, valleyGirlButton, LOLCatButton);
		gp.add(tileButtons, 0, 2);
	}
	
	/**
	 * Helper function for Yoda Button setup. 
	 */
	public void setUpYodaButton(){
		yodaButton = new Button();
		Image img = new Image(getClass().getResourceAsStream("yodahead.png"));
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitHeight(25);
		imgV.setFitWidth(40);
		yodaButton.setGraphic(imgV);

		yodaButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				String userInput = input.getText();
				if (userInput.isEmpty()){
					Alert err = new Alert(AlertType.ERROR, "Input required.");
					err.setTitle("No input");
					err.showAndWait();
				}else{	
					try {
						done.setText(SpeakingStyle.translateYoda(userInput));
					} catch (UnirestException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	/**
	 * Helper function for Minion Button setup. 
	 */
	public void setUpMinionButton(){
		minionButton = new Button();
		Image img = new Image(getClass().getResourceAsStream("minion_head.png"));
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitHeight(25);
		imgV.setFitWidth(40);
		minionButton.setGraphic(imgV);
		
		minionButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				String userInput = input.getText();
				if (userInput.isEmpty()){
					Alert err = new Alert(AlertType.ERROR, "Input required.");
					err.setTitle("No input");
					err.showAndWait();
				}else{	
					try {
						done.setText(SpeakingStyle.translateMinion(userInput));
					} catch (UnirestException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Helper function for Pirate Button setup. 
	 */
	public void setUpPirateButton(){
		pirateButton = new Button();
		Image img = new Image(getClass().getResourceAsStream("pirate_flag.png"));
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitHeight(25);
		imgV.setFitWidth(40);
		pirateButton.setGraphic(imgV);
		
		pirateButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				String userInput = input.getText();
				if (userInput.isEmpty()){
					Alert err = new Alert(AlertType.ERROR, "Input required.");
					err.setTitle("No input");
					err.showAndWait();
				}else{	
					try {
						done.setText(SpeakingStyle.translatePirate(userInput));
					} catch (UnirestException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	/**
	 * Helper function for Valley Girl function setup. 
	 */
	public void setUpValleyGirlButton(){
		valleyGirlButton = new Button();
		Image img = new Image(getClass().getResourceAsStream("valleyGirl.png"));
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitHeight(25);
		imgV.setFitWidth(80);
		valleyGirlButton.setGraphic(imgV);
		
		valleyGirlButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				String userInput = input.getText();
				if (userInput.isEmpty()){
					Alert err = new Alert(AlertType.ERROR, "Input required.");
					err.setTitle("No input");
					err.showAndWait();
				}else{	
					try {
						done.setText(SpeakingStyle.translateValleyGirl(userInput));
					} catch (UnirestException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	/**
	 * Helper function for LOLCatButton setup. 
	 */
	public void setUpLOLCatButton(){
		LOLCatButton = new Button();
		Image img = new Image(getClass().getResourceAsStream("cat_head.png"));
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitHeight(25);
		imgV.setFitWidth(25);
		LOLCatButton.setGraphic(imgV);
		
		LOLCatButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				String userInput = input.getText();
				if (userInput.isEmpty()){
					Alert err = new Alert(AlertType.ERROR, "Input required.");
					err.setTitle("No input");
					err.showAndWait();
				}else{	
					try {
						done.setText(SpeakingStyle.translateLOLCat(userInput));
					} catch (UnirestException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	/**
	 * Main function 
	 * @param args No arguments needed. 
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
