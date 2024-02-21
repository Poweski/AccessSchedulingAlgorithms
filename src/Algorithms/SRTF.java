package Algorithms;

import Comparators.*;
import MyObjects.*;
import java.util.ArrayList;

public class SRTF {
    public static void doSRTF(Database database) {

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

                    tempArray.sort(new SortByPhaseLength());

                    tempArray.getFirst().setPhaseLength(tempArray.getFirst().getPhaseLength()-1);

                    for (int j=1; j<tempArray.size(); j++) {
                        tempArray.get(j).setWaitingTime(tempArray.get(j).getWaitingTime() + 1);
                    }

                    if (tempArray.getFirst().getPhaseLength() == 0) {
                        garbageArray.add(tempArray.getFirst());
                        tempArray.removeFirst();
                    }
                }
                currentMoment++;
            }
        }
    }
}
