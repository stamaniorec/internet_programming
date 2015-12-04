
public class ClassExample {
	public static void main(String[] args) {
		final Room room = new Room(); 
		// Ctrl + 2 (Release both) + L to generate instance variable
		
		room.setWidth(10);
		room.setHeight(12);
		System.out.println("Area: " + room.calculateArea());
		
		final Room room2 = new Room();
		room2.setWidth(10);
		room2.setHeight(12);
		System.out.println(room == room2);
		System.out.println(room.equals(room2));
	}
}
