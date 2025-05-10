package com.linkjob.service;

import com.linkjob.entity.Company;
import com.linkjob.entity.Job;
import com.linkjob.repository.CompanyRepository;
import com.linkjob.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    public Job addJobToCompany(Long companyId, Job job) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        job.setCompany(company);
        return jobRepository.save(job);
    }

    public List<Job> getJobsByCompanyId(Long companyId) {
        return jobRepository.findByCompanyId(companyId);
    }
    
    //직무 정보 수정
    public Job updateJob(Long companyId, Long jobId, Job updatedJob) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("직무 없음"));

        if (!job.getCompany().getId().equals(companyId)) {
            throw new RuntimeException("회사에 속한 직무가 아닙니다.");
        }

        job.setCareer(updatedJob.getCareer());
        job.setSalary(updatedJob.getSalary());
        job.setSkill(updatedJob.getSkill());

        return jobRepository.save(job);
    }
    //직무 정보 삭제
    public void deleteJob(Long companyId, Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("직무 없음"));

        if (!job.getCompany().getId().equals(companyId)) {
            throw new RuntimeException("회사에 속한 직무가 아닙니다.");
        }

        jobRepository.delete(job);
    }


}