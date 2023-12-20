package it.edu.iisgubbio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CercaNome extends Application {

	ArrayList<String> listaNomi = new ArrayList<>();
	
	Label lRisposta = new Label("risposta: ");
	TextField tfNome = new TextField();
	Button bCerca = new Button("cerca");

	public void start(Stage primaryStage) {
		
		FileReader flussoCaratteri;
		try {
			flussoCaratteri = new FileReader("/Users/classe4I/Desktop/nomi.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		tfNome.setPromptText("inserisci un nome");

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(tfNome, 			0, 0);
		griglia.add(bCerca, 			0, 1);
		griglia.add(lRisposta, 			0, 2);
		bCerca.setOnAction(e -> problema());

		primaryStage.setTitle("Cerca Nome");
		primaryStage.setScene(scena);
		primaryStage.show();
	}

	public void problema() {
		
		 
		
	}

	public static void main(String args[]) {
		launch();
	}
}