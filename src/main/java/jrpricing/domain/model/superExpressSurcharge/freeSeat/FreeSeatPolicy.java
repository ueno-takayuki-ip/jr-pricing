package jrpricing.domain.model.superExpressSurcharge.freeSeat;

import jrpricing.domain.Fare;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class FreeSeatPolicy {
    @Getter
    private final Fare discountValue = new Fare(530);
}
