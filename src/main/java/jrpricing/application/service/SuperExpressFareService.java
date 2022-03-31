package jrpricing.application.service;

import jrpricing.application.repository.BasicFareRepository;
import jrpricing.domain.Fare;
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurchargeDetail;
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurchargeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperExpressFareService {
    @Autowired
    private BasicFareRepository basicFareRepository;
    @Autowired
    private SuperExpressSurchargeDetailService superExpressSurchargeDetailService;

    public Fare SuperExpressTotalFare(SuperExpressSurchargeDetail superExpressSurchargeDetail) {
        Fare totalFare;
        totalFare = basicFareRepository.findBasicFare(superExpressSurchargeDetail.getRoute());
        totalFare = totalFare.add(superExpressSurchargeDetailService.calculateTotalSuperExpressSurchargeFare(superExpressSurchargeDetail));

        return totalFare;
    }
}
