public class DemoApplication {

	public static void main(String[] args) {
		long calculatedResult = ApplicationRunner.run(1100);
		System.out.println(String.format("Result is %s", calculatedResult));
	}


}
