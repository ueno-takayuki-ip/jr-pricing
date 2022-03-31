package jrpricing.domain.model.superExpressSurcharge.freeSeat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class SeatType {
    @Getter
    private final SeatTypeName seatTypeName;
}
