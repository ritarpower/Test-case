package common;

import model.NormalPatient;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IONormalPatient {
    private static final String NORMALPATIENT_FILE = "src/data/data/NormalPatient.csv";

    public static void writeNormalPatientToFile(NormalPatient normalPatient) {
        try {
            FileWriter fileWriter = new FileWriter(NORMALPATIENT_FILE, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = normalPatient.getId() + "," + normalPatient.getCodeFile() + "," + normalPatient.getCodePatient() + "," + normalPatient.getName() + "," +
                    normalPatient.getInDate() + "," + normalPatient.getOutDate() + "," + normalPatient.getReason() + "," + normalPatient.getFee();
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeNormalPatientListToFile(List<NormalPatient> normalPatients) {
        try {
            FileWriter fileWriter = new FileWriter(NORMALPATIENT_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (NormalPatient normalPatient : normalPatients) {
                String data = normalPatient.getId() + "," + normalPatient.getCodeFile() + "," + normalPatient.getCodePatient() + "," + normalPatient.getName() + "," +
                        normalPatient.getInDate() + "," + normalPatient.getOutDate() + "," + normalPatient.getReason() + "," + normalPatient.getFee();
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<NormalPatient> readNormalPatientFromFile() {
        List<NormalPatient> normalPatients = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(NORMALPATIENT_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String data = bufferedReader.readLine();
                if (data == null) {
                    break;
                }
                String[] arr = data.split(",");
                NormalPatient normalPatient = new NormalPatient(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],LocalDate.parse(arr[4]),
                        LocalDate.parse(arr[5]),arr[6],Double.parseDouble(arr[7]));
                normalPatients.add(normalPatient);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return normalPatients;
    }

    public static NormalPatient findNormalPatientByCodeFile(String codeFile) {
        List<NormalPatient> normalPatients = readNormalPatientFromFile();
        for (NormalPatient normalPatient : normalPatients) {
            if (normalPatient.getCodeFile().equals(codeFile)) {
                return normalPatient;
            }
        }
        return null;
    }

    public static void removeNormalPatientFromFile(NormalPatient normalPatient) {
        List<NormalPatient> normalPatients = readNormalPatientFromFile();
        for (NormalPatient normalPatient1 : normalPatients) {
            if (normalPatient1.getCodeFile().equals(normalPatient.getCodeFile())) {
                normalPatients.remove(normalPatient1);
                writeNormalPatientListToFile(normalPatients);
                return;
            }
        }
    }

    public static int getNextId() {
        int count;
        try {
            FileReader file = new FileReader(NORMALPATIENT_FILE);
            BufferedReader bufferedReader = new BufferedReader(file);
            count = 1;
            while (bufferedReader.readLine() != null) {
                count++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
