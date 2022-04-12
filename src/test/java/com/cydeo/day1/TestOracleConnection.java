package com.cydeo.day1;

import javax.xml.transform.Result;
import java.sql.*;

public class TestOracleConnection {

    public static void main(String[] args) throws SQLException {

        // step1: Create Connection by providing Connection Information
        //  we provide JDBC url

        String url = "jdbc:oracle:thin:@54.234.53.165:1521:XE"; // we get from developers
        String userName = "hr";
        String password = "hr";

        // now JDBC Provide utility class called DriverManager with many methods
        // the getConnection method accept 3 parameters url , username, password
        // according this information ,
        // it will first look for the driver of the database type you are connecting to
        // once it's found , use the rest of connection information like
        // host ip , username password , port , sid to make connection
        // MAKE SURE YOUR CONNECTION WORK MANUALLY ,
        // ANYTHING DOES NOT WORK MANUALLY WILL NOT WORK AUTOMATION

        //WE  WHEN  YOU LOOK DATA  from DATABASE  we need  DRIVER in this  way ORACLE  DRIVER

        Connection con = DriverManager.getConnection(url, userName, password);
        System.out.println("Successfully connected");

        // Once we have connection, now we use this connection Object to create statement Object


        Statement stmt = con.createStatement();

        // Once we create statement Object, now we can execute query to get ResultSet

        ResultSet rs = stmt.executeQuery("select * from regions");
         // resultSet  Object store all the row data
        // It uses iterator to move through the row using the cursor to hold its current position

       // in order to get to the first row, you need to call next() method

        rs.next() ; // now we are at first data
        // now we need  to get  a data

        // the resulting data has two column REGION_ID, REGION_NAME
        // In order to access the cell value, we use getXmethod
        // we can use column name or index
        String firstRowValue = rs.getString("REGION_ID") ;
        String secondRowValue = rs.getString("REGION_NAME") ;

        System.out.println("firstRowValue = " + firstRowValue);
        System.out.println("secondRowValue = " + secondRowValue);


        System.out.println("Lets  find the row value by using column index number");

        System.out.println("rs.getString(1) = " + rs.getString(1));
        System.out.println("rs.getString(2) = " + rs.getString(2));

        // let's move to the next row

        rs.next() ;

        String firstRowValue1 = rs.getString("REGION_ID") ;
        String secondRowValue1 = rs.getString("REGION_NAME") ;
        System.out.println("firstRowValue1 = " + firstRowValue1);
        System.out.println("secondRowValue1 = " + secondRowValue1);

    }


}
