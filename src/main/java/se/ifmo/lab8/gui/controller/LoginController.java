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
import se.ifmo.lab8.configuration.RuntimeConfiguration;
import se.ifmo.lab8.database.model.User;
import se.ifmo.lab8.database.service.UserService;
import se.ifmo.lab8.gui.stage.StageHandler;
import se.ifmo.lab8.localization.Localization;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    private final StageHandler stageHandler;
    private final Localization localization;

    @FXML // fx:id="authorize"
    private Button authorize; // Value injected by FXMLLoader

    @FXML
    private Text error_text;

    @FXML // fx:id="login"
    private TextField login; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader

    @FXML // fx:id="register"
    private Button register; // Value injected by FXMLLoader

    @FXML
    void login(ActionEvent event) {
        sendLoginRequest(login.getText(), password.getText());
    }

    @SneakyThrows
    private void sendLoginRequest(String username, String password) {
        try {
            RuntimeConfiguration.setUsername(username);

            if (!userService.checkAuth(username, password)) {
                error_text.setText(localization.get("error.incorrectUsernameOrPassword"));
                return;
            }

            Optional<User> optionalUser = userService.findByUsername(username);
            RuntimeConfiguration.setUser(optionalUser);

            error_text.setText("");
            stageHandler.showWorkspaceScene();
        } catch (Exception e) {
            error_text.setText("Error! " + e.getMessage());
        }
    }

    @FXML
    void handleRegister(ActionEvent event) {
        try {
            stageHandler.showRegisterScene();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


