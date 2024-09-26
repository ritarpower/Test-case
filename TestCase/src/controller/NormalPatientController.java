package controller;

import common.IONormalPatient;
import model.NormalPatient;
import service.NormalPatientService.INormalPatientService;
import service.NormalPatientService.NormalPatientService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class NormalPatientController {
    private static final Scanner sc = new Scanner(System.in);
    private INormalPatientService normalPatientService = new NormalPatientService();

    public void getAllNormalPatient() {
        List<NormalPatient> normalPatients = normalPatientService.getAll();
        for (NormalPatient normalPatient : normalPatients) {
            if (normalPatient != null) {
                System.out.println(normalPatient.toData());
            } else {
                return;
            }
        }
    }

    public void addNormalPatient() {
        int id = IONormalPatient.getNextId();
        String codeFile;
        do {
            System.out.println("Nhap ma benh an: ");
            codeFile = sc.nextLine();
        } while (!Validate.isValidCodeFile(codeFile) || isExistCodeFile(codeFile));
        String codePatient;
        do {
            System.out.println("Nhap ma benh nhan: ");
            codePatient = sc.nextLine();
        } while (!Validate.isValidCodePatient(codePatient));
        System.out.println("Nhap ten benh nhan: ");
        String name = sc.nextLine();
        String inDate1;
        do {
            System.out.println("Nhap ngay vao vien theo yyyy-MM-dd : ");
            inDate1 = sc.nextLine();
        } while (!Validate.isValidDate(inDate1));
        LocalDate inDate = LocalDate.parse(inDate1);
        String outDate1;
        do {
            System.out.println("Nhap ngay xuat vien theo yyyy-MM-dd : ");
            outDate1 = sc.nextLine();
        } while (!Validate.isValidDate(outDate1) || !Validate.isAfterInDate(inDate1, outDate1));
        LocalDate outDate = LocalDate.parse(outDate1);
        System.out.println("Nhap li do nhap vien: ");
        String reason = sc.nextLine();
        System.out.println("Nhap vien phi chi tra ($): ");
        double fee = Double.parseDouble(sc.nextLine());
        NormalPatient normalPatient = new NormalPatient(id, codeFile, codePatient, name, inDate, outDate, reason, fee);
        normalPatientService.addNormalPatient(normalPatient);
        System.out.println("Da them moi thanh cong!");
    }

    public void removeNormalPatient() {
        System.out.println("Nhap ma benh an can xoa: ");
        String codeFile = sc.nextLine();
        NormalPatient normalPatient = normalPatientService.findbyCodeFile(codeFile);
        if (normalPatient != null) {
            confirmRemoveNormalPatient(normalPatient);
        } else {
            System.out.println("Khong tim thay ma benh an!");
        }
    }

    public void confirmRemoveNormalPatient(NormalPatient normalPatient) {
        System.out.println("Ban chac chan muon xoa benh an " + normalPatient.getCodeFile() + " chu?\n " +
                "\t 1.Co \t 2.Khong\n" +
                "Chon muc:");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                normalPatientService.removeNormalPatient(normalPatient);
                System.out.println("Da xoa thanh cong!");
                break;
            case 2:
                System.out.println("Chon lai muc khac!");
                break;
            default:
                System.out.println("Thao tac khong thanh cong!");
        }
    }

    public boolean isExistCodeFile(String codeFile){
        List<NormalPatient> normalPatients = IONormalPatient.readNormalPatientFromFile();
        for (NormalPatient normalPatient : normalPatients) {
            if (normalPatient.getCodeFile().equals(codeFile)) {
                return true;
            }
        }
        return false;
    }
}
