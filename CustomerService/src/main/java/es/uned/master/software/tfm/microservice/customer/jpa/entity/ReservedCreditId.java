package es.uned.master.software.tfm.microservice.customer.jpa.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ReservedCreditId implements Serializable {

	private static final long serialVersionUID = 2234618454466060795L;
	
	private Long orderId;
	private Long customerId;

	public ReservedCreditId() {
		super();
	}

	public ReservedCreditId(Long orderId, Long customerId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
	}

	public Long getOrderId() {
		return orderId;
	}
	
	public Long getCustomerId() {
		return customerId;
	}

}
