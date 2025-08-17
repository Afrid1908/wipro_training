package day7;

public class ArrayIndexException {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		try {
			int i=0;
			while(i<arr.length){
				System.out.println(arr[5]+" ");
				break;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Index out of bound \n"+e);
		}finally {
			System.out.println("...Execution completed...");
		}
	}

}
