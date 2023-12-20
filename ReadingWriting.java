//bottone scrivi: scrive sul file la parola nella TextField
//bottone leggi: legge la prima riga del file

package it.edu.iisgubbio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ReadingWriting extends Application {

	TextField tfRisultato = new TextField("");
	Button bLeggi = new Button("leggi");
	Button bScrivi = new Button("scrivi");

	public void start(Stage primaryStage) {

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(bLeggi, 		0, 0);
		griglia.add(tfRisultato, 	0, 1);
		griglia.add(bScrivi, 		0, 2);
		bLeggi.setOnAction(e -> leggi());
		bScrivi.setOnAction(e -> scrivi());

		primaryStage.setTitle("Reading and Writing");
		primaryStage.setScene(scena);
		primaryStage.show();
	}

	public void leggi() {

		FileReader flussoCaratteri;
		try {
			flussoCaratteri = new FileReader("/Users/classe4I/Desktop/qualcosa.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			String testo = lettoreDiRighe.readLine();
			lettoreDiRighe.close();
			flussoCaratteri.close();
			tfRisultato.setText(testo);
		} catch (IOException e) {
			tfRisultato.setText("ERROR" + e.getLocalizedMessage());
		}
	}

	public void scrivi() {

		FileWriter flussoCaratteri;
		try {
			String testo = tfRisultato.getText();
			flussoCaratteri = new FileWriter("/Users/classe4I/Desktop/qualcosa.txt");
			flussoCaratteri.write(testo + "\n");
			flussoCaratteri.close();
			tfRisultato.setText(testo);
		} catch (IOException e) {
			tfRisultato.setText("ERROR" + e.getLocalizedMessage());
		}
		tfRisultato.setText("");
	}

	public static void main(String args[]) {
		launch();
	}
}