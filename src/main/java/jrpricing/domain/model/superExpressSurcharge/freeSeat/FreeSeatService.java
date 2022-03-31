package jrpricing.domain.model.superExpressSurcharge.freeSeat;

import jrpricing.domain.Fare;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FreeSeatService {
    public Fare discountFreeSeat(SeatType seatType, Fare fare) {
        FreeSeatPolicy freeSeatPolicy = new FreeSeatPolicy();
        if (seatType.equals(new SeatType(new SeatTypeName("自由席")))) {
            return fare.subtract(freeSeatPolicy.getDiscountValue());
        }
        return fare;
    }
}
