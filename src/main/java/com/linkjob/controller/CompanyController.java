package com.linkjob.controller;

import com.linkjob.entity.Company;
import com.linkjob.entity.Job;
import com.linkjob.service.CompanyService;
import com.linkjob.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private JobService jobService;
    
    //1. 회사 등록
    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }
    
    // 2. 회사 전체 조회
    @GetMapping
    public List<Company> getAllCompanies() { //GET API 추가
        return companyService.getAllCompanies();
    }

    // 회사별 직무 목록 조회
    @GetMapping("/{companyId}/jobs")
    public List<Job> getJobsByCompany(@PathVariable Long companyId) {
        return jobService.getJobsByCompanyId(companyId);
    }

    // 회사 수정
    @PutMapping("/{companyId}")
    public Company updateCompany(@PathVariable Long companyId, @RequestBody Company updatedCompany) {
        return companyService.updateCompany(companyId, updatedCompany);
    }

    // 회사 삭제
    @DeleteMapping("/{companyId}")
    public void deleteCompany(@PathVariable Long companyId) {
        companyService.deleteCompany(companyId);
    }
}
