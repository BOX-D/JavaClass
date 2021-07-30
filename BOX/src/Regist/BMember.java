package Regist;

public class BMember {
	
	private String b_id;
	private String b_pw;
	private String b_name;
	private String b_phone;
	private String b_email;
	private String b_addr;
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_pw() {
		return b_pw;
	}
	public void setB_pw(String b_pw) {
		this.b_pw = b_pw;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_phone() {
		return b_phone;
	}
	public void setB_phone(String b_phone) {
		this.b_phone = b_phone;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}
	public String getB_addr() {
		return b_addr;
	}
	public void setB_addr(String b_addr) {
		this.b_addr = b_addr;
	}
	@Override
	public String toString() {
		return "BMember [b_id=" + b_id + ", b_pw=" + b_pw + ", b_name=" + b_name + ", b_phone=" + b_phone + ", b_email="
				+ b_email + ", b_addr=" + b_addr + ", getB_id()=" + getB_id() + ", getB_pw()=" + getB_pw()
				+ ", getB_name()=" + getB_name() + ", getB_phone()=" + getB_phone() + ", getB_email()=" + getB_email()
				+ ", getB_addr()=" + getB_addr() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public BMember() {
		super();
	}
	public BMember(String b_id, String b_pw, String b_name, String b_phone, String b_email, String b_addr) {
		super();
		this.b_id = b_id;
		this.b_pw = b_pw;
		this.b_name = b_name;
		this.b_phone = b_phone;
		this.b_email = b_email;
		this.b_addr = b_addr;
	}
	
	
}
