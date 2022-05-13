package javafx.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.javafx.controllers.DepartmentListController;
import javafx.javafx.services.DepartmentService;
import javafx.javafx.util.Alerts;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import java.util.function.Consumer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController<T> implements Initializable {
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
        loadView("DepartmentList.fxml", controller -> {
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        });
    }


    public void onMenuItemAboutAction() throws IOException {
        loadView("AboutView.fxml", x -> {});
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO: 03/05/2022  
    }

    private synchronized void loadView(String absoluteName, Consumer<DepartmentListController> initializingAction) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = MainApplication.getScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());

            T controller = loader.getController();
            initializingAction.accept((DepartmentListController) controller);

        }
        catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}