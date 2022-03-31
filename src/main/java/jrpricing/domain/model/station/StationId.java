package jrpricing.domain.model.station;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class StationId {
    @Getter
    private final int value;
}
