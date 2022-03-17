package com.shopping;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class CustomerDetails{
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int customer_id;
	private String name;
	private String mail_id;
    private long phone_number;
    private String address;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private List<PurchaseDetails>purchases;
	



}
