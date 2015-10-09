
public class ControlFlowStatements {

	public static void main(String[] args) {
		ifExample();
		forExample();
	}

	private static void forExample() {
		for (int i = 0; i < 10; i++) {
			
		}
	}

	private static void ifExample() {
		if(true){
			System.out.println("called");
		}
		
		if(1>2){
			System.out.println("not called");
		}else{
			System.out.println("called");
		}
	}
}
