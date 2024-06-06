package se.ifmo.lab8.gui.loader;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;

public class SpringFXMLLoader {
    private final ApplicationContext context;

    public SpringFXMLLoader(ApplicationContext context) {
        this.context = context;
    }

    public FXMLLoader getLoader(String url) {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(context::getBean);
        loader.setLocation(getClass().getResource(url));
        return loader;
    }
}
