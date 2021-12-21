package com.skillsoft.mocks;

public class TemperatureAnalizer {
    private ThermometerInterface thermometerInterface = null;

    private boolean hypothermia = false;
    private boolean normal = true;
    private boolean fever = false;
    private boolean hyperpyrexia =false;


    public TemperatureAnalizer( ThermometerInterface thermometerInterface){
        super();
        this.thermometerInterface = thermometerInterface;
    }

    public void diagnoseCondition() throws Exception {
        if(thermometerInterface == null) {
            throw new Exception("Thermometer interface not properly defined");
        }
        //Get the first temperature
        float temp1 = thermometerInterface.getTemperatureInDegreeF();

        //Get the second
        float temp2 = thermometerInterface.getTemperatureInDegreeF();

        //Calculate the difference
        float difference = Math.abs(temp1 - temp2);

        if( difference > 1.0) {
            throw new Exception("This is too large of a temperature differential");
        }

        //Calculate the average temperature
        float average  = (float) ((temp1 + temp2) / 2.0);

        // Based on the conditions, set the diagnosis appropriately

        if (average < 95.0) {
            hypothermia = true;
            normal = false;
            fever = false;
            hyperpyrexia = false;
        }
        else if ((97.7 < average) && (average <= 99.5)) {
            hypothermia = false;
            normal = true;
            fever = false;
            hyperpyrexia = false;
        }
        else if ((99.5 < average) && (average <= 105.8)) {
            hypothermia = false;
            normal = false;
            fever = true;
            hyperpyrexia = false;
        }
        else if (average > 105.8) {
            hypothermia = false;
            normal = false;
            fever = true;
            hyperpyrexia = true;
        }
        else {
            hypothermia = false;
            normal = false;
            fever = false;
            hyperpyrexia = false;
        }
    }

    public boolean isHypothermia() {
        return hypothermia;
    }
    public boolean isNormal() {
        return normal;
    }
    public boolean isFever() {
        return fever;
    }
    public boolean isHyperpyrexia() {
        return hyperpyrexia;
    }
}
