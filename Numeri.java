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

public class Numeri extends Application {

	Label lNumero = new Label("numero ");
	TextField tfNumero = new TextField();
	Button bCerca = new Button("cerca");
	Label lRisultato = new Label("");

	public void start(Stage primaryStage) {

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(lNumero, 		0, 0);
		griglia.add(tfNumero, 		1, 0);
		griglia.add(bCerca, 		0, 1);
		griglia.add(lRisultato, 	1, 1);
		bCerca.setOnAction(e -> cerca());

		primaryStage.setTitle("Numeri");
		primaryStage.setScene(scena);
		primaryStage.show();
	}

	public void cerca() {

		FileReader flussoCaratteri;
		try {
			flussoCaratteri = new FileReader("/Users/classe4I/Desktop/numeri.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			String rigaLetta;
			boolean trovato = false;
			int numeroCercato = 0;
			int numeroRighe = 0;
			do {
				String numero = tfNumero.getText();
				rigaLetta = lettoreDiRighe.readLine();
				if(rigaLetta != null) {
					numeroRighe++;
					if (rigaLetta.equals(numero)) {
						trovato = true;
						numeroCercato++;
					}
				}
			} while (rigaLetta != null);
			lettoreDiRighe.close();
			flussoCaratteri.close();
			if(trovato) {
				lRisultato.setText("c'è " + numeroCercato + " volt* su " + numeroRighe + " righe");
			} else {
				lRisultato.setText("non c'è");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		launch();
	}
}