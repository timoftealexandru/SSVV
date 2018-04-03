package model;

public class Member {
	private String name;
	private String id;
	private Integer monthlyValue;
	private Integer contributedValue;

	public Member(String name, String id, Integer monthlyValue, Integer contributedValue){
		this.name= name;
		this.id=id;
		this.monthlyValue=monthlyValue;
		this.contributedValue=contributedValue;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public String getId() {
		return this.id;
	}
	public Integer getMonthlyValue() {return this.monthlyValue; }
	public Integer getContributedValue() {return this.contributedValue; }
	public String toString() {
		return this.name + " " + this.id;
	}
}
