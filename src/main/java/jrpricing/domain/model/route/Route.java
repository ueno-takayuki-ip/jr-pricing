package jrpricing.domain.model.route;

import jrpricing.domain.model.station.Station;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Route {
    @Getter
    private final Station departure;
    @Getter
    private final Station destination;
}
