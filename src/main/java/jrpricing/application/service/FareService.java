package jrpricing.application.service;

import jrpricing.application.repository.BasicFareRepository;
import jrpricing.domain.Fare;
import jrpricing.domain.model.station.Station;
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurcharge;
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurchargeService;
import jrpricing.infrastructure.datasource.BasicFareDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FareService {
    @Autowired
    BasicFareRepository basicFareRepository;
    @Autowired
    SuperExpressSurchargeService superExpressSurchargeService;

    public Fare calculateTotalFare(Station departure, Station destination, SuperExpressSurcharge superExpressSurcharge) {
        Fare totalFare = basicFareRepository.findBasicFare(departure,destination);
        return totalFare.add(superExpressSurchargeService.surchargeFare(superExpressSurcharge,departure,destination));


//        return totalFare;
    }

}
