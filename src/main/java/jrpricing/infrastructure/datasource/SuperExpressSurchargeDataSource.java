package jrpricing.infrastructure.datasource;

import jrpricing.application.repository.SuperExpressSurchargeRepository;
import jrpricing.domain.Fare;
import jrpricing.domain.model.route.Route;
import jrpricing.domain.model.station.Station;
import jrpricing.domain.model.station.StationId;
import jrpricing.domain.model.station.StationName;
import org.springframework.stereotype.Repository;

@Repository
public class SuperExpressSurchargeDataSource implements SuperExpressSurchargeRepository {
    @Override
    public Fare findSuperSurcharge(Route route) {
        Station departure = route.getDeparture();
        Station destination = route.getDestination();

        Station TOKYO = new Station(new StationId(1), new StationName("東京"));
        Station SHINOSAKA = new Station(new StationId(2), new StationName("新大阪"));
        Station HIMEJI = new Station(new StationId(3), new StationName("姫路"));

        if (departure.equals(TOKYO) && destination.equals(SHINOSAKA)) {
            return new Fare(5490);
        }
        if (departure.equals(SHINOSAKA) && destination.equals(TOKYO)) {
            return new Fare(5490);
        }

        if (departure.equals(TOKYO) && destination.equals(HIMEJI)) {
            return new Fare(5920);
        }
        if (departure.equals(HIMEJI) && destination.equals(TOKYO)) {
            return new Fare(5920);
        }

        return new Fare(0);
    }
}
