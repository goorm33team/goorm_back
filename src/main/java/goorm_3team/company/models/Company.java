package goorm_3team.company.models;

import goorm_3team.company.dto.CompanyRequestDto;
import goorm_3team.company.dto.JobDescriptionRequestDto;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 회사 정보를 나타내는 JPA 엔티티 클래스
// DB의 company 테이블과 매핑됨
@Entity
@Setter
@Getter
@NoArgsConstructor // 기본 생성자 필요 (JPA에서 필수로 사용함)
public class Company {

    @Id // 기본 키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 값 사용 (MySQL 기준)
    private Long id;

    // 회사명 (예: 삼성전자)
    private String name;

    // 주소 (예: 서울 강남구 ...)
    private String address;

    // 회사 유형 (예: 대기업, 스타트업 등)
    private String companyType;

    @OneToMany(mappedBy = "company", targetEntity = JobDescription.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobDescription> jobDescriptions;

    // DTO를 받아서 Company 객체로 변환하는 생성자
    public Company(CompanyRequestDto req) {
        setName(req.getName());
        setAddress(req.getAddress());
        setCompanyType(req.getCompanyType());
    }

    public Company(String name, String address, String companyType) {
        this.name = name;
        this.address = address;
        this.companyType = companyType;
    }
}
