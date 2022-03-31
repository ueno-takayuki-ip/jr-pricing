package jrpricing.application.repository;

import jrpricing.domain.Fare;
import jrpricing.domain.model.route.Route;

public interface SuperExpressSurchargeRepository {
    Fare findSuperSurcharge(Route route);
}
