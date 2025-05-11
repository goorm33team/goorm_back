package goorm_3team.company.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// 회사 등록 요청 시 사용하는 데이터 전달 객체 (DTO)
// 클라이언트 → 서버로 전달되는 데이터를 담는 용도임
@Data // Lombok 어노테이션: 모든 필드에 대해 Getter, Setter, toString 등을 자동 생성함
@Getter // 명시적으로도 추가돼 있음 (Data 어노테이션에 포함되어 있으므로 중복임)
@Setter
public class CompanyRequestDto {

    // 회사 이름 (예: 카카오, 네이버 등)
    private String name;

    // 회사 주소 (예: 서울특별시 강남구 ...)
    private String address;

    // 회사 유형 (예: 대기업, 스타트업, 중견기업 등)
    private String companyType;
}
