package jrpricing.application.repository;

import jrpricing.domain.Distance;
import jrpricing.domain.model.route.Route;
import jrpricing.domain.model.station.Station;

public interface DistanceRepository {
    Distance findDistance(Route route);
}
