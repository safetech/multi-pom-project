package queries;


import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class InsertRowIntoPreference {

    private final Logger logger = getLogger(this.getClass());

    //private String COMPAS_SYS1 = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=dbslt0014.uhc.com)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=cmpts08.uhc.com)))";
    private String COMPAS_STAGE = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=orass0023.uhc.com)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=cmpst03.uhc.com)))";

    private String enterTestDataForPC = "insert into is_prefs.ecomm_transaction" +
            " (transaction_id , token , Email_address, transaction_start_date," +
            " state , Date_of_birth, created_by, Creation_date , last_modified_by, LAst_modified_date, user_id)" +
            " values" +
            " ('9900121', '9900121TOKEN', '9900121@test.com, ''24-JUL-2015', 'PA', '01-SEP-1951', '24-JUL-2015', 'SOAP UI', '02-JUL-2015', '112196247')";

    private String SUBMISSION_QUERY = "select" +
            "  TRIM(TO_CHAR(b.MEMBERSHIP_NUMBER, '000000000')) as MEMBERSHIP_NUMBER," +
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
            "  d.PAYMENT_METHOD_TYPE_ID," +
            "  b.APPL_IMAGE_NUM_ORIG" +
            " from " +
            "  ((ole_application a left outer join application b on a.application_id = b.application_id)" +
            "  left outer join individual c on b.individual_id = c.individual_id)" +
            "  left outer join household_billing_profile d on b.household_id = d.household_id" +
            " where" +
            "  b.MEMBERSHIP_NUMBER = substr(%s,1, LENGTH(%s) - 1)";

}
