package se.ifmo.lab8.gui.stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import se.ifmo.lab8.gui.loader.SpringFXMLLoader;

@Component @Scope("singleton")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class StageHandler
//класс отвечает за отображение окон приложения
{
    @NonFinal @Setter
            //Переменная, которая будет хранить ссылку на главное окно приложения (Stage). Она помечена как NonFinal для возможности установки значения в конструкторе и Setter для возможности изменения значения с помощью сеттера
    Stage primaryStage;
    ApplicationContext applicationContext;

    public StageHandler(ApplicationContext applicationContext) {
        showLoginScene();
        //отображения сцены входа в систему при создании объекта
        this.applicationContext = applicationContext;
    }

    public void showRegisterScene()
    //отображение окна регистрации
    {
        try {
            SpringFXMLLoader fxmlLoader = new SpringFXMLLoader(applicationContext);
            FXMLLoader loader = fxmlLoader.getLoader(("/register.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Register");
            primaryStage.show();
        } catch (Exception ex) {
            log.warn(ex.getMessage());
        }
    }

    public void showLoginScene()
    //отображение окно логина
    {
        try {
            SpringFXMLLoader fxmlLoader = new SpringFXMLLoader(applicationContext);
            FXMLLoader loader = fxmlLoader.getLoader("/login_v1.fxml");
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Login");
            primaryStage.show();
        } catch (Exception ex) {
            log.warn(ex.getMessage());
        }
    }

    public void showWorkspaceScene()
    //отображение окна рабочего окна
    {
        try {
            SpringFXMLLoader fxmlLoader = new SpringFXMLLoader(applicationContext);
            FXMLLoader loader = fxmlLoader.getLoader(("/workspace.fxml"));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Workspace");
            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.warn(ex.getMessage());
        }
    }
}
