package queries;


import org.slf4j.Logger;
import util.DbUtils;

import java.sql.SQLException;

import static org.slf4j.LoggerFactory.getLogger;

public class InsertRowIntoPreference {

    private final Logger logger = getLogger(this.getClass());

    //private String COMPAS_SYS1 = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=dbslt0014.uhc.com)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=cmpts08.uhc.com)))";

    private String IS_PREF_STAGE = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=orass0088.uhc.com)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=acest02.uhc.com)))";


    private String insertionQuery = "insert into is_prefs.ecomm_transaction" +
            " (transaction_id , token , Email_address, transaction_start_date," +
            " state , Date_of_birth, created_by, Creation_date , last_modified_by, Last_modified_date, user_id)" +
            " values" +
            " ('9900121', '9900121TOKEN', '9900121@test.com, ''24-JUL-2015', 'PA', '01-SEP-1951', '24-JUL-2015', 'SOAP UI', '02-JUL-2015', '112196247')";

    public void insertDataInPC() throws SQLException {

//        String query = String.format(insertionQuery, sheet.getToken(), sheet.getEmail(), sheet.getProduct(), sheet.getTransactionid());

//        logger.info(query);


//        String currentDate = DateUtils.DD_MMM_YYYY_FORMAT.format(new java.util.Date());


        DbUtils.setSingleRecord(IS_PREF_STAGE);

        //fill(row.put("token"));
        //fill(row.put(with((String) sheet.setToken("token"))));

//        logger.info(String.format("Here is the link to the image... https://acesx-tst-alt.uhc.com/appEnroll-web/resources/retrievePDF/v1/%s", row.get("APPL_IMAGE_NUM_ORIG")));

    }


}
