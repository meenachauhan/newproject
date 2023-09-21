import static java.util.Comparator.comparing;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

	public List<Transaction> getTransactions() {
		List<Transaction> transactions = new ArrayList<>();
		Transaction t1 = new TransactionBuilder().withId(1).withValue(100).withTransactionType("Grocery").build();
		transactions.add(t1);
		Transaction t2 = new TransactionBuilder().withId(2).withValue(150).withTransactionType("Entertainment").build();
		transactions.add(t2);
		Transaction t3 = new TransactionBuilder().withId(3).withValue(80).withTransactionType("Grocery").build();
		transactions.add(t3);
		Transaction t4 = new TransactionBuilder().withId(4).withValue(200).withTransactionType("Travel").build();
		transactions.add(t4);
		Transaction t5 = new TransactionBuilder().withId(5).withValue(99).withTransactionType("Grocery").build();
		transactions.add(t5);
		Transaction t6 = new TransactionBuilder().withId(6).withValue(900).withTransactionType("Travel").build();
		transactions.add(t6);
		return transactions;
	}
	class Transaction {
		Integer id;
		Integer value;
		String transactionType;

		public Transaction(Integer id, Integer value, String transactionType) {
			this.id = id;
			this.value = value;
			this.transactionType = transactionType;
		}
		public Integer getId() {
			return  this.id;
		}

		public Integer getValue() {
			return  this.value;
		}

		public String getTransactionType() {
			return this.transactionType;
		}
	}

	class TransactionBuilder {
		Integer id;
		Integer value;
		String transactionType;

		public TransactionBuilder withId(Integer id) {
			this.id = id;
			return this;
		}

		public TransactionBuilder withValue(Integer value) {
			this.value = value;
			return this;
		}

		public TransactionBuilder withTransactionType(String transactionType) {
			this.transactionType = transactionType;
			return this;
		}

		public Transaction build() {
			return new Transaction(id, value, transactionType);
		}

	}

	public static void main(String[] args) {
		// What is flatMap? flattening is referred to as merging multiple collections/arrays into one

		//Before flattening 	: [[1, 2, 3], [4, 5], [6, 7, 8]]
		//After flattening 	: [1, 2, 3, 4, 5, 6, 7, 8]
		List<List<Integer>> listOfLists = Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(4, 5),
				Arrays.asList(6, 7, 8)
		);

		List<Integer> flattenedList = listOfLists.stream()
				.flatMap(list -> list.stream())  // Flattening step
				.collect(Collectors.toList());


		//Prints [1, 2, 3, 4, 5, 6, 7, 8]
		System.out.println("Flattened list: " + flattenedList);

		System.out.println("=============================================");
		int sum = listOfLists.stream()
				.flatMap(list -> list.stream()) // Flatten the list of lists
				.mapToInt(Integer::intValue) // Convert to IntStream
				.sum(); // Calculate the sum

		System.out.println("Sum of all numbers: " + sum);  //36

		System.out.println("=============================================");
		Stream<String> words = Stream.of("Java","streams","are","very","useful");

		Map<String, Long> letterToCount =
				words.map(w -> w.split(""))
						.flatMap(Arrays::stream)
						.collect(groupingBy(identity(), counting()));

		letterToCount.forEach( (k,v) -> System.out.println(k+":"+v));

		System.out.println("=============================================");
		StreamsDemo demo = new StreamsDemo();
		List<Transaction> transactions = demo.getTransactions();
		Map<String, Integer> sumByTransactions =
				transactions.stream()
						.collect(groupingBy(Transaction::getTransactionType,summingInt(Transaction::getValue)));

		sumByTransactions.forEach((k,v) -> System.out.println(k+" -> "+v));
		System.out.println("=============================================");
		Map<String, Optional<Transaction>> maxTransactions = transactions.stream().collect(
				groupingBy(Transaction::getTransactionType, maxBy(comparing(Transaction::getValue)))
		);
		maxTransactions.forEach((k,v) -> System.out.println(k+" -> "+v.get().getValue()));

		System.out.println("=============================================");

	}
}

