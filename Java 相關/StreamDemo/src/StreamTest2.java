import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		list.stream()
			.filter(n -> n % 2 == 0)
			.forEach(n -> System.out.print(" " + n));

		System.out.println();

		list.stream()
			.filter(n -> n % 2 == 0)
			.map(i -> i * i)
			.forEach(n -> System.out.print(" " + n));

		System.out.println();

		int sum = list.stream()
			.filter(n -> n % 2 == 0)
			.map(i -> i * i)
			.mapToInt(i -> i)
			.peek(i -> System.out.print(" " + i))
			.sum();
		
		System.out.println();
		
		System.out.println("sum:" + sum);

	}

}
