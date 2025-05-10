package com.linkjob.repository;

import com.linkjob.entity.JobCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobCompanyRepository extends JpaRepository<JobCompany, Long> {
}
