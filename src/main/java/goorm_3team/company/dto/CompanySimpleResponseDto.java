package goorm_3team.company.dto;

import goorm_3team.company.models.Company;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanySimpleResponseDto {
    private Long id;
    private String name;
    private String companyType;
    private String address;

    public static CompanySimpleResponseDto toDto(Company company) {
        Long id = company.getId();
        String name = company.getName();
        String companyType = company.getCompanyType();
        String address = company.getAddress();
        return new CompanySimpleResponseDto(id, name, companyType, address);
    }
}
