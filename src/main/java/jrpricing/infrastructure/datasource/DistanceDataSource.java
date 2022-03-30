package jrpricing.infrastructure.datasource;

import jrpricing.application.repository.DistanceRepository;
import jrpricing.domain.Distance;
import jrpricing.domain.model.station.Station;
import org.springframework.stereotype.Repository;

@Repository
public class DistanceDataSource implements DistanceRepository {
    public Distance findDistance(Station departure, Station destination){
        if(departure.getStationName().equals("東京") && destination.getStationName().equals("新大阪")){
            return new Distance(553);
        }
        if(departure.getStationName().equals("新大阪") && destination.getStationName().equals("東京")){
            return new Distance(553);
        }

        if(departure.getStationName().equals("東京") && destination.getStationName().equals("姫路")){
            return new Distance(644);
        }
        if(departure.getStationName().equals("姫路") && destination.getStationName().equals("東京")){
            return new Distance(644);
        }

        return new Distance(0);
    }
}
