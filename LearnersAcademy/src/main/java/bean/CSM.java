package bean;

public class CSM {
	private int csm_id;
	private int class_id;
	private int sub_id;
	private String class_name;
	private String sub_name;
	private int tcsm_id;
	private String class_time;
	private String teacher_name;
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	private int teacher_id;
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public int getTcsm_id() {
		return tcsm_id;
	}
	public void setTcsm_id(int tcsm_id) {
		this.tcsm_id = tcsm_id;
	}
	public String getClass_time() {
		return class_time;
	}
	public void setClass_time(String class_time) {
		this.class_time = class_time;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public int getCsm_id() {
		return csm_id;
	}
	public void setCsm_id(int csm_id) {
		this.csm_id = csm_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	@Override
	public String toString() {
		return "CSM [csm_id=" + csm_id + ", class_id=" + class_id + ", sub_id=" + sub_id + ", class_name=" + class_name
				+ ", sub_name=" + sub_name + ", tcsm_id=" + tcsm_id + ", class_time=" + class_time + ", teacher_name="
				+ teacher_name + ", teacher_id=" + teacher_id + "]";
	}
	
	
}
