package jrpricing.domain.model.superExpressSurcharge;

import jrpricing.application.repository.SuperExpressSurchargeRepository;
import jrpricing.domain.Fare;
import jrpricing.domain.model.route.Route;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SuperExpressSurchargeService {
    @Autowired
    SuperExpressSurchargeRepository superExpressSurchargeRepository;

    public Fare surchargeFare(SuperExpressSurcharge superExpressSurcharge, Route route) {
        if (!superExpressSurcharge.isSuperExpress()) {
            return new Fare(0);
        }
        return superExpressSurchargeRepository.findSuperSurcharge(route);

    }

}
