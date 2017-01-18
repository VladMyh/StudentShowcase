package com.studentshowcase.service.track;

import com.studentshowcase.model.track.Track;
import com.studentshowcase.repository.track.MongoTrackRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService {

    private static final Logger LOGGER = Logger.getLogger(TrackServiceImpl.class);

    private MongoTrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(MongoTrackRepository trackRepository) {
        LOGGER.info("Initializing TrackServiceImpl");
        this.trackRepository = trackRepository;
    }

    @Override
    public void addOrUpdateTrack(Track track) {
        LOGGER.info("Saving track");
        trackRepository.save(track);
    }
}
