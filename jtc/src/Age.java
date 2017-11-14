/* 
 * Java Training Course example file
 * 2017-11-10, Georg Fischer
 *
 * Copyright 2017 Georg Fischer <dr.georg.fischer at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&gt;
 */
public class Age {

    /**
     * Shows all fields of a Calendar.
     * @oaram calendar the Calendar to be shown
     */
    public static void dumpCalendar(Calendar calendar) {
        // print out a bunch of interesting things
        System.out.println("ERA: " + calendar.get(Calendar.ERA));
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("DATE: " + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_WEEK_IN_MONTH: "
                + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
        System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
        System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
        System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
        System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
        System.out.println("ZONE_OFFSET: "
                + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000)));
        System.out.println("DST_OFFSET: "
                + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000)));

        System.out.println("Current Time, with hour reset to 3");
        calendar.clear(Calendar.HOUR_OF_DAY); // so doesn't override
        calendar.set(Calendar.HOUR, 3);
        System.out.println("ERA: " + calendar.get(Calendar.ERA));
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("DATE: " + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_WEEK_IN_MONTH: "
                + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
        System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
        System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
        System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
        System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
        System.out.println("ZONE_OFFSET: "
                + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000))); // in hours
        System.out.println("DST_OFFSET: "
                + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000))); // in hours
    } // dumpCalendar

    /**
     * Get a month's number from its name.
     *
     * @param monthName month's name, or the first 3 letters of it
     * @return number of the month: 1 to 12
     */
    public static int getMonthNumber(String monthName) {
        monthName = monthName.toLowerCase();
        int result = 0;
        if (false) {
        } else if (monthName.startsWith("jan")) {
            result = 1;
        } else if (monthName.startsWith("feb")) {
            result = 2;
        } else if (monthName.startsWith("mar")) {
            result = 3;
        } else if (monthName.startsWith("apr")) {
            result = 4;
        } else if (monthName.startsWith("m")) {
            result = 5;
        } else if (monthName.startsWith("jun")) {
            result = 6;
        } else if (monthName.startsWith("jul")) {
            result = 7;
        } else if (monthName.startsWith("aug")) {
            result = 8;
        } else if (monthName.startsWith("sep")) {
            result = 9;
        } else if (monthName.startsWith("o")) {
            result = 10;
        } else if (monthName.startsWith("nov")) {
            result = 11;
        } else if (monthName.startsWith("de ")) {
            result = 12;
        } else {
            result = 0;
        }
        return result;
    } // getMonthNumber

    /**
     * Test program
     *
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[]{"29", "Jun", "1947", ""};
        } // set default arguments
        int day = Integer.parseInt(args[0]);
        int month = getMonthNumber(args[1]);
        int year = Integer.parseInt(args[2]);
        //---------------------------------
        Calendar currentCalendar = new GregorianCalendar();
        Date currentTime = new Date();
        currentCalendar.setTime(currentTime);
        Calendar birthCalendar   = new GregorianCalendar(year, month - 1, day);
    /*   
        System.out.println("Current calendar:");
        dumpCalendar(currentCalendar);
        System.out.println("Birth calendar:");
        dumpCalendar(birthCalendar);
    */    
        int yearDiff  = currentCalendar.get(Calendar.YEAR)
                      -   birthCalendar.get(Calendar.YEAR);
        int monthDiff = currentCalendar.get(Calendar.MONTH)
                      -   birthCalendar.get(Calendar.MONTH);
        int dayDiff   = currentCalendar.get(Calendar.DAY_OF_MONTH)
                      -   birthCalendar.get(Calendar.DAY_OF_MONTH);
        if (dayDiff   < 0) {
            // dayDiff += 30 or 31 or 28 or 29?
            monthDiff -= 1;
        }
        if (monthDiff < 0) {
            monthDiff += 12;
            yearDiff  -= 1;
        }
        //----------------------------------------------------
        long currentMillis = currentCalendar.getTimeInMillis();
        long birthMillis   =   birthCalendar.getTimeInMillis();
        long diffMillis    = currentMillis - birthMillis;
        System.out.println("Up to now you have lived: ");
        long divisor = 1000l;
        System.out.println(String.format("%10d seconds", diffMillis / divisor));
        divisor *= 60l;
        System.out.println(String.format("%10d minutes", diffMillis / divisor));
        divisor *= 60l;
        System.out.println(String.format("%10d hours"  , diffMillis / divisor));
        divisor *= 24l;
        System.out.println(String.format("%10d days"   , diffMillis / divisor));
        divisor *=  7l;
        System.out.println(String.format("%10d weeks"  , diffMillis / divisor));
        System.out.println(String.format("%10d months" , monthDiff + yearDiff * 12));
        System.out.println(String.format("%10d years"  , yearDiff            ));
    } // main

} // Age
