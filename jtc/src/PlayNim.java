/* Plays a simple Nim misère game
 * Java Training Course example file
 * 2017-11-17, Georg Fischer
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
 * Plays a simple Nim misère game. The machine writes the rules, and then
 * presents a number of sticks to the human player, who begins. The human takes
 * 1, 2 or 3 sticks, and than the machine does the same. The one who has to take
 * the last stick will loose.
 *
 * @author Georg Fischer &lt;dr.georg.fischer at gmail.com&gt;
 */
public class PlayNim {
    
    /** minimum number of sticks to be taken by each player */
    private static final int MIN_TAKE = 1;
    /** maximum number of sticks to be taken by each player */
    private static final int MAX_TAKE = 3;
    
    /** Get a random number between (including) MIN_TAKE and MAX_TAKE
     *  @return random number
     */
    public static int randomNumber() {
        return (new Double(Math.random() * MAX_TAKE + MIN_TAKE)).intValue(); 
                // random() yields >= 0.0 and < 1.0 -> 1..3
    } // randomNumber

    /** Get the nearest magic number <= to the parameter.
     * The magic number for MAX_TAKE = 3 are 1, 5, 9, 13, 17 and so on.
     * The general formula is magic = 1 + MAX_TAKE * n.
     * @param noSticks current number of sticks; the result must be <= this value
     *  @return the nearest random number
     */
    public static int getNearestMagic(int noSticks) {
        return ((noSticks - 1) / (MAX_TAKE + 1)) * (MAX_TAKE + 1) + 1;
     } // getNearestMagic

    /**
     * Test program
     */
    public static void main(String[] args) {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
        //  prompt for the user's name
        int machineTaken = 0;
        int noSticks = 19;
        while (noSticks >= 0) {
            System.out.println("There are " + noSticks + " left.");
            System.out.print("How many sticks do you take? ");
            int humanTaken = scanner.nextInt();
            if (humanTaken < MIN_TAKE || humanTaken > MAX_TAKE) {
                System.out.println("** You must take between " + MIN_TAKE + " and " + MAX_TAKE + " sticks!");
            } else { // proper humanTaken
                noSticks -= humanTaken;
                System.out.println(noSticks + " are left.");
                if (noSticks == 1) { // machine looses
                    System.out.println("Good for you! You have won!");
                    noSticks = -1;
                } else { // machine not yet lost
                    int magic = getNearestMagic(noSticks);
                    if (noSticks - magic == 0) { // human was clever: machine tries randomly
                        machineTaken = randomNumber();
                    } else { // human did not reach a magic number: machine takes it and wins
                        machineTaken = noSticks - magic;
                        System.out.print("I will win! ");
                    } // machine wins
                    System.out.println("I take " + machineTaken + ".");
                    noSticks -= machineTaken;
                    // now decide wether we reached the end
                    if (noSticks == 1) {
                        System.out.println("Bad for you. I have won.");
                        noSticks = -1;
                    }
                } // machine not yet lost
            } // proper humanTaken
        } // while noSticks >= 0
    } // main

} // PlayNim
