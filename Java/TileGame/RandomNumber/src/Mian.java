import java.util.Random;

public class Mian {

	public static void main(String[] args) {
		Random random = new Random();
		int rand = 0;
		for (int i = 0; i < 10; i++) {
			while (true){
			    rand = random.nextInt(5);
			    if(rand !=0) break;
			}
			System.out.println(rand);
		}

	}

}
