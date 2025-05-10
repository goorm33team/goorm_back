package com.linkjob.controller;

import com.linkjob.entity.Job;
import com.linkjob.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // 전체 직무 조회
    @GetMapping
    public List<Job> getJobs(){
        return jobService.getAllJobs();
    }

    // 단일 직무 등록 (회사 연동 없이)
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }

    // 회사에 직무 등록
    @PostMapping("/company/{companyId}")
    public Job addJobToCompany(@PathVariable Long companyId, @RequestBody Job job) {
        return jobService.addJobToCompany(companyId, job);
    }

    // 직무 수정
    @PutMapping("/company/{companyId}/{jobId}")
    public Job updateJob(@PathVariable Long companyId,
                         @PathVariable Long jobId,
                         @RequestBody Job updatedJob) {
        return jobService.updateJob(companyId, jobId, updatedJob);
    }

    // 직무 삭제
    @DeleteMapping("/company/{companyId}/{jobId}")
    public void deleteJob(@PathVariable Long companyId,
                          @PathVariable Long jobId) {
        jobService.deleteJob(companyId, jobId);
    }
}
