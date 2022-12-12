import java.util.Scanner;

public class task_4 {
//Напишите мощность рекурсивного метода (база, экспонента), который при вызове возвращает базовый показатель
//Например, мощность (3,4) = 3 * 3 * 3 * 3. Предположим, что показатель степени — это целое число, большее или равное 1.
//Подсказка: шаг рекурсии должен использовать соотношение
//base^exponent = base · base^(exponent – 1)
//
//и условие завершения возникает, когда показатель степени равен 1
//
//base^1 = base
//
//Включите этот метод в программу, позволяющую пользователю вводить основание и показатель степени
    static void solution(){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите основание: ");
        var base = input.nextDouble();
        System.out.print("Введите степень: ");
        var exponent = input.nextInt();
        System.out.println(foo(base, exponent));
    }
    static double foo(double base, int exponent){
        //foo(3, 3)= 3 * foo(3, 2) = 3 * 3 * foo(3, 1) = 3 * 3 * 3
        if (exponent <= 1)
            return base;
        return base * foo(base, exponent-1);
    }
}
