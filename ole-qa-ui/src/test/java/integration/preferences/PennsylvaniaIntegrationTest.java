package integration.preferences;

import integration.CQBaseIntegrationTest;
<<<<<<< HEAD
import oracle.jdbc.pool.OracleDataSource;
=======
//import jdk.nashorn.internal.ir.annotations.Ignore;
import oracle.jdbc.pool.OracleDataSource;
import org.fluentlenium.core.annotation.Page;
import org.junit.Ignore;
import org.junit.Before;
>>>>>>> 33ac902f563afcd3dbcccae1e1f6da6d510d43ee
import org.junit.Test;
import util.DateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class PennsylvaniaIntegrationTest extends CQBaseIntegrationTest {


    @Test
    public void playGround() throws Exception {


        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=orass0088.uhc.com)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=acest02.uhc.com)))");
        ods.setUser("uhg_000921560");
        ods.setPassword("*Hansa2001");

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
                        " ('9900121', '9900121TOKEN', '9900121@test.com', '24-JUL-2015', 'PA', '01-SEP-1951', 'IntiliJ', '24-JUL-2015', 'SOAP UI', '02-JUL-2015', '112196247')");
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

        System.out.print("insert into is_prefs.ecomm_transaction(transaction_id , token, Email_address, transaction_start_date, state, Date_of_birth, created_by, Creation_date, last_modified_by, Last_modified_date, user_id) values ('9900121', '9900121TOKEN', '9900121@test.com, " +  DateUtils.customizePastOrFutureDates(0) +", 'PA', " +  DateUtils.customizePastOrFutureDates(1) + ", " +  DateUtils.customizePastOrFutureDates(1) + ", 'IntliJ', " + DateUtils.customizePastOrFutureDates(-7) + " '112196247')");


      }
}
