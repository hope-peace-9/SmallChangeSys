package oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {

    //parameters
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key;
    //"1.資 産 明 細"
    String details = "---------------資産明細---------------";
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //"2.入 金 明 細"
    double money = 0;
    double balance = 0;
    String note = "";

    //メニュー表示
    public void mainMenu(){
        do {
            System.out.println("================MENU(OOP)================");
            System.out.println("\t\t\t1.資 産 明 細");
            System.out.println("\t\t\t2.入 金 明 細");
            System.out.println("\t\t\t3.出 金 明 細");
            System.out.println("\t\t\t4.終      了");

            System.out.println("\n1−4を選んでください:");
            key = scanner.next();

            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("エラー：1−4を選んでください");
            }
        } while (loop);
    }

    //資産明細表示
    public void detail(){
        System.out.println(details);
    }

    //入金明細表示
    public void income() {
        System.out.println("入金価額入力してください，「0」を入力するとメニューに戻ります：");
        while (true) {
            if (scanner.hasNextDouble()) {
                double temp = scanner.nextDouble();
                if (temp > 0) {
                    money = temp;
                    balance += money;

                    date = new Date();
                    details += "\n入金価額\t+" + money + "\t" + sdf.format(date) + "\t" + "TOTAL\t" + balance;
                    break;
                } else if (temp == 0) {
                    break;
                } else {
                    System.out.println("０円以上入力してください!");
                }
            } else {
                System.out.println("数値を入力してください!");
                scanner.next();
            }
        }
    }

    //出金明細表示
    public void pay() {
        System.out.println("3.出 金 明 細");
        while (true) {
            System.out.print("出金価額を入力してください，「0」を入力するとメニューに戻ります：");
            if (scanner.hasNextDouble()) {
                money = scanner.nextDouble();
                if (money > 0) {
                    if (money <= balance) {
                        System.out.print("内容説明：");
                        note = scanner.next();
                        balance -= money;
                        date = new Date();
                        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date)
                                + "\t" + "TOTAL\t" + balance;
                        break;

                    } else {
                        System.out.println("全資産額以下に入力してください!");
                    }
                } else if (money == 0) {
                    break;
                } else {
                    System.out.println("正数を入力してください!");
                }
            } else {
                System.out.println("数値を入力してください!");
                scanner.next();
            }
        }
    }

    //終了
    public void exit() {
        System.out.println("4.終      了");
        System.out.println("ご利用ありがとうございました");
        loop = false;
    }
}
