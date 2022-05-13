package javafx.javafx.services;

import javafx.javafx.dao.DaoFactory;
import javafx.javafx.dao.DepartmentDao;
import javafx.javafx.entities.Department;

import java.util.List;

public class DepartmentService {
    private DepartmentDao dao = DaoFactory.createDepartmentDao();


    public List<Department> findAll() {
      return dao.findAll();
    }

    public void saveOrUpdate(Department obj) {
        if (obj.getId() == null) {
            dao.insert(obj);
        }
        else {
            dao.update(obj);
        }
    }
}
