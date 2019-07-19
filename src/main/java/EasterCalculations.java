class EasterCalculations {
    int calculateEasterDate(int year, boolean isLeapYear) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int temp = h + l - 7 * m + 114;
        int p = temp % 31;
        int dayOfEaster = p + 1;
        int monthOfEaster = temp / 31;
        int sumDays = 0;
        int[] monthDays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        if (isLeapYear){
            for (int z = 2; z < 12; z++)
                monthDays[z] += 1;
        }
        for(int z = 0; z < monthOfEaster; z++){
            sumDays = monthDays[z];
        }
        sumDays += dayOfEaster;
        return sumDays;
    }
}
