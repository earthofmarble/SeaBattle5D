package sample;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

public class Controller {
                            //ладно
    // ладно

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public TextField xField;

    @FXML
    public TextField yField;

    @FXML
    public Button shootButton;

    @FXML
    public TextArea textArea;


    @FXML
    public TableView<String[]> mainTablePlayer2;

    @FXML
    public TableView<String[]> addTablePlayer2;

    @FXML
    public TableView<String[]> addTablePlayer1;

    @FXML
    public TableView<String[]> mainTablePlayer1;


                                                // могло что-то поломаться, я много эксперементировал, но в последний раз всё работало(все что предполагалось быть рабочим :) )

    Field player1;
    Field player2;
    public void initialize() {
        removeTableHeader(mainTablePlayer1);
        removeTableHeader(mainTablePlayer2);
        removeTableHeader(addTablePlayer1);
        removeTableHeader(addTablePlayer2);
         player1 = new Field(15,15, "Player ONE");          //УКАЗЫВАЕМ РАЗМЕРЫ ПОЛЯ
         player2 = new Field(15,15, "Player TWO");             //

        player1.createFields();     //создаем поле игрока 1
        player2.createFields();     //создаем поле игрока 2

         // fillTableViews();             //это я убрал, потому что придется переписывать половину программы, я лучше сделаю что-нибудь интересное, чем буду бездумно переписывать методы под текстфилды и кнопки
                                //НО Я, ВСЁ-ТАКИ, СМОГ СДЕЛАТЬ ТАК ЧТОБ ВЫВОДИЛО МОИ МАССИВЫ В ТЕЙБЛВЬЮ
                //ЕСЛИ АККУРАТНО РАСКОММЕНТИРОВАТЬ ФИЛЛЫ И ЗАКОМЕНТИРОВАТЬ КОД НИЖЕ, МОЖНО УБЕДИТЬСЯ. ОСТАЛЬНОЕ НЕ ВАЖНО


        player1.createShips();          //игрок 1 расставляет корабли
        player2.createShips();          //игрок 2
       // fillTableViews();


            boolean temp1=true;
            boolean temp2=true;
            while (temp1 && temp2) {                    //пока есть корабли происходит перестрелка внутри методов есть свои методы, там все по правилам
                temp1=player1.shooting(player1, player2);
                temp2=player2.shooting(player2, player1);
            }
            if (!temp1){
                System.out.println("выиграл " + player1.name);      // если корабли закончились на ходу первого игрока соответственно проиграл второй
            }
            if (!temp2){                                            //и наоборот
                System.out.println("выиграл " + player2.name);
            }

        }

        public void fillTableViews(){ //стоило бы выделить ещеодин метод, но не сегодня, ненавижу таблицы и джава фх

            StackPane root = new StackPane();

            ObservableList<String[]> data = FXCollections.observableArrayList();
            ObservableList<String[]> data2 = FXCollections.observableArrayList();
            ObservableList<String[]> data3 = FXCollections.observableArrayList();
            ObservableList<String[]> data4 = FXCollections.observableArrayList();

            data.addAll(Arrays.asList(player1.firstField));
            for (int i = 0; i < player1.firstField[0].length; i++) {
                TableColumn tc = new TableColumn(player1.firstField[0][i]);
                final int colNo = i;
                tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                        return new SimpleStringProperty((p.getValue()[colNo]));
                    }
                });

                mainTablePlayer1.getColumns().add(tc);
            }
            mainTablePlayer1.setItems(data);



            data2.addAll(Arrays.asList(player2.firstField));

            for (int i = 0; i < player2.firstField[0].length; i++) {
                TableColumn tc = new TableColumn( player2.firstField[0][i]);
                final int colNo = i;
                tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                        return new SimpleStringProperty((p.getValue()[colNo]));
                    }
                });
                mainTablePlayer2.getColumns().add(tc);
            }
            mainTablePlayer2.setItems(data2);

            data3.addAll(Arrays.asList(player1.accessoryField));

            for (int i = 0; i < player1.accessoryField[0].length; i++) {
                TableColumn tc = new TableColumn(player1.accessoryField[0][i]);
                final int colNo = i;
                tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                        return new SimpleStringProperty((p.getValue()[colNo]));
                    }
                });

                addTablePlayer1.getColumns().add(tc);
            }

            addTablePlayer1.setItems(data3);

            data4.addAll(Arrays.asList(player2.accessoryField));

            for (int i = 0; i < player2.accessoryField[0].length; i++) {
                TableColumn tc = new TableColumn( player2.accessoryField[0][i]);
                final int colNo = i;
                tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                        return new SimpleStringProperty((p.getValue()[colNo]));
                    }
                });

                addTablePlayer2.getColumns().add(tc);
            }
            addTablePlayer2.setItems(data4);
        }           //заполняет тейблвью

        public void removeTableHeader(TableView tableView){
            tableView.widthProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> source, Number oldWidth, Number newWidth) {
                    Pane header = (Pane) tableView.lookup("TableHeaderRow");
                    if (header.isVisible()){
                        header.setMaxHeight(0);
                        header.setMinHeight(0);
                        header.setPrefHeight(0);
                        header.setVisible(false);
                    }
                }
            });
        }       //убирает хедеры тейблвью



}
