/* Plays a simple Nim misère game
 * Java Training Course example file
 * 2017-11-14, Georg Fischer
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
import java.util.Scanner;
/**
 * Plays a simple Nim misère game.
 * The machine writes the rules, and then
 * presents a number of sticks to the human player, who begins.
 * The human takes 1, 2 or 3 sticks, and than the machine does the same.
 * The one who has to take the last stick will loose.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&gt;
 */
public class PlayNim {

    /**
     * Test program
     *  Interactive input on the commandline: the number of sticks chosen by the human.
     */
    public static void main(String[] args) {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        //  prompt for the user's name
        while (true) {
            System.out.print("How many sticks do you take? ");
            int humanTaken = scanner.nextInt();
            System.out.println("You take " + humanTaken + ".");
            System.out.println("I take "   + machineTaken + ".");
            
        } // while input
    } // main

} // PlayNim
