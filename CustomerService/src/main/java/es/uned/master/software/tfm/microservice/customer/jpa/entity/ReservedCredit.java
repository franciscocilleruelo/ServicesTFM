package es.uned.master.software.tfm.microservice.customer.jpa.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVED_CREDIT")
public class ReservedCredit implements Serializable {
	
	private static final long serialVersionUID = -5895756852084946427L;
	
	@EmbeddedId
	private ReservedCreditId reservedCreditId;
	private int totalReserved;
	
	public ReservedCredit() {
		super();
	}

	public ReservedCredit(ReservedCreditId reservedCreditId, int totalReserved) {
		super();
		this.reservedCreditId = reservedCreditId;
		this.totalReserved = totalReserved;
	}

	public ReservedCreditId getReservedCreditId() {
		return reservedCreditId;
	}

	public void setReservedCreditId(ReservedCreditId reservedCreditId) {
		this.reservedCreditId = reservedCreditId;
	}

	public int getTotalReserved() {
		return totalReserved;
	}
	
	public void setTotalReserved(int totalReserved) {
		this.totalReserved = totalReserved;
	}

}
