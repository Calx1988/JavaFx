package javafx.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class MainController {
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

    public void onMenuItemAboutAction() {
        System.out.println("About action");
    }
}