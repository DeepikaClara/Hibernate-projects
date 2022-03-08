package hibernate_projects.sample_programs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_details")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="e_empid")
private int empid;
	
	@Column(name="e_ename")
private String ename;
	@Column(name="e_salary")
private double salary;
	@Column(name="e_email_id")
private String email_id;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String ename, double salary, String email_id) {
		super();
		this.ename = ename;
		this.salary = salary;
		this.email_id = email_id;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email_id;
	}
	public void setEmail(String email_id) {
		this.email_id = email_id;
	}
	
}
