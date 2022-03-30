package jrpricing.infrastructure.datasource;

import jrpricing.application.repository.SuperExpressSurchargeRepository;
import jrpricing.domain.Fare;
import jrpricing.domain.model.station.Station;
import org.springframework.stereotype.Repository;

@Repository
public class SuperExpressSurchargeDataSource implements SuperExpressSurchargeRepository {
    @Override
    public Fare findSuperSurcharge(Station departure, Station destination) {
        if (departure.getStationName().equals("東京") && destination.getStationName().equals("新大阪")) {
            return new Fare(5490);
        }
        if (departure.getStationName().equals("新大阪") && destination.getStationName().equals("東京")) {
            return new Fare(5490);
        }

        if (departure.getStationName().equals("東京") && destination.getStationName().equals("姫路")) {
            return new Fare(5920);
        }
        if (departure.getStationName().equals("姫路") && destination.getStationName().equals("東京")) {
            return new Fare(5920);
        }

        return new Fare(0);
    }
}
