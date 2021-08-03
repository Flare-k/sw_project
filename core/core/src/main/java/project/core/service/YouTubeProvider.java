package project.core.service;

import com.google.api.services.youtube.model.SearchResult;
import project.core.dto.QueryDto;
import project.core.dto.video.YouTubeDto;

import java.util.List;

public interface YouTubeProvider {
    List<SearchResult> get(QueryDto queryDto);
}
