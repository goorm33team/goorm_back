package goorm_3team.company;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Company {

    @Id
    private int id;

    private String name;
    private String industry;
    private String location;
}

