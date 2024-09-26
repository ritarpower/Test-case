package view;

import common.IONormalPatient;
import controller.NormalPatientController;
import controller.VIPPatientController;
import model.NormalPatient;

import java.util.Scanner;

public class PatientManagement {
    private static final Scanner sc = new Scanner(System.in);
    private VIPPatientController vipPatientController = new VIPPatientController();
    private NormalPatientController normalPatientController = new NormalPatientController();

    public void normalPatientManagement() {
        do {
            System.out.println("-----QUAN LY BENH AN THUONG-----\n" +
                    "Chon chuc nang theo so (de tiep tuc)\n" +
                    "1.\tHien thi danh sach benh an.\n" +
                    "2.\tThem benh an moi.\n" +
                    "3.\tXoa benh an.\n" +
                    "4.\tQuay lai trang chinh.\n" +
                    "5.\tThoat.\n" +
                    "Chon chuc nang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    normalPatientController.getAllNormalPatient();
                    break;
                case 2:
                    normalPatientController.addNormalPatient();
                    break;
                case 3:
                    normalPatientController.removeNormalPatient();
                    break;
                case 4:
                    mainMenu();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Vui long chon lai!");
            }
        } while (true);
    }

    public void vipPatientManagement() {
        do {
            System.out.println("-----QUAN LY BENH AN VIP-----\n" +
                    "Chon chuc nang theo so (de tiep tuc)\n" +
                    "1.\tHien thi danh sach benh an.\n" +
                    "2.\tThem benh an moi.\n" +
                    "3.\tXoa benh an.\n" +
                    "4.\tQuay lai trang chinh.\n" +
                    "5.\tThoat.\n" +
                    "Chon chuc nang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    vipPatientController.getAllVIPPatient();
                    break;
                case 2:
                    vipPatientController.addVIPPatient();
                    break;
                case 3:
                    vipPatientController.removeVIPPatient();
                    break;
                case 4:
                    mainMenu();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Vui long chon lai!");
            }
        } while (true);
    }

    public void mainMenu() {
        do {
            System.out.println("-----CHUONG TRINH QUAN LY BENH AN-----\n" +
                    "Chon chuc nang theo so (de tiep tuc)\n" +
                    "1.\tQuan ly benh an thuong\n" +
                    "2.\tQuan ly benh an VIP\n" +
                    "3.\tThoat.\n" +
                    "Chon chuc nang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    normalPatientManagement();
                    break;
                case 2:
                    vipPatientManagement();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Vui long chon lai!");
            }
        } while (true);
    }

    public static void main(String[] args) {
        PatientManagement patientManagement = new PatientManagement();
        patientManagement.mainMenu();
    }
}
