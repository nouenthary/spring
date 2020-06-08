package com.spring.springbootdemo.repository.imp;

import com.spring.springbootdemo.model.Department;
import com.spring.springbootdemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepositoryImp implements DepartmentRepository {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String sql;

    @Autowired
    public DepartmentRepositoryImp(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    @Override
    public boolean addDepartment(Department department) {
        try {
            sql = "INSERT INTO department (department_name) VALUES (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getDepartment_name());
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDepartment(Department department) {
        try {
            sql = "UPDATE department SET department_name = ?  WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getDepartment_name());
            preparedStatement.setLong(2, department.getId());
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            sql = "DELETE FROM department WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Department findById(Long id) {
        try {
            sql = "SELECT id, department_name, created_date, status  FROM department WHERE id = ? AND status = 1";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Department(
                        resultSet.getLong("id"),
                        resultSet.getString("department_name"),
                        resultSet.getDate("created_date"),
                        resultSet.getString("status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> findAll() {
        try {
            sql = "SELECT id, department_name, created_date, status  FROM department WHERE status = 1";
            preparedStatement = connection.prepareStatement(sql);
            List<Department> departments = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departments.add(new Department(
                        resultSet.getLong("id"),
                        resultSet.getString("department_name"),
                        resultSet.getDate("created_date"),
                        resultSet.getString("status")
                ));
            }
            return departments;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean restoreById(Long id) {
        try {
            sql = "UPDATE department SET status = 1 WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
