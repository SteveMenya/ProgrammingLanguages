package com.skillsoft.mocks;

public interface ThermometerInterface {

    public default float getTemperatureInDegreeF() {
        return 90;
    }
}
