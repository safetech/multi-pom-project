package integration.preferences;

import com.github.javafaker.Faker;
import entity.Application;
import entity.SubmissionResult;
import entity.preference.CribSheet;
import integration.CQBaseIntegrationTest;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import pages.preference.CheatPage;
import queries.InsertRowIntoPreference;

import java.text.SimpleDateFormat;
import java.util.Date;


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
    public void createTestDateInEcomTable() throws Exception {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        System.out.println(sdf.format(date));

    }


}
