import org.junit.Assert;
import org.junit.Test;


public class EasterCalculationsTest {
    @Test
    public void calculateEasterDateTest2017() {
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(106, testObject.calculateEasterDate(2017, isLeap(2017)));
    }
    @Test
    public void calculateEasterDateTest2018() {
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(91, testObject.calculateEasterDate(2018, isLeap(2018)));
    }
    @Test
    public void calculateEasterDateTest2019() {
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(111, testObject.calculateEasterDate(2019, isLeap(2019)));
    }

    @Test
    public void calculateEasterDateTest2020() {
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(103, testObject.calculateEasterDate(2020, isLeap(2020)));
    }

    @Test
    public void calculateEasterDateTest2021() {
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(94, testObject.calculateEasterDate(2021, isLeap(2021)));
    }

    @Test
    public void calculateEasterDateTest2022(){
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(107, testObject.calculateEasterDate(2022, isLeap(2022)));
    }
    @Test
    public void calculateEasterDateTest2023(){
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(99, testObject.calculateEasterDate(2023, isLeap(2023)));
    }
    @Test
    public void calculateEasterDateTest2024(){
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(91, testObject.calculateEasterDate(2024, isLeap(2024)));
    }
    @Test
    public void calculateEasterDateTest2025(){
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(110, testObject.calculateEasterDate(2025, isLeap(2025)));
    }
    private static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

}