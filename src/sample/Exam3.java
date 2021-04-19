package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Exam3 extends Exam2{

    public int score3;

    static String string3_1_1 = "выражении";
    static String string3_1_2 = "классе";
    static String string3_1_3 = "функции";
    static String string3_2_1 = "сдвиг";
    static String string3_2_2 = "реляционный";
    static String string3_2_3 = "равенство";
    static String string3_3_1 = "да";
    static String string3_3_2 = "нет";

    @FXML
    private Button back_button;

    @FXML
    private ComboBox<String> first_combobox;

    @FXML
    private ComboBox<String> second_combobox;

    @FXML
    private ComboBox<String> third_combobox;

    @FXML
    private Button check_button;

    @FXML
    private TextField change3_1_1;

    @FXML
    private TextField change3_1_2;

    @FXML
    private TextField change3_1_3;

    @FXML
    private TextField change3_2_1;

    @FXML
    private TextField change3_2_2;

    @FXML
    private TextField change3_2_3;

    @FXML
    private TextField change3_3_1;

    @FXML
    private TextField change3_3_2;

    @FXML
    private Button button1_1;

    @FXML
    private Button button2_1;

    @FXML
    private Button button3_1;

    @FXML
    private Button button1_4;

    @FXML
    private TextField answer3_1_4;

    @FXML
    private TextField answer3_2_4;

    @FXML
    private Button button2_4;

    @FXML
    private Button button3_4;

    @FXML
    private TextField answer3_3_4;

    @FXML
    private Button button3_1_2;

    @FXML
    private Button button3_1_3;

    @FXML
    private Button button3_2_2;

    @FXML
    private Button button3_2_3;

    @FXML
    private Button button3_3_2;

    @FXML
    private Label mark_label;

    @FXML
    private Button end_button;

    @FXML
    void initialize() {
        setComboBox(1);
        setComboBox(2);
        setComboBox(3);
        back_button.setDisable(true);
        clickLessons();
        rightanswer();
        end();
    }
    void end(){
        end_button.setOnAction(e->{
            end_button.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/document.fxml"));
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
    @Override
    void clickLessons(){
        back_button.setOnAction(event->
        {
            back_button.getScene().getWindow().hide();
        });
    }
    @Override
    void rightanswer(){
        check_button.setOnAction(event -> {
            try {
                back_button.setDisable(false);
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet;

                resultSet = statement.executeQuery("SELECT answers FROM lessons WHERE answers = \'"
                        + first_combobox.getValue() + "\'");
                if (resultSet.next()) {
                    score3 = score3 + 10;
                }

                resultSet = statement.executeQuery("SELECT answers FROM lessons WHERE answers = \'"
                        + second_combobox.getValue() + "\'");
                if (resultSet.next()) {
                    score3 = score3 + 20;
                }

                resultSet = statement.executeQuery("SELECT answers FROM lessons WHERE answers = \'"
                        + third_combobox.getValue() + "\'");
                if (resultSet.next()) {
                    score3 = score3 + 10;
                }
                score = score + score3;
                mark_label.setText(String.valueOf(score3));
                String resultUpdate = "UPDATE everyone SET result =\'" + String.valueOf(score) + "\'"
                        + " WHERE password =\'" + Result.getResult() + "\'";
                statement.executeUpdate(resultUpdate);
                score3 = 0;
                score = 0;
                check_button.setDisable(true);
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    void setComboBox(int combobox_number){

        ObservableList<String> first = FXCollections.observableArrayList(string3_1_1,string3_1_2,string3_1_3);
        first_combobox.setItems(first);
        first_combobox.setValue(string3_1_2);

        ObservableList<String> second = FXCollections.observableArrayList(string3_2_1,string3_2_2,string3_2_3);
        second_combobox.setItems(second);
        second_combobox.setValue(string3_2_1);

        ObservableList<String> third = FXCollections.observableArrayList(string3_3_1,string3_3_2);
        third_combobox.setItems(third);
        third_combobox.setValue(string3_3_1);

        if(combobox_number == 1) {
            button1_1.setDisable(true);
            button3_1_2.setDisable(true);
            button3_1_3.setDisable(true);
            button1_4.setDisable(true);
            change3_1_1.setDisable(true);
            change3_1_2.setDisable(true);
            change3_1_3.setDisable(true);
            answer3_1_4.setDisable(true);
            try {
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM teacher WHERE password = \'" + Result.getResult() + "\'");
                if (resultSet.next()) {
                    button1_1.setDisable(false);
                    button3_1_2.setDisable(false);
                    button3_1_3.setDisable(false);
                    button1_4.setDisable(false);
                    change3_1_1.setDisable(false);
                    change3_1_2.setDisable(false);
                    change3_1_3.setDisable(false);
                    answer3_1_4.setDisable(false);
                    button1_1.setOnAction(e -> {
                        string3_1_1 = change3_1_1.getText();
                        ObservableList<String> firstchange = FXCollections.observableArrayList(string3_1_1, string3_1_2, string3_1_3);
                        first_combobox.setItems(firstchange);
                        first_combobox.setValue(string3_1_1);
                    });
                    button3_1_2.setOnAction(e -> {
                        string3_1_2 = change3_1_2.getText();
                        ObservableList<String> firstchange = FXCollections.observableArrayList(string3_1_1, string3_1_2, string3_1_3);
                        first_combobox.setItems(firstchange);
                        first_combobox.setValue(string3_1_1);
                    });
                    button3_1_3.setOnAction(e -> {
                        string3_1_3 = change3_1_3.getText();
                        ObservableList<String> firstchange = FXCollections.observableArrayList(string3_1_1, string3_1_2, string3_1_3);
                        first_combobox.setItems(firstchange);
                        first_combobox.setValue(string3_1_1);
                    });
                    button1_4.setOnAction(e -> {
                        try {
                            statement.executeUpdate("UPDATE lessons SET answers = \'" + answer3_1_4.getText() + "\'" + " WHERE id = 7");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });
                }
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        }
        if(combobox_number == 2) {
            button2_1.setDisable(true);
            button3_2_2.setDisable(true);
            button3_2_3.setDisable(true);
            button2_4.setDisable(true);
            change3_2_1.setDisable(true);
            change3_2_2.setDisable(true);
            change3_2_3.setDisable(true);
            answer3_2_4.setDisable(true);
            try {
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM teacher WHERE password = \'" + Result.getResult() + "\'");
                if (resultSet.next()) {
                    button2_1.setDisable(false);
                    button3_2_2.setDisable(false);
                    button3_2_3.setDisable(false);
                    button2_4.setDisable(false);
                    change3_2_1.setDisable(false);
                    change3_2_2.setDisable(false);
                    change3_2_3.setDisable(false);
                    answer3_2_4.setDisable(false);
                    button2_1.setOnAction(e -> {
                        string3_2_1 = change3_2_1.getText();
                        ObservableList<String> secondchange = FXCollections.observableArrayList(string3_2_1, string3_2_2, string3_2_3);
                        second_combobox.setItems(secondchange);
                        second_combobox.setValue(string3_2_3);
                    });
                    button3_2_2.setOnAction(e -> {
                        string3_2_2 = change3_2_2.getText();
                        ObservableList<String> secondchange = FXCollections.observableArrayList(string3_2_1, string3_2_2, string3_2_3);
                        second_combobox.setItems(secondchange);
                        second_combobox.setValue(string3_2_3);
                    });
                    button3_2_3.setOnAction(e -> {
                        string3_2_3 = change3_2_3.getText();
                        ObservableList<String> secondchange = FXCollections.observableArrayList(string3_2_1, string3_2_2, string3_2_3);
                        second_combobox.setItems(secondchange);
                        second_combobox.setValue(string3_2_3);
                    });
                    button2_4.setOnAction(e -> {
                        try {
                            statement.executeUpdate("UPDATE lessons SET answers = \'" + answer3_2_4.getText() + "\'" + " WHERE id = 8");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });
                }
            }   catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        }
        if(combobox_number == 3) {
            button3_1.setDisable(true);
            button3_3_2.setDisable(true);
            button3_4.setDisable(true);
            change3_3_1.setDisable(true);
            change3_3_2.setDisable(true);
            answer3_3_4.setDisable(true);
            try {
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM teacher WHERE password = \'" + Result.getResult() + "\'");
                if (resultSet.next()) {
                    button3_1.setDisable(false);
                    button3_3_2.setDisable(false);
                    button3_4.setDisable(false);
                    change3_3_1.setDisable(false);
                    change3_3_2.setDisable(false);
                    answer3_3_4.setDisable(false);
                    button3_1.setOnAction(e -> {
                        string3_3_1 = change3_3_1.getText();
                        ObservableList<String> thirdchange = FXCollections.observableArrayList(string3_3_1, string3_3_2);
                        third_combobox.setItems(thirdchange);
                        third_combobox.setValue(string3_3_1);
                    });
                    button3_3_2.setOnAction(e -> {
                        string3_3_2 = change3_3_2.getText();
                        ObservableList<String> thirdchange = FXCollections.observableArrayList(string3_3_1, string3_3_2);
                        third_combobox.setItems(thirdchange);
                        third_combobox.setValue(string3_3_1);
                    });
                    button3_4.setOnAction(e -> {
                        try {
                            statement.executeUpdate("UPDATE lessons SET answers = \'" + answer3_3_4.getText() + "\'" + " WHERE id = 9");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });
                }
            }   catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}


