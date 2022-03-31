package jrpricing.domain.model.superExpressSurcharge;

import jrpricing.domain.Fare;
import jrpricing.domain.model.superExpressSurcharge.additionalCharge.AdditionalChargeService;
import jrpricing.domain.model.superExpressSurcharge.freeSeat.FreeSeatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SuperExpressSurchargeDetailService {
    @Autowired
    private SuperExpressSurchargeService superExpressSurchargeService;
    @Autowired
    private AdditionalChargeService additionalChargeService;
    @Autowired
    private FreeSeatService freeSeatService;

    public Fare calculateTotalSuperExpressSurchargeFare(SuperExpressSurchargeDetail superExpressSurchargeDetail) {
        Fare totalSuperSurchargeFare;
        totalSuperSurchargeFare = superExpressSurchargeService.surchargeFare(
                superExpressSurchargeDetail.getSuperExpressSurcharge(),
                superExpressSurchargeDetail.getRoute());

        totalSuperSurchargeFare = additionalChargeService.calculateAdditionalSurcharge(
                superExpressSurchargeDetail.getSuperExpressType(),
                superExpressSurchargeDetail.getRoute(),
                totalSuperSurchargeFare);

        totalSuperSurchargeFare = freeSeatService.discountFreeSeat(
                superExpressSurchargeDetail.getSeatType(),
                totalSuperSurchargeFare);


        return totalSuperSurchargeFare;
    }
}
