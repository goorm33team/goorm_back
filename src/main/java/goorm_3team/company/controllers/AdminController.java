package goorm_3team.company.controllers;

import goorm_3team.company.dto.CompanyRequestDto;
import goorm_3team.company.dto.JobDescriptionRequestDto;
import goorm_3team.company.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 관리자용 API 컨트롤러
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    // AdminService 주입됨 (생성자 통해 자동 주입됨)
    private final AdminService adminService;

    // 회사 등록 요청 처리
    @PostMapping("/register/company")
    public ResponseEntity<?> registerCompany(@RequestBody CompanyRequestDto req) {
        // 서비스 레이어에 등록 요청 전달
        adminService.registerCompany(req);
        // 응답은 상태 코드 200 OK만 반환함
        return ResponseEntity.ok().build();
    }

    // 채용 공고 등록 요청 처리
    @PostMapping("/register/job-description")
    public ResponseEntity<?> registerJobDescription(@RequestBody JobDescriptionRequestDto req) {
        // 서비스에 JD 등록 요청 전달
        adminService.registerJobDescription(req);
        // 성공 시 OK 반환
        return ResponseEntity.ok().build();
    }
}
