import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

class XMLInterior {
    private Document document;
    private Element element;
    private Element month;
    private Attr holiday;
    private int startYearDay;
    private int currentYearDay;
    private int dateEaster;
    private int dateCorpusCristi;
    private int datePentecost;
    private boolean isLeapYear;

    XMLInterior(int whatYear) {
        EasterCalculations easterCalculations = new EasterCalculations();
        WhatFirstDayOfYear whatFirstDayOfYear = new WhatFirstDayOfYear(whatYear);
        startYearDay = whatFirstDayOfYear.calculateWhatFirstDayOfYear();
        currentYearDay = 1;
        isLeapYear = whatYear % 4 == 0 && whatYear % 100 != 0 || whatYear % 400 == 0;
        dateEaster = easterCalculations.calculateEasterDate(whatYear, isLeapYear);
        dateCorpusCristi = dateEaster + 40;
        datePentecost = dateEaster + 60;
    }

    Document newDocumentXML() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        document = documentBuilder.newDocument();

        element = document.createElement("Year");
        document.appendChild(element);
        makeYear();

        return document;
    }

    private void createMonthInterior(int numberMonth, int numberDays) {
        int dayOfMonth = 1;
        Attr noOfDay;
        Element day;
        for (int i = 1; i <= numberDays; i++) {
            day = document.createElement("Day");
            holiday = document.createAttribute("Holiday");
            checkHoliday(numberMonth, dayOfMonth);
            day.setAttributeNode(holiday);
            noOfDay = document.createAttribute("NoDay");
            noOfDay.setValue(Integer.toString(i));
            day.setAttributeNode(noOfDay);
            month.appendChild(day);
            startYearDay++;
            currentYearDay++;
            dayOfMonth++;
        }
    }

    private void createMonth(String name, int numberDays, int monthNumber) {
        month = document.createElement(name);
        element.appendChild(month);
        Attr noDays = document.createAttribute("NoDays");
        noDays.setValue(Integer.toString(numberDays));
        month.setAttributeNode(noDays);
        Attr noMonth = document.createAttribute("NoMonth");
        noMonth.setValue(Integer.toString(monthNumber));
        month.setAttributeNode(noMonth);
        createMonthInterior(monthNumber, numberDays);
    }

    private void makeYear() {
        createMonth("January", 31, 1);
        if (isLeapYear)
            createMonth("February", 29, 2);
        else
            createMonth("February", 28, 2);
        createMonth("March", 31, 3);
        createMonth("April", 30, 4);
        createMonth("May", 31, 5);
        createMonth("June", 30, 6);
        createMonth("July", 31, 7);
        createMonth("August", 31, 8);
        createMonth("September", 30, 9);
        createMonth("October", 31, 10);
        createMonth("November", 30, 11);
        createMonth("December", 31, 12);
    }

    private void checkHoliday(int noMonth, int currentMonthDay) {
        if (6 == startYearDay % 7 || 0 == startYearDay % 7) holiday.setValue("1");
        else if (1 == noMonth && (1 == currentMonthDay || 6 == currentMonthDay)) holiday.setValue("1");
        else if (5 == noMonth && (1 == currentMonthDay || 3 == currentMonthDay)) holiday.setValue("1");
        else if (8 == noMonth && 15 == currentMonthDay) holiday.setValue("1");
        else if (11 == noMonth && (11 == currentMonthDay || 1 == currentMonthDay)) holiday.setValue("1");
        else if (12 == noMonth && (25 == currentMonthDay || 26 == currentMonthDay)) holiday.setValue("1");
        else if (currentYearDay == dateEaster || currentYearDay == dateEaster + 1) holiday.setValue("1");
        else if (currentYearDay == dateCorpusCristi) holiday.setValue("1");
        else if (currentYearDay == datePentecost) holiday.setValue("1");
        else holiday.setValue("0");
    }
}
