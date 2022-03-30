package jrpricing.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
public class Fare {
    @Getter
    private final int value;

    public Fare add(Fare fare) {
        return new Fare(value + fare.value);
    }

    public Fare truncate() {
        return new Fare((int) Math.floor(value / 10) * 10);
    }
}
