package jrpricing.application.service;

import jrpricing.application.repository.DistanceRepository;
import jrpricing.domain.Distance;
import jrpricing.domain.model.station.Station;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {
    DistanceRepository distanceRepository;

    public Distance findDistance(Station departure,Station destination){
        return distanceRepository.findDistance(departure,destination);
    }
}
