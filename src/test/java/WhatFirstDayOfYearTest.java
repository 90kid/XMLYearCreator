import org.junit.Assert;
import org.junit.Test;


public class WhatFirstDayOfYearTest {
    @Test
    public void calculateWhatFirstDayOfYear() {
        int currentFirstDayOfYear = 4;
        for (int currentYear = 1920; currentYear < 2221; currentYear++) {
            WhatFirstDayOfYear testObject = new WhatFirstDayOfYear(currentYear);
            Assert.assertEquals(currentFirstDayOfYear, testObject.calculateWhatFirstDayOfYear());
            if (currentYear % 4 == 0 && currentYear % 100 != 0 || currentYear % 400 == 0) {
                currentFirstDayOfYear += 2;
            } else {
                currentFirstDayOfYear++;
            }
            currentFirstDayOfYear %= 7;
        }
    }

    @Test
    public void Test2019() {
        WhatFirstDayOfYear testObject = new WhatFirstDayOfYear(2019);
        Assert.assertEquals(2, testObject.calculateWhatFirstDayOfYear());
    }

    @Test
    public void Test2010() {
        WhatFirstDayOfYear testObject = new WhatFirstDayOfYear(2010);
        Assert.assertEquals(5, testObject.calculateWhatFirstDayOfYear());
    }

    @Test
    public void Test2025() {
        WhatFirstDayOfYear testObject = new WhatFirstDayOfYear(2025);
        Assert.assertEquals(3, testObject.calculateWhatFirstDayOfYear());
    }
}