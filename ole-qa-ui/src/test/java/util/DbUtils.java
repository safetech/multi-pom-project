package util;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.util.HashMap;

public class DbUtils {
    public static HashMap<String, String> getSingleRecord(String query, String connectionString) throws SQLException {

        OracleDataSource ods = new OracleDataSource();
        ods.setURL(connectionString);
        ods.setUser(System.getProperty("DBUN"));
        ods.setPassword(System.getProperty("DBPW"));

        HashMap<String, String> row = null;

        Connection conn = null;
        try {
            conn = ods.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            rs.next();
            row = new HashMap<String, String>(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getString(i) == null ? "" : rs.getString(i));
            }
        } finally {
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        }

        return row;

    }

    public static void setSingleRecord(String connectionString) throws SQLException {

        OracleDataSource ods = new OracleDataSource();
        ods.setURL(connectionString);
        ods.setUser(System.getProperty("DBUN"));
        ods.setPassword(System.getProperty("DBPW"));

        Connection conn = null;
        try {
            conn = ods.getConnection();
            Statement stmt = conn.createStatement();





            // Prepare to insert new names in the EMP table
            PreparedStatement pstmt = null;
            try{
               // pstmt = conn.prepareStatement ("insert into EMP (EMPNO, ENAME) values (?, ?)");
                pstmt = conn.prepareCall("insert into is_prefs.ecomm_transaction" +
                        " (transaction_id , token , Email_address, transaction_start_date," +
                        " state , Date_of_birth, created_by, Creation_date , last_modified_by, Last_modified_date, user_id)" +
                        " values" +
                        " ('9900121', '9900121TOKEN', '9900121@test.com, ''24-JUL-2015', 'PA', '01-SEP-1951', '24-JUL-2015', 'SOAP UI', '02-JUL-2015', '112196247')");

                pstmt.execute ();

            }

            finally{
                if(pstmt!=null)

                    // Close the statement
                    pstmt.close();
            }



        } finally {
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        }

    }
}
