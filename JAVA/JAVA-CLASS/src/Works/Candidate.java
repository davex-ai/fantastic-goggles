package Works;

import java.util.Scanner;
//All candidates have to take three tests. A candidate is selected for
// the interview round based on the scores of all the three tests.
// The individual score in each test has to be greater than 75 and the average
// score across the three tests should be minimum of 80. The call letter
// for the interview is to be sent to candidates who have been selected and a rejection
// letter is to be sent to the rest. Represent the logic for the above process by using a flowchart.
public class Candidate {
        private double first;
        private double Second;
        private double Third;

    public Candidate(double first, double second, double third) {
        this.first = first;
        Second = second;
        Third = third;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return Second;
    }

    public void setSecond(double second) {
        Second = second;
    }

    public double getThird() {
        return Third;
    }

    public void setThird(double third) {
        Third = third;
    }
}

