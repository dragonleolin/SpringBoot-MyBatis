package com.example.demo.pojo;

public class ExcelDataBean {
	public ExcelDataBean() {

	}

	/** 姓名 */
	private String name;
	/** 年齡 */
	private Integer age;
	/** 居住地 */
	private String location;
	/** 職業 */
	private String job;
	/** 性別 */
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
