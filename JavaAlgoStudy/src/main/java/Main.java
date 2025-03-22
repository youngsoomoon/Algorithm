import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

        sc.close();

        if(b<45){
            a--;
            b = 60 - (45 - b);
        } else {
            b -= 45;
        }

        if(a<0) {
            a = 23;
        }

		System.out.println(a + " " + b);
		
	}
}