/*
 * Class: CMSC203
 * Instructor: Dr. Grinberg
 * Description: Java program to encrypt and decrypt a phrase using two similar approaches, each insecure by modern standards.  
 * Due: 03/08/2025 
 * Platform/compiler: IntelliJ / vscode-javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Paolo Nessim
 */
 


package com.example.encryption;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * The main method for the GUI example program JavaFX version
 * 
 * @author Farnaz Eivaz
 * @version 7/11/2022 *
 */
public class FXDriver extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// call the main scene which is a BorderPane
		FXMainPane root = new FXMainPane();
		stage.setScene(new Scene(root, 600, 350));
		// Set stage title and show the stage.
		stage.setTitle("Cybersecurity Encryption and Decryption");
		stage.show();

	}
}
