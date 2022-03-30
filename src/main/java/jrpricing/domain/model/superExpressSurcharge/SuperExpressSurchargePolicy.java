package jrpricing.domain.model.superExpressSurcharge;

import jrpricing.domain.model.superExpressSurcharge.freeSeat.FreeSeat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SuperExpressSurchargePolicy {
    @Getter
    private final FreeSeat freeSeat;


}
