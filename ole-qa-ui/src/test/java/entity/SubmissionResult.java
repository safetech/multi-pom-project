package entity;

public class SubmissionResult {
    private String adjudicationStatus = "";
    private String status = "";
    private String workQueue = "";
    private String workQueueReason = "";

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


}
