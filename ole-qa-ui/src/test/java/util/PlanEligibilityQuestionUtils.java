package util;

import java.util.Date;

import static org.apache.commons.lang3.time.DateUtils.addMonths;
import static org.apache.commons.lang3.time.DateUtils.addYears;

public class PlanEligibilityQuestionUtils {

    public static String hasTurned65In6GABasedUponDpsd(Date dob, Date dpsd) {

        Date sixtyFifthBirthday = addYears(dob, 65);

        // return NO if dpsd is before 65th birthday
        if(dpsd.compareTo(sixtyFifthBirthday) < 0) {
            return AnswerUtils.NO;
        }
        // return NO if dpsd more than 6 months after 65th birthday
        if(dpsd.compareTo(addMonths(sixtyFifthBirthday,6)) > 0) {
            return AnswerUtils.NO;
        }

        return AnswerUtils.YES;
    }

    public static String hasPartBIn6GABasedUponDpsd(Date mpbed, Date dpsd) {

        // return NO if dpsd is before mpbed
        if(dpsd.compareTo(mpbed) < 0) {
            return AnswerUtils.NO;
        }
        // return NO if dpsd more than 6 months after mpbed
        if(dpsd.compareTo(addMonths(mpbed,6)) > 0) {
            return AnswerUtils.NO;
        }

        return AnswerUtils.YES;
    }

    public static String hasPlanEffIn6OfEligibleBasedUponDpsd(Date dob, Date mpbed, Date dpsd) {

        if(PlanEligibilityQuestionUtils.hasTurned65In6GABasedUponDpsd(dob, dpsd).equals(AnswerUtils.YES)) {
            return AnswerUtils.YES;
        }
        if(PlanEligibilityQuestionUtils.hasPartBIn6GABasedUponDpsd(mpbed, dpsd).equals(AnswerUtils.NO)) {
            return AnswerUtils.YES;
        }
        return AnswerUtils.NO;

    }
}
