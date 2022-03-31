package jrpricing.application.repository;

import jrpricing.domain.Fare;
import jrpricing.domain.model.route.Route;
import jrpricing.domain.model.superExpressType.SuperExpressType;

public interface AdditionalChargeRepository {
    Fare findAdditionalChargeFare(SuperExpressType superExpressType, Route route);
}
