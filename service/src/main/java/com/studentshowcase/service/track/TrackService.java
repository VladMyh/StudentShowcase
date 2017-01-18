package com.studentshowcase.service.track;

import com.studentshowcase.model.track.Track;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrackService {
    void addOrUpdateTrack(Track track);
    Page<Track> getPage(Integer page, Integer size);
    void addStudentToTrack(String trackId, String studentId);
    List<Track> getTracksByIds(List<String> ids);
}
