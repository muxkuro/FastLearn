package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class Teacher {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button lesson2_button;

    @FXML
    private Button lesson1_button;

    @FXML
    private Button lesson3_button;

    @FXML
    private CheckBox checkbox_1;

    @FXML
    private CheckBox checkbox_2;

    @FXML
    private CheckBox checkbox_3;

    @FXML
    private Button info_button;

    @FXML
    void initialize() {
        lesson1_button.setDisable(true);
        lesson2_button.setDisable(true);
        lesson3_button.setDisable(true);
        setEnabled(1);
        setEnabled(2);
        setEnabled(3);
        clickLesson(1);
        clickLesson(2);
        clickLesson(3);
        info();
    }
    void info(){
        info_button.setOnAction(e->{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/StudentInfo.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
    void setEnabled(int number){
        if(number == 1) {
            checkbox_1.setOnAction(e -> {
                if (checkbox_1.isSelected()) {
                    try {
                        Connection conn = conn = Main.getConnection();
                        Statement statement = conn.createStatement();
                        ResultSet resultSet;
                        resultSet = statement.executeQuery("SELECT button1 FROM lessons");
                        if (resultSet.next()) {
                            statement.executeUpdate("UPDATE lessons SET button1 = 1");
                            lesson1_button.setDisable(false);
                        }
                    } catch (SQLException | IOException throwables) {
                        throwables.printStackTrace();
                    }

                }
                else{
                    try {
                        Connection conn = conn = Main.getConnection();
                        Statement statement = conn.createStatement();
                        ResultSet resultSet;
                        resultSet = statement.executeQuery("SELECT button1 FROM lessons");
                        if (resultSet.next()) {
                            statement.executeUpdate("UPDATE lessons SET button1 = 0");
                            lesson1_button.setDisable(true);
                        }
                    } catch (SQLException | IOException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });
        }
        if(number == 2){
            checkbox_2.setOnAction(e -> {
                if (checkbox_2.isSelected()) {
                    try {
                        Connection conn = conn = Main.getConnection();
                        Statement statement = conn.createStatement();
                        ResultSet resultSet;
                        resultSet = statement.executeQuery("SELECT button2 FROM lessons");
                        if (resultSet.next()) {
                            statement.executeUpdate("UPDATE lessons SET button2 = 1");
                            lesson2_button.setDisable(false);
                        }
                    } catch (SQLException | IOException throwables) {
                        throwables.printStackTrace();
                    }

                }
                else{
                    try {
                        Connection conn = conn = Main.getConnection();
                        Statement statement = conn.createStatement();
                        ResultSet resultSet;
                        resultSet = statement.executeQuery("SELECT button2 FROM lessons");
                        if (resultSet.next()) {
                            statement.executeUpdate("UPDATE lessons SET button2 = 0");
                            lesson2_button.setDisable(true);
                        }
                    } catch (SQLException | IOException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });
        }
        if(number == 3){
            checkbox_3.setOnAction(e -> {
                if (checkbox_3.isSelected()) {
                    try {
                        Connection conn = conn = Main.getConnection();
                        Statement statement = conn.createStatement();
                        ResultSet resultSet;
                        resultSet = statement.executeQuery("SELECT button3 FROM lessons");
                        if (resultSet.next()) {
                            statement.executeUpdate("UPDATE lessons SET button3 = 1");
                            lesson3_button.setDisable(false);
                        }
                    } catch (SQLException | IOException throwables) {
                        throwables.printStackTrace();
                    }

                }
                else{
                    try {
                        Connection conn = conn = Main.getConnection();
                        Statement statement = conn.createStatement();
                        ResultSet resultSet;
                        resultSet = statement.executeQuery("SELECT button3 FROM lessons");
                        if (resultSet.next()) {
                            statement.executeUpdate("UPDATE lessons SET button3 = 0");
                            lesson3_button.setDisable(true);
                        }
                    } catch (SQLException | IOException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });
        }
    }
    void clickLesson(int number) {
        if (number == 1) {
            lesson1_button.setOnAction(event -> {
                try {
                    lesson1_button.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/lesson1.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        if (number == 2) {
            lesson2_button.setOnAction(event -> {
                lesson2_button.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/lesson2.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.showAndWait();
            });
        }
        if (number == 3) {
            lesson3_button.setOnAction(event -> {
                lesson3_button.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/lesson3.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.showAndWait();
            });
        }
    }
}
