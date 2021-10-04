package Lesson4;

public class Functions {

    public static boolean isNumberEven(Integer number){
        return number % 2 == 0;
    }

    public static boolean isNumberPrime(Integer number){
        if (number < 0) {
            return false;
        }
        if (number <= 2) {
            return true;
        }

        for (int i = 2; i < number - 1; i++){
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String word){
        if (word.length() < 2){
            return true;
        }
        if (word.charAt(0) != word.charAt(word.length() - 1)){
            return false;
        }
        return isPalindrome(word.substring(1, word.length() - 1));
    }

    public static Object areaTriangle(double a, double b, double c){
        if (a < (b + c) && a > (b - c) && b < (a + c) && b > (a - c) && c < (a + b) && c > (a - b)){
            double perimeter = (a + b + c) / 2;
            return Math.sqrt(perimeter*(perimeter-a)*(perimeter-b)*(perimeter-c));
        }
        else if (a <= 0 || b <= 0 || c <= 0){
            return "Треугольник со значением стороны 0 или отрицательным не существует";
        }
        else {
            return  "Треугольник с данными значениями сторон не существует";
        }

    }
}
