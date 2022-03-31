package jrpricing.domain.model.superExpressSurcharge;

import jrpricing.domain.model.route.Route;
import jrpricing.domain.model.superExpressSurcharge.freeSeat.SeatType;
import jrpricing.domain.model.superExpressType.SuperExpressType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SuperExpressSurchargeDetail {
    @Getter
    private final SuperExpressSurcharge superExpressSurcharge;
    @Getter
    private final Route route;
    @Getter
    private final SuperExpressType superExpressType;
    @Getter
    private final SeatType seatType;
}
