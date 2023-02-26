package tuchs;

public class Operation {

    public static void main(String[] args){
        int x = 8;
        int y = 2;

        //Сложение
        int sam = x + y;
        System.out.println("Результат сложения " + sam);

        //Вычитание
        int dif = x - y;
        System.out.println("Результат вычесления " + dif);

        //Умножение
        int supSam = x * y;
        System.out.println("Результат умножения " + supSam);

        //Деление
        int div = x / y;
        System.out.println("Результат деления " + div);

        //Деление с остатком
        int divWithOstatok = y % x;
        System.out.println("Остаток от деления " + divWithOstatok);

        //Больше
        boolean max = x > y;
        System.out.println("X > Y ? " + max);

        //Меньше
        boolean min = y < x;
        System.out.println("Y < X ? " + min);

        //Равно
        boolean equal = x == y;
        System.out.println("X = Y ? " + equal);

        //Переполнение
        byte a = 126;
        byte b = (byte) (a + 2);
        System.out.println("Результат переполнения " + b);

        //Разные типы данных
        double c = 1.5;
        int d = 2;
        int f =(int) c + d;
        double v = (double) d + c;
        int g = (int) (c + d);
        double k = (int) (d + c);


        System.out.println("Разны типы данных " + (c + d));
        System.out.println(f  +" ,"+ v + " ,"+ g + " ,"+ k );



    }





}
