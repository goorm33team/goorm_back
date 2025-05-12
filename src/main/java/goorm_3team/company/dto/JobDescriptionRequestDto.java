package goorm_3team.company.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// 채용공고 등록 시 사용하는 요청 DTO
// 클라이언트가 입력한 채용 정보가 이 객체에 담겨 서버로 전달됨
@Data // Lombok 어노테이션: Getter, Setter, toString 등을 자동 생성함
@Getter // 중복 선언되어 있으나, 실사용에 큰 문제는 없음
@Setter
public class JobDescriptionRequestDto {

    // 모집 직무명 (예: 백엔드 개발자, 디자이너 등)
    private String position;



    // 필요 경력 기간 (예: 0년, 1년, 3년 등)
    private int requiredCareerPeriod;

    // 연봉 (단위: 만 원)
    private int salary;

    // 스킬
    private String skills;

    private Long companyId;
}
