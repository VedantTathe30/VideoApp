package com.example.service;

import com.example.entity.Video;
import com.example.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }


    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }
}
