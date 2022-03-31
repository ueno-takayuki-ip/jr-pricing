package jrpricing.presentation.api;

import jrpricing.application.service.SuperExpressFareService;
import jrpricing.domain.model.route.Route;
import jrpricing.domain.model.station.Station;
import jrpricing.domain.model.station.StationId;
import jrpricing.domain.model.station.StationName;
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurcharge;
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurchargeDetail;
import jrpricing.domain.model.superExpressSurcharge.freeSeat.SeatType;
import jrpricing.domain.model.superExpressSurcharge.freeSeat.SeatTypeName;
import jrpricing.domain.model.superExpressType.SuperExpressType;
import jrpricing.domain.model.superExpressType.SuperExpressTypeName;
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
    private SuperExpressFareService superExpressFareService;

    @RequestMapping()
    public Map calculateFare() {
        Station departure = new Station(new StationId(1), new StationName("東京"));
        Station destination = new Station(new StationId(2), new StationName("新大阪"));
        Route route = new Route(departure, destination);
        SuperExpressSurchargeDetail superExpressSurchargeDetail
                = new SuperExpressSurchargeDetail(
                new SuperExpressSurcharge(true), route,
                new SuperExpressType(new SuperExpressTypeName("のぞみ")),
                new SeatType(new SeatTypeName("自由席")));

        Map<String, Object> res = new HashMap<>();

        res.put("値段", superExpressFareService.SuperExpressTotalFare(superExpressSurchargeDetail));

        return res;
    }
}
