
public class ClassExample {
	public static void main(String[] args) {
		final Room room = new Room(); 
		// Ctrl + 2 (Release both) + L to generate instance variable
		
		room.setWidth(10);
		room.setHeight(12);
		System.out.println("Area: " + room.calculateArea());
	}
}
