package test

import jrpricing.Application
import jrpricing.application.service.SuperExpressFareService
import jrpricing.domain.model.route.Route
import jrpricing.domain.model.station.Station
import jrpricing.domain.model.station.StationId
import jrpricing.domain.model.station.StationName
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurcharge
import jrpricing.domain.model.superExpressSurcharge.SuperExpressSurchargeDetail
import jrpricing.domain.model.superExpressSurcharge.freeSeat.SeatType
import jrpricing.domain.model.superExpressSurcharge.freeSeat.SeatTypeName
import jrpricing.domain.model.superExpressType.SuperExpressType
import jrpricing.domain.model.superExpressType.SuperExpressTypeName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
@SpringBootTest(classes = Application.class)
class IntegrationTest extends Specification {
    @Autowired
    SuperExpressFareService superExpressFareService;

    def "東京 から 新大阪 まで ひかり 指定席 大人片道1枚"() {
        expect://東京から新大阪ひかり指定席大人片道1枚の運賃+特急料金の値段を出力するテスト
        Station departure = new Station(new StationId(1), new StationName("東京"))
        Station destination = new Station(new StationId(2), new StationName("新大阪"))
        Route route = new Route(departure, destination)
        SuperExpressSurchargeDetail superExpressSurchargeDetail = new SuperExpressSurchargeDetail(
                new SuperExpressSurcharge(true), route,
                new SuperExpressType(new SuperExpressTypeName("ひかり")),
                new SeatType(new SeatTypeName("指定席")))

        superExpressFareService.SuperExpressTotalFare(superExpressSurchargeDetail).value == 14400
    }

    def "東京 から #station まで #train #seat 大人片道1枚"() {
        when:
        def actualFare = superExpressFareService.SuperExpressTotalFare(
                new SuperExpressSurchargeDetail(
                        new SuperExpressSurcharge(true),
                        new Route(new Station(
                                new StationId(1), new StationName("東京")),
                                new Station(new StationId(stationId), new StationName(station))),
                        new SuperExpressType(new SuperExpressTypeName(train)),
                        new SeatType(new SeatTypeName(seat)))).value

        then:
        actualFare == expectedFare

        where:
        station | stationId | train | seat  || expectedFare
        "新大阪"   | 2         | "ひかり" | "指定席" || 14400
        "新大阪"   | 2         | "ひかり" | "自由席" || 13870
        "新大阪"   | 2         | "のぞみ" | "指定席" || 14720
        "新大阪"   | 2         | "のぞみ" | "自由席" || 14190
        "姫路"    | 3         | "ひかり" | "指定席" || 15930
        "姫路"    | 3         | "ひかり" | "自由席" || 15400
        "姫路"    | 3         | "のぞみ" | "指定席" || 16460
        "姫路"    | 3         | "のぞみ" | "自由席" || 15930
    }

    //仮テスト実行用
    private static int getFareExample(String station, String train, String seat) {
        int fare = 0
        switch (station) {
            case "新大阪": fare += 8910 + 5490
                if (train == "のぞみ") fare += 320
                break
            case "姫路": fare += 10010 + 5920
                if (train == "のぞみ") fare += 530
                break
        }
        if (seat == "自由席") {
            fare -= 530
        }
        return fare
    }
}
