package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void positivePointsDestinationTest(){
        Point point = new Point(1.0, 1.0, 5.0, 5.0);
        Assert.assertEquals(point.distance(), 5.656854249492381);
    }

    @Test
    public void negativePointsDestinationTest(){
        Point point = new Point(-1.0, -1.0, 5.0, 5.0);
        Assert.assertEquals(point.distance(), 8.48528137423857);
    }

    @Test
    public void zeroPointsDestinationTest(){
        Point point = new Point(0, 0, 0, 0);
        Assert.assertEquals(point.distance(), 0.0);
    }
}
