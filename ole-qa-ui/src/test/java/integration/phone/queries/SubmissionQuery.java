package integration.phone.queries;

import integration.phone.entity.Application;
import oracle.jdbc.pool.OracleDataSource;
import org.slf4j.Logger;
import util.DateUtils;
import util.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class SubmissionQuery {
    private final Logger logger = getLogger(this.getClass());

    private String COMPAS_SYS1 = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=dbslt0014.uhc.com)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=cmpts08.uhc.com)))";
    private String SUBMISSION_QUERY = "select" +
        "  TO_CHAR(b.MEMBERSHIP_NUMBER, '000000000') as MEMBERSHIP_NUMBER," +
        "  c.NAME_PREFIX_ID," +
        "  a.FIRST_NAME," +
        "  c.MIDDLE_NAME," +
        "  a.LAST_NAME," +
        "  c.NAME_SUFFIX_ID," +
        "  a.ADDRESS_LINE_1," +
        "  a.ADDRESS_LINE_2," +
        "  a.CITY," +
        "  a.STATE_CD," +
        "  a.ZIP_CD," +
        "  TO_CHAR(a.DATE_OF_BIRTH, 'MM/DD/YYYY') as DATE_OF_BIRTH," +
        "  c.GENDER_CD," +
        "  a.DAY_PHONE_NUM," +
        "  a.EVENING_PHONE_NUM," +
        "  a.HCSG_APPLICATION_ID," +
        "  a.EMAIL_ADDRESS," +
        "  a.PLAN_CD," +
        "  TO_CHAR(b.REQUESTED_EFFECTIVE_DATE, 'MM/DD/YYYY') as REQUESTED_EFFECTIVE_DATE," +
        "  a.MEDICARE_CLAIM_NUMBER," +
        "  TO_CHAR(c.PART_A_EFFECTIVE_DATE, 'MM/DD/YYYY') as PART_A_EFFECTIVE_DATE," +
        "  TO_CHAR(a.MED_PART_B_DATE, 'MM/DD/YYYY') as MED_PART_B_DATE," +
        "  a.BOTH_PARTS_ACTIVE," +
        "  TO_CHAR(b.CPA_SIGNATURE_DATE, 'MM/DD/YYYY') as CPA_SIGNATURE_DATE," +
        "  TO_CHAR(b.APPL_RECEIPT_DATE, 'MM/DD/YYYY') as APPL_RECEIPT_DATE," +
        "  TO_CHAR(b.APPL_SIGNATURE_DATE, 'MM/DD/YYYY') as APPL_SIGNATURE_DATE," +
        "  a.AGENT_FIRST_NAME," +
        "  a.AGENT_LAST_NAME," +
        "  a.SELLING_AGENT_ID," +
        "  a.QR_DATE," +
        "  a.STATUS," +
        "  a.MARKETING_PRODUCT_CODE," +
        "  a.CHANNEL," +
        "  a.ACTOR," +
        "  a.MECHANISM," +
        "  b.APPL_COMPONENT_NUMBER," +
        "  b.ADJUDICATION_CD," +
        "  b.HASH_CD," +
        "  d.PAYMENT_METHOD_TYPE_ID" +
        " from " +
        "  ((ole_application a left outer join application b on a.application_id = b.application_id)" +
        "  left outer join individual c on b.individual_id = c.individual_id)" +
        "  left outer join household_billing_profile d on b.household_id = d.household_id" +
        " where" +
        "  a.hcsg_application_id = '%s'";



    public void verifySubmissionData(Application app) throws SQLException {

        String query = String.format(SUBMISSION_QUERY, app.getHCSGApplicationId());

        logger.debug(query);

        HashMap<String, String> row = DbUtils.getSingleRecord(query, COMPAS_SYS1);

//        assertThat(row.get("MEMBERSHIP_NUMBER"), equalTo(""));
//        assertThat(rs.getString("NAME_PREFIX_ID"), equalTo(""));
//        assertThat(rs.getString("FIRST_NAME"), equalTo(""));
//        assertThat(rs.getString("MIDDLE_NAME"), equalTo(""));
//        assertThat(rs.getString("LAST_NAME"), equalTo(""));
//        assertThat(rs.getString("NAME_SUFFIX_ID"), equalTo(""));
//        assertThat(rs.getString("ADDRESS_LINE_1"), equalTo(""));
//        assertThat(rs.getString("ADDRESS_LINE_2"), equalTo(""));
//        assertThat(rs.getString("CITY"), equalTo(""));
//        assertThat(rs.getString("STATE_CD"), equalTo(""));
//        assertThat(rs.getString("ZIP_CD"), equalTo(""));
//        assertThat(rs.getString("DATE_OF_BIRTH"), equalTo(""));
//        assertThat(rs.getString("GENDER_CD"), equalTo(""));
//        assertThat(rs.getString("DAY_PHONE_NUM"), equalTo(""));
//        assertThat(rs.getString("EVENING_PHONE_NUM"), equalTo(""));
        assertThat(row.get("EMAIL_ADDRESS"), equalTo(""));
//        assertThat(rs.getString("PLAN_CD"), equalTo(""));
//        assertThat(rs.getString("REQUESTED_EFFECTIVE_DATE"), equalTo(""));
//        assertThat(rs.getString("MEDICARE_CLAIM_NUMBER"), equalTo(""));
//        assertThat(rs.getString("PART_A_EFFECTIVE_DATE"), equalTo(""));
        assertThat(row.get("MED_PART_B_DATE"), equalTo("01/01/1999"));
//        assertThat(rs.getString("BOTH_PARTS_ACTIVE"), equalTo(""));
//        assertThat(rs.getString("CPA_SIGNATURE_DATE"), equalTo(""));
//        assertThat(rs.getString("APPL_RECEIPT_DATE"), equalTo(""));
//        assertThat(rs.getString("APPL_SIGNATURE_DATE"), equalTo(""));
//        assertThat(rs.getString("AGENT_FIRST_NAME"), equalTo(""));
//        assertThat(rs.getString("AGENT_LAST_NAME"), equalTo(""));
//        assertThat(rs.getString("SELLING_AGENT_ID"), equalTo(""));
//        assertThat(rs.getString("QR_DATE"), equalTo(""));
//        assertThat(rs.getString("STATUS"), equalTo(""));
//        assertThat(rs.getString("MARKETING_PRODUCT_CODE"), equalTo(""));
//        assertThat(rs.getString("CHANNEL"), equalTo(""));
//        assertThat(rs.getString("ACTOR"), equalTo(""));
//        assertThat(rs.getString("MECHANISM"), equalTo(""));
//        assertThat(rs.getString("APPL_COMPONENT_NUMBER"), equalTo(""));
//        assertThat(rs.getString("HASH_CD"), equalTo(""));
//        assertThat(rs.getString("PAYMENT_METHOD_TYPE_ID"), equalTo(""));
//        assertThat(rs.getString("ADJUDICATION_CD"), equalTo("A"));

    }

}
