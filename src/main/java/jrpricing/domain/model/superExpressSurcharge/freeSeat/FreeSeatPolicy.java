package jrpricing.domain.model.superExpressSurcharge.freeSeat;

import jrpricing.domain.Fare;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FreeSeatPolicy {
    private final int discountValue = 530;

    public Fare discount(FreeSeat freeSeat, Fare fare) {
        if (freeSeat.isFreeSeat()) {
            return new Fare(fare.getValue() - discountValue);
        }
        return fare;
    }
}
