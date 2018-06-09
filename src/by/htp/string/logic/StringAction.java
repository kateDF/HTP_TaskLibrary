package by.htp.string.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAction {

	public static String addSequenceMultiString(String str, int num, String seq) { // variant A, task 4
		int i = 0;
		while (i + num <= str.length()) {
			str = (String) str.subSequence(0, i + num) + seq + (String) str.subSequence(i + num, str.length());
			i = i + num + 1;
		}

		return str;
	}

	public static StringBuilder addSequenceMultiWithStringBuilder(StringBuilder sbT, int num, String seq) {
		for (int i = 0; i + num < sbT.length(); i = i + num + 1) {
			sbT.insert(i + num, seq);
		}
		return sbT;
	}

	public static StringBuilder addWordsAfterEndWordSequense(StringBuilder sbT, String regex, String addWord) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sbT);

		while (m.find()) {
			sbT.insert(m.end() - 1, addWord);
		}
		return sbT;
	}

	public static StringBuilder deleteNonLetersOrBackspaceSimbols(StringBuilder sbT, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sbT);
		int start = 0;

		while (m.find(start)) {
			sbT.replace(m.start(), m.end(), "");
			start = m.start();
		}

		return sbT;
	}

	public static StringBuilder addBackspacesAfterEverySymbol(StringBuilder sbT) {
		for (int i = 1; i < sbT.length(); i += 2) {
			sbT.insert(i, " ");
		}
		return sbT;
	}

	private static String[] allWordsInArray(StringBuilder sbT) {
		String regex = "[à-ÿÀ-ß]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sbT);
		List<String> allWords = new ArrayList<>();
		while (m.find()) {
			allWords.add(m.group());
		}
		String[] words = allWords.toArray(new String[0]);

		return words;
	}

	public static String[] createArrayWithUniqueWords(StringBuilder sbT) {
		String[] allWords = allWordsInArray(sbT);
		int k = 1;
		for (int i = 0; i < allWords.length; i++, k++) {
			for (int j = k; j < allWords.length; j++) {
				if (allWords[i] != null && allWords[j] != null && allWords[i].equalsIgnoreCase(allWords[j])) {
					allWords[j] = null;
				}
			}
		}

		int counter = 0;
		for (int i = 0; i < allWords.length; i++) {
			if (allWords[i] != null) {
				counter++;
			}
		}

		String[] uniqueWords = new String[counter];
		int j = 0;

		for (int i = 0; i < allWords.length; i++) {
			if (allWords[i] != null) {
				uniqueWords[j] = allWords[i];
				j++;
			}
		}

		return uniqueWords;
	}

	public static int[] countUniqueWordsInString(StringBuilder sbT) {
		String[] uniqueWords = createArrayWithUniqueWords(sbT);
		String regex;
		Pattern p;
		Matcher m;
		int count = 0;
		int[] countRepeatedWords = new int[uniqueWords.length];
		for (int i = 0; i < uniqueWords.length; i++) {
			regex = "(?:^|[^à-ÿÀ-ÿ])" + uniqueWords[i] + "[^à-ÿÀ-ÿ]";
			p = Pattern.compile(regex);
			m = p.matcher(sbT);
			while (m.find()) {
				count++;
			}
			countRepeatedWords[i] = count;
			count = 0;
		}
		return countRepeatedWords;
	}

	public static void showPairsUniqueWordsAndCounts(StringBuilder sbT) {
		String[] uniqueWords = createArrayWithUniqueWords(sbT);
		int[] numberRepeatedWords = countUniqueWordsInString(sbT);

		for (int i = 0; i < uniqueWords.length; i++) {
			System.out.println(uniqueWords[i] + ". Number of repeats = " + numberRepeatedWords[i]);
		}
	}

}
