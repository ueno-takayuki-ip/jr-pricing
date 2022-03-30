package jrpricing.application.repository;

import jrpricing.domain.Distance;
import jrpricing.domain.model.station.Station;

public interface DistanceRepository {
    Distance findDistance(Station departure, Station destination);
}
