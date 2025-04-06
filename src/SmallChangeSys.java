import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {

    //This is a practice project, and its main function is bookkeeping.
    //これは練習用のプロジェクトで、主な機能は家計簿管理です。

    public static void main(String[] args) {
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

        do {
            System.out.println("================MENU================");
            System.out.println("\t\t\t1.資 産 明 細");
            System.out.println("\t\t\t2.入 金 明 細");
            System.out.println("\t\t\t3.出 金 明 細");
            System.out.println("\t\t\t4.終      了");

            System.out.println("\n1−4を選んでください:");
            key = scanner.next();

            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("入金価額入力してください：");
                    while (true) {
                        if (scanner.hasNextDouble()) {
                            double temp = scanner.nextDouble();
                            if (temp >= 0) {
                                money = temp;
                                balance += money;

                                date = new Date();
                                details += "\n入金価額\t+" + money + "\t" + sdf.format(date) + "\t" + "TOTAL\t" + balance;
                                break;
                            } else if (temp < 0) {
                                System.out.println("０円以上入力してください!");
                            }
                        } else {
                            System.out.println("数値を入力してください!");
                            scanner.next();
                        }
                    }
                    break;
                case "3":
                    System.out.println("3.出 金 明 細");
                    while (true) {
                        System.out.print("出金価額を入力してください：");
                        if (scanner.hasNextDouble()) {
                            money = scanner.nextDouble();
                            if (money >= 0) {
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
                            } else {
                                System.out.println("正数を入力してください!");
                            }
                        } else {
                            System.out.println("数値を入力してください!");
                            scanner.next();
                        }
                    }
                    break;
                case "4":
                    System.out.println("4.終      了");
                    loop = false;
                    break;
                default:
                    System.out.println("エラー：1−4を選んでください");
            }
        } while (loop);

        System.out.println("SmallChangeSys終了しました");
    }
}
