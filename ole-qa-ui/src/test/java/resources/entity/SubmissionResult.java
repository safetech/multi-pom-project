package resources.entity;

public class SubmissionResult {
    private String adjudicationStatus = "";
    private String status = "";
    private String workQueue = "";
    private String workQueueReason = "";
    private String riderOne = "";
    private String riderTwo = "";
    private String riderThree = "";
    private String riderFour = "";
    private String riderFive = "";
    private String planCode = "";

    public String getRiderFive() {
        return riderFive;
    }

    public void setRiderFive(String riderFive) {
        this.riderFive = riderFive;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getRiderOne() {
        return riderOne;
    }

    public void setRiderOne(String riderOne) {
        this.riderOne = riderOne;
    }

    public String getRiderTwo() {
        return riderTwo;
    }

    public void setRiderTwo(String riderTwo) {
        this.riderTwo = riderTwo;
    }

    public String getRiderThree() {
        return riderThree;
    }

    public void setRiderThree(String riderThree) {
        this.riderThree = riderThree;
    }

    public String getRiderFour() {
        return riderFour;
    }

    public void setRiderFour(String riderFour) {
        this.riderFour = riderFour;
    }

    public String getAdjudicationStatus() {
        return adjudicationStatus;
    }

    public void setAdjudicationStatus(String adjudicationStatus) {
        this.adjudicationStatus = adjudicationStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(String workQueue) {
        this.workQueue = workQueue;
    }

    public String getWorkQueueReason() {
        return workQueueReason;
    }

    public void setWorkQueueReason(String workQueueReason) {
        this.workQueueReason = workQueueReason;
    }

    public void setPendingInfo(String workQueue, String workQueueReason) {
        setAdjudicationStatus("P");
        setStatus("C");
        setWorkQueue(workQueue);
        setWorkQueueReason(workQueueReason);
    }
    public void setAcceptedInfo() {
        setAdjudicationStatus("A");
        setStatus("C");
    }
    public void verifyAcceptedPlanAndRiderCodes(String planCode, String riderOne, String riderTwo, String riderThree, String riderFour) {
        setPlanCode(planCode);
        setRiderOne(riderOne);
        setRiderTwo(riderTwo);
        setRiderThree(riderThree);
        setRiderFour(riderFour);
        setStatus("C");
        setAdjudicationStatus("A");
    }
    public void verifyPendingPlanAndRiderCodes(String planCode, String riderOne, String riderTwo, String riderThree, String riderFour, String workQueue, String workQueueReason) {
        setPlanCode(planCode);
        setRiderOne(riderOne);
        setRiderTwo(riderTwo);
        setRiderThree(riderThree);
        setRiderFour(riderFour);
        setWorkQueue(workQueue);
        setWorkQueueReason(workQueueReason);
        setAdjudicationStatus("P");
        setStatus("C");
    }
    public void verifyPendingAndWorkQPlanAndRiderCodes(String planCode, String riderOne, String riderTwo, String riderThree, String riderFour, String workQueue, String workQueueReason) {
        setPlanCode(planCode);
        setRiderOne(riderOne);
        setRiderTwo(riderTwo);
        setRiderThree(riderThree);
        setRiderFour(riderFour);
        setWorkQueue(workQueue);
        setWorkQueueReason(workQueueReason);
        setAdjudicationStatus("");
        setStatus("Q");
    }
    public void setAcceptedOrPendingInfo(String workQueue, String workQueueReason) {
        setAdjudicationStatus("A P");
        setStatus("C");
        setWorkQueue(workQueue);
        setWorkQueueReason(workQueueReason);
    }
}
