package jrpricing.application.repository;

import jrpricing.domain.Fare;
import jrpricing.domain.model.station.Station;

public interface SuperExpressSurchargeRepository {
    Fare findSuperSurcharge(Station departure, Station destination);
}
