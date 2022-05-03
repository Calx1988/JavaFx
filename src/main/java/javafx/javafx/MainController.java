package javafx.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    public void onMenuItemSellerAction() {
        System.out.println("Seller action");
    }

    public void onMenuItemDepartmentAction() {
        System.out.println("Department Action");
    }

    public void onMenuItemAboutAction() throws IOException {
        loadView("AboutView.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO: 03/05/2022  
    }

    private void loadView(String viewPath){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
            VBox newVbox = loader.load();
            Scene mainScene = MainApplication.getScene();
            VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newVbox.getChildren());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}