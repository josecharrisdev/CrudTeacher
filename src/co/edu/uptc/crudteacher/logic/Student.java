package co.edu.uptc.crudteacher.logic;

public class Student extends BaseClass {
	private String code;
	private String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + "]";
	}
	
	
}
