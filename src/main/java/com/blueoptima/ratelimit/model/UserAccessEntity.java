package com.blueoptima.ratelimit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_access_log")
public class UserAccessEntity {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userId;
	
	private String url;
	
	private Date accessTime;
	
	public UserAccessEntity() {
	}
	
	public UserAccessEntity(String userId, String url) {
		this.userId = userId;
		this.url = url;
		this.accessTime = new Date();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}

	@Override
	public String toString() {
		return "UserAccessEntity [id=" + id + ", userId=" + userId + ", url=" + url + ", accessTime=" + accessTime
				+ "]";
	}

}
