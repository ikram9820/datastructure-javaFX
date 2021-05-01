package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class QueueController {
	
	private Queue q;
	@FXML private TextField text,index;
	
	@FXML private Label resultLabel;
	@FXML private Label display;
	private String stext;
	
	
	public QueueController() {
		int size =0;
		while(size == 0) {
		try {
			size= Integer.parseInt(JOptionPane.showInputDialog("enter array size for Queue:"));
			q =new Queue(size);
	}catch(Exception NumberFormatException) {JOptionPane.showMessageDialog(null,"please input integer data type");}
		}
	}
	
	
	public void switchToMain(ActionEvent event)throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("switchScene.fxml"));
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Data Structure");
		stage.show();
}
	
	public void add(ActionEvent e) {
		if(q.isFull())
			JOptionPane.showMessageDialog(null, "queue is full");
		else {
			try {
			stext=text.getText();
			
		 q.enqueue(Integer.parseInt(stext));
		display.setText(q.traverse());	
			}catch(Exception NumberFormatException) {JOptionPane.showMessageDialog(null,"please input integer data type");}
			
		text.clear();
		}
	}

	public void delete(ActionEvent e) {
		if(q.isEmpty())
			JOptionPane.showMessageDialog(null, "queue is empty");
		else {
		resultLabel.setText("deleted item = "+q.dequeue());
			display.setText(q.traverse());
		}
		text.clear();
	}
		
	public void front(ActionEvent e) {
		
		if(q.isEmpty())
			JOptionPane.showMessageDialog(null, "queue is empty");
		else
		resultLabel.setText("peak = "+q.front());
		
		
		text.clear();
	}
		
	



}
