package com.spring.springbootdemo.repository.imp;

import com.spring.springbootdemo.model.Role;
import com.spring.springbootdemo.repository.RoleRepository;
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
public class RoleRepositoryImp implements RoleRepository {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String sql;

    @Autowired
    public RoleRepositoryImp(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    @Override
    public boolean addRole(Role role) {
        try {
            sql = "INSERT INTO role (role_name) VALUES (?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, role.getRole_name());
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRole(Role role) {
        try {
            sql = "UPDATE role SET role_name = ?  WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, role.getRole_name());
            preparedStatement.setLong(2, role.getId());
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
            sql = "DELETE FROM role WHERE id = ?";
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
    public Role findById(Long id) {
        try {
            sql = "SELECT id, role_name,start_date, status ,user_id FROM role WHERE id = ?  AND status = 1";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("role_name"),
                        resultSet.getDate("start_date"),
                        resultSet.getString("status"),
                        resultSet.getLong("user_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        try {
            sql = "SELECT id, role_name,start_date, status ,user_id FROM role Where status = 1";
            preparedStatement = connection.prepareStatement(sql);
            List<Role> roles = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                roles.add(new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("role_name"),
                        resultSet.getDate("start_date"),
                        resultSet.getString("status"),
                        resultSet.getLong("user_id")
                ));
            }
            return roles;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Role> findRoleByUserId(Long id) {
        try {
            sql = "SELECT id, role_name,start_date, status ,user_id FROM role WHERE user_id=? AND status = 1";
            List<Role> roles = new ArrayList<>();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                roles.add(new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("role_name"),
                        resultSet.getDate("start_date"),
                        resultSet.getString("status"),
                        resultSet.getLong("user_id")
                ));
            }
            return roles;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role findByRole(String role) {
        return null;
    }
}
