package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;


public class Main extends Application {

    static String resultpass;
    static int counter = 0;
    Result r = new Result(resultpass);
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()) {
                Statement statement = conn.createStatement();
                System.out.println("Connection to FastLearn DB is successful!");
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("FastLearn");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Main.class, new String[0]);
    }
    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("C:\\Users\\Kuro\\Desktop\\" +
                "Kursovaya rabota\\src\\sample\\database.properties.txt"))) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button mainregistr_button;


    @FXML
    private void initialize() {
        clickRegistr();
        clickLog();
    }
    @FXML
    private void clickRegistr(){
        mainregistr_button.setOnAction(event -> {
            mainregistr_button.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/registration.fxml"));
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
    private void clickLog() {
        loginButton.setOnAction(event -> {
            try {
                Connection conn = getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT password FROM everyone WHERE password = \'"
                        + password_field.getText() + "\'");
                if (resultSet.next()) {
                    resultpass = resultSet.getString("password");
                    r.setResult(resultpass);
                    statement.executeUpdate("UPDATE everyone SET session = session + 1 WHERE password = \'"
                            + password_field.getText() + "\'");
                    loginButton.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/welcome.fxml"));
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
                }
                ResultSet resultSet1 = statement.executeQuery("SELECT password FROM teacher WHERE password = \'"
                        + password_field.getText() + "\'");
                if(resultSet1.next()){
                    resultpass = resultSet1.getString("password");
                    r.setResult(resultpass);
                    loginButton.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/wteacher.fxml"));
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
                }
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}

