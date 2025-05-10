package com.linkjob.service;

import com.linkjob.entity.Company;
import com.linkjob.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies(){ //조회 메서드 추가
        return companyRepository.findAll();
    }
    //회사 정보 수정
    public Company updateCompany(Long id, Company updatedCompany) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("회사 없음"));

        company.setName(updatedCompany.getName());
        company.setLocation(updatedCompany.getLocation());
        company.setIndustry(updatedCompany.getIndustry());

        return companyRepository.save(company);
    }
    // 회사 정보 삭제
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

}
