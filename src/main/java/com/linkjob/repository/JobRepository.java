package com.linkjob.repository;

import com.linkjob.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    //특정 회사에 속한 직무 목록 조회
    List<Job> findByCompanyId(Long companyId);
}
