package goorm_3team.company.services;

import goorm_3team.company.dto.CompanyRequestDto;
import goorm_3team.company.dto.JobDescriptionRequestDto;
import goorm_3team.company.models.Company;
import goorm_3team.company.models.JobDescription;
import goorm_3team.company.repositories.CompanyRepository;
import goorm_3team.company.repositories.JobDescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 관리자 기능을 담당하는 서비스 클래스
// 회사 등록, 채용공고 등록 기능을 포함함
@Service
@RequiredArgsConstructor // 생성자 주입 자동 생성
public class AdminService {

    private final CompanyRepository companyRepository;
    private final JobDescriptionRepository jobDescriptionRepository;

    // 회사 등록 처리
    public void registerCompany(CompanyRequestDto req) {
        // 요청 DTO를 Company 엔티티로 변환
        Company company = new Company(req);
        // DB에 저장
        companyRepository.save(company);
    }

    // 채용공고 등록 처리
    public void registerJobDescription(JobDescriptionRequestDto req) {
        // DTO에 포함된 companyId로 실제 회사 조회
        Company company = companyRepository.findById(req.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Can't find company with ID : " + req.getCompanyId()));

        // 요청 DTO와 회사 정보를 바탕으로 JD 생성
        JobDescription jobDescription = new JobDescription(req, company);

        // DB에 저장
        jobDescriptionRepository.save(jobDescription);
    }
}
