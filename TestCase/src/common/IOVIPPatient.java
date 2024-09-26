package common;

import model.NormalPatient;
import model.VIPPatient;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOVIPPatient {
    private static final String VIPPATIENT_FILE = "src/data/data/VIPPatient.csv";

    public static void writeVIPPatientToFile(VIPPatient vipPatient) {
        try {
            FileWriter fileWriter = new FileWriter(VIPPATIENT_FILE, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = vipPatient.getId() + "," + vipPatient.getCodeFile() + "," + vipPatient.getCodePatient() + "," + vipPatient.getName() + "," +
                    vipPatient.getInDate() + "," + vipPatient.getOutDate() + "," + vipPatient.getReason() +"," + vipPatient.getVipType() + "," + vipPatient.getVipDate();
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeVIPPatientListToFile(List<VIPPatient> vipPatients) {
        try {
            FileWriter fileWriter = new FileWriter(VIPPATIENT_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (VIPPatient vipPatient : vipPatients) {
                String data = vipPatient.getId() + "," + vipPatient.getCodeFile() + "," + vipPatient.getCodePatient() + "," + vipPatient.getName() + "," +
                        vipPatient.getInDate() + "," + vipPatient.getOutDate() + "," + vipPatient.getReason() +"," + vipPatient.getVipType() + "," + vipPatient.getVipDate();
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<VIPPatient> readVIPPatientFromFile() {
        List<VIPPatient> vipPatients = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(VIPPATIENT_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String data = bufferedReader.readLine();
                if (data == null) {
                    break;
                }
                String[] arr = data.split(",");
                VIPPatient vipPatient = new VIPPatient(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], LocalDate.parse(arr[4]), LocalDate.parse(arr[5]), arr[6], arr[7],LocalDate.parse(arr[8]));
                vipPatients.add(vipPatient);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vipPatients;
    }

    public static VIPPatient findVIPPatientByCodeFile(String codeFile) {
        List<VIPPatient> vipPatients = readVIPPatientFromFile();
        for (VIPPatient vipPatient : vipPatients) {
            if (vipPatient.getCodeFile().equals(codeFile)) {
                return vipPatient;
            }
        }
        return null;
    }

    public static void removeVIPPatientFromFile(VIPPatient vipPatient) {
        List<VIPPatient> vipPatients = readVIPPatientFromFile();
        for (int i = 0; i < vipPatients.size(); i++) {
            if(vipPatients.get(i).getCodeFile().equals(vipPatient.getCodeFile())) {
                vipPatients.remove(i);
                writeVIPPatientListToFile(vipPatients);
            }
        }
    }

    public static int getNextId() {
        int count;
        try {
            FileReader file = new FileReader(VIPPATIENT_FILE);
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
