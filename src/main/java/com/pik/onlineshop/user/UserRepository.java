package com.pik.onlineshop.user;

import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRepository {
    ArrayList<User> userList;

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    UserRepository(){ }

    public void readLogins()
    {
        try {
            Class.forName("org.postgresql.Driver");

            Context ctx = new InitialContext();
            if (ctx == null)
                throw new Exception("Boom - No Context");
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/postgres");

            if (ds == null) {
                throw new Exception("Data source not found!");
            }
            else
                {

                Connection connection = ds.getConnection();

                if (connection != null) {
                    userList = new ArrayList<User>();
                    Statement statement = connection.createStatement();

                    ResultSet resultSet = statement.executeQuery("SELECT * FROM logins");

                    while (resultSet.next()) {
                        userList.add(new User(resultSet.getString(1), resultSet.getString(2)));
                    }
                    connection.close();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void updateLogins(String sqlCommand){
        try {
            Class.forName("org.postgresql.Driver");

            Context ctx = new InitialContext();
            if (ctx == null)
                throw new Exception("Boom - No Context");
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/postgres");

            if (ds == null) {
                throw new Exception("Data source not found!");
            }
            else
            {

                Connection connection = ds.getConnection();

                if (connection != null) {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(sqlCommand);
                    connection.close();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsers(){
        readLogins();
        return userList;
    }

    public PasswordEncoder getEncoder(){
        return encoder;
    }

    public void addUser(User user){
        String login = user.getLogin();
        String password = encoder.encode(user.getPassword());

        updateLogins("INSERT INTO logins VALUES ( '" + login + "', '" + password + "')");
    }

    public void removeUser(User user){
        updateLogins("DELETE FROM logins WHERE login ='"+user.getLogin()+"'");
    }

}