package com.studentshowcase.service.track;

import com.studentshowcase.model.track.Track;
import com.studentshowcase.repository.track.MongoTrackRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;

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

    @Override
    public Page<Track> getPage(Integer page, Integer size) {
        LOGGER.info("Getting page " + page + ", of size " + size + " of tracks");
        Page<Track> result = trackRepository.findAll(new PageRequest(page, size));

        return result;
    }

    @Override
    public void addStudentToTrack(String trackId, String studentId) {
        LOGGER.info("Adding student " + studentId + " to track " + trackId);
        Track track = trackRepository.findOne(trackId);

        if(track != null) {
            if(track.getStudentIds() == null) {
                HashSet<String> students = new HashSet<>();
                students.add(studentId);
                track.setStudentIds(students);
            }
            else {
                track.getStudentIds().add(studentId);
            }

            trackRepository.save(track);
        }
        else {
            LOGGER.info("No track with id " + studentId);
        }
    }
}
