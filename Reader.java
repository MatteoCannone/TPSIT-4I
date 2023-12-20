package it.edu.iisgubbio;

import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Reader extends Application {

	Label lRisultato = new Label("");
	TextField tfPosizione = new TextField();
	Button bLeggi = new Button("test");
	Label lPosizione = new Label("posizione ");

	public void start(Stage primaryStage) {

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(lPosizione, 	0, 0);
		griglia.add(tfPosizione, 	1, 0);
		griglia.add(bLeggi, 		0, 1, 2, 1);
		griglia.add(lRisultato, 	0, 2);
		bLeggi.setOnAction(e -> leggi());

		primaryStage.setTitle("Reader");
		primaryStage.setScene(scena);
		primaryStage.show();
	}

	public void leggi() {

		FileReader flussoCaratteri;
;		try {
			flussoCaratteri = new FileReader("/Users/classe4I/Desktop/qualcosa.txt");
			char caratteri[] = new char[1000];
			int caratteriLetti = flussoCaratteri.read(caratteri);
			String testo = new String(caratteri, 0, caratteriLetti);
			System.out.println(testo);
			flussoCaratteri.close();
			int posizione = Integer.parseInt(tfPosizione.getText());
			lRisultato.setText(""+caratteri[posizione]);
		} catch (IOException e) {
			lRisultato.setText("ERROR"+e.getLocalizedMessage());
		}

	}

	public static void main(String args[]) {
		launch();
	}
}