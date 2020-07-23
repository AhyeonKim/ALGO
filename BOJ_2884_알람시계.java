import java.util.Scanner;

public class BOJ_2884_알람시계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		int time = hour*60+minute;
		if(time-45>0) {
			time = time-45;			
		}else {
			time = 24*60+(time-45);
		}
		hour = time/60;
		minute = time%60;
		System.out.println(hour%24+" "+minute);
	}

}
