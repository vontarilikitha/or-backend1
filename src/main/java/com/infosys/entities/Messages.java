package com.infosys.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Messages {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Role from;
	
	private String toRoleId;
	
	private String message;

	public Messages() {
		super();
	}

	public Messages(int id, Role from, String toRoleId, String message) {
		super();
		this.id = id;
		this.from = from;
		this.toRoleId = toRoleId;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getFrom() {
		return from;
	}

	public void setFrom(Role from) {
		this.from = from;
	}

	public String getToRoleId() {
		return toRoleId;
	}

	public void setToRoleId(String toRoleId) {
		this.toRoleId = toRoleId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Messages [id=" + id + ", from=" + from + ", toRoleId=" + toRoleId + ", message=" + message + "]";
	}
	
	
	
}
