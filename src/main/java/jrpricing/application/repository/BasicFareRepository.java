package jrpricing.application.repository;

import jrpricing.domain.Fare;
import jrpricing.domain.model.station.Station;

public interface BasicFareRepository {
    Fare findBasicFare(Station departure,Station destination);
}
