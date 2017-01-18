package com.studentshowcase.repository.track;

import com.studentshowcase.model.track.Track;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoTrackRepository extends PagingAndSortingRepository<Track, String> {
}
