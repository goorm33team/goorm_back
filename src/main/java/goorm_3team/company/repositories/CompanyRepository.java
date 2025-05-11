package goorm_3team.company.repositories;

import goorm_3team.company.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 회사 엔티티(Company)에 대한 DB 접근 인터페이스
// JpaRepository를 상속받으면 기본적인 CRUD 메서드가 자동으로 생성됨
public interface CompanyRepository extends JpaRepository<Company, Long> {

    // 회사 유형(companyType)에 따라 회사 목록을 조회함
    // 예: "대기업", "스타트업" 등으로 필터링할 때 사용함
    List<Company> findByCompanyType(String companyType);
}
