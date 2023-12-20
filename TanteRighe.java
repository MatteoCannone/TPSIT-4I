//bottone scrivi: scrive sul file la parola nella TextField
//bottone leggi: legge la prima riga del file

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

public class TanteRighe extends Application {

	Label lNumero = new Label("n: ");
	TextField tfNumero = new TextField("");
	Button bLeggi = new Button("leggi");
	Label lRisultato = new Label();

	public void start(Stage primaryStage) {

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(lNumero, 		0, 0);
		griglia.add(tfNumero, 		1, 0);
		griglia.add(bLeggi, 		0, 1);
		griglia.add(lRisultato, 	1, 1);
		bLeggi.setOnAction(e -> leggi());

		primaryStage.setTitle("Reading and Writing");
		primaryStage.setScene(scena);
		primaryStage.show();
	}

	public void leggi() {

		FileReader flussoCaratteri;
		int numero = Integer.parseInt(tfNumero.getText());
		int contatore = 0;
		try {
			flussoCaratteri = new FileReader("/Users/classe4I/Desktop/tanteRighe.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			String rigaLetta;
			do {
				rigaLetta = lettoreDiRighe.readLine();
				contatore++;
				if(rigaLetta != null) {
					if(numero==contatore) {
						lRisultato.setText(rigaLetta);
					}
				}
			} while (rigaLetta != null);
			lettoreDiRighe.close();
			flussoCaratteri.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		launch();
	}
}