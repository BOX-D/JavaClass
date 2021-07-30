package vo;
// Value Object 약자

public class Member {
	
	// 1.필드
	private int id;				// 식별id
	private String name;		// 이름
	private String phone;		// 연락처
	private int age;			// 나이
	private String addr;		// 주소
	private String email;		// 이메일
	private String hobby;		// 취미
	
	
	
	// 2.메소드
	// (1) getter, setter
	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	// (2) toString()
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", phone=" + phone + ", age=" + age + ", addr=" + addr
				+ ", email=" + email + ", hobby=" + hobby + "]";
	}
	
	// 3. 생성자
	// (1) 기본생성자
	public Member() {
		super();
	}
	
	// (2) 매개변수생성자
	public Member(int id, String name, String phone, int age, String addr, String email, String hobby) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.addr = addr;
		this.email = email;
		this.hobby = hobby;
	}	
	
	
}
