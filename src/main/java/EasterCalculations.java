class EasterCalculations { //zastanowic sie jak to zmienic
    int calculateEasterDate(int year, boolean isLeapYear) {
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
