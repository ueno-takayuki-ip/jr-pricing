package jrpricing.infrastructure.datasource;

import jrpricing.application.repository.BasicFareRepository;
import jrpricing.domain.Fare;
import jrpricing.domain.model.station.Station;
import jrpricing.domain.model.station.StationId;
import jrpricing.domain.model.station.StationName;
import org.springframework.stereotype.Repository;

@Repository
public class BasicFareDataSource implements BasicFareRepository {
    public Fare findBasicFare(Station departure,Station destination){
        Station TOKYO = new Station(new StationId(1),new StationName("東京"));
        Station SHINOSAKA = new Station(new StationId(2),new StationName("新大阪"));
        Station HIMEJI = new Station(new StationId(3),new StationName("姫路"));

        if(departure.equals(TOKYO) && destination.equals(SHINOSAKA)){
            return new Fare(8910);
        }
        if(departure.equals(SHINOSAKA) && destination.equals(TOKYO)){
            return new Fare(8910);
        }

        if(departure.equals(TOKYO) && destination.equals(HIMEJI)){
            return new Fare(10010);
        }
        if(departure.equals(HIMEJI) && destination.equals(TOKYO)){
            return new Fare(10010);
        }

        throw new RuntimeException("存在しないルートです");
    }
}
