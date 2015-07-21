package com.idgenericgenerator.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CUSTOMER", schema = "PUBLIC")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cIdNextValGen")
	@GenericGenerator(name = "cIdNextValGen", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "cid_nextval") })
	@Column(name = "CID", unique = true, nullable = false)
	private Long cId;
	
	@Column(name = "CNAME", unique = true, nullable = false)
	private String cName;
	
	public Customer(String cName) {
		super();
		this.cName = cName;
	}

	
	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getCName() {
		return cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", CName=" + cName + "]";
	}

}
