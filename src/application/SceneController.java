package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

	Parent root;
	Stage stage;
	Scene scene;
	
	public void switchToArray(ActionEvent event)throws IOException {
	
			root = FXMLLoader.load(getClass().getResource("array.fxml"));
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Array");
			stage.show();
	}
	
	public void switchToLinkedList(ActionEvent event)throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("linklist.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Linked List");
		stage.show();
}
	
public void switchToQueue(ActionEvent event)throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("queue.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Queue");
		stage.show();
}


public void switchToStack(ActionEvent event)throws IOException {
	
	root = FXMLLoader.load(getClass().getResource("stack.fxml"));
	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("Stack");
	stage.show();
}

public void switchToTree(ActionEvent event)throws IOException {
	
	root = FXMLLoader.load(getClass().getResource("tree.fxml"));
	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("Tree");
	stage.show();
}
	

public void switchToGraph(ActionEvent event)throws IOException {
	
	root = FXMLLoader.load(getClass().getResource("graph.fxml"));
	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("Graph");
	stage.show();
}

}
