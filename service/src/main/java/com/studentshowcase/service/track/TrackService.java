package com.studentshowcase.service.track;

import com.studentshowcase.model.track.Track;
import org.springframework.stereotype.Service;

@Service
public interface TrackService {
    void addOrUpdateTrack(Track track);

}
