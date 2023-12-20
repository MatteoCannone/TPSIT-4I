package it.edu.iisgubbio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Filtro extends Application {

	Label lMinimo = new Label("min ");
	Label lMassimo = new Label("max ");
	TextField tfMinimo = new TextField();
	TextField tfMassimo = new TextField();
	Button bFiltra = new Button("filtra");
	Label lRisultato = new Label("");

	public void start(Stage primaryStage) {

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(lMinimo, 		0, 0);
		griglia.add(tfMinimo, 		1, 0);
		griglia.add(lMassimo, 		0, 1);
		griglia.add(tfMassimo, 		1, 1);
		griglia.add(bFiltra, 		0, 2, 2, 1);
		griglia.add(lRisultato, 	0, 3, 2, 1);
		bFiltra.setOnAction(e -> filtra());

		primaryStage.setTitle("Filtra");
		primaryStage.setScene(scena);
		primaryStage.show();
	}

	public void filtra() {

		try ( 
				FileReader flussoCaratteriR = new FileReader("/Users/classe4I/Desktop/numeri.txt");
				FileWriter flussoCaratteriW = new FileWriter("/Users/classe4I/Desktop/numeri1.txt");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteriR);
			){
			String rigaLetta;
				int minimo = Integer.parseInt(tfMinimo.getText());
				int massimo = Integer.parseInt(tfMassimo.getText());
			do {
				rigaLetta = lettoreDiRighe.readLine();
				if(rigaLetta != null) {
					
				}
			} while (rigaLetta != null);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		launch();
	}
}