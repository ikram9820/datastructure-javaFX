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

public class StackController {
	
	private Stack <Integer> s;
	@FXML private TextField text,index;
	
	@FXML private Label resultLabel;
	@FXML private Label display;
	private String stext;
	
	
	public StackController() {
		
		int size =0;
		while(size == 0) {
		try {
			size= Integer.parseInt(JOptionPane.showInputDialog("enter array size for Stack:"));
			s =new Stack<Integer>(size);
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
		if(s.isFull())
			JOptionPane.showMessageDialog(null, "stack is overflow");
		else {
			try {
			stext=text.getText();
			
		 s.push(Integer.parseInt(stext));
		display.setText(s.traverse());	
			}catch(Exception NumberFormatException) {JOptionPane.showMessageDialog(null,"please input integer data type");}
			
		text.clear();
		}
	}

	public void delete(ActionEvent e) {
		if(s.isEmpty())
			JOptionPane.showMessageDialog(null, "stack is underflow");
		else {
		resultLabel.setText("poped item = "+s.pop());
			display.setText(s.traverse());
		}
		text.clear();
	}
		
	public void peak(ActionEvent e) {
		
		if(s.isEmpty())
			JOptionPane.showMessageDialog(null, "stack is underflow");
		else
		resultLabel.setText("peak = "+s.peak());
		
		
		text.clear();
	}
		
	



}
