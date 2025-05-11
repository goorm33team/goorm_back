package goorm_3team.company.models;

import goorm_3team.company.dto.JobDescriptionRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 채용공고 정보를 담는 JPA 엔티티
// 하나의 회사(Company)에 여러 개의 JD가 연결될 수 있음
@Entity //필수
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobDescription {

    @Id // 기본 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 ID
    private Long id;

    // 직무명 (예: 백엔드 개발자, 마케팅 매니저 등)
    private String position;

    // 직무 상세 설명
    @Column(length = 500) // 최대 500자 제한
    private String description;

    // 필요 경력 기간 (단위: 년)
    private int requiredCareerPeriod;

    // 연봉 (단위: 만 원)
    private int salary;

    // 스킬
    private String skills;

    // 어떤 회사의 JD인지 나타내는 외래 키 관계
    @ManyToOne
    @JoinColumn(name = "company_id") // FK 컬럼명 설정
    private Company company;

    // 요청 DTO와 연결된 회사 엔티티를 받아서 JD 객체를 생성함
    public JobDescription(JobDescriptionRequestDto req, Company company) {
        setPosition(req.getPosition());
        setRequiredCareerPeriod(req.getRequiredCareerPeriod());
        setSalary(req.getSalary());
        setSkills(req.getSkills());
        setCompany(company);
    }
}
