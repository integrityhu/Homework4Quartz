package hu.infokristaly.homework.quartz.back.model;

// Generated 2012.10.09. 11:07:05 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QrtzJobDetailsId generated by hbm2java
 */
@Embeddable
public class QrtzJobDetailsId implements java.io.Serializable {

    private String schedName;
    private String jobName;
    private String jobGroup;

    public QrtzJobDetailsId() {
    }

    public QrtzJobDetailsId(String schedName, String jobName, String jobGroup) {
        this.schedName = schedName;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
    }

    @Column(name = "SCHED_NAME", nullable = false, length = 120)
    public String getSchedName() {
        return this.schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Column(name = "JOB_NAME", nullable = false, length = 200)
    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Column(name = "JOB_GROUP", nullable = false, length = 200)
    public String getJobGroup() {
        return this.jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof QrtzJobDetailsId))
            return false;
        QrtzJobDetailsId castOther = (QrtzJobDetailsId) other;

        return ((this.getSchedName() == castOther.getSchedName()) || (this.getSchedName() != null && castOther.getSchedName() != null && this.getSchedName().equals(castOther.getSchedName())))
                && ((this.getJobName() == castOther.getJobName()) || (this.getJobName() != null && castOther.getJobName() != null && this.getJobName().equals(castOther.getJobName())))
                && ((this.getJobGroup() == castOther.getJobGroup()) || (this.getJobGroup() != null && castOther.getJobGroup() != null && this.getJobGroup().equals(castOther.getJobGroup())));
    }

    public int hashCode() {
            int result = 17;
            result = 37 * result + (getSchedName() == null ? 0 : this.getSchedName().hashCode());
            result = 37 * result + (getJobName() == null ? 0 : this.getJobName().hashCode());
            result = 37 * result + (getJobGroup() == null ? 0 : this.getJobGroup().hashCode());
            return result;
    }

}
