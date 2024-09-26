package controller;

import common.IOVIPPatient;
import model.VIPPatient;
import service.VIPPatientService.IVIPPatientService;
import service.VIPPatientService.VIPPatientService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VIPPatientController {
    private static final Scanner sc = new Scanner(System.in);
    private IVIPPatientService vipPatientService = new VIPPatientService();

    public void getAllVIPPatient() {
        List<VIPPatient> vipPatients = vipPatientService.getAll();
        for (VIPPatient vipPatient : vipPatients) {
            if (vipPatient == null) {
                return;
            } else {
                System.out.println(vipPatient.toData());
            }
        }
    }

    public void addVIPPatient() {
        int id = IOVIPPatient.getNextId();
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
            System.out.println("Nhap ngay vao vien theo yyyy-MM-dd: ");
            inDate1 = sc.nextLine();
        } while (!Validate.isValidDate(inDate1));
        LocalDate inDate = LocalDate.parse(inDate1);
        String outDate1;
        do {
            System.out.println("Nhap ngay xuat vien theo yyyy-MM-dd: ");
            outDate1 = sc.nextLine();
        } while (!Validate.isValidDate(outDate1) || !Validate.isAfterInDate(inDate1, outDate1));
        LocalDate outDate = LocalDate.parse(outDate1);
        System.out.println("Nhap li do nhap vien: ");
        String reason = sc.nextLine();
        String vipType;
        do {
            System.out.println("Nhap loai VIP: ");
            vipType = sc.nextLine();
        } while (!Validate.isValidVIPType(vipType));
        System.out.println("Nhap thoi han VIP theo yyyy-MM-dd : ");
        LocalDate vipDate = LocalDate.parse(sc.nextLine());
        VIPPatient vipPatient = new VIPPatient(id, codeFile, codePatient, name, inDate, outDate, reason, vipType, vipDate);
        vipPatientService.addVIPPatient(vipPatient);
        System.out.println("Da them moi thanh cong!");
    }

    public void removeVIPPatient() {
        System.out.println("Nhap ma benh an can xoa: ");
        String codeFile = sc.nextLine();
        VIPPatient vipPatient = vipPatientService.findByCodeFile(codeFile);
        if (vipPatient != null) {
            confirmRemoveVIPPatient(vipPatient);
        } else {
            System.out.println("Khong tim thay ma benh nhan can xoa!");
        }
    }

    public void confirmRemoveVIPPatient(VIPPatient vipPatient) {
        System.out.println("Ban chac chan muon xoa benh an " + vipPatient.getCodeFile() + " chu?\n " +
                "\t 1.Co \t 2.Khong\n" +
                "Chon muc:");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                vipPatientService.removeVIPPatient(vipPatient);
                System.out.println("Da xoa thanh cong!");
                break;
            case 2:
                System.out.println("Chon lai muc khac!");
                break;
            default:
                System.out.println("Thao tac khong thanh cong!");
        }
    }

    public boolean isExistCodeFile(String codeFile) {
        List<VIPPatient> vipPatients = IOVIPPatient.readVIPPatientFromFile();
        for (VIPPatient vipPatient : vipPatients) {
            if (vipPatient.getCodeFile().equals(codeFile)) {
                return true;
            }
        }
        return false;
    }
}
