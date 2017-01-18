package com.studentshowcase.restcontroller.controller;

import com.studentshowcase.model.track.Track;
import com.studentshowcase.service.track.TrackService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
