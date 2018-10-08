/*
Попытка сделать интерфейс на JavaFX
Элементы:
    GridPane(столбцов 3, строк .., столбцы с шириной 33%)
        HBox (занимает 3 столбца)
            TextField, Button, Label
            пишу текст в TextField, жму Button,  текст из TextField появляется в Label
        
        Кнопки, каждая в своей ячейке, кнопка растянута на всю ширину/высоту ячейки
        Bt0, Bt1, Bt2
        Bt3, Bt4, Bt5
        Bt6, Bt7, Bt8
        Bt9
        
Материал:
    https://habr.com/post/305282/
    https://metanit.com/java/javafx/3.8.php
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.HPos;
import javafx.geometry.VPos;

import javafx.stage.Stage;

/**
 *
 * @author Gerasimov V. Gerasim
 */


public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label lInfo = new Label("текст на метке");
              lInfo.setBorder(new Border(new BorderStroke(Color.BLACK, 
                                    BorderStrokeStyle.SOLID,
                                        new CornerRadii(3),
                                            BorderWidths.DEFAULT)));
        TextField eInfo = new TextField("New info");
        Button btInfo = new Button("Info");
        btInfo.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String s = "!";
                s = eInfo.getText();
                lInfo.setText(s);
                primaryStage.setTitle(s);
                System.out.println(s);
            }
        });
        
        //описываю заголовок
        HBox header = new HBox();
        header.setSpacing(10);
        header.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"+
                        "-fx-border-width: 2;" + "-fx-border-insets: 5;"+
                        "-fx-border-radius: 5;" + "-fx-border-color: gray;");

        header.getChildren().add(eInfo);
        header.getChildren().add(btInfo);
        header.getChildren().add(lInfo);
        
        GridPane grid = new GridPane();
 
        // определения столбцов
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(33);
        grid.getColumnConstraints().add(column1);
         
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(33);
        grid.getColumnConstraints().add(column2);
         
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(33);
        grid.getColumnConstraints().add(column3);
        
        
        grid.setPadding(new Insets(8));//расстояние от GridPanel до вмещающего его объекта (в данном случае окно приложения)
        //расстояния между ячейками
        grid.setHgap(8);
        grid.setVgap(8);
        
        grid.add(header, 0, 0, 3, 1);//херед помещаю с нулевой ячейки, занимает 3 столбца и одну строку
        grid.setGridLinesVisible(true);//полезно для отладки
        Button[] aButtons = new Button[10];
        int br = 0;
        int bc = 1;
        int mbr = 3;
        for (int i = 0; i<aButtons.length; i++){
            aButtons[i] = new Button("#"+i);
            aButtons[i].setMaxWidth(Double.MAX_VALUE);
            aButtons[i].setMaxHeight(Double.MAX_VALUE);
            GridPane.setHgrow(aButtons[i], Priority.ALWAYS);
            GridPane.setVgrow(aButtons[i], Priority.ALWAYS);
            grid.add(aButtons[i],br,bc);
            if (++br >= mbr) {br = 0; bc++;}
        }        

        /*
        Эксперименты:
        
        FlowPane root = new FlowPane();
        root.setOrientation(Orientation.VERTICAL);
        root.setVgap(8);
        root.setHgap(8);
        
        //root.getChildren().add(header);
        //root.getChildren().add(btInfo);
        //root.getChildren().add(lInfo);
        
        Button[] aButtons = new Button[10];
        for (int i = 0; i<aButtons.length; i++){
            aButtons[i] = new Button("#"+i);
            root.getChildren().add(aButtons[i]);
        }
        */
        /*
        FlowPane root = new FlowPane();
        root.getChildren().add(eInfo);
        root.getChildren().add(btInfo);
        root.getChildren().add(lInfo);
        root.setVgap(8);
        root.setHgap(8);
        */
        Scene scene = new Scene(grid, 500, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */

public static void main(String[] args) {
        launch(args);
    }
    
}
