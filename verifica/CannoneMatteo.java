package it.edu.iisgubbio.verifica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CannoneMatteo extends Application {
	TextField tfMateria = new TextField();
	Button bMateria = new Button();
	Label lMateria = new Label("");
	TextField tfInsegnante = new TextField();
	Button bInsegnante = new Button();
	Label lInsegnante = new Label("");
	ListView<String> lista = new ListView<>();
	

	public void start(Stage primaryStage) {

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(tfMateria, 			0, 0);
		griglia.add(bMateria, 			1, 0);
		griglia.add(lMateria, 			2, 0);
		griglia.add(tfInsegnante, 		0, 1);
		griglia.add(bInsegnante, 		1, 1);
		griglia.add(lInsegnante, 		2, 1);
		bMateria.setOnAction(e -> materia());
		bInsegnante.setOnAction(e -> insegnanti());

		primaryStage.setTitle("Verifica");
		primaryStage.setScene(scena);
		primaryStage.show();
	}

	//capire quante volte è presente una materia
	public void materia() {
		
		
		int contatore = 0;
		
		try {
			FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/elencoAttivita.csv");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			
			String rigaLetta;
			String materiaInserita = tfMateria.getText();
			lettoreDiRighe.readLine();
			do {
				rigaLetta = lettoreDiRighe.readLine();
				if (rigaLetta != null) {
					String val[] = rigaLetta.toLowerCase().split("\"");
					if(val[3].equals(materiaInserita)) {
						contatore++;
					}
				}
				lMateria.setText("la materia che hai inserito si ripete " + contatore + " volte");
			} while (rigaLetta != null);
			System.out.println(contatore);
		} catch (IOException e) {
			lMateria.setText("ERROR");
		}
		
		
	}
	
	
	
	//fornire l'elenco delle classi in cui l'insegnante insegna
	public void insegnanti() {
		
		
		try {
			FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/elencoAttivita.csv");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			
			String rigaLetta;
			String insegnanteInserito = tfInsegnante.getText();
			lettoreDiRighe.readLine();
			do {
				rigaLetta = lettoreDiRighe.readLine();
				if (rigaLetta != null) {
					String val[] = rigaLetta.toLowerCase().split("\"");
					//System.out.println(val[5]);
					if(val[5].equals(insegnanteInserito)) {
						lista.getItems().add(val[1]);
//						lInsegnante.setText(val[0] + " ,");
//						System.out.println("ciao");
					}
				}
				lInsegnante.setText("classi: " + lista);
			} while (rigaLetta != null);
		} catch (IOException e) {
			lInsegnante.setText("ERROR");
		}
		
		
	}
	
	

	public static void main(String args[]) {
		launch();
	}
}