package com.spring.springbootdemo.repository.imp;

import com.spring.springbootdemo.model.Department;
import com.spring.springbootdemo.model.Role;
import com.spring.springbootdemo.model.User;
import com.spring.springbootdemo.repository.UserRepository;
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
public class UserRepositoryImp implements UserRepository {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String sql;

    @Autowired
    public UserRepositoryImp(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    @Autowired
    private RoleRepositoryImp roleRepositoryImp;

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        try {
            sql = "SELECT u.id , u.username, u.email, u.password, u.created_date, u.status , d.id as department_id, d.department_name " +
                    "FROM user u INNER JOIN department d ON u.department_id = d.id";

            preparedStatement = connection.prepareStatement(sql);
            List<User> users = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();

//            while (resultSet.next()) {
//
//                Department department = new Department();
//                department.setId(resultSet.getLong("department_id"));
//                department.setDepartment_name(resultSet.getString("department_name"));
//
//                List<Role> roles = roleRepositoryImp.findRoleByUserId(resultSet.getLong("id"));
//
//                users.add(
//                        new User(
//                                resultSet.getLong("id"),
//                                resultSet.getString("username"),
//                                resultSet.getString("email"),
//                                resultSet.getString("password"),
//                                resultSet.getString("address"),
//                                resultSet.getDate("created_date"),
//                                resultSet.getString("status"),
//                                department,
//                                roles
//                        ));
//            }
            System.out.print(resultSet + "ll");
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
