package javafx.javafx.dao;

import javafx.javafx.db.DB;
import javafx.javafx.db.DepartmentDaoJDBC;
import javafx.javafx.db.SellerDaoJDBC;
public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
