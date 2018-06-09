package by.htp.string.run;

import by.htp.string.logic.StringAction;

public class Main {

	public static void main(String[] args) {

		// variant A, task 4
		int num = 3;
		String str = "¬ тексте после " + num + "-го символа вставить заданную подстроку";
		String s1 = "*";

		String str1 = StringAction.addSequenceMultiString(str, num, s1);

		System.out.println(str1);

		StringBuilder sbT = new StringBuilder("¬ тексте после " + num + "-го символа вставить заданную подстроку");
		StringAction.addSequenceMultiWithStringBuilder(sbT, num, s1);

		System.out.println(sbT);

		// variant A, task 5
		String regex = "ой(\\W|,)";
		StringBuilder sbT1 = new StringBuilder(
				"ѕосле каждого слова текста, заканчивающегос€ любой заданной подстрокой вставить указанные слова.");
		String addWord = " add smth";

		StringAction.addWordsAfterEndWordSequense(sbT1, regex, addWord);

		System.out.println(sbT1);

		// variant A task 7
		String regex2 = "[^а-€ј-я ]";
		StringBuilder sbT2 = new StringBuilder("»з текста удалить все символы, кроме пробелов, "
				+ "не €вл€ющиес€ буквами (7,6!*). + ћежду последовательност€ми подр€д идущих букв "
				+ "оставить хот€ бы один пробел.");

		StringAction.deleteNonLetersOrBackspaceSimbols(sbT2, regex2);
		System.out.println(sbT2);

		StringAction.addBackspacesAfterEverySymbol(sbT2);
		System.out.println(sbT2);

		System.out.println();

		// variant A task 9
		StringBuilder sbT3 = new StringBuilder("ќпределить, сколько раз повтор€етс€ в тексте каждое слово, "
				+ "которое встречаетс€ в нем. ќпределить, сколько раз повтор€етс€. "
				+ "ќпределить, сколько раз повтор€етс€ в тексте каждое слово. "
				+ "ќпределить, сколько раз повтор€етс€ в тексте каждое слово, " + "которое встречаетс€ в нем.");
		System.out.println(sbT3);
		StringAction.showPairsUniqueWordsAndCounts(sbT3);

	}

}
