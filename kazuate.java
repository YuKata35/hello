import java.util.InputMismatchException;
import java.util.Scanner;

public class kazuate {
    public static void main(String[] args) {
        // 設定された数
        int targetNumber = 42;

        // ユーザの入力回数をカウントする変数
        int attempts = 0;

        // ユーザに数を当てさせるループ（最大5回まで）
        while (attempts < 5) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("2桁の正の整数を入力してください: ");

            try {
                int guess = scanner.nextInt();
                attempts++;

                // 入力された数と設定された数を比較
                if (guess == targetNumber) {
                    System.out.println("当たり！");
                    scanner.close();
                    break;
                } else {
                    System.out.println("外れました。");

                    // 数の大小をユーザにフィードバックする
                    if (guess > targetNumber) {
                        System.out.println("設定された数よりも小さい数です。");
                    } else {
                        System.out.println("設定された数よりも大きい数です。");
                    }

                    // 20以上差がある場合のメッセージを表示
                    if (Math.abs(guess - targetNumber) >= 20) {
                        System.out.println("20以上の差があります。");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("数値を入力してください。");
                scanner.next(); // 入力バッファをクリアする
            }
        }

        // 最大試行回数に達した場合のメッセージを表示
        if (attempts == 5) {
            System.out.println("ゲームオーバー！正解は " + targetNumber + " でした。");
        }
    }
}
