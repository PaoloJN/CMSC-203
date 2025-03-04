package com.example.labfx;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */



//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button btn1, btn2, btn3, btn4, btn5, btn6;
	private Label lbl1;
	private TextField txt1;
	//  declare two HBoxes
	private HBox hb1, hb2;
	
	//student Task #4:
	//  declare an instance of DataManager
	private DataManager dataManager;

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		btn1 = new Button("Hello");
		btn2 = new Button("Howdy");
		btn3 = new Button("Chinese");

		btn6 = new Button("Arabic");

		btn4 = new Button("Clear");
		btn5 = new Button("Exit");
		lbl1 = new Label("Feedback:");
		txt1 = new TextField();
		hb1 = new HBox(10);
		hb2 = new HBox(10);
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(btn1, new Insets(5));
		HBox.setMargin(btn2, new Insets(5));
		HBox.setMargin(btn3, new Insets(5));
		HBox.setMargin(btn4, new Insets(5));
		HBox.setMargin(btn5, new Insets(5));
		HBox.setMargin(btn6, new Insets(5));
		HBox.setMargin(txt1, new Insets(5));

		hb1.setPadding(new Insets(10));
		hb1.setAlignment(Pos.CENTER);
		hb2.setPadding(new Insets(10));
		hb2.setAlignment(Pos.CENTER);

		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hb1.getChildren().addAll(lbl1, txt1);
		//  add the buttons to the other HBox
		hb2.getChildren().addAll(btn1, btn2, btn3, btn6, btn4, btn5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(hb1, hb2);

		btn1.setOnAction(new ButtonHandler());
		btn2.setOnAction(new ButtonHandler());
		btn3.setOnAction(new ButtonHandler());
		btn4.setOnAction(new ButtonHandler());
		btn5.setOnAction(new ButtonHandler());
		btn6.setOnAction(new ButtonHandler());


	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == btn1) {
				txt1.setText(dataManager.getHello());
			} else if (event.getSource() == btn2) {
				txt1.setText(dataManager.getHowdy());
			} else if (event.getSource() == btn3) {
				txt1.setText(dataManager.getChinese());
			} else if (event.getSource() == btn6 ) {
				txt1.setText(dataManager.getArabic());
			} else if (event.getSource() == btn4) {
				txt1.setText("");
			} else if (event.getSource() == btn5) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
