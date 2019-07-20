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
    public void calculateEasterDateTest2022() {
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(107, testObject.calculateEasterDate(2022, isLeap(2022)));
    }

    @Test
    public void calculateEasterDateTest2023() {
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(99, testObject.calculateEasterDate(2023, isLeap(2023)));
    }

    @Test
    public void calculateEasterDateTest2024() {
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(91, testObject.calculateEasterDate(2024, isLeap(2024)));
    }

    @Test
    public void calculateEasterDateTest2025() {
        EasterCalculations testObject = new EasterCalculations();
        Assert.assertEquals(110, testObject.calculateEasterDate(2025, isLeap(2025)));
    }

    @Test
    public void gausseVsButcherTest() {
        EasterCalculations testObject = new EasterCalculations();
        for (int i = 1900; i <= 2099; i++) {
            Assert.assertEquals(methodGausse(i, isLeap(i)), testObject.calculateEasterDate(i, isLeap(i)));
        }
    }

    private boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private int methodGausse(int year, boolean isLeapYear) {
        final int centuryPaschalFullMoon = 24, cycleOfDaysOfWeek = 5; //valid until 2099 A.D.
        int cycleMetonic, leapJulian, nonLeapYear, datePaschalFullMoon, firstSundayAfterPaschalFullMoon;

        cycleMetonic = year % 19;
        leapJulian = year % 4;
        nonLeapYear = year % 7;

        datePaschalFullMoon = (cycleMetonic * 19 + centuryPaschalFullMoon) % 30;
        firstSundayAfterPaschalFullMoon = (2 * leapJulian + 4 * nonLeapYear + 6 * datePaschalFullMoon + cycleOfDaysOfWeek) % 7;

        int dayOfEaster = 81 + datePaschalFullMoon + firstSundayAfterPaschalFullMoon;
        if (29 == datePaschalFullMoon && 6 == firstSundayAfterPaschalFullMoon)
            return isLeapYear ? 110 : 109;
        else if (28 == datePaschalFullMoon && 6 == firstSundayAfterPaschalFullMoon && cycleMetonic > 10)
            return isLeapYear ? dayOfEaster - 6 : dayOfEaster - 7;
        return isLeapYear ? dayOfEaster + 1 : dayOfEaster;
    }

}