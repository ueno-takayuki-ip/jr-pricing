package jrpricing.domain.model.superExpressSurcharge;

import jrpricing.application.repository.SuperExpressSurchargeRepository;
import jrpricing.domain.Fare;
import jrpricing.domain.model.station.Station;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SuperExpressSurchargeService {
    SuperExpressSurchargeRepository superExpressSurchargeRepository;

    public Fare surchargeFare(SuperExpressSurcharge superExpressSurcharge, Station departure, Station destination){
        if(!superExpressSurcharge.isSuperExpress()){
            return new Fare(0);
        }
        return superExpressSurchargeRepository.findSuperSurcharge(departure,destination);

    }

}
