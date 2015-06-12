package queries;


import entity.Application;
import entity.SubmissionResult;
import org.slf4j.Logger;
import util.DateUtils;
import util.DbUtils;

import java.sql.SQLException;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class SubmissionQuery {
    private final Logger logger = getLogger(this.getClass());

    private String COMPAS_SYS1 = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=dbslt0014.uhc.com)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=cmpts08.uhc.com)))";
    private String ADJUDICATION_QUERY = "\n" +
        "select \n" +
        "  f.hcsg_application_id,\n" +
        "  f.ole_reference_identifier,\n" +
        "  b.application_id,\n" +
        "  f.status,\n" +
        "  b.adjudication_cd,\n" +
        "  g.type_desc,\n" +
        "  d.item_reason_type_desc\n" +
        "from \n" +
        "  ((((((ole_application f left outer join application b on f.application_id = b.application_id) \n" +
        "    left outer join work_queue_rec_id a on (a.identifier_value = b.application_id and a.identifier_type_id = 2011))\n" +
        "    left outer join work_queue_item_reason c on a.tracking_number = c.tracking_number)\n" +
        "    left outer join work_queue_item_reason_type d on c.item_reason_type_id = d.item_reason_type_id)\n" +
        "    left outer join work_queue_item e on a.tracking_number = e.tracking_number)\n" +
        "    left outer join work_queue_type g on e.type_id = g.type_id)  \n" +
        "where\n" +
        "  f.hcsg_application_id = '%s'";

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
        "  a.hcsg_application_id = '%s'";


    public void verifySubmissionData(Application app, SubmissionResult expectedSubmissionResult) throws SQLException {

        String query = String.format(SUBMISSION_QUERY, app.getHCSGApplicationId());

        logger.info(query);

        HashMap<String, String> row = DbUtils.getSingleRecord(query, COMPAS_SYS1);

        String currentDate = DateUtils.NORMALIZED_DATE_FORMAT.format(new java.util.Date());

        assertThat(row.get("MEMBERSHIP_NUMBER"), equalTo(app.getAARPMembershipNumber()));
//        assertThat(row.get("NAME_PREFIX_ID"), equalTo(""));
        assertThat(row.get("FIRST_NAME"), equalTo(app.getFirstName().toUpperCase()));
        assertThat(row.get("MIDDLE_NAME"), equalTo(app.getMI().toUpperCase()));
        assertThat(row.get("LAST_NAME"), equalTo(app.getLastName().toUpperCase()));
//        assertThat(row.get("NAME_SUFFIX_ID"), equalTo(""));
        assertThat(row.get("ADDRESS_LINE_1"), equalTo(app.getAddressLine1().toUpperCase()));
        assertThat(row.get("ADDRESS_LINE_2"), equalTo(app.getAddressLine2().toUpperCase()));
        assertThat(row.get("CITY"), equalTo(app.getCity().toUpperCase()));
        assertThat(row.get("STATE_CD"), equalTo(app.getState().toUpperCase()));
        assertThat(row.get("ZIP_CD"), equalTo(app.getZipCode()));
//        assertThat(row.get("DATE_OF_BIRTH"), equalTo(""));
//        assertThat(row.get("GENDER_CD"), equalTo(""));
        assertThat(row.get("DAY_PHONE_NUM"), equalTo(app.getPhonePrimary()));
        assertThat(row.get("EVENING_PHONE_NUM"), equalTo(app.getPhoneEvening()));
        assertThat(row.get("EMAIL_ADDRESS"), equalTo(""));
//        assertThat(row.get("PLAN_CD"), equalTo(""));
        assertThat(row.get("REQUESTED_EFFECTIVE_DATE"), equalTo(app.getReqEffectiveDate()));
        assertThat(row.get("MEDICARE_CLAIM_NUMBER"), equalTo(app.getMedicareClaimNum().toUpperCase()));
        assertThat(row.get("PART_A_EFFECTIVE_DATE"), equalTo(app.getMPAED()));
        assertThat(row.get("MED_PART_B_DATE"), equalTo(app.getMPBED()));
        assertThat(row.get("BOTH_PARTS_ACTIVE"), equalTo(app.getPartABActiveIndicator() == "yes" ? "Y" : "N"));
        assertThat(row.get("CPA_SIGNATURE_DATE"), equalTo(currentDate));
        assertThat(row.get("APPL_RECEIPT_DATE"), equalTo(currentDate));
        assertThat(row.get("APPL_SIGNATURE_DATE"), equalTo(currentDate));
//        assertThat(row.get("AGENT_FIRST_NAME"), equalTo(""));
//        assertThat(row.get("AGENT_LAST_NAME"), equalTo(""));
        assertThat(row.get("SELLING_AGENT_ID"), equalTo(""));
        assertThat(row.get("QR_DATE"), equalTo(""));
        assertThat(row.get("STATUS"), equalTo(expectedSubmissionResult.getStatus()));
//        assertThat(row.get("MARKETING_PRODUCT_CODE"), equalTo(""));
        assertThat(row.get("CHANNEL"), equalTo("1"));
        assertThat(row.get("ACTOR"), equalTo("2"));
        assertThat(row.get("MECHANISM"), equalTo("2"));
//        assertThat(row.get("APPL_COMPONENT_NUMBER"), equalTo(""));
//        assertThat(row.get("HASH_CD"), equalTo(""));
        assertThat(row.get("PAYMENT_METHOD_TYPE_ID"), equalTo("2"));
        assertThat(row.get("ADJUDICATION_CD"), equalTo(expectedSubmissionResult.getAdjudicationStatus()));

        logger.info(String.format("Here is the link to the image... https://acesx-stg-alt.uhc.com/appEnroll-web/resources/retrievePDF/v1/%s", row.get("APPL_IMAGE_NUM_ORIG")));

    }

    public void verifyAdjudicationData(Application app, SubmissionResult expectedSubmissionResult) throws SQLException {

        String query = String.format(ADJUDICATION_QUERY, app.getHCSGApplicationId());

        logger.info(query);

        HashMap<String, String> row = DbUtils.getSingleRecord(query, COMPAS_SYS1);
        logger.info("query is "+row.get("TYPE_DESC")+" and expected is "+expectedSubmissionResult.getWorkQueue());
        assertThat(row.get("TYPE_DESC"), equalTo(expectedSubmissionResult.getWorkQueue()));
        assertThat(row.get("ITEM_REASON_TYPE_DESC"), equalTo(expectedSubmissionResult.getWorkQueueReason()));

    }


}
