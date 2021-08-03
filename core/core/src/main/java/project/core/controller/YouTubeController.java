package project.core.controller;

import com.google.api.services.youtube.model.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.core.dto.QueryDto;
import project.core.dto.video.YouTubeDto;
import project.core.service.YouTubeProvider;

import java.util.List;

@RestController
public class YouTubeController {

    private YouTubeProvider youTUbeProvider;

    @Autowired
    public YouTubeController(final YouTubeProvider youTUbeProvider) {
        this.youTUbeProvider = youTUbeProvider;
    }

    @GetMapping("/youtube")
    public List<SearchResult> Index(@RequestBody QueryDto queryDto) {
        return youTUbeProvider.get(queryDto);
    }
}
