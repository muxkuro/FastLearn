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


public class Exam1 extends Lesson2 {

    static int score;
    public int score1 = 0;
    static String string1_1 = "класса";
    static String string1_2 = "функции";
    static String string1_3 = "переменной";
    static String string2_1 = "операнды пользовательского типа";
    static String string2_2 = "которые уже определены в С++";
    static String string2_3 = "оператор";
    static String string3_1 = "оператор";
    static String string3_2 = "функция";
    static String string3_3 = "тип данных";

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
    private TextField change1_1;

    @FXML
    private TextField change1_2;

    @FXML
    private TextField change1_3;

    @FXML
    private TextField change2_1;

    @FXML
    private TextField change2_2;

    @FXML
    private TextField change2_3;

    @FXML
    private TextField change3_1;

    @FXML
    private TextField change3_2;

    @FXML
    private TextField change3_3;

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
    private TextField answer1_4;

    @FXML
    private TextField answer2_4;

    @FXML
    private TextField answer3_4;

    @FXML
    private Button button1_2;

    @FXML
    private Button button1_3;

    @FXML
    private Button button2_2;

    @FXML
    private Button button2_3;

    @FXML
    private Button button3_2;

    @FXML
    private Button button3_3;


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
    void clickLessons() {
        back_button.setOnAction(event ->
        {
            back_button.getScene().getWindow().hide();
        });
    }

    void rightanswer() {
        check_button.setOnAction(event -> {
            try {
                back_button.setDisable(false);
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet;

                resultSet = statement.executeQuery("SELECT answers FROM lessons WHERE answers = \'"
                        + first_combobox.getValue() + "\'");
                if (resultSet.next()) {
                    score1 = score1 + 10;
                }

                resultSet = statement.executeQuery("SELECT answers FROM lessons WHERE answers = \'"
                        + second_combobox.getValue() + "\'");
                if (resultSet.next()) {
                    score1 = score1 + 10;
                }

                resultSet = statement.executeQuery("SELECT answers FROM lessons WHERE answers = \'"
                        + third_combobox.getValue() + "\'");
                if (resultSet.next()) {
                    score1 = score1 + 10;
                }
                mark_label.setText(String.valueOf(score1));
                score = score1;
                score1 = 0;
                check_button.setDisable(true);
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    void setComboBox(int combobox_number) {
        ObservableList<String> first = FXCollections.observableArrayList(string1_1, string1_2, string1_3);
        first_combobox.setItems(first);
        first_combobox.setValue(string1_1);

        ObservableList<String> second = FXCollections.observableArrayList(string2_1,
                string2_2, string2_3);
        second_combobox.setItems(second);
        second_combobox.setValue(string3_3);

        ObservableList<String> third = FXCollections.observableArrayList(string3_1, string3_2, string3_3);
        third_combobox.setItems(third);
        third_combobox.setValue(string3_1);

        if (combobox_number == 1) {
            button1_1.setDisable(true);
            button1_2.setDisable(true);
            button1_3.setDisable(true);
            button1_4.setDisable(true);
            change1_1.setDisable(true);
            change1_2.setDisable(true);
            change1_3.setDisable(true);
            answer1_4.setDisable(true);
            try {
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM teacher WHERE password = \'" + Result.getResult() + "\'");
                if (resultSet.next()) {
                    button1_1.setDisable(false);
                    button1_2.setDisable(false);
                    button1_3.setDisable(false);
                    button1_4.setDisable(false);
                    change1_1.setDisable(false);
                    change1_2.setDisable(false);
                    change1_3.setDisable(false);
                    answer1_4.setDisable(false);
                    button1_1.setOnAction(e -> {
                        string1_1 = change1_1.getText();
                        ObservableList<String> firstchange = FXCollections.observableArrayList(string1_1, string1_2, string1_3);
                        first_combobox.setItems(firstchange);
                        first_combobox.setValue(string1_2);
                    });
                    button1_2.setOnAction(e->{
                        string1_2 = change1_2.getText();
                        ObservableList<String> firstchange = FXCollections.observableArrayList(string1_1, string1_2, string1_3);
                        first_combobox.setItems(firstchange);
                        first_combobox.setValue(string1_2);
                    });
                    button1_3.setOnAction(e->{
                        string1_3 = change1_3.getText();
                        ObservableList<String> firstchange = FXCollections.observableArrayList(string1_1, string1_2, string1_3);
                        first_combobox.setItems(firstchange);
                        first_combobox.setValue(string1_2);
                    });
                    button1_4.setOnAction(e -> {
                        try {
                            statement.executeUpdate("UPDATE lessons SET answers = \'" + answer1_4.getText() + "\'" + " WHERE id = 1");
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
            button2_2.setDisable(true);
            button2_3.setDisable(true);
            button2_4.setDisable(true);
            change2_1.setDisable(true);
            change2_2.setDisable(true);
            change2_3.setDisable(true);
            answer2_4.setDisable(true);
            try {
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM teacher WHERE password = \'" + Result.getResult() + "\'");
                if (resultSet.next()) {
                    button2_1.setDisable(false);
                    button2_2.setDisable(false);
                    button2_3.setDisable(false);
                    button2_4.setDisable(false);
                    change2_1.setDisable(false);
                    change2_2.setDisable(false);
                    change2_3.setDisable(false);
                    answer2_4.setDisable(false);
                    button2_1.setOnAction(e -> {
                        string2_1 = change2_1.getText();
                        ObservableList<String> secondchange = FXCollections.observableArrayList(string2_1,string2_2,string2_3);
                        second_combobox.setItems(secondchange);
                        second_combobox.setValue(string2_3);
                    });
                    button2_3.setOnAction(e -> {
                        string2_2 = change2_2.getText();
                        ObservableList<String> secondchange = FXCollections.observableArrayList(string2_1,string2_2,string2_3);
                        second_combobox.setItems(secondchange);
                        second_combobox.setValue(string2_3);
                    });
                    button2_3.setOnAction(e -> {
                        string2_3 = change2_3.getText();
                        ObservableList<String> secondchange = FXCollections.observableArrayList(string2_1,string2_2,string2_3);
                        second_combobox.setItems(secondchange);
                        second_combobox.setValue(string2_3);
                    });
                    button2_4.setOnAction(e -> {
                        try {
                            statement.executeUpdate("UPDATE lessons SET answers = \'" + answer2_4.getText() + "\'" + " WHERE id = 2");
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
            button3_2.setDisable(true);
            button3_3.setDisable(true);
            button3_4.setDisable(true);
            change3_1.setDisable(true);
            change3_2.setDisable(true);
            change3_3.setDisable(true);
            answer3_4.setDisable(true);
            try {
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM teacher WHERE password = \'" + Result.getResult() + "\'");
                if (resultSet.next()) {
                    button3_1.setDisable(false);
                    button3_2.setDisable(false);
                    button3_3.setDisable(false);
                    button3_4.setDisable(false);
                    change3_1.setDisable(false);
                    change3_2.setDisable(false);
                    change3_3.setDisable(false);
                    answer3_4.setDisable(false);
                    button3_1.setOnAction(e -> {
                        string3_1 = change3_1.getText();
                        ObservableList<String> thirdchange = FXCollections.observableArrayList(string3_1,string3_2,string3_3);
                        third_combobox.setItems(thirdchange);
                        third_combobox.setValue(string3_2);
                    });
                    button3_2.setOnAction(e -> {
                        string3_2 = change3_2.getText();
                        ObservableList<String> thirdchange = FXCollections.observableArrayList(string3_1,string3_2,string3_3);
                        third_combobox.setItems(thirdchange);
                        third_combobox.setValue(string3_2);
                    });
                    button3_3.setOnAction(e -> {
                        string3_3 = change3_3.getText();
                        ObservableList<String> thirdchange = FXCollections.observableArrayList(string3_1,string3_2,string3_3);
                        third_combobox.setItems(thirdchange);
                        third_combobox.setValue(string3_2);
                    });
                    button3_4.setOnAction(e -> {
                        try {
                            statement.executeUpdate("UPDATE lessons SET answers = \'" + answer3_4.getText() + "\'" + " WHERE id = 3");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });
                }
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

