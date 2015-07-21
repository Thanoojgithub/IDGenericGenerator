package com.idgenericgenerator.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK", schema = "PUBLIC")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @GenericGenerator(name="bIdNextgen",strategy="increment")
	 * @GeneratedValue(generator="bIdNextgen")
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BID", unique = true, nullable = false)
	private Long bId;

	@Column(name = "BNAME", unique = true, nullable = false)
	private String bName;

	public Book(String bName) {
		super();
		this.bName = bName;
	}

	public Long getbId() {
		return bId;
	}

	public void setbId(Long bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	@Override
	public String toString() {
		return "Book [bId=" + bId + ", bName=" + bName + "]";
	}

}
