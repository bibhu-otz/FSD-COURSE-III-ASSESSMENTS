package bean;

public class Teacher {
	private int  teacher_id;
	private String teacher_name;
	private String teacher_img;
	private String teacher_address;
	private String teacher_phno;
	private String teacher_qualification;
	private String join_date;
	private double teacher_salary;
	
	//Setter & Getter 
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_img() {
		return teacher_img;
	}
	public void setTeacher_img(String teacher_img) {
		this.teacher_img = teacher_img;
	}
	public String getTeacher_address() {
		return teacher_address;
	}
	public void setTeacher_address(String teacher_address) {
		this.teacher_address = teacher_address;
	}
	public String getTeacher_phno() {
		return teacher_phno;
	}
	public void setTeacher_phno(String teacher_phno) {
		this.teacher_phno = teacher_phno;
	}
	public String getTeacher_qualification() {
		return teacher_qualification;
	}
	public void setTeacher_qualification(String teacher_qualification) {
		this.teacher_qualification = teacher_qualification;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public double getTeacher_salary() {
		return teacher_salary;
	}
	public void setTeacher_salary(double teacher_salary) {
		this.teacher_salary = teacher_salary;
	}
	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", teacher_img=" + teacher_img
				+ ", teacher_address=" + teacher_address + ", teacher_phno=" + teacher_phno + ", teacher_qualification="
				+ teacher_qualification + ", join_date=" + join_date + ", teacher_salary=" + teacher_salary + "]";
	}

	
	
}
