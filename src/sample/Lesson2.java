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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Lesson2 extends Lesson1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea lessonarea;

    @FXML
    private Button lessons_button;

    @FXML
    private Button exam_button;

    @FXML
    private Button change_button;

    @FXML
    void initialize() {
        change_button.setDisable(true);
        setLessonText();
        clickLessons();
        clickExam();
    }
    @Override
    void setLessonText() {
        try {
            Connection conn = Main.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT lesson FROM lessons WHERE id = 4");
            if (resultSet.next()) {
                String lesson2 = resultSet.getString("lesson");
                lessonarea.setText(lesson2);
                ResultSet resultSet1 = statement.executeQuery("SELECT password FROM teacher WHERE password = \'" + Result.getResult() + "\'");
                if(resultSet1.next()) {
                    change_button.setDisable(false);
                    lessonarea.setEditable(true);
                    change_button.setOnAction(e -> {
                        try {
                            statement.executeUpdate("UPDATE lessons SET lesson = \'" + lessonarea.getText() + "\'" + "WHERE id = 4");
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    });
                }
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    void clickLessons() {
        lessons_button.setOnAction(event -> {
            lessons_button.getScene().getWindow().hide();
        });
    }
    @Override
    void clickExam(){
        exam_button.setOnAction(event->{
            exam_button.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Exam2.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
