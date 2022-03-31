package jrpricing.application.repository;

import jrpricing.domain.Fare;
import jrpricing.domain.model.route.Route;

public interface BasicFareRepository {
    Fare findBasicFare(Route route);
}
