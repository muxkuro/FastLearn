package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Exam2 extends Exam1{

    public int score2;

    static String string2_1_1 = "операнд";
    static String string2_1_2 = "переменную";
    static String string2_1_3 = "предыдущее состояние объекта";
    static String string2_2_1 = "возвращают ссылку на свой левый операнд";
    static String string2_2_2 = "ничего не возвращают";
    static String string2_2_3 = "вовзращают префиксную операцию";
    static String string2_3_1 = "сравнения";
    static String string2_3_2 = "сдвига";
    static String string2_3_3 = "арифмитические операторы";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private Label mark_label;

    @FXML
    private TextField change2_1_1;

    @FXML
    private TextField change2_1_2;

    @FXML
    private TextField change2_1_3;

    @FXML
    private TextField change2_2_1;

    @FXML
    private TextField change2_2_2;

    @FXML
    private TextField change2_2_3;

    @FXML
    private TextField change2_3_1;

    @FXML
    private TextField change2_3_2;

    @FXML
    private TextField change2_3_3;

    @FXML
    private Button button1_1;

    @FXML
    private Button button2_1;

    @FXML
    private Button button3_1;

    @FXML
    private Button button1_4;

    @FXML
    private Button button2_4;

    @FXML
    private Button button3_4;

    @FXML
    private TextField answer2_1_4;

    @FXML
    private TextField answer2_2_4;

    @FXML
    private TextField answer2_3_4;

    @FXML
    private Button button2_1_2;

    @FXML
    private Button button2_1_3;

    @FXML
    private Button button2_2_2;

    @FXML
    private Button button2_2_3;

    @FXML
    private Button button2_3_2;

    @FXML
    private Button button2_3_3;


    @FXML
    void initialize() {
        setComboBox(1);
        setComboBox(2);
        setComboBox(3);
        back_button.setDisable(true);
        clickLessons();
        rightanswer();
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
                    score2 = score2 + 10;
                }

                resultSet = statement.executeQuery("SELECT answers FROM lessons WHERE answers = \'"
                        + second_combobox.getValue() + "\'");
                if (resultSet.next()) {
                    score2 = score2 + 10;
                }

                resultSet = statement.executeQuery("SELECT answers FROM lessons WHERE answers = \'"
                        + third_combobox.getValue() + "\'");
                if (resultSet.next()) {
                    score2 = score2 + 10;
                }
                score = score + score2;
                mark_label.setText(String.valueOf(score2));
                score2 = 0;
                check_button.setDisable(true);
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    void setComboBox(int combobox_number) {
        ObservableList<String> first = FXCollections.observableArrayList(string2_1_1, string2_1_2, string2_1_3);
        first_combobox.setItems(first);
        first_combobox.setValue(string2_1_1);

        ObservableList<String> second = FXCollections.observableArrayList(string2_2_1,
                string2_2_2, string2_2_3);
        second_combobox.setItems(second);
        second_combobox.setValue(string2_2_3);

        ObservableList<String> third = FXCollections.observableArrayList(string2_3_1, string2_3_2, string2_3_3);
        third_combobox.setItems(third);
        third_combobox.setValue(string2_3_2);

        if (combobox_number == 1) {
            button1_1.setDisable(true);
            button2_1_2.setDisable(true);
            button2_1_3.setDisable(true);
            button1_4.setDisable(true);
            change2_1_1.setDisable(true);
            change2_1_2.setDisable(true);
            change2_1_3.setDisable(true);
            answer2_1_4.setDisable(true);
            try {
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM teacher WHERE password = \'" + Result.getResult() + "\'");
                if (resultSet.next()) {
                    button1_1.setDisable(false);
                    button2_1_2.setDisable(false);
                    button2_1_3.setDisable(false);
                    button1_4.setDisable(false);
                    change2_1_1.setDisable(false);
                    change2_1_2.setDisable(false);
                    change2_1_3.setDisable(false);
                    answer2_1_4.setDisable(false);
                    button1_1.setOnAction(e -> {
                        string2_1_1 = change2_1_1.getText();
                        ObservableList<String> firstchange = FXCollections.observableArrayList(string2_1_1, string2_1_2, string2_1_3);
                        first_combobox.setItems(firstchange);
                        first_combobox.setValue(string2_1_1);
                    });
                    button2_1_2.setOnAction(e -> {
                        string2_1_2 = change2_1_2.getText();
                        ObservableList<String> firstchange = FXCollections.observableArrayList(string2_1_1, string2_1_2, string2_1_3);
                        first_combobox.setItems(firstchange);
                        first_combobox.setValue(string2_1_1);
                    });
                    button2_1_3.setOnAction(e -> {
                        string2_1_3 = change2_1_3.getText();
                        ObservableList<String> firstchange = FXCollections.observableArrayList(string2_1_1, string2_1_2, string2_1_3);
                        first_combobox.setItems(firstchange);
                        first_combobox.setValue(string2_1_1);
                    });
                    button1_4.setOnAction(e -> {
                        try {
                            statement.executeUpdate("UPDATE lessons SET answers = \'" + answer2_1_4.getText() + "\'" + " WHERE id = 4");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });

                }
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }

        }
        if (combobox_number == 2) {
            button2_1.setDisable(true);
            button2_2_2.setDisable(true);
            button2_2_3.setDisable(true);
            button2_4.setDisable(true);
            change2_2_1.setDisable(true);
            change2_2_2.setDisable(true);
            change2_2_3.setDisable(true);
            answer2_2_4.setDisable(true);
            try {
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM teacher WHERE password = \'" + Result.getResult() + "\'");
                if (resultSet.next()) {
                    button2_1.setDisable(false);
                    button2_2_2.setDisable(false);
                    button2_2_3.setDisable(false);
                    button2_4.setDisable(false);
                    change2_2_1.setDisable(false);
                    change2_2_2.setDisable(false);
                    change2_2_3.setDisable(false);
                    answer2_2_4.setDisable(false);
                    button2_1.setOnAction(e -> {
                        string2_2_1 = change2_2_1.getText();
                        ObservableList<String> secondchange = FXCollections.observableArrayList(string2_2_1,string2_2_2,string2_2_3);
                        second_combobox.setItems(secondchange);
                        second_combobox.setValue(string2_2_3);
                    });
                    button2_2_2.setOnAction(e -> {
                        string2_2_2 = change2_2_2.getText();
                        ObservableList<String> secondchange = FXCollections.observableArrayList(string2_2_1,string2_2_2,string2_2_3);
                        second_combobox.setItems(secondchange);
                        second_combobox.setValue(string2_2_3);
                    });
                    button2_2_3.setOnAction(e -> {
                        string2_2_3 = change2_2_3.getText();
                        ObservableList<String> secondchange = FXCollections.observableArrayList(string2_2_1,string2_2_2,string2_2_3);
                        second_combobox.setItems(secondchange);
                        second_combobox.setValue(string2_2_3);
                    });
                    button2_4.setOnAction(e -> {
                        try {
                            statement.executeUpdate("UPDATE lessons SET answers = \'" + answer2_2_4.getText() + "\'" + " WHERE id = 5");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });
                }
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        }
        if (combobox_number == 3) {
            button3_1.setDisable(true);
            button2_3_2.setDisable(true);
            button2_3_3.setDisable(true);
            button3_4.setDisable(true);
            change2_3_1.setDisable(true);
            change2_3_2.setDisable(true);
            change2_3_3.setDisable(true);
            answer2_3_4.setDisable(true);
            try {
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM teacher WHERE password = \'" + Result.getResult() + "\'");
                if (resultSet.next()) {
                    button3_1.setDisable(false);
                    button2_3_2.setDisable(false);
                    button2_3_3.setDisable(false);
                    button3_4.setDisable(false);
                    change2_3_1.setDisable(false);
                    change2_3_2.setDisable(false);
                    change2_3_3.setDisable(false);
                    answer2_3_4.setDisable(false);
                    button3_1.setOnAction(e -> {
                        string2_3_1 = change2_3_1.getText();
                        ObservableList<String> thirdchange = FXCollections.observableArrayList(string2_3_1,string2_3_2,string2_3_3);
                        third_combobox.setItems(thirdchange);
                        third_combobox.setValue(string2_3_2);
                    });
                    button2_3_2.setOnAction(e -> {
                        string2_3_2 = change2_3_2.getText();
                        ObservableList<String> thirdchange = FXCollections.observableArrayList(string2_3_1,string2_3_2,string2_3_3);
                        third_combobox.setItems(thirdchange);
                        third_combobox.setValue(string2_3_2);
                    });
                    button2_3_3.setOnAction(e -> {
                        string2_3_3 = change2_3_3.getText();
                        ObservableList<String> thirdchange = FXCollections.observableArrayList(string2_3_1,string2_3_2,string2_3_3);
                        third_combobox.setItems(thirdchange);
                        third_combobox.setValue(string2_3_2);
                    });
                    button3_4.setOnAction(e -> {
                        try {
                            statement.executeUpdate("UPDATE lessons SET answers = \'" + answer2_3_4.getText() + "\'" + " WHERE id = 6");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });
                }
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        }
    }}

