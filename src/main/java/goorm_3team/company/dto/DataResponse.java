package goorm_3team.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataResponse {
    private boolean hasNext;
    private List<?> list;
}
