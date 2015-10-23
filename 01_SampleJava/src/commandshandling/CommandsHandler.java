package commandshandling;

import java.util.Scanner;


public class CommandsHandler {

	public static void main(String[] args) {
		System.out.println("Enter command: ");
		final Scanner in = new Scanner(System.in);
		final String command = in.next();
		final CommandHandler handler = parse(command);
		final int result = handler.execute();
		System.out.println("Result: " + result);
		in.close();
	}
	
	private static CommandHandler parse(String command) {
		final String[] split = command.split(":");
		if("sum".equals(split[0])) { // avoid NullPointerException
			return new SumCommandHandler(split);
		}
		throw new IllegalArgumentException("Unknown command: " + command);
	}
	
	public int run() {
		return 0;
	}
	
}
