package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Formelrad Application
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();

			// Creating an image
			Image image = new Image(new FileInputStream("bin\\application\\formelradelektronik.gif"));
			ImageView imageView = new ImageView(image);
			imageView.setX(10);
			imageView.setY(10);
			imageView.setFitHeight(300);
			imageView.setFitWidth(300);
			imageView.setPreserveRatio(true);
			root.getChildren().add(imageView);

			Label lbleistung = new Label("Leistung:");
			lbleistung.relocate(10, 285);
			lbleistung.setFont(Font.font(15));
			root.getChildren().add(lbleistung);

			TextField txLeistung = new TextField();
			txLeistung.relocate(100, 285);
			txLeistung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txLeistung);

			Label lblSpannung = new Label("Spannung:");
			lblSpannung.relocate(10, 325);
			lblSpannung.setFont(Font.font(15));
			root.getChildren().add(lblSpannung);

			TextField txSpannung = new TextField();
			txSpannung.relocate(100, 325);
			txSpannung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txSpannung);

			Label lblStrom = new Label("Strom:");
			lblStrom.relocate(10, 365);
			lblStrom.setFont(Font.font(15));
			root.getChildren().add(lblStrom);

			TextField txStrom = new TextField();
			txStrom.relocate(100, 365);
			txStrom.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txStrom);

			Label lblWiderstand = new Label("Widerstand:");
			lblWiderstand.relocate(10, 405);
			lblWiderstand.setFont(Font.font(15));
			root.getChildren().add(lblWiderstand);

			TextField txWiderstand = new TextField();
			txWiderstand.relocate(100, 405);
			txWiderstand.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txWiderstand);

			Button btnBerechnen = new Button();
			btnBerechnen.relocate(100, 445);
			btnBerechnen.setText("Berechnen");
			root.getChildren().add(btnBerechnen);
			
			Button btnDeletValue = new Button();
			btnDeletValue.relocate(175, 445);
			btnDeletValue.setText("Delete");
			btnDeletValue.setTextFill(Color.web("red"));
			root.getChildren().add(btnDeletValue);
			
			Label lblWarning = new Label();
			lblWarning.relocate(10, 480);
			lblWarning.setFont(Font.font(17));
			lblWarning.setTextFill(Color.web("#D8C300"));
			root.getChildren().add(lblWarning);
			
			btnBerechnen.setOnAction(e -> {
				int score = 0;
				if(txWiderstand.getText().trim().isEmpty())
					score++;
				if (txLeistung.getText().trim().isEmpty())
					score++;
				if (txSpannung.getText().trim().isEmpty())
					score++;
				if (txStrom.getText().trim().isEmpty())
					score++;
				if(score < 2)
					lblWarning.setText("Bitte gib nur 2 Werte ein!");
				else if(score > 2)
					lblWarning.setText("Du musst mindestens 2 Werte eingeben!");
				else{
					Calculator myCalculator = new Calculator(
							parseTxtToDouble(txLeistung.getText()),
							parseTxtToDouble(txSpannung.getText()),
							parseTxtToDouble(txStrom.getText()),
							parseTxtToDouble(txWiderstand.getText()));
					System.out.print("Vorher:  ");
					System.out.println(myCalculator.toString());
					myCalculator.calculate();
					System.out.print("Nachher: ");
					System.out.println(myCalculator.toString());
						
					txLeistung.setText(Double.toString(myCalculator.getLeistung()));
					if(myCalculator.isLeistungColor())
						txLeistung.setStyle("-fx-text-inner-color: red;");
					else
						txLeistung.setStyle("-fx-text-inner-color: black;");
					txSpannung.setText(Double.toString(myCalculator.getSpannung()));
					if(myCalculator.isSpannungColor())
						txSpannung.setStyle("-fx-text-inner-color: red;");
					else
						txSpannung.setStyle("-fx-text-inner-color: black;");
					txStrom.setText(Double.toString(myCalculator.getStrom()));
					if(myCalculator.isStromColor())
						txStrom.setStyle("-fx-text-inner-color: red;");
					else
						txStrom.setStyle("-fx-text-inner-color: black;");
					txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
					if(myCalculator.isWiderstandColor())
						txWiderstand.setStyle("-fx-text-inner-color: red;");
					else
						txWiderstand.setStyle("-fx-text-inner-color: black;");
				}		
				
			});
			
			btnDeletValue.setOnAction(b -> {
				txWiderstand.clear();
				txStrom.clear();
				txSpannung.clear();
				txLeistung.clear();	
			});

			Scene scene = new Scene(root, 330, 520);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Formelrad");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public double parseTxtToDouble(String txt) {
		String txtToParse;
		if (txt.isEmpty())
			txtToParse = "NaN";

		else

			txtToParse = txt;
		double d = Double.parseDouble(txtToParse);
		return d;
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
