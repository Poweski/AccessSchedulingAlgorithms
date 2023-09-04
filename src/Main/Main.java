package Main;

import DataExchange.*;
import MyObjects.*;
import Algorithms.*;

public class Main {

    public static void main(String[] args) {

        System.out.println();

        int numberOfStrings = 50;//CollectData.makeARequest("Enter the number of strings: ");
        int numberOfProcesses = 40;//CollectData.makeARequest("Enter the number of processes in a single string: ");
        int range = 100;//CollectData.makeARequest("Specify the maximum length of the process: ");
        int threshold = 1;//CollectData.makeARequest("Specify the minimum length of the process: ");
        int timeQuantum = 7;//CollectData.makeARequest("Enter the time quantum length: ");
        //CollectData.makeARequest("Enter the number of process sections(2-5): ");

        System.out.println();

        Database database = Database.generateDatabase(numberOfStrings,numberOfProcesses,range,threshold);

        Database databaseFCFS = Database.copyDatabase(database);
        Database databaseSJF = Database.copyDatabase(database);
        Database databaseSRTF = Database.copyDatabase(database);
        Database databaseRR = Database.copyDatabase(database);

        FCFS.doFCFS(databaseFCFS);
        SJF.doSJF(databaseSJF);
        SRTF.doSRTF(databaseSRTF);
        RR.doRR(databaseRR,timeQuantum);

        PresentResults.presentResults(timeQuantum,range,threshold,database,
                databaseFCFS,databaseSJF,databaseSRTF,databaseRR);

        System.out.println();
    }
}