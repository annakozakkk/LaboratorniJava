package ua.lviv.iot.algo.part1.lab1;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BicycleWriter {

    public String write(final List<AbstractBicycle> bicycles) {
        if (bicycles == null || bicycles.isEmpty()) {
            return null;
        }
        String defaultFileName = "result.csv";
        try (PrintWriter printWriter = new PrintWriter(defaultFileName)) {
            boolean bicycleHeaderWritten = false;
            boolean electricBicycleHeaderWritten = false;
            boolean gyroScooterHeaderWritten = false;
            boolean electricScooterHeaderWritten = false;
            for (AbstractBicycle ab : bicycles) {
                if (ab instanceof Bicycle) {
                    if (!bicycleHeaderWritten) {
                        printWriter.println(ab.getHeaders());
                        bicycleHeaderWritten = true;
                    }
                } else if (ab instanceof ElectricBicycle) {
                    if (!electricBicycleHeaderWritten) {
                        printWriter.println(ab.getHeaders());
                        electricBicycleHeaderWritten = true;
                    }
                } else if (ab instanceof GyroScooter) {
                    if (!gyroScooterHeaderWritten) {
                        printWriter.println(ab.getHeaders());
                        gyroScooterHeaderWritten = true;
                    }
                } else if (ab instanceof ElectricScooter) {
                    if (!electricScooterHeaderWritten) {
                        printWriter.println(ab.getHeaders());
                        electricScooterHeaderWritten = true;
                    }
                }
                printWriter.println(ab.toCSV());
            }
        } catch (IOException e) {
        }
        return defaultFileName;
    }
}
//
//}
//
//
//
//
//
//        File csvFile = new File("result.csv");
//        PrintWriter printWriter = new PrintWriter(csvFile);
//
//        boolean bicycleHeaderWritten = false;
//        boolean electricBicycleHeaderWritten = false;
//        boolean gyroScooterHeaderWritten = false;
//        boolean electricScooterHeaderWritten = false;
//
//        for (AbstractBicycle ab : bicycles) {
//            if (ab instanceof Bicycle) {
//                if (!bicycleHeaderWritten) {
//                    printWriter.println(ab.getHeaders());
//                    bicycleHeaderWritten = true;
//                }
//            } else if (ab instanceof ElectricBicycle) {
//                if (!electricBicycleHeaderWritten) {
//                    printWriter.println(ab.getHeaders());
//                    electricBicycleHeaderWritten = true;
//                }
//            } else if (ab instanceof GyroScooter) {
//                if (!gyroScooterHeaderWritten) {
//                    printWriter.println(ab.getHeaders());
//                    gyroScooterHeaderWritten = true;
//                }
//            } else if (ab instanceof ElectricScooter) {
//                if (!electricScooterHeaderWritten) {
//                    printWriter.println(ab.getHeaders());
//                    electricScooterHeaderWritten = true;
//                }
//            }
//            printWriter.println(ab.toCSV());
//
//        }
//        printWriter.close();
//    }
//}

