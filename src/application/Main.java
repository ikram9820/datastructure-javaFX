package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage arg0) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("switchScene.fxml"));
			Scene scene = new Scene(root,600,400);
		
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			arg0.setScene(scene);
			arg0.setTitle("Data Structure");
			Image img =new Image("dsa.png");
			arg0.getIcons().add(img);
			arg0.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
