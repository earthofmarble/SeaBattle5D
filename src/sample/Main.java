package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("SeaBattle5D");
        primaryStage.setScene(new Scene(root, 1200, 900));
        primaryStage.show();



//        Field player1 = new Field(15,15, "Player ONE");
//        Field player2 = new Field(15,15, "Player TWO");
//
//        player1.createFields();
//        player2.createFields();
//
//            player1.createShips();
//            player2.createShips();
///раскомментить
//            boolean temp1=true;
//            boolean temp2=true;
//            while (temp1 && temp2) {
//                temp1=player1.shooting(player1, player2);
//                temp2=player2.shooting(player2, player1);
//            }
//            if (!temp1){
//                System.out.println("выиграл " + player1.name);
//            }
//            if (!temp2){
//                System.out.println("выиграл " + player2.name);
//            }
    }


    public static void main(String[] args) {
        launch(args);

    }
}
