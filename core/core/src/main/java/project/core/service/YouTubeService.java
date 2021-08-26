package project.core.service;


import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.api.services.youtube.model.*;
import org.springframework.stereotype.Service;
import project.core.dto.QueryDto;
import project.core.dto.VideoResponseDto;

import java.io.IOException;
import java.util.Iterator;

@Service
public class YouTubeService implements VideoProvider {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final long NUMBER_OF_VIDEOS_RETURNED = 25;
    private static String PROPERTIES_FILENAME = "application.properties";
    private static YouTube youTube;

    @Override
    public List<VideoResponseDto> get(QueryDto queryDto) {

        List<SearchResult> videoTmp = new ArrayList<>();
        Properties properties = new Properties();

        try {
            InputStream in = YouTube.Search.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
            properties.load(in);

        } catch (IOException e) {
            System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()  + " : " + e.getMessage());
            System.exit(1);
        }

        List<VideoResponseDto> videoList = new ArrayList<>();

        try {
            youTube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                    public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-video-duration-get").build();

            YouTube.Search.List videos = youTube.search().list("id,snippet");

            String apiKey = properties.getProperty("youtube.apikey");   // apiKey 설정
            videos.setKey(apiKey);
            videos.setQ(queryDto.getQuery());       // 검색어를 파라미터로
            videos.setType("video");
            videos.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
            videos.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

            SearchListResponse searchResponse = videos.execute();

            videoTmp = searchResponse.getItems(); // videoTmp에 SearchResult의 값 할당

            Iterator<SearchResult> iteratorSearchResults = videoTmp.iterator(); // videoTmp의 값을 VideoResponseDto인 videoList에 할당할 것

            if (!iteratorSearchResults.hasNext()) {
                System.out.println(" There aren't any results for your query.");
            }

            while (iteratorSearchResults.hasNext()) {

                SearchResult singleVideo = iteratorSearchResults.next();
                ResourceId rId = singleVideo.getId();

                // Double checks the kind is video.
                if (rId.getKind().equals("youtube#video")) {

                    Thumbnail thumbnail = (Thumbnail) singleVideo.getSnippet().getThumbnails().get("default");

                    VideoResponseDto videoResponseDto = new VideoResponseDto();
                    videoResponseDto.setId(rId.getVideoId());
                    videoResponseDto.setTitle(singleVideo.getSnippet().getTitle());
                    videoResponseDto.setUrl("https://www.youtube.com/embed/" + rId.getVideoId());
                    videoResponseDto.setThumbnails(thumbnail.getUrl());
                    videoResponseDto.setPlatform("youtube");

                    videoList.add(videoResponseDto);
                }
            }
        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return videoList;
    }
}
