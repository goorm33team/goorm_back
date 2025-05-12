package goorm_3team.company.dto;

import goorm_3team.company.models.Company;
import goorm_3team.company.models.JobDescription;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobDescriptionSimpleDto {
    private Long id;
    private String position;
    private String skills;
    private int requiredCareerPeriod;
    private int salary;

    //프론트에 보내기위해

    public static JobDescriptionSimpleDto toDto(JobDescription jd) {
        Long id = jd.getId();
        String position = jd.getPosition();
        String skills = jd.getSkills();
        int requiredCareerPeriod = jd.getRequiredCareerPeriod();
        int salary = jd.getSalary();
        return new JobDescriptionSimpleDto(id, position, skills, requiredCareerPeriod, salary);
    }
}
