package com.studentshowcase.restcontroller.controller;

import com.studentshowcase.model.track.Track;
import com.studentshowcase.service.track.TrackService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    private static final Logger LOGGER = Logger.getLogger(TrackController.class);

    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void saveOrUpdateTrack(@RequestBody Track track) {
        LOGGER.info("saving student");

        trackService.addOrUpdateTrack(track);
    }

    @RequestMapping(value = "/page/{page}/size/{size}", method = RequestMethod.GET)
    public ResponseEntity<?> getPage(@PathVariable(name = "page") Integer page,
                                     @PathVariable(name = "size") Integer size) {
        LOGGER.info("Getting page number " + page + " of size " + size + " of tracks");

        return ResponseEntity.ok(trackService.getPage(page - 1, size));
    }

    @RequestMapping(value = "{id}/students", method = RequestMethod.POST)
    public void addTrack(@PathVariable(name = "id") String trackId,
                         @RequestBody String studentId) {
        LOGGER.info("Adding student " + studentId + " to track " + trackId);

        trackService.addStudentToTrack(trackId, studentId);
    }
}
