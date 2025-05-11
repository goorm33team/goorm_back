package goorm_3team.company.services;

import goorm_3team.company.dto.CompanyDetailResponseDto;
import goorm_3team.company.dto.CompanySimpleResponseDto;
import goorm_3team.company.dto.DataResponse;
import goorm_3team.company.dto.JobDescriptionSimpleDto;
import goorm_3team.company.models.Company;
import goorm_3team.company.models.JobDescription;
import goorm_3team.company.repositories.CompanyRepository;
import goorm_3team.company.repositories.JobDescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

// 사용자 요청을 처리하는 서비스 클래스
// 회사 목록 조회, JD 검색 등의 기능을 제공함
@Service
@RequiredArgsConstructor
public class UserService {

    private final CompanyRepository companyRepository;
    private final JobDescriptionRepository jobDescriptionRepository;

    // 회사 목록 조회
    // isAll이 true면 전체, false면 최신 4개만 반환함
    public DataResponse findCompanies(boolean isAll, Pageable pageable) {
        Page<Company> companies; // 변수 선언
        if (isAll) {
            // 전체 회사 리스트 반환
            companies = companyRepository.findAll(pageable);
        } else {
            // 최신 회사 4개만 조회 (ID 기준 내림차순 정렬)
            companies = companyRepository.findAll(PageRequest.of(0, 4, Sort.Direction.DESC, "id"));
        }
        List<CompanySimpleResponseDto> companyDtos =  companies.stream().map(company -> CompanySimpleResponseDto.toDto(company)).collect(Collectors.toList());
        //여기서는 각 Company 객체를 → CompanySimpleResponseDto로 바꿈
        return new DataResponse(companies.hasNext(), companyDtos);
    }

    // 회사 유형(companyType)으로 회사 검색
    //대기업이나 스타트업 회사 유형에ㄷ 따라서 검색!
    public List<Company> searchCompany(String companyType) {
        // 빈 문자열로 들어오면 null 처리

        if (companyType.equals("")) {
            companyType = null;
        }
        return companyRepository.findByCompanyType(companyType);
    }

    // 특정 회사 하나를 기준으로 회사의 모든 채용공고를 함께 조회한다.
    public CompanyDetailResponseDto searchJobDescriptionByCompany(Long companyId) {
//        List<JobDescription> jdList = jobDescriptionRepository.findByCompanyId(companyId);
//        return jdList.stream().map(jobDescription -> JobDescriptionSimpleDto.toDto(jobDescription)).collect(Collectors.toList());
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 회사가 존재하지 않습니다."));
        return CompanyDetailResponseDto.toDto(company);
    }






    // 회사 유형과 경력 조건으로 JD 리스트 필터링
    public List<JobDescriptionSimpleDto> searchJobDescriptionByFilter(String companyType, Integer career) {
        List<JobDescription> jds = jobDescriptionRepository.searchJobsByFilters(companyType, career);
        return jds.stream().map(jobDescription -> JobDescriptionSimpleDto.toDto(jobDescription)).collect(Collectors.toList());
    }
}
