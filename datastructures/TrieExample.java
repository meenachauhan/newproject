
class TrieNode {
	// Assuming the Trie deals with lowercase English letters (a-z)
	private TrieNode[] children;
	private boolean isEndOfWord;

	public TrieNode() {
		children = new TrieNode[26]; // 26 letters in the alphabet
		isEndOfWord = false;
	}

	public boolean containsKey(char ch) {
		return children[ch - 'a'] != null;
	}

	public TrieNode get(char ch) {
		return children[ch - 'a'];
	}

	public void put(char ch, TrieNode node) {
		children[ch - 'a'] = node;
	}

	public void setEnd() {
		isEndOfWord = true;
	}

	public boolean isEnd() {
		return isEndOfWord;
	}
}

public class TrieExample {
	private TrieNode root;

	public TrieExample() {
		root = new TrieNode();
	}
	public void insert(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			if (!node.containsKey(ch)) {
				node.put(ch, new TrieNode());
			}
			node = node.get(ch);
		}
		node.setEnd();
	}

	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}

	public boolean startsWith(String prefix) {
		return searchPrefix(prefix) != null;
	}

	private TrieNode searchPrefix(String prefix) {
		TrieNode node = root;
		for (char ch : prefix.toCharArray()) {
			if (node.containsKey(ch)) {
				node = node.get(ch);
			} else {
				return null;
			}
		}
		return node;
	}

	public static void main(String[] args) {
		TrieExample trie = new TrieExample();

		// Insert words into the Trie
		trie.insert("book");
		trie.insert("booking");

		// Search for words
		System.out.println(trie.search("book")); // true
		System.out.println(trie.search("books"));   // false
		System.out.println(trie.startsWith("boo")); // true
	}
}

