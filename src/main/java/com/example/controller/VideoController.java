package com.example.controller;

import com.example.entity.Video;
import com.example.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/videos") 
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "*")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> videos = videoService.getAllVideos();
        return ResponseEntity.ok(videos);  
    }
    
    @PostMapping
    public ResponseEntity<Video> addVideo(@RequestBody Video video) {
        return ResponseEntity.ok(videoService.saveVideo(video));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> updateVideo(
            @PathVariable Long id,
            @RequestBody Video updatedVideo) {
        
        Optional<Video> existingVideo = videoService.getVideoById(id);
        if (existingVideo.isPresent()) {
            Video video = existingVideo.get();
            video.setVideoname(updatedVideo.getVideoname());
            video.setLink(updatedVideo.getLink());
            video.setWebsitelink(updatedVideo.getWebsitelink());
            video.setGithublink(updatedVideo.getGithublink());
            return ResponseEntity.ok(videoService.saveVideo(video));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getVideoById(@PathVariable Long id) {
        Optional<Video> video = videoService.getVideoById(id);

        if (video.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("videoUrl", video.get().getLink());  // Assuming 'link' contains the video URL
            response.put("websiteUrl", video.get().getWebsitelink()); // Assuming 'link' contains the video URL
            response.put("githubUrl", video.get().getGithublink());  // Assuming 'link' contains the video URL
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
