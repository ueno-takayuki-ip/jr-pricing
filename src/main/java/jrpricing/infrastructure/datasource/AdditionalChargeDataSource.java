package jrpricing.infrastructure.datasource;

import jrpricing.application.repository.AdditionalChargeRepository;
import jrpricing.domain.Fare;
import jrpricing.domain.model.route.Route;
import jrpricing.domain.model.station.Station;
import jrpricing.domain.model.station.StationId;
import jrpricing.domain.model.station.StationName;
import jrpricing.domain.model.superExpressType.SuperExpressType;
import jrpricing.domain.model.superExpressType.SuperExpressTypeName;
import org.springframework.stereotype.Repository;

@Repository
public class AdditionalChargeDataSource implements AdditionalChargeRepository {

    @Override
    public Fare findAdditionalChargeFare(SuperExpressType superExpressType, Route route) {
        Station departure = route.getDeparture();
        Station destination = route.getDestination();

        SuperExpressType NOZOMI = new SuperExpressType(new SuperExpressTypeName("のぞみ"));
        SuperExpressType HIKARI = new SuperExpressType(new SuperExpressTypeName("ひかり"));

        Station TOKYO = new Station(new StationId(1), new StationName("東京"));
        Station SHINOSAKA = new Station(new StationId(2), new StationName("新大阪"));
        Station HIMEJI = new Station(new StationId(3), new StationName("姫路"));

        if (superExpressType.equals(HIKARI)) {
            return new Fare(0);
        }

        if (superExpressType.equals(NOZOMI)) {
            if (departure.equals(TOKYO) && destination.equals(SHINOSAKA)) {
                return new Fare(320);
            }
            if (departure.equals(SHINOSAKA) && destination.equals(TOKYO)) {
                return new Fare(320);
            }

            if (departure.equals(TOKYO) && destination.equals(HIMEJI)) {
                return new Fare(530);
            }
            if (departure.equals(HIMEJI) && destination.equals(TOKYO)) {
                return new Fare(530);
            }
        }

        throw new RuntimeException("新幹線の名前が存在しないか、ルートが存在しません。");
    }
}
