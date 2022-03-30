package jrpricing.presentation.api;

import jrpricing.application.service.FareService;
import jrpricing.domain.model.station.Station;
import jrpricing.domain.model.station.StationId;
import jrpricing.domain.model.station.StationName;
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurcharge;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@Component
public class FareApi {
    @Autowired
    FareService fareService;

    @RequestMapping()
    public Map calculateFare() {
        Station departure = new Station(new StationId(1), new StationName("東京"));
        Station destination = new Station(new StationId(2), new StationName("新大阪"));
        SuperExpressSurcharge superExpressSurcharge = new SuperExpressSurcharge(false);

        Map<String, Object> res = new HashMap<>();

        res.put("値段:", fareService.calculateTotalFare(departure, destination, superExpressSurcharge).getValue());

        return res;
    }
}
