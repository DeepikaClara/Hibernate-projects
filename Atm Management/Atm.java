package atmmanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
	@Entity
	@Table(name="Account_details")
	public class Atm{
		@Id
		@Column(name="account_no")
	private int accountnumber;
		
		@Column(name="name")
	private String account_holder_name;
		@Column(name="phn_no")
	private long phone_number;
		public Atm(int accountnumber, String account_holder_name, long phone_number) {
			super();
			this.accountnumber = accountnumber;
			this.account_holder_name = account_holder_name;
			this.phone_number = phone_number;
		}
		public Atm() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getAccountnumber() {
			return accountnumber;
		}
		public void setAccountnumber(int accountnumber) {
			this.accountnumber = accountnumber;
		}
		public String getAccount_holder_name() {
			return account_holder_name;
		}
		public void setAccount_holder_name(String account_holder_name) {
			this.account_holder_name = account_holder_name;
		}
		public long getPhone_number() {
			return phone_number;
		}
		public void setPhone_number(long phone_number) {
			this.phone_number = phone_number;
		}
		
}
