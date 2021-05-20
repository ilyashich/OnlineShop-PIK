package com.pik.onlineshop.authentication;

import com.pik.onlineshop.user.User;

import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LoginJDBC {
    ArrayList<User> userList;
    LoginJDBC(){ }

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

    public void addUser(User user){
        updateLogins("INSERT INTO logins VALUES ( '" + user.getLogin() + "', '" + user.getPassword() + "')");
    }

    public void removeUser(User user){
        updateLogins("DELETE FROM logins WHERE login ='"+user.getLogin()+"'");
    }

}