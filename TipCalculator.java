/*
 * Arielle Watson
 * CISC 3115
 * Extra Credit TipCalculator
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

	public class TipCalculator extends Application {
	private Label rLabel;
	private TextField field;
	private Button calcTip;
	private Label amountToTip;
	private Label totalWithTip;
	
		@SuppressWarnings("unchecked")
		public void start(Stage primaryStage) {
			
			rLabel = new Label("Restaurant Charge:");
			field = new TextField();
			calcTip = new Button ("Calculate Tip");
			
			calcTip.setOnAction(new ButtonHandler());
			
			amountToTip = new Label("Amount to Tip:");
			totalWithTip = new Label();
			
			VBox box = new VBox(10);
			box.getChildren().add(rLabel);
			box.getChildren().add(field);
			box.getChildren().add(calcTip);
			box.getChildren().add(amountToTip);
			box.getChildren().add(totalWithTip);
			box.setAlignment(Pos.CENTER);
			box.setPadding(new Insets(10,10,10,10));
			Scene scene = new Scene(box,200,200);
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
		}
		private class ButtonHandler implements EventHandler {
			public void handle(Event e) {
				final double tipPercent = 20;
				String userInput;
				double tip;
				double totalAmount;
				
				userInput = field.getText().trim();
				tip = (Double.parseDouble(userInput)*tipPercent)/100.0;
				totalAmount = tip + Double.parseDouble(userInput);
				totalWithTip.setText(String.format("$%.2f", totalAmount));
			}

		}
		
		public static void main(String[]args) {
			launch(args);
		}
	}
