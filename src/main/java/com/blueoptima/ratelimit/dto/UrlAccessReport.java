package com.blueoptima.ratelimit.dto;


public class UrlAccessReport {
	
	private String userId;
	
	private String url;
	
	private int perHourCount;
	
	private long perMinutCount;
	
	private int perDayCount;
	
	
	
	public UrlAccessReport() {
	}

	public UrlAccessReport(String userId, String url, int perMinutCount) {
		super();
		this.userId = userId;
		this.url = url;
		this.perMinutCount = perMinutCount;
	}



	public UrlAccessReport(String userId, String url, int perHourCount, int perMinutCount) {
		super();
		this.userId = userId;
		this.url = url;
		this.perHourCount = perHourCount;
		this.perMinutCount = perMinutCount;
	}



	public UrlAccessReport(String userId, String url, int perHourCount, int perMinutCount, int perDayCount) {
		super();
		this.userId = userId;
		this.url = url;
		this.perHourCount = perHourCount;
		this.perMinutCount = perMinutCount;
		this.perDayCount = perDayCount;
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

	public int getPerHourCount() {
		return perHourCount;
	}

	public void setPerHourCount(int perHourCount) {
		this.perHourCount = perHourCount;
	}

	public long getPerMinutCount() {
		return perMinutCount;
	}

	public void setPerMinutCount(long perMinutesCount) {
		this.perMinutCount = perMinutesCount;
	}

	public int getPerDayCount() {
		return perDayCount;
	}

	public void setPerDayCount(int perDayCount) {
		this.perDayCount = perDayCount;
	}
	
	 
	
	

}
