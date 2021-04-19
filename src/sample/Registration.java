package sample;

import java.io.IOException;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Registration {
    Main m = new Main();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField registr_surname;

    @FXML
    private Button regirstr_button;

    @FXML
    private Button back_button;

    @FXML
    private Label passlabel;

    @FXML
    private Label errorlabel;

    @FXML
    void initialize() {
        clickRegistr();
        clickMain();
    }

    private void clickRegistr() {
        regirstr_button.setOnAction(event -> {
            try {
                errorlabel.setText("");
                passlabel.setText("");
                Connection conn = m.getConnection();
                Statement statement = conn.createStatement();
                Statement statement1 = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM teacher WHERE surname = \'"
                        + registr_surname.getText() + "\'");
                ResultSet resultSet1 = statement1.executeQuery("SELECT password FROM everyone WHERE surname = \'"
                        + registr_surname.getText() + "\'");
                if(resultSet.next()){
                    String result = resultSet.getString("password");
                    errorlabel.setText("");
                    passlabel.setText(result);
                }
                if (resultSet1.next()) {
                    String result = resultSet1.getString("password");
                    errorlabel.setText("");
                    passlabel.setText(result);
                }
                else {
                    passlabel.setText("");
                    errorlabel.setText("Пользователь не найден или вы ничего не ввели");
                }
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        });
    }
    void clickMain() {
        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();
        });
    }
}
