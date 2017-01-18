package com.studentshowcase.service.track;

import com.studentshowcase.model.track.Track;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TrackService {
    void addOrUpdateTrack(Track track);
    Page<Track> getPage(Integer page, Integer size);
}
