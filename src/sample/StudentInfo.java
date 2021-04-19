package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StudentInfo {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button lessons_button;

    @FXML
    private Label counter_label;

    @FXML
    private Label mark_label;

    @FXML
    private Label surname_label;

    @FXML
    private TextField surname_field;

    @FXML
    private Button find_button;

    @FXML
    void initialize() {
        getStudent();
        clickLessons();
    }
    void clickLessons(){
        lessons_button.setOnAction(event->
        {
            lessons_button.getScene().getWindow().hide();
        });
    }
    void getStudent(){
        find_button.setOnAction(e->{
            try {
                Connection conn = Main.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT*FROM everyone WHERE surname =" +
                        "\'" + surname_field.getText() + "\'");
                if(resultSet.next()) {
                    String mark = resultSet.getString("result");
                    String surname = resultSet.getString("surname");
                    String session = resultSet.getString("session");
                    mark_label.setText(mark);
                    surname_label.setText(surname);
                    counter_label.setText(session);
                }
                else {
                    surname_label.setText("");
                    mark_label.setText("");
                    mark_label.setText("Нету такого студента");
                    surname_label.setText("Нету такого студента");
                }
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}
