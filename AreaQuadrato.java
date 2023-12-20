package it.edu.iisgubbio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AreaQuadrato extends Application {
	TextField tfLato = new TextField("");
	Button bCalcolaArea = new Button("calcola area");
	Label lLato = new Label("Lato: ");
	Label lArea = new Label("Area: ");

	public void start(Stage primaryStage) {

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(lLato, 			0, 0);
		griglia.add(tfLato, 		1, 0);
		griglia.add(bCalcolaArea, 	1, 1);
		griglia.add(lArea, 			0, 2);
		bCalcolaArea.setOnAction(e -> problema());

		primaryStage.setTitle("Area Quadrato");
		primaryStage.setScene(scena);
		primaryStage.show();
	}

	public void problema() {
		
			int valoreArea;
			//int valoreLato = Integer.parseInt(tfLato.getText()); ----> questo deve essere dentro al try, essendo che deve provare e capire dove si verifica
			
			try {
				int valoreLato = Integer.parseInt(tfLato.getText());
				valoreArea = valoreLato*valoreLato;
				lArea.setText(""+valoreArea);
			} catch(NumberFormatException erroreTastiera) {
				lArea.setText("problema nell'inserimento del numero");
			}
			
	}

	public static void main(String args[]) {
		launch();
	}
}