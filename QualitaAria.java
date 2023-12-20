package it.edu.iisgubbio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class QualitaAria extends Application {
	TextField tfTextField = new TextField("");
	Button bButton = new Button("verifica ");
	Label lLabel = new Label("");

	public void start(Stage primaryStage) {

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(tfTextField, 		0, 0);
		griglia.add(bButton, 			1, 0);
		griglia.add(lLabel, 			0, 1);
		bButton.setOnAction(e -> problema());

		primaryStage.setTitle("Qualità dell'aria");
		primaryStage.setScene(scena);
		primaryStage.show();
	}

	public void problema() {

		try (FileReader leggoFile = new FileReader("/Users/classe4I/Desktop/QualitaDellAria.csv");
				BufferedReader lettoreDiRighe = new BufferedReader(leggoFile);) {
			String rigaLetta;
			String comuneInserito = tfTextField.getText();
			lettoreDiRighe.readLine(); //leggo la prima riga passando subito a quella successiva
			do {
				rigaLetta = lettoreDiRighe.readLine();
				if (rigaLetta != null) {
					String val []=rigaLetta.split(",");
					if(val[0].equals(comuneInserito)) {
						lLabel.setText("la qualità dell'aria è: " + val[2]);
					}
				}
			} while (rigaLetta != null);
		} catch (IOException e) {
			lLabel.setText("errore");
		}

	}

	public static void main(String args[]) {
		launch();
	}
}