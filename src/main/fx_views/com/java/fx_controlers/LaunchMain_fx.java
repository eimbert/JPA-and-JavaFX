package com.java.fx_controlers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;


public class LaunchMain_fx extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = FXMLLoader.load(getClass().getResource("/com/java/fx_forms/frm_main.fxml")); 
			Scene scene = new Scene(root);
			primaryStage.setTitle("On-line Shop");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		primaryStage.setOnCloseRequest((WindowEvent event1) -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("¿Quieres guardar la cesta de la compra? ");

			alert.showAndWait();			
	    });
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}