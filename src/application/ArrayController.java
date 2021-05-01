package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class ArrayController {
	
	private Array arr;

	@FXML private TextField text,index;
	@FXML private RadioButton rb1,rb2,rb3,rb4;
	@FXML private Label resultLabel;
	@FXML private Label display;
	private String stext,sindex;
	
	
	public ArrayController() {
		int size =0;
		while(size == 0) {
		try {
			size= Integer.parseInt(JOptionPane.showInputDialog("enter array size:"));
			arr=new Array(size);
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
	public void setData() {
		try {
			stext=text.getText();
		    sindex=index.getText();
			}catch(Exception NumberFormatException) {JOptionPane.showMessageDialog(null,"please input integer data type");}
			
	}
	public void add(ActionEvent e) {
		
		setData();
	if(sindex.equals("")&&!stext.equals(""))
		arr.insert(Integer.parseInt(stext));
	else if(!sindex.equals("")&&!stext.equals(""))
	arr.insert(Integer.parseInt(stext),Integer.parseInt(sindex));
	else
		JOptionPane.showMessageDialog(null,"enter data");
	
		display.setText(arr.travers());	
     	clr();
	}
public void clr() {
	text.clear();
	index.clear();
}
	public void delete(ActionEvent e) {
		setData();    
		if(!sindex.equals("")&&stext.equals(""))
			resultLabel.setText("deleted item :"+arr.deleteAt(Integer.parseInt(sindex)));
		else if(sindex.equals("")&&!stext.equals(""))
		resultLabel.setText("deleted item :"+arr.delete(Integer.parseInt(stext)));
		else 
			JOptionPane.showMessageDialog(null,"enter data or index");
		
	
			display.setText(arr.travers());
		    clr();
	}
		
	public void get(ActionEvent e) {
		try {
		    sindex=index.getText();
			}catch(Exception NumberFormatException) {JOptionPane.showMessageDialog(null,"please input integer data type");}
			
		if(!sindex.equals("")) {
		resultLabel.setText(arr.getAt(Integer.parseInt(sindex))+": at index "+sindex);
		
		}
		else
			JOptionPane.showMessageDialog(null,"enter index number");
		 clr();
	}
		
	public void search(ActionEvent e) {
		try {
			stext=text.getText();
		    sindex=index.getText();
			}catch(Exception NumberFormatException) {JOptionPane.showMessageDialog(null,"please input integer data type");}
			
		if(!stext.equals("")) {
		
			if(rb1.isSelected()) 
			resultLabel.setText("data at index: "+arr.search(Integer.parseInt(stext)));
		
		if(rb2.isSelected()) {	
			arr.insertionSort();
			display.setText(arr.travers());
			resultLabel.setText("data at index: "+arr.bSearch(Integer.parseInt(stext)));
		}
		
		}
		else
			JOptionPane.showMessageDialog(null,"enter data");
		 clr();
	}
		
	public void sort(ActionEvent e) {
	
		if(rb3.isSelected()) 
			arr.insertionSort();
		
		if(rb4.isSelected())
			arr.quickSort(0,arr.getNelement()-1);
		
		display.setText(arr.travers());
		 clr();
	}


}
