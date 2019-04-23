package com.java.fx_message_manager;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControlMensajes {

	public static void mostrarAlerta(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Aviso");
		alert.setHeaderText(null);
		alert.setContentText(msg);

		alert.showAndWait();			
	}
}
