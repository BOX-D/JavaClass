package NAVERID;

public class NMember {
	// 데이터베이스에 있는 컬럼들을 클래스의 필드로 선언
	/*
	 	N_ID     NVARCHAR2(20),
     	N_PW     NVARCHAR2(16),
     	N_NAME   NVARCHAR2(5),
     	N_BIRTH  DATE,
     	N_GENDER NVARCHAR2(2),
     	N_EMAIL  NVARCHAR2(50),
     	N_PHONE  NVARCHAR2(20)
	 */
	
	private String n_id;
	private String n_pw;
	private String n_name;
	private String n_birth;
	private String n_gender;
	private String n_email;
	private String n_phone;
	
	// getter, setter 
	
	public String getN_id() {
		return n_id;
	}
	public void setN_id(String n_id) {
		this.n_id = n_id;
	}
	public String getN_pw() {
		return n_pw;
	}
	public void setN_pw(String n_pw) {
		this.n_pw = n_pw;
	}
	public String getN_name() {
		return n_name;
	}
	public void setN_name(String n_name) {
		this.n_name = n_name;
	}
	public String getN_birth() {
		return n_birth;
	}
	public void setN_birth(String n_birth) {
		this.n_birth = n_birth;
	}
	public String getN_gender() {
		return n_gender;
	}
	public void setN_gender(String n_gender) {
		this.n_gender = n_gender;
	}
	public String getN_email() {
		return n_email;
	}
	public void setN_email(String n_email) {
		this.n_email = n_email;
	}
	public String getN_phone() {
		return n_phone;
	}
	public void setN_phone(String n_phone) {
		this.n_phone = n_phone;
	}
	
	
	// toString
	@Override
	public String toString() {
		return "NMember [n_id=" + n_id + ", n_pw=" + n_pw + ", n_name=" + n_name + ", n_birth=" + n_birth
				+ ", n_gender=" + n_gender + ", n_email=" + n_email + ", n_phone=" + n_phone + "]";
	}
	
	// constructor
	public NMember() {
		super();
	}
	
	public NMember(String n_id, String n_pw, String n_name, String n_birth, String n_gender, String n_email,
			String n_phone) {
		super();
		this.n_id = n_id;
		this.n_pw = n_pw;
		this.n_name = n_name;
		this.n_birth = n_birth;
		this.n_gender = n_gender;
		this.n_email = n_email;
		this.n_phone = n_phone;
	}
	
		
}
