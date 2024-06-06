package se.ifmo.lab8.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import se.ifmo.lab8.Lab8Application;
import se.ifmo.lab8.gui.stage.StageReadyEvent;

//основа для создания графический интерфейса
public class GuiApplication extends Application {
    private static ConfigurableApplicationContext applicationContext;

    //генерирует исключения перед запуском
    @Override
    public void init() throws Exception {
        applicationContext = new SpringApplicationBuilder(Lab8Application.class).run();
    }

    //вызывается для запуска гуи
    @Override
    public void start(Stage primaryStage) {
        applicationContext.publishEvent(new StageReadyEvent(primaryStage));
    }

    //вызывается перед завершением гуи
    @Override
    public void stop() {
        applicationContext.close();
    }
}

