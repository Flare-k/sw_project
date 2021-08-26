package project.core.service;

import project.core.dto.QueryDto;
import project.core.dto.VideoResponseDto;

import java.util.List;

public interface VideoProvider {
    List<VideoResponseDto> get(QueryDto queryDto);
}
