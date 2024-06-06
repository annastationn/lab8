package se.ifmo.lab8;

import javafx.application.Application;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import se.ifmo.lab8.gui.GuiApplication;

@SpringBootApplication
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Log4j2
@EnableScheduling
public class Lab8Application {
	public static void main(String[] args) {
		Application.launch(GuiApplication.class, args);
	}
}
