package test;

public class sandbox {

	public static void main(String[] args) {
		String s = "Bert was hier";
		String[] commands = s.split(" ");
		System.out.println(commands[0]);
		for (String command : commands) {
			System.out.println(command);
		}
	}
}
