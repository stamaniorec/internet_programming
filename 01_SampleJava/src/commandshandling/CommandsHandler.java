package commandshandling;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CommandsHandler {
	
	private static Map<String, CommandHandler> HANDLERS = new HashMap<String, CommandHandler>();

	public static void main(String[] args) {
		HANDLERS.put("sum", new SumCommandHandler());
		System.out.println("Enter command: ");
		final Scanner in = new Scanner(System.in);
		final String command = in.next();
		final CommandHandler handler = parse(command);
		final int result = handler.execute(command.split(":"));
		System.out.println("Result: " + result);
		in.close();
	}
	
	private static CommandHandler parse(String command) {
		final String[] split = command.split(":");
		final CommandHandler result = HANDLERS.get(split[0]);
		if(result == null) {
			throw new IllegalArgumentException("Unknown command: " + command);
		}
		return result;
	}
	
	public int run() {
		return 0;
	}
	
}
