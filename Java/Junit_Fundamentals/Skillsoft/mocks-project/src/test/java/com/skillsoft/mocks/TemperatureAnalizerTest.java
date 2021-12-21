package com.skillsoft.mocks;

//import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.dom.OnElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TemperatureAnalizerTest {
    private TemperatureAnalizer ta;

    @Mock
    private ThermometerInterface mockedThermometer;

    @BeforeMethod
    public void beforeMethod() {
        mockedThermometer = mock(ThermometerInterface.class);
    }

    @AfterMethod
    public void afterMethod() {
        ta = null;
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {new Object[] {98.6,98.6, true}, new Object[] {99.5, 99.5, true},
                new Object[] {99.6, 99.6, false}, new Object[] {99.4, 99.4, true}, };
    }

    @Test(dataProvider = "dp")
    public void testNormal(double temp1, double temp2, boolean normal) throws Exception {

        //Arrange stage
        when(mockedThermometer.getTemperatureInDegreeF()).thenReturn((float) temp1, (float) temp2);

        //Instantiate the object to test
        ta = new TemperatureAnalizer(mockedThermometer);

        //act state
        ta.diagnoseCondition();

        //assert /check results

        assertEquals(ta.isNormal(), normal);
        verify(mockedThermometer, times(2)).getTemperatureInDegreeF();
    }
}
