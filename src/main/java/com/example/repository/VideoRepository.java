package com.example.repository;

import com.example.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    
    // ✅ Fixed method name to match field names in `Video` entity
    Optional<Video> findByUserIdAndVideoname(Long userId, String videoname);
}
