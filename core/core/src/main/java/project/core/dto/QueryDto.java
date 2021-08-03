package project.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * 사용자가 검색창에 검색하면 위 DTO로 실어서 Service에 전달
 */
public class QueryDto {
    private String query;
}
