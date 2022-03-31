package jrpricing.application.service;

import jrpricing.application.repository.BasicFareRepository;
import jrpricing.domain.Fare;
import jrpricing.domain.model.route.Route;
import jrpricing.domain.model.station.Station;
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurcharge;
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurchargeDetail;
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurchargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FareService {
    @Autowired
    BasicFareRepository basicFareRepository;
    @Autowired
    SuperExpressSurchargeService superExpressSurchargeService;

    public Fare calculateTotalFare(SuperExpressSurchargeDetail superExpressSurchargeDetail) {
        Fare totalFare = basicFareRepository.findBasicFare(superExpressSurchargeDetail.getRoute());

        return totalFare;

    }

    public Fare calculateBasicFare(Route route){
        return basicFareRepository.findBasicFare(route);
    }

}
