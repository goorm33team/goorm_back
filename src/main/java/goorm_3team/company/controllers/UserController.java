package goorm_3team.company.controllers;

import goorm_3team.company.dto.CompanyDetailResponseDto;
import goorm_3team.company.dto.CompanySimpleResponseDto;
import goorm_3team.company.dto.DataResponse;
import goorm_3team.company.dto.JobDescriptionSimpleDto;
import goorm_3team.company.models.Company;
import goorm_3team.company.models.JobDescription;
import goorm_3team.company.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


// 사용자용 API 컨트롤러
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    // UserService 주입됨
    private final UserService userService;

    // 모든 회사 리스트 조회
    @GetMapping("/companies/all")
    public ResponseEntity<DataResponse> getCompanies(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 10) Pageable pageable) {
        //내림차순
        // true 전달 → 전체 회사 리스트 조회함
        return ResponseEntity.ok(userService.findCompanies(true, pageable));
    }

    // 최신 회사 4개만 조회
    @GetMapping("/companies/latest")
    public ResponseEntity<DataResponse> getLastestCompanies(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 4) Pageable pageable) {
        // false 전달 → 최신 회사 4개만 조회함
        return ResponseEntity.ok(userService.findCompanies(false, pageable));
    }

    // 특정 회사의 채용공고 리스트 조회
    @GetMapping("/jobs/company/{id}")
    public ResponseEntity<CompanyDetailResponseDto> getCompany(@PathVariable Long id) {
        // 회사 ID 기준으로 JD 리스트 반환함
        return ResponseEntity.ok(userService.searchJobDescriptionByCompany(id));
    }

    // 필터 조건(기업유형, 경력)에 따른 채용공고 검색
    @GetMapping("/jobs/filter")
    public ResponseEntity<List<JobDescriptionSimpleDto>> searchJobs(
            @RequestParam(required = false, defaultValue = "") String companyType,
            @RequestParam(required = false, defaultValue = "0") Integer career) {
        // 필터 기준에 맞는 JD 리스트 반환함
        return ResponseEntity.ok(userService.searchJobDescriptionByFilter(companyType, career));
    }
}
