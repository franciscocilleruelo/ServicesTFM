package es.uned.master.software.tfm.microservice.customer.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVED_CREDIT")
public class ReservedCredit implements Serializable {
	
	private static final long serialVersionUID = -5895756852084946427L;
	
	@Id
	private Long orderId;
	@Id
	private Long customerId;
	private int totalReserved;
	
	public Long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public int getTotalReserved() {
		return totalReserved;
	}
	
	public void setTotalReserved(int totalReserved) {
		this.totalReserved = totalReserved;
	}

}
