package bean;

public class Student {
	private int std_id;
	private String std_name;
	private String std_rollno;
	private String admission_date;
	private String std_address;
	private String class_name;
	private int class_id;
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getStd_rollno() {
		return std_rollno;
	}
	public void setStd_rollno(String std_rollno) {
		this.std_rollno = std_rollno;
	}
	public String getAdmission_date() {
		return admission_date;
	}
	public void setAdmission_date(String admission_date) {
		this.admission_date = admission_date;
	}
	public String getStd_address() {
		return std_address;
	}
	public void setStd_address(String std_address) {
		this.std_address = std_address;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	@Override
	public String toString() {
		return "Student [std_id=" + std_id + ", std_name=" + std_name + ", std_rollno=" + std_rollno
				+ ", admission_date=" + admission_date + ", std_address=" + std_address + ", class_name=" + class_name
				+ ", class_id=" + class_id + "]";
	}
	
	
	
}
