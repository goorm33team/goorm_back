package goorm_3team.company.repositories;

import goorm_3team.company.models.JobDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// 채용공고 엔티티(JobDescription)에 대한 DB 접근 인터페이스
public interface JobDescriptionRepository extends JpaRepository<JobDescription, Long> {

        // 특정 회사 ID에 해당하는 모든 채용공고(JD) 리스트 조회
        List<JobDescription> findByCompanyId(Long companyId);

        // 회사 유형과 경력 조건으로 JD를 필터링해서 조회하는 커스텀 쿼리
        @Query("SELECT j FROM JobDescription j " +
                        "JOIN j.company c " + // JD와 연결된 회사 정보도 함께 조회함
                        "WHERE (:companyType IS NULL OR c.companyType = :companyType) " + // 회사 유형 필터 (null이면 조건 생략)
                        "AND (:career IS NULL OR j.requiredCareerPeriod <= :career)" // 경력 조건 필터 (null이면 조건 생략)
        )
        List<JobDescription> searchJobsByFilters(
                        @Param("companyType") String companyType, // 대기업, 스타트업 등
                        @Param("career") Integer career // 최대 경력 요구 조건
        );
}
