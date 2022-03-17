package com.shopping;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class PurchaseDetails 
{
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int product_id;
    private String product_name;
	private String product_type;
    private float cost;
	
}
