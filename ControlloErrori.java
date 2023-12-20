// alla stringa bisogna fare .split, bisogna controllare che al posto 0 ci sia una parola e non un numero
// la posto 2 bisogna verificare che ci sia scritto il quadrato del numero precedente
// es: se c'è scritto 10, il numero successivo deve essere 100

// serve: una Label, una TextField, un Button

package it.edu.iisgubbio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ControlloErrori extends Application {
	
	Label lInfo = new Label("info");
	TextField tfInformazioni = new TextField();
	Button bTest = new Button("test");
	Label lErrorOk = new Label();

	public void start(Stage primaryStage) {

		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia);

		griglia.add(lInfo, 				0, 0);
		griglia.add(tfInformazioni, 	1, 0);
		griglia.add(bTest, 				1, 1);
		griglia.add(lErrorOk, 			0, 2);
		bTest.setOnAction(e -> problema());

		primaryStage.setTitle("Controllo Errori");
		primaryStage.setScene(scena);
		primaryStage.show();
	}

	public void problema() {

		String[] vettore = tfInformazioni.getText().split(", ");

		// quadrato

		try {

			if (vettore[0].equals("quadrato")) {
				int lato = Integer.parseInt(vettore[1]);

				if ((lato * lato + "").equals(vettore[2])) {
					lErrorOk.setText("ok");
				} else {
					lErrorOk.setText("non ok");
				}
			}

			// rettangolo

			if (vettore[0].equals("rettangolo")) {
				int base = Integer.parseInt(vettore[1]);
				int altezza = Integer.parseInt(vettore[2]);

				if ((base * altezza + "").equals(vettore[3])) {
					lErrorOk.setText("ok");
				} else {
					lErrorOk.setText("non ok");
				}
			}

			// triangolo

			if (vettore[0].equals("triangolo")) {
				int base = Integer.parseInt(vettore[1]);
				int altezza = Integer.parseInt(vettore[2]);
				int area = base * altezza / 2;

				if ((area + "").equals(vettore[3])) {
					lErrorOk.setText("ok");
				} else {
					lErrorOk.setText("non ok");
				}
			}

			// cerchio

			if (vettore[0].equals("cerchio")) {
				int raggio = Integer.parseInt(vettore[1]);
				double areaCerchio = (raggio * raggio) * Math.PI;
				double cerchioPiuCinque = areaCerchio + areaCerchio / 100 * 5; // calcolo il 5% in più del valore con le
																				// virgole
				double cerchioMenoCinque = areaCerchio - areaCerchio / 100 * 5; // caloclo il 5% in meno del vaolre con
																				// le virgole
				double areaInserita = Double.parseDouble(vettore[2]); // l'ho dovuto cambiare per far si di controllare
																		// la paete con la virgola

				System.out.println(areaCerchio);

				if (areaInserita >= cerchioMenoCinque && areaInserita <= cerchioPiuCinque) {
					lErrorOk.setText("ok");
				} else {
					lErrorOk.setText("non ok");
				}
			}

		} catch (ArrayIndexOutOfBoundsException x) {
			lErrorOk.setText("hai mancato un numero");
		} catch (NumberFormatException y) {
			lErrorOk.setText("hai scritto lettere al posto di numeri");
		}
	}

	public static void main(String args[]) {
		launch();
	}
}