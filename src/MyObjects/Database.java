package MyObjects;

public class Database {
    private final MyProcess[][] mainArray;

    Database(int numberOfStrings, int numberOfProcesses) {
        mainArray = new MyProcess[numberOfStrings][numberOfProcesses];
    }

    public MyProcess[][] getMainArray() {
        return mainArray;
    }

    public int getNumberOfStrings() {
        return mainArray.length;
    }

    public int getNumberOfProcesses() {
        return mainArray[0].length;
    }

    public static Database generateDatabase(int numberOfStrings, int numberOfProcesses, int range, int threshold) {
        Database database = new Database(numberOfStrings,numberOfProcesses);
        for (int i=0; i<numberOfStrings; i++) {
            for (int j = 0; j < numberOfProcesses; j++) {
                database.getMainArray()[i][j] = MyProcess.generateProcess(j, i, range, threshold, numberOfProcesses);
            }
        }
        return database;
    }
    public static Database copyDatabase(Database originalDatabase) {
        Database copiedDatabase = new Database(
                originalDatabase.getNumberOfStrings(),
                originalDatabase.getNumberOfProcesses()
        );
        for (int i=0; i<originalDatabase.getNumberOfStrings(); i++) {
            for (int j = 0; j < originalDatabase.getNumberOfProcesses(); j++) {
                copiedDatabase.getMainArray()[i][j] = new MyProcess(
                        originalDatabase.getMainArray()[i][j].getProcessNumber(),
                        originalDatabase.getMainArray()[i][j].getStringNumber(),
                        originalDatabase.getMainArray()[i][j].getPhaseLength(),
                        originalDatabase.getMainArray()[i][j].getMomentOfNotification()
                );
            }
        }
        return copiedDatabase;
    }
}