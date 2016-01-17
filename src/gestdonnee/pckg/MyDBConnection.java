/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestdonnee.pckg;

import com.mysql.jdbc.Statement;
import java.sql.*;

/**
 *
 * @author Neiba Aristide
 */
public class MyDBConnection {

    private Connection conn;
    private Statement statement;
    private ResultSet resultSet;
    static String jdbc_driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    static String database_url = "jdbc:odbc:bs_grid";
    String sno, sex;
    double grade;

    /**
     * Creates a new instance of MyDBConnection
     */
    public MyDBConnection() {

        try {

            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(
                    database_url, "sa", "0");
            // create Statement to query database  
            statement = (Statement) conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

        } catch (Exception e) {
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
    }

    public MyDBConnection(String driver, String url, String user, String password) {

        try {

            Class.forName(driver);
            conn = DriverManager.getConnection(
                    url, user, password);
            statement = (Statement) conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

        } catch (ClassNotFoundException e) {
            System.out.println("class not found  ");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to get connection ");
            e.printStackTrace();
        }
    }

    public void callProcedure1(String studentName) {
        try {
            CallableStatement callStmt
                    = conn.prepareCall("{call procedure3(?,?,?,?)}");
            callStmt.setString(1, studentName);  //ï¿½ï¿½ï¿½ï¿½Òªï¿½ï¿½ï¿½ï¿½Äµï¿½Ò»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½(?)Öµï¿½ï¿½20001  
            callStmt.registerOutParameter(2, java.sql.Types.VARCHAR);//×¢ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½  
            callStmt.registerOutParameter(3, java.sql.Types.VARCHAR);
            /*SQLserver data type is decimalÊ±,ï¿½ï¿½ï¿½ï¿½Îª 
             callStmt.registerOutParameter(4,java.sql.Types.DECIMAL,0) 
             double   b4=(callStmt.getOBJECT(4));  
             or 
             callStmt.registerOutParameter(4,java.sql.Types.DOUBLE,0) 
             double   b4=(callStmt.getDOUBLE(4));  
             */
            callStmt.registerOutParameter(4, java.sql.Types.DOUBLE);
            callStmt.execute();
            sno = callStmt.getString(2);
            sex = callStmt.getString(3);
            grade = (callStmt.getDouble(4));
            callStmt.close();
        } catch (SQLException e) {
            System.out.println("Failed to call procedure ");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public ResultSet setQuery(String query) {
        try { // specify query and execute it  
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public Connection getMyConnection() {
        return conn;
    }

    public Statement getStatement() {
        return statement;
    }

    public void close(ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println("Failed to close ResultSet " + e);
            }

        }
    }

    public void close(Statement stmt) {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                System.out.println("Failed to close Statement " + e);
            }

        }
    }

    public void coloseDBConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        close(resultSet);
        close(statement);

    }

}
