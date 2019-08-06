
public class Person {

	private String firstNm;

	private String lastNm;

	private String phoneNo;

	public String getFirstNm() {

		return firstNm;

	}

	public void setFirstNm(String firstNm) {

		this.firstNm = firstNm;

	}

	public String getLastNm() {

		return lastNm;

	}

	public void setLastNm(String lastNm) {

		this.lastNm = lastNm;

	}

	public String getPhoneNo() {

		return phoneNo;

	}

	public void setPhoneNo(String phoneNo) {

		this.phoneNo = phoneNo;

	}

	@Override

	public String toString() {

		return "[Name:" + firstNm + " " + lastNm

				+ ", Phone Number:" + phoneNo + "]";

	}

	public Person(String firstNm, String lastNm, String phoneNo) {

		this.firstNm = firstNm;

		this.lastNm = lastNm;

		this.phoneNo = phoneNo;

	}
	 public void changeFirst(String f)
     {
       firstNm=f;
     }
  
     public void changeLast(String l)
     {
       lastNm=l;
     }

}