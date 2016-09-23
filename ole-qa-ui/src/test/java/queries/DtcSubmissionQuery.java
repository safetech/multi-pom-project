package queries;


import resources.entity.Application;
import resources.entity.SubmissionResult;
import resources.entity.dtc.CribSheet;
import org.slf4j.Logger;
import resources.utils.DateUtils;
import resources.utils.DbUtils;
import resources.utils.PropertyUtils;

import java.sql.SQLException;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class DtcSubmissionQuery {

    private final Logger logger = getLogger(this.getClass());
    private String SELECTED_COMPAS_ENVIRONMENT;

    private String ADJUDICATION_QUERY = "\n" +
            "select \n" +
            "  b.MEMBERSHIP_NUMBER,\n" +
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
            "  b.MEMBERSHIP_NUMBER = substr(%s,1, LENGTH(%s) - 1)";

    private String SUBMISSION_QUERY = "\n" +
            "select\n" +
            "  TRIM(TO_CHAR(b.MEMBERSHIP_NUMBER, '000000000')) as MEMBERSHIP_NUMBER,\n" +
            "  c.NAME_PREFIX_ID,\n" +
            "  a.FIRST_NAME,\n" +
            "  c.MIDDLE_NAME,\n" +
            "  a.LAST_NAME, \n" +
            "  c.NAME_SUFFIX_ID,\n" +
            "  a.ADDRESS_LINE_1,\n" +
            "  a.ADDRESS_LINE_2,\n" +
            "  a.CITY,\n" +
            "  a.STATE_CD,\n" +
            "  a.ZIP_CD,\n" +
            "  TO_CHAR(a.DATE_OF_BIRTH, 'MM/DD/YYYY') as DATE_OF_BIRTH,\n" +
            "  c.GENDER_CD,\n" +
            "  a.DAY_PHONE_NUM,\n" +
            "  a.EVENING_PHONE_NUM, \n" +
            "  a.HCSG_APPLICATION_ID,\n" +
            "  a.EMAIL_ADDRESS,\n" +
            "  a.PLAN_CD, \n" +
            "  TO_CHAR(b.REQUESTED_EFFECTIVE_DATE, 'MM/DD/YYYY') as REQUESTED_EFFECTIVE_DATE,\n" +
            "  a.MEDICARE_CLAIM_NUMBER,\n" +
            "  TO_CHAR(c.PART_A_EFFECTIVE_DATE, 'MM/DD/YYYY') as PART_A_EFFECTIVE_DATE,\n" +
            "  TO_CHAR(a.MED_PART_B_DATE, 'MM/DD/YYYY') as MED_PART_B_DATE,\n" +
            "  a.BOTH_PARTS_ACTIVE,\n" +
            "  TO_CHAR(b.CPA_SIGNATURE_DATE, 'MM/DD/YYYY') \n" +
            "  as CPA_SIGNATURE_DATE,\n" +
            "  TO_CHAR(b.APPL_RECEIPT_DATE, 'MM/DD/YYYY') as APPL_RECEIPT_DATE,\n" +
            "  TO_CHAR(b.APPL_SIGNATURE_DATE, 'MM/DD/YYYY') as APPL_SIGNATURE_DATE, \n" +
            "  a.AGENT_FIRST_NAME,\n" +
            "  a.AGENT_LAST_NAME,\n" +
            "  a.SELLING_AGENT_ID,\n" +
            "  a.QR_DATE,\n" +
            "  a.STATUS,\n" +
            "  a.MARKETING_PRODUCT_CODE,\n" +
            "  a.CHANNEL,\n" +
            "  a.ACTOR,\n" +
            "  a.PLAN_CD, \n" +
            "  a.RIDER_REQUEST_1,\n" +
            "  a.RIDER_REQUEST_2,\n" +
            "  a.RIDER_REQUEST_3,\n" +
            "  a.RIDER_REQUEST_4,\n" +
            "  a.MECHANISM,\n" +
            "  b.APPL_COMPONENT_NUMBER,\n" +
            "  b.ADJUDICATION_CD,\n" +
            "  b.HASH_CD,\n" +
            " b.ASSOCIATION_ID,\n"+
            " b.INSURED_CD,\n"+
            "  d.PAYMENT_METHOD_TYPE_ID,\n" +
            "  b.APPL_IMAGE_NUM_ORIG, \n"+
            "  d.EFT_FREQUENCY_TYPE_ID \n" +
            "from \n" +
            "  ((ole_application a left outer join application b on a.application_id = b.application_id)\n" +
            "  left outer join individual c on b.individual_id = c.individual_id)\n" +
            "  left outer join household_billing_profile d on b.household_id = d.household_id\n" +
            "where\n" +
            "  b.MEMBERSHIP_NUMBER = substr(%s,1, LENGTH(%s) - 1)";


    private String RIDERS_QUERY = "\n" +
            "select\n" +
            "  TRIM(TO_CHAR(b.MEMBERSHIP_NUMBER, '000000000')) as MEMBERSHIP_NUMBER,\n" +
            "  c.NAME_PREFIX_ID,\n" +
            "  a.FIRST_NAME,\n" +
            "  c.MIDDLE_NAME,\n" +
            "  a.LAST_NAME,\n" +
            "  c.NAME_SUFFIX_ID,\n" +
            "  a.ADDRESS_LINE_1,\n" +
            "  a.ADDRESS_LINE_2,\n" +
            "  a.CITY,\n" +
            "  a.STATE_CD,\n" +
            "  a.ZIP_CD,\n" +
            "  TO_CHAR(a.DATE_OF_BIRTH, 'MM/DD/YYYY') as DATE_OF_BIRTH,\n" +
            "  c.GENDER_CD,\n" +
            "  a.DAY_PHONE_NUM,\n" +
            "  a.EVENING_PHONE_NUM,\n" +
            "  a.HCSG_APPLICATION_ID,\n" +
            "  a.EMAIL_ADDRESS,\n" +
            "  a.PLAN_CD,\n" +
            "  TO_CHAR(b.REQUESTED_EFFECTIVE_DATE, 'MM/DD/YYYY') as REQUESTED_EFFECTIVE_DATE,\n" +
            "  a.MEDICARE_CLAIM_NUMBER,\n" +
            "  TO_CHAR(c.PART_A_EFFECTIVE_DATE, 'MM/DD/YYYY') as PART_A_EFFECTIVE_DATE,\n" +
            "  TO_CHAR(a.MED_PART_B_DATE, 'MM/DD/YYYY') as MED_PART_B_DATE,\n" +
            "  a.BOTH_PARTS_ACTIVE,\n" +
            "  TO_CHAR(b.CPA_SIGNATURE_DATE, 'MM/DD/YYYY') as CPA_SIGNATURE_DATE,\n" +
            "  TO_CHAR(b.APPL_RECEIPT_DATE, 'MM/DD/YYYY') as APPL_RECEIPT_DATE,\n" +
            "  TO_CHAR(b.APPL_SIGNATURE_DATE, 'MM/DD/YYYY') as APPL_SIGNATURE_DATE,\n" +
            "  a.AGENT_FIRST_NAME,\n" +
            "  a.AGENT_LAST_NAME,\n" +
            "  a.SELLING_AGENT_ID,\n" +
            "  a.QR_DATE,\n" +
            "  a.STATUS,\n" +
            "  a.MARKETING_PRODUCT_CODE,\n" +
            "  a.CHANNEL,\n" +
            "  a.ACTOR,\n" +
            "  a.PLAN_CD,\n" +
            "  a.RIDER_REQUEST_1,\n" +
            "  a.RIDER_REQUEST_2,\n" +
            "  a.RIDER_REQUEST_3,\n" +
            "  a.RIDER_REQUEST_4,\n" +
            "  a.MECHANISM,\n" +
            "  b.APPL_COMPONENT_NUMBER,\n" +
            "  b.ADJUDICATION_CD,\n" +
            "  b.HASH_CD,\n" +
            "  d.PAYMENT_METHOD_TYPE_ID,\n" +
            "  b.APPL_IMAGE_NUM_ORIG, \n" +
            "  d.EFT_FREQUENCY_TYPE_ID \n" +
            "from \n" +
            "  ((ole_application a left outer join application b on a.application_id = b.application_id)\n" +
            "  left outer join individual c on b.individual_id = c.individual_id)\n" +
            "  left outer join household_billing_profile d on b.household_id = d.household_id\n" +
            "where \n" +
            "  b.MEMBERSHIP_NUMBER = substr(%s,1, LENGTH(%s) - 1)";

    public void verifyPlanAndRiderCodes(Application app, CribSheet sheet, SubmissionResult expectedSubmissionResult) throws SQLException {
        SELECTED_COMPAS_ENVIRONMENT = PropertyUtils.getProperty("compas.db");

        String query = String.format(RIDERS_QUERY, app.getAARPMembershipNumber(), app.getAARPMembershipNumber());
        logger.info(query);
        String currentDate = DateUtils.NORMALIZED_DATE_FORMAT.format(new java.util.Date());

        HashMap<String, String> row = DbUtils.getSingleRecord(query, SELECTED_COMPAS_ENVIRONMENT);
        assertThat(row.get("PLAN_CD"), equalTo(expectedSubmissionResult.getPlanCode()));
        assertThat(row.get("RIDER_REQUEST_1"), equalTo(expectedSubmissionResult.getRiderOne()));
        assertThat(row.get("RIDER_REQUEST_2"), equalTo(expectedSubmissionResult.getRiderTwo()));
        assertThat(row.get("RIDER_REQUEST_3"), equalTo(expectedSubmissionResult.getRiderThree()));
        assertThat(row.get("RIDER_REQUEST_4"), equalTo(expectedSubmissionResult.getRiderFour()));
        assertThat(row.get("STATE_CD"), equalTo(sheet.getState()));
        assertThat(row.get("MEMBERSHIP_NUMBER"), containsString(app.getAARPMemberNumber()));
        assertThat(row.get("FIRST_NAME"), containsString(app.getFirstName().toUpperCase()));
        assertThat(row.get("MIDDLE_NAME"), equalTo(app.getMI().toUpperCase()));
        assertThat(row.get("LAST_NAME"), equalTo(app.getLastName().toUpperCase()));
        assertThat(row.get("ADDRESS_LINE_1"), equalTo(app.getAddressLine1().toUpperCase()));
        assertThat(row.get("ADDRESS_LINE_2"), equalTo(app.getAddressLine2().toUpperCase()));
        assertThat(row.get("CITY"), equalTo(app.getCity().toUpperCase()));
        assertThat(row.get("DAY_PHONE_NUM"), equalTo(app.getPhonePrimary()));
        //assertThat(row.get("EVENING_PHONE_NUM"), equalTo(app.getPhoneEvening()));
        assertThat(row.get("EMAIL_ADDRESS"), equalTo(app.getEmail().toUpperCase()));
        assertThat(row.get("BOTH_PARTS_ACTIVE"), equalTo(app.getPartABActiveIndicator() == "yes" ? "Y" : "N"));
        assertThat(row.get("CPA_SIGNATURE_DATE"), equalTo(currentDate));
        assertThat(row.get("APPL_RECEIPT_DATE"), equalTo(currentDate));
        assertThat(row.get("APPL_SIGNATURE_DATE"), equalTo(currentDate));
        assertThat(row.get("STATUS"), equalTo(expectedSubmissionResult.getStatus()));
        assertThat(row.get("CHANNEL"), equalTo("10"));
        assertThat(row.get("ACTOR"), equalTo("1"));
        assertThat(row.get("MECHANISM"), equalTo("2"));

        logger.info(String.format("Here is the link to the image... https://acesx-tst-alt.uhc.com/appEnroll-web/resources/retrievePDF/v1/%s", row.get("APPL_IMAGE_NUM_ORIG") +" For the state of --> " + row.get("STATE_CD")));
    }

    public void verifySubmissionData(Application app, SubmissionResult expectedSubmissionResult) throws SQLException {
        SELECTED_COMPAS_ENVIRONMENT = PropertyUtils.getProperty("compas.db");

        String query = String.format(SUBMISSION_QUERY, app.getAARPMembershipNumber(), app.getAARPMembershipNumber());
        logger.info(query);
        HashMap<String, String> row = DbUtils.getSingleRecord(query, SELECTED_COMPAS_ENVIRONMENT);
        String currentDate = DateUtils.NORMALIZED_DATE_FORMAT.format(new java.util.Date());

        assertThat(row.get("MEMBERSHIP_NUMBER"), containsString(app.getAARPMemberNumber()));
        assertThat(row.get("FIRST_NAME"), equalTo(app.getFirstName().toUpperCase()));
        assertThat(row.get("MIDDLE_NAME"), equalTo(app.getMI().toUpperCase()));
        assertThat(row.get("LAST_NAME"), equalTo(app.getLastName().toUpperCase()));
        assertThat(row.get("ADDRESS_LINE_1"), equalTo(app.getAddressLine1().toUpperCase()));
        assertThat(row.get("ADDRESS_LINE_2"), equalTo(app.getAddressLine2().toUpperCase()));
        assertThat(row.get("CITY"), equalTo(app.getCity().toUpperCase()));
        assertThat(row.get("DAY_PHONE_NUM"), equalTo(app.getPhonePrimary()));
        assertThat(row.get("EMAIL_ADDRESS"), equalTo(app.getEmail().toUpperCase()));
        assertThat(row.get("BOTH_PARTS_ACTIVE"), equalTo(app.getPartABActiveIndicator() == "yes" ? "Y" : "N"));
        assertThat(row.get("CPA_SIGNATURE_DATE"), equalTo(currentDate));
        assertThat(row.get("APPL_RECEIPT_DATE"), equalTo(currentDate));
        assertThat(row.get("APPL_SIGNATURE_DATE"), equalTo(currentDate));
        assertThat(row.get("STATUS"), equalTo(expectedSubmissionResult.getStatus()));
        assertThat(row.get("CHANNEL"), equalTo("10"));
        assertThat(row.get("ACTOR"), equalTo("1"));
        assertThat(row.get("MECHANISM"), equalTo("2"));
        assertThat(row.get("ADJUDICATION_CD"), equalTo(expectedSubmissionResult.getAdjudicationStatus()));
        assertThat(row.get("EFT_FREQUENCY_TYPE_ID"), equalTo(app.getPlanPaymentOptions().equals("Recurring")?"1":app.getPlanPaymentOptions().equals("OneTime")?"2":"")); //eft 1=reoccuring

        logger.info(String.format("Here is the link to the image... https://acesx-stg-alt.uhc.com/appEnroll-web/resources/retrievePDF/v1/%s", row.get("APPL_IMAGE_NUM_ORIG") +" For the state of --> " + row.get("STATE_CD")));
    }

    public void verifyAdjudicationData(Application app, SubmissionResult expectedSubmissionResult) throws SQLException {
        SELECTED_COMPAS_ENVIRONMENT = PropertyUtils.getProperty("compas.db");

        String query = String.format(ADJUDICATION_QUERY, app.getAARPMembershipNumber(), app.getAARPMembershipNumber());

        HashMap<String, String> row = DbUtils.getSingleRecord(query, SELECTED_COMPAS_ENVIRONMENT);
        assertThat(row.get("ADJUDICATION_CD"), containsString(expectedSubmissionResult.getAdjudicationStatus()));
        assertThat(row.get("TYPE_DESC"), containsString(expectedSubmissionResult.getWorkQueue()));
        assertThat(row.get("ITEM_REASON_TYPE_DESC"), containsString(expectedSubmissionResult.getWorkQueueReason()));
        logger.info(query);
        logger.info("query is "+row.get("TYPE_DESC")+" and expected is "+expectedSubmissionResult.getWorkQueue());

    }

}
