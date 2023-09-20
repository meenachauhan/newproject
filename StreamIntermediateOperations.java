import java.util.ArrayList;
import java.util.List;

public class StreamIntermediateOperations {

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
		Transaction t5 = new TransactionBuilder().withId(4).withValue(99).withTransactionType("Grocery").build();
		transactions.add(t5);
		return transactions;
	}

	public static void main(String[] args) {
		//we need to find all transactions of type grocery and return a list of transaction Ids sorted in descending order of transaction value.
		// BEFORE STREAMS
		StreamIntermediateOperations examples = new StreamIntermediateOperations();
		List<Transaction> transactions = examples.getTransactions();

		long totalTransactions = transactions.stream()
				.filter( t -> t.getTransactionType().equals("Travel")) // return a new stream
				.mapToInt(Transaction::getValue)
				.count();

		System.out.println(totalTransactions);


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
}

