/* Convert the number of a weekday to its indonesian name
 * Java Training Course example file
 * 2017-11-10, Georg Fischer
 *
 * Copyright 2017 Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;.
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
 * limitations under the License. */

/**
 * Convert the number of a weekday to its indonesian name.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com>&gt;
 */
public class Weekday {

    /**
     * Test program. Result with the default argument is "Senin" (monday).
     *
     * @param args commandline arguments: the number of a weekday (1-7).
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[]{"1"};
        } // set default arguments
        int number = Integer.parseInt(args[0]);
        String weekdayName = "";
        switch (number) {
            case 1: // monday
                weekdayName = "Senin";
                break;
            case 2: // tuesday
                weekdayName = "Selasa";
                break;
            case 3: // wednesday
                weekdayName = "Rabu";
                break;
            case 4: // thursday
                weekdayName = "Kamis";
                break;
            case 5: // friday
                weekdayName = "Jumat";
                break;
            case 6: // saturday
                weekdayName = "Sabtu";
                break;
            case 7: // sunday
                weekdayName = "Minggu";
                break;
            default:
                weekdayName = String.valueOf(number);
        } // switch
        System.out.println(weekdayName);
    } // main

} // Weekday
