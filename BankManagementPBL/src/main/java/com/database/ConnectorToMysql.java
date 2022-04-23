package com.database;
import com.domain.Details;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;

public class ConnectorToMysql {
    private Connection con;
    public void main() throws Exception {
        String url = "jdbc:mysql://localhost:3306/bankMDB";
        String username = "root";
        String password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);

    }
    public List<Details> getAllDetails()  throws Exception{
        Statement statement = con.createStatement();
        String query = "select * from details";
        ResultSet rs = statement.executeQuery(query);
        List<Details> detailsList = new ArrayList<>();
        while (rs.next()) {
            detailsList.add(new Details(rs.getInt(1),rs.getString(2),rs.getFloat(3)));
        }
        statement.close();
        con.close();
        return detailsList;
    }
    public List<Details> getDetailsByName(String name) throws Exception{
        Statement statement = con.createStatement();
        String query = "select * from details where name="+"'"+name+"'";
        ResultSet rs = statement.executeQuery(query);
        List<Details> detailsList = new ArrayList<>();
        while (rs.next()) {
            detailsList.add(new Details(rs.getInt(1),rs.getString(2),rs.getFloat(3)));
        }
        statement.close();
        con.close();
        return detailsList;
    }
    public void putDetails(Details details)throws Exception{
        String query = "insert into details values(" + details.getId() + "," + "'" + details.getName()+"'"+"," +
                details.getAmount()+")";
        Statement statement = con.createStatement();
        System.out.println(statement.executeUpdate(query)+" rows affected");
    }
    public void deleteDetailsById(int id) throws Exception{

        String query = "delete from details where id="+id;
        Statement statement = con.createStatement();
        int count = statement.executeUpdate(query);
        System.out.println("Rows affect: " + count + " by delete");
    }
}
