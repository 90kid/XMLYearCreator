class WhatFirstDayOfYear {
    private int whatYear;

    WhatFirstDayOfYear(int whatYear) {
        this.whatYear = whatYear;
    }

    int calculateWhatFirstDayOfYear() {
        int tempYear = 2019;
        int tempYearFirstDay = 2;
        if (whatYear > tempYear) {
            while (whatYear != tempYear) {
                if (tempYear % 4 == 0 && tempYear % 100 != 0 || tempYear % 400 == 0) tempYearFirstDay += 2;
                else tempYearFirstDay++;
                tempYear++;
            }
        } else if (whatYear < tempYear) {
            while (whatYear != tempYear) {
                if (whatYear % 4 == 0 && whatYear % 100 != 0 || whatYear % 400 == 0) tempYearFirstDay -= 2;
                else tempYearFirstDay--;
                whatYear++;
            }
        } else return tempYearFirstDay;
        return (tempYearFirstDay % 7 + 7) % 7;
    }
}
