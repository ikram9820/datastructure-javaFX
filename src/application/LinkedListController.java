package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LinkedListController implements Initializable {
	
	private LinkedList <Integer> obj;
	@FXML private TextField text,index;
	@FXML private Label resultLabel;
	@FXML private Label display;
	@FXML private ChoiceBox<String> addcb,delcb;
	private String stext,sindex;
	private String [] addOp= {"insert first","insert last","insert at specific location","insert in sorted list"};
	private String [] delOp= {"delete first","delete last","delete at specific location","delete specific item"};
	
	public LinkedListController() {
		obj=new LinkedList<Integer>();
	}
	
	@Override
	public void initialize(URL arg0 , ResourceBundle arg1 ) {
		addcb.getItems().addAll(addOp);
		delcb.getItems().addAll(delOp);
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
		try {
		String ch= addcb.getValue();
		if(ch.equals("insert first"))
			obj.insertFirst(Integer.parseInt(stext));
		else if(ch.equals("insert last"))
			obj.insertLast(Integer.parseInt(stext));
		else if(ch.equals("insert in sorted list")) {
			obj.insertionSort();
			obj.insertIn(Integer.parseInt(stext));
		}
		else if(ch.equals("insert at specific location"))
			obj.insertAt(Integer.parseInt(sindex),Integer.parseInt(stext));
		else
			JOptionPane.showMessageDialog(null,"choose your addition choice");
		}catch(Exception NumberFormatException) {JOptionPane.showMessageDialog(null,"please input integer data type");}
		

			display.setText(obj.traverseForward());	
			clr();
	}
	public void clr() {
	text.clear();
	index.clear();
}
	
	public void delete(ActionEvent e) {
		setData();
		try {
		String ch= delcb.getValue();
		if(ch.equals("delete first"))
			obj.deleteFirst();
		else if(ch.equals("delete last"))
			obj.deleteLast();
		else if(ch.equals("delete specific item"))
			obj.delete(Integer.parseInt(stext));
		else if(ch.equals("delete at specific location"))
			obj.deleteAt(Integer.parseInt(sindex));
		else
			JOptionPane.showMessageDialog(null,"choose your addition choice");
		}catch(Exception NumberFormatException) {JOptionPane.showMessageDialog(null,"please input integer data type");}
		

			display.setText(obj.traverseForward());	
			clr();
	}
		
	public void get(ActionEvent e) {
		try {
		    sindex=index.getText();
			}catch(Exception NumberFormatException) {JOptionPane.showMessageDialog(null,"please input integer data type");}
			
		if(!sindex.equals("")) {
		resultLabel.setText(obj.getAt(Integer.parseInt(sindex)).data+": at index "+sindex);
		
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
		 
			resultLabel.setText("found : "+obj.find(Integer.parseInt(stext)).data);
		
		
		}
		else
			JOptionPane.showMessageDialog(null,"enter data");
		 clr();
	}
		
	public void sort(ActionEvent e) {
	
		obj.insertionSort();
		display.setText(obj.traverseForward());
		 clr();
	}


}
