package jrpricing.domain.model.superExpressSurcharge.additionalCharge;

import jrpricing.application.repository.AdditionalChargeRepository;
import jrpricing.domain.Fare;
import jrpricing.domain.model.route.Route;
import jrpricing.domain.model.superExpressType.SuperExpressType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdditionalChargeService {
    @Autowired
    AdditionalChargeRepository additionalChargeRepository;

    public Fare calculateAdditionalSurcharge(SuperExpressType superExpressType, Route route, Fare fare) {
        return fare.add(additionalChargeRepository.findAdditionalChargeFare(superExpressType, route));
    }
}
