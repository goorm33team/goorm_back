package goorm_3team.company.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import goorm_3team.company.models.Company;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDetailResponseDto {
    private Long id;
    private String name;
    private String companyType;
    private String address;
    private List<JobDescriptionSimpleDto> jobs;

    public static CompanyDetailResponseDto toDto(Company company) {
        Long id = company.getId();
        String name = company.getName();
        String companyType = company.getCompanyType();
        String address = company.getAddress();
        List<JobDescriptionSimpleDto> jobs = company.getJobDescriptions().stream().map(JobDescriptionSimpleDto::toDto).collect(Collectors.toList());
        return new CompanyDetailResponseDto(id, name, companyType, address, jobs);
    }
}


