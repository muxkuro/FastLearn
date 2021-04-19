package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.text.html.ImageView;

public class DocumentControl {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label mark_label;

    @FXML
    private Label first_label;

    @FXML
    private Label second_label;

    @FXML
    private ImageView imageview;

    @FXML
    void initialize() {
        getMark();
    }

    void getMark() {
        try {
            Connection conn = Main.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT*FROM everyone WHERE password =" +
                    "\'" + Result.getResult() + "\'");
            if(resultSet.next()) {
                String mark = resultSet.getString("result");
                if(Integer.valueOf(mark) < 60){
                    first_label.setText("Не хорошо!");
                    second_label.setText("Вы провалили курс по теме: перегрузка операторов в С++. Удачи в следующий раз");
                }
                else{
                    first_label.setText("Поздравляем!");
                    second_label.setText("Вы прошли курс по теме: перегрузка операторов в С++. Молодец!");

                }
                mark_label.setText(mark);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
