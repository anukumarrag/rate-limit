package com.blueoptima.ratelimit.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueoptima.ratelimit.dto.UrlAccessReport;
import com.blueoptima.ratelimit.model.UserAccessEntity;
import com.blueoptima.ratelimit.repository.UserAccessRepository;

@Service
public class UserAccessService {

	@Autowired
	private UserAccessRepository userAccessRepository;

	private static final int MINUTES = 60;

	public UserAccessEntity create(UserAccessEntity userAccessEntity) {
		return userAccessRepository.save(userAccessEntity);
	}

	public List<UserAccessEntity> findAll() {
		return userAccessRepository.findAll();
	}

	public UrlAccessReport getReport(String userId, String url) {

		UrlAccessReport report = new UrlAccessReport();

		List<UserAccessEntity> users = userAccessRepository.report(userId, url);

		long perMinutesCount = users.stream()
				.filter(data -> ChronoUnit.SECONDS.between(
						LocalDateTime.ofInstant(data.getAccessTime().toInstant(), ZoneId.systemDefault()),
						LocalDate.now()) <= MINUTES)
				.count();

		report.setPerMinutCount(perMinutesCount);
		return report;
	}

}
