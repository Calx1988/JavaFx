package javafx.javafx.dao;

import java.util.List;

import javafx.javafx.entities.Department;
import javafx.javafx.entities.Seller;

public interface SellerDao {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
}
