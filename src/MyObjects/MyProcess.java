package MyObjects;

import java.util.Objects;
import java.util.Random;

public class MyProcess implements Comparable<MyProcess>{
    private final int processNumber;
    private final int stringNumber;
    private int phaseLength;
    private final int momentOfNotification;
    private int waitingTime = 0;

    MyProcess(int processNumber, int stringNumber, int phaseLength, int momentOfNotification) {
        this.processNumber = processNumber;
        this.stringNumber = stringNumber;
        this.phaseLength = phaseLength;
        this.momentOfNotification = momentOfNotification;
    }

    public int getProcessNumber() {
        return processNumber;
    }
    public int getStringNumber() {
        return stringNumber;
    }
    public int getPhaseLength() {
        return phaseLength;
    }
    public void setPhaseLength(int phaseLength) {
        this.phaseLength = phaseLength;
    }
    public int getMomentOfNotification() {
        return momentOfNotification;
    }
    public int getWaitingTime() {
        return waitingTime;
    }
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public static MyProcess generateProcess(int processNumber, int stringNumber, int range,
                                            int threshold, int numberOfProcesses) {
        Random generator = new Random();
        int length = generatePhaseLength(range,threshold);
        int moment = generator.nextInt(numberOfProcesses*(range+threshold)/4);
        return new MyProcess(processNumber,stringNumber,length,moment);
    }
    public static int generatePhaseLength(int range, int threshold) {
        Random generator = new Random();
        int ratio = generator.nextInt(4);
        int limit = threshold + Math.abs(range-threshold)/5;

        if (ratio == 0)
            return generator.nextInt(limit, range);
        else
            return generator.nextInt(threshold, limit);
    }

    public static int generatePhaseLength2(int range, int threshold, int limit) {
        Random generator = new Random();

        int ratio = generator.nextInt(4);

        if (ratio == 0)
            return generator.nextInt(limit, range);
        else
            return generator.nextInt(threshold, limit);
    }

    @Override
    public int compareTo(MyProcess o) {
        return Integer.compare(o.getMomentOfNotification(), momentOfNotification);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyProcess p = (MyProcess) o;
        return processNumber == p.getProcessNumber() && stringNumber == p.getStringNumber();
    }
    @Override
    public int hashCode() {
        return Objects.hash(processNumber,stringNumber);
    }
    @Override
    public String toString() {
        return String.format("%d-%d-%d-%d", processNumber,phaseLength,momentOfNotification,waitingTime);
    }
}
