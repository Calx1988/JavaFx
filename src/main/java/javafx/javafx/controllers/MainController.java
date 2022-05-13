package javafx.javafx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.javafx.MainApplication;
import javafx.javafx.services.DepartmentService;
import javafx.javafx.util.Alerts;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
        loadView2("DepartmentList.fxml");
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

    private synchronized void loadView2(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = MainApplication.getScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());

            DepartmentListController controller = loader.getController();
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        }
        catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}