package integration.preferences;

import com.github.javafaker.Faker;
import entity.Application;
import entity.SubmissionResult;
import entity.preference.CribSheet;
import integration.CQBaseIntegrationTest;
//import jdk.nashorn.internal.ir.annotations.Ignore;
import oracle.jdbc.pool.OracleDataSource;
import org.fluentlenium.core.annotation.Page;
import org.junit.Ignore;
import org.junit.Before;
import org.junit.Test;
import pages.preference.CheatPage;
import queries.InsertRowIntoPreference;
import util.DateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class PennsylvaniaIntegrationTest extends CQBaseIntegrationTest {

    @Page public CheatPage cheatPage;

    public InsertRowIntoPreference insertRowIntoPreference;
    private Faker faker;
    private CribSheet sheet;
    private SubmissionResult expectedSubmissionResult;

    @Before
    public void setup() {
        insertRowIntoPreference = new InsertRowIntoPreference();
        faker = new Faker();
        sheet = new CribSheet(faker);
        expectedSubmissionResult = new SubmissionResult();

    }

    @Ignore
    public void test_pennsylvania_preference() throws Exception {

        sheet.setRandomTokenEmailTransaction();

        Application app = new Application();

        goTo(cheatPage);
        cheatPage.fillAndSubmit(sheet);

    }

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
