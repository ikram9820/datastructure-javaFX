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
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class TreeController {
	
	private Tree<Integer> t;
	

	@FXML private TextField text;
	@FXML private Label resultLabel, display;
	private String stext;
	@FXML private AnchorPane treePane;
	@FXML private Line line;
	@FXML Label nodeLabel;
	
	
	public TreeController() {
		t = new Tree<Integer>();
		treePane=new AnchorPane();
	

		
		
	}// end constructor
	
	
	public void switchToMain(ActionEvent event)throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("switchScene.fxml"));
		Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Data Structure");
		stage.show();
}//end switchTomain()
	
	public void add(ActionEvent e) {
		
			try {
			stext=text.getText();
		
		 t.insert(Integer.parseInt(stext));
		 treePane.getChildren().clear();
		 inorder(t.root);
	//	display.setText(t.display());	
			}catch(Exception NumberFormatException) {JOptionPane.showMessageDialog(null,"please input integer data type");}
			
		text.clear();
		
	}//end add()

	public void delete(ActionEvent e) {
		if(t.isEmpty())
			JOptionPane.showMessageDialog(null, "queue is empty");
		else {
			stext=text.getText();
			resultLabel.setText("deleted item = "+t.delete(Integer.parseInt(stext)));
			 treePane.getChildren().clear();
			 bft();
		}
		text.clear();
	}//end delete()
		
	public void search(ActionEvent e) {
		
		if(t.isEmpty())
			JOptionPane.showMessageDialog(null, "queue is empty");
		else {
			try {
				stext=text.getText();
				t.search(Integer.parseInt(stext));	
			}catch(Exception NumberFormatException) {JOptionPane.showMessageDialog(null,"please input integer data type");}
				
			text.clear();
		}//end else
	}//end search()
	//int i=0;
	
	
	public void bft() {
		Queue<node<Integer>> q= new Queue<node<Integer>>(10);
		q.enqueue(t.root);
		
		t.root.x=130;
		t.root.y=0;
		while(!q.isEmpty()) {
			node<Integer> temp=q.dequeue();
		
			drawNode(temp);
			
			if(temp.left!=null)
			q.enqueue(temp.left);
			if(temp.right!=null)
			q.enqueue(temp.right);
		}
	}
	
	public void inorder(node<Integer> curr) {
		if(curr==null)
			return;
		drawNode(curr);
		inorder(curr.left);
		inorder(curr.right);
	}
	
	public void drawNode(node<Integer>curr) {
		double X=curr.x,Y=curr.y,x=25,y=60;

		if(curr.isLeft)
			setNode(curr,curr.x,curr.y);
		else
			setNode(curr,curr.x-10,curr.y);
		if(curr.left!=null) {
			lineDraw(X,Y,-x,y);
			curr.left.x=X-x;
			curr.left.y=Y+y;
		}
		if(curr.right!=null) {
			lineDraw(X,Y,x,y);
			curr.right.x=X+x;
			curr.right.y=Y+y;
		}
	}//end drawNode()
	
	public void lineDraw( double X,double Y,double x, double y) {
		line=new Line();
		line.setStartX(X);
		line.setStartY(Y+20);
		double endx=X+x;
		double endy=Y+y;
		line.setEndX(endx);
		line.setEndY(endy);
		treePane.getChildren().add(line);

	}//lineDraw()	
    
	public void setNode(node<Integer> data,double X,double Y) {
		nodeLabel=new Label();
		nodeLabel.setText(""+data.data);
		nodeLabel.setLayoutX(X);
		nodeLabel.setLayoutY(Y);
		treePane.getChildren().add(nodeLabel);
	}
}//end TreeController