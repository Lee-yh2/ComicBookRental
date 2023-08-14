package com.cmbookrental.prj.app;

import com.cmbookrental.prj.comm.DBException;
import com.cmbookrental.prj.controller.ComicBookController;
import com.cmbookrental.prj.controller.CustomerController;
import com.cmbookrental.prj.controller.RentalController;
import com.cmbookrental.prj.dto.ComicBookDto;
import com.cmbookrental.prj.dto.CustomerDto;
import com.cmbookrental.prj.dto.RentalDto;
import com.cmbookrental.prj.factory.Factory;

import java.util.Scanner;

public class ComicBookRentalApp {
    public final static String MENU = "<메뉴선택>";
    public final static String LINE = "======================";

    public static void main(String[] args) {
        ComicBookRentalApp app = new ComicBookRentalApp();
        app.view();
    }

    public void view() {
        Scanner sc = new Scanner(System.in);
        ComicBookController comicBookController = Factory.getInstance().getComicBookController();
        CustomerController customerController = Factory.getInstance().getCustomerController();
        RentalController rentalController = Factory.getInstance().getRentalController();
        while (true) {
            mainView();
            int sel = isIntCheck(sc);

            if (sel == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            switch (sel) {
                case 1:
                    while (true) {
                        System.out.println(MENU);
                        System.out.println("1.만화책 등록");
                        System.out.println("2.만화책 수정");
                        System.out.println("3.만화책 삭제");
                        System.out.println("4.만화책 조회");
                        System.out.println("0.이전 메뉴");
                        System.out.println(LINE);
                        System.out.print("메뉴입력: ");
                        sel = isIntCheck(sc);
                        if (sel == 0) {
                            System.out.println("이전메뉴로 돌아갑니다");
                            break;
                        } else if (sel == 1) {
                            System.out.print("ID: ");
                            int id = isIntCheck(sc);
                            System.out.print("만화책 명: ");
                            String cmBookName = sc.next();
                            System.out.print("작가 명: ");
                            String cmBookWriter = sc.next();
                            if (!comicBookController.haveComicBook(id)) {
                                comicBookController.add(new ComicBookDto(id, cmBookName, cmBookWriter));
                                System.out.println("등록이 완료되었습니다");
                            } else {
                                System.out.println("등록이 실패하였습니다 (ID가 이미 존재)");
                            }
                        } else if (sel == 2) {
                            System.out.print("수정할 만화책 ID: ");
                            int id = isIntCheck(sc);
                            System.out.print("만화책 명: ");
                            String cmBookName = sc.next();
                            System.out.print("작가 명: ");
                            String cmBookWriter = sc.next();
                            try {
                                comicBookController.update(new ComicBookDto(id, cmBookName, cmBookWriter), id);
                                System.out.println("수정에 성공하였습니다");
                            } catch (DBException e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (sel == 3) {
                            System.out.print("삭제할 만화책 ID: ");
                            int id = isIntCheck(sc);
                            try {
                                comicBookController.delete(id);
                                System.out.println("삭제에 성공하였습니다");
                            } catch (DBException e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (sel == 4) {
                            System.out.println("목록을 조회합니다");
                            if (comicBookController.findAll().isEmpty()) {
                                System.out.println("목록이 없습니다");
                            } else {
                                for (ComicBookDto comicbook : comicBookController.findAll()) {
                                    System.out.println(comicbook.toString());
                                    System.out.println("--------------------------");
                                }
                            }
                        } else {
                            System.out.println("없는 메뉴입니다");
                        }
                    }
                    break;
                case 2:
                    System.out.print("대여 ID: ");
                    int rentalId = isIntCheck(sc);
                    System.out.print("대여할 만화책 ID: ");
                    int id = isIntCheck(sc);
                    System.out.print("대여 고객 ID: ");
                    int customerId = isIntCheck(sc);

                    if (!comicBookController.haveComicBook(id)) {
                        System.out.println("대여할 만화책이 없습니다");
                    } else if (!customerController.haveCustomer(customerId)) {
                        System.out.println("고객정보가 맞지 않습니다");
                    } else if (rentalController.haveRental(rentalId)) {
                        System.out.println("렌탈 아이디가 이미 존재합니다");
                    } else {
                        rentalController.add(new RentalDto(rentalId, id, customerId));
                        System.out.println("대여에 성공했습니다");
                    }
                    break;
                case 3:
                    System.out.print("반납할 대여 아이디: ");
                    int rentalID = isIntCheck(sc);
                    try {
                        rentalController.delete(rentalID);
                        System.out.println("반납에 성공하였습니다");
                    } catch (DBException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    int customerID;
                    String customerName;
                    while (true) {
                        System.out.println(MENU);
                        System.out.println("1.고객 등록");
                        System.out.println("2.고객 정보 수정");
                        System.out.println("3.고객 삭제");
                        System.out.println("4.고객 조회");
                        System.out.println("0.이전 메뉴");
                        System.out.println(LINE);
                        System.out.print("메뉴입력: ");
                        sel = isIntCheck(sc);
                        if (sel == 0) break;
                        else if (sel == 1) {
                            System.out.print("ID: ");
                            customerID = isIntCheck(sc);
                            System.out.print("고객 명: ");
                            customerName = sc.next();
                            if (!customerController.haveCustomer(customerID)) {
                                customerController.add(new CustomerDto(customerID, customerName));
                                System.out.println("등록에 성공하였습니다");
                            } else {
                                System.out.println("등록에 실패하였습니다 (ID가 이미 존재)");
                            }
                        } else if (sel == 2) {
                            System.out.print("수정할 고객ID: ");
                            customerID = isIntCheck(sc);
                            System.out.print("고객 명: ");
                            customerName = sc.next();
                            try {
                                customerController.update(new CustomerDto(customerID, customerName), customerID);
                                System.out.println("수정 완료하였습니다");
                            } catch (DBException e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (sel == 3) {
                            System.out.print("삭제할 고객 ID: ");
                            customerID = isIntCheck(sc);
                            try {
                                customerController.delete(customerID);
                                System.out.println("삭제에 성공하였습니다");
                            } catch (DBException e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (sel == 4) {
                            System.out.println("목록을 조회합니다");
                            if (customerController.findAll().isEmpty()) {
                                System.out.println("목록이 없습니다");
                            } else {
                                for (CustomerDto customer : customerController.findAll()) {
                                    System.out.println(customer.toString());
                                    System.out.println("--------------------------");
                                }
                            }
                        } else {
                            System.out.println("없는 메뉴입니다");
                        }
                    }
                    break;
                default:
                    System.out.println("없는 메뉴입니다");
                    break;
            }
        }
    }

    public void mainView() {
        System.out.println(MENU);
        System.out.println("1.만화책 조회/등록/수정/삭제");
        System.out.println("2.만화책 대여");
        System.out.println("3.만화책 반납");
        System.out.println("4.고객 조회/등록/수정/삭제");
        System.out.println("0.프로그램 종료");
        System.out.println(LINE);
        System.out.print("메뉴입력: ");
    }

    public int isIntCheck(Scanner sc){
        while (!sc.hasNextInt()) {
            sc.next();
            System.err.print("숫자만 입력해주세요. \n재입력 : ");
        }
        return sc.nextInt();
    }
}
