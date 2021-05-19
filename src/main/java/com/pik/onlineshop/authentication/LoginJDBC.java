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

    public void init()
    {
        try {
            Class.forName("org.postgresql.Driver");

            Context ctx = new InitialContext();
            if (ctx == null)
                throw new Exception("Boom - No Context");
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/postgres");

            if (ds == null) {
                System.out.println("Data source is null");
                throw new Exception("Data source not found!");
            }
            else
                {
//            Class.forName("org.postgresql.Driver");
//            String url = "jdbc:postgresql://localhost:5432/clients";
//
//            Properties props = new Properties();
//            props.setProperty("user","shopadmin");
//            props.setProperty("password","");
//
//            DriverManager.getConnection(url, props);

                //Connection connection = DriverManager.getConnection(url, props);

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
//            }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public ArrayList<User> getUsers(){
        return userList;
    }

}
