package jrpricing.infrastructure.datasource;

import jrpricing.application.repository.DistanceRepository;
import jrpricing.domain.Distance;
import jrpricing.domain.model.route.Route;
import jrpricing.domain.model.station.Station;
import jrpricing.domain.model.station.StationId;
import jrpricing.domain.model.station.StationName;
import org.springframework.stereotype.Repository;

@Repository
public class DistanceDataSource implements DistanceRepository {
    public Distance findDistance(Route route){
        Station departure = route.getDeparture();
        Station destination = route.getDestination();

        Station TOKYO = new Station(new StationId(1),new StationName("東京"));
        Station SHINOSAKA = new Station(new StationId(2),new StationName("新大阪"));
        Station HIMEJI = new Station(new StationId(3),new StationName("姫路"));

        if(departure.equals(TOKYO) && destination.equals(SHINOSAKA)){
            return new Distance(553);
        }
        if(departure.equals(SHINOSAKA) && destination.equals(TOKYO)){
            return new Distance(553);
        }

        if(departure.equals(TOKYO) && destination.equals(HIMEJI)){
            return new Distance(644);
        }
        if(departure.equals(HIMEJI) && destination.equals(TOKYO)){
            return new Distance(644);
        }

        throw new RuntimeException("存在しないルートです");
    }
}
