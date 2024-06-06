package se.ifmo.lab8.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import se.ifmo.lab8.database.service.UserService;
import se.ifmo.lab8.gui.stage.StageHandler;
import se.ifmo.lab8.localization.Localization;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
public class RegisterController {
    private final UserService userService;
    private final StageHandler stageHandler;
    private final Localization localization;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="authorize1"
    private Button authorize1; // Value injected by FXMLLoader

    @FXML // fx:id="error_text"
    private Text error_text; // Value injected by FXMLLoader

    @FXML // fx:id="login"
    private TextField login; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader


    @FXML
    private PasswordField password_repeat;

    @FXML // fx:id="register"
    private Button register; // Value injected by FXMLLoader

    @SneakyThrows
    @FXML
    void backToLogin(ActionEvent event) {
        stageHandler.showLoginScene();
    }

    @FXML
    void handleRegister(ActionEvent event) {
        String username = this.login.getText();
        String password = this.password.getText();
        String passwordRepeat = this.password_repeat.getText();

        if (username.isBlank() || password.isBlank() || passwordRepeat.isBlank()) {
            error_text.setText(localization.get("error.fillAllFields"));
            return;
        }

        if (!password.equals(passwordRepeat)) {
            error_text.setText(localization.get("error.passwordMustMatch"));
            return;
        }

        if (password.length() <= 6) {
            error_text.setText(localization.get("error.passwordLengthMustBeMoreThanSix"));
            return;
        }

        if (userService.existsByUsername(username)) {
            error_text.setText(localization.get("error.usernameAlreadyExists"));
            return;
        }

        userService.register(username, password);

        error_text.setText("");

        stageHandler.showLoginScene();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert authorize1 != null : "fx:id=\"authorize1\" was not injected: check your FXML file 'register.fxml'.";
        assert error_text != null : "fx:id=\"error_text\" was not injected: check your FXML file 'register.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'register.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'register.fxml'.";
        assert register != null : "fx:id=\"register\" was not injected: check your FXML file 'register.fxml'.";
    }

}

