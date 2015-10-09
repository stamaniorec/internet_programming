
public class Room {
	
	private int width;
	private int height;
	
	// Alt+Shift+S R to generate getters/setters
	// or Menu -> Source -> Generate Getters and Setters
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	// methodName + Ctrl + Space expands into a method
	// Ctrl + 1 to fix return value
	public int calculateArea(){
		return height*width;
	}
	
	// consider overriding hashCode()
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Room) {
			final Room room2 = (Room) obj;
			return width == room2.width && height == room2.height; 
		}
		return false;
	}
}
