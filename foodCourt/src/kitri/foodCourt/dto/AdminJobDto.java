package kitri.foodCourt.dto;

public class AdminJobDto {

	private String jobId;
	private String jobName;
	private String gradeLevel;
	
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getGradeLevel() {
		return gradeLevel;
	}
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	@Override
	public String toString() {
		return "AdminJobDto [jobId=" + jobId + ", jobName=" + jobName + ", gradeLevel=" + gradeLevel + "]";
	}
	
}
