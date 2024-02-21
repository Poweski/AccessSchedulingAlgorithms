package Algorithms;

import Comparators.*;
import MyObjects.*;
import java.util.ArrayList;

public class RR {
    public static void doRR(Database database, int timeQuantum) {

        for (int i=0; i<database.getNumberOfStrings(); i++) {

            int currentMoment = 0;
            ArrayList<MyProcess> tempArray = new ArrayList<>();
            ArrayList<MyProcess> garbageArray = new ArrayList<>();

            while (garbageArray.size() < database.getNumberOfProcesses()) {

                for (int j=0; j<database.getNumberOfProcesses(); j++) {
                    if (database.getMainArray()[i][j].getMomentOfNotification() <= currentMoment
                            && !tempArray.contains(database.getMainArray()[i][j])
                            && !garbageArray.contains(database.getMainArray()[i][j])) {
                        tempArray.add(database.getMainArray()[i][j]);
                    }
                }

                if (!tempArray.isEmpty()) {

                    tempArray.sort(new SortByMomentOfNotification());

                    if (tempArray.getFirst().getPhaseLength() <= timeQuantum) {
                        tempArray.getFirst().setWaitingTime(currentMoment-tempArray.getFirst().getMomentOfNotification());
                        currentMoment += tempArray.getFirst().getPhaseLength();
                        tempArray.getFirst().setPhaseLength(0);
                        garbageArray.add(tempArray.getFirst());
                        tempArray.removeFirst();
                    }
                    else {
                        tempArray.getFirst().setWaitingTime(currentMoment-tempArray.getFirst().getMomentOfNotification());
                        tempArray.getFirst().setPhaseLength(tempArray.getFirst().getPhaseLength()-timeQuantum);
                        currentMoment += timeQuantum;
                    }
                }
                else {
                    currentMoment++;
                }
            }
        }
    }
}
