package Day1;

public class LongString {

	public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 5; i++) {
            sb.append("Line ").append(i).append("\n");
        }

        System.out.println("Result:\n" + sb);
    }

}
