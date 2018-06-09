package by.htp.string.run;

import by.htp.string.logic.StringAction;

public class Main {

	public static void main(String[] args) {

		// variant A, task 4
		int num = 3;
		String str = "� ������ ����� " + num + "-�� ������� �������� �������� ���������";
		String s1 = "*";

		String str1 = StringAction.addSequenceMultiString(str, num, s1);

		System.out.println(str1);

		StringBuilder sbT = new StringBuilder("� ������ ����� " + num + "-�� ������� �������� �������� ���������");
		StringAction.addSequenceMultiWithStringBuilder(sbT, num, s1);

		System.out.println(sbT);

		// variant A, task 5
		String regex = "��(\\W|,)";
		StringBuilder sbT1 = new StringBuilder(
				"����� ������� ����� ������, ���������������� ����� �������� ���������� �������� ��������� �����.");
		String addWord = " add smth";

		StringAction.addWordsAfterEndWordSequense(sbT1, regex, addWord);

		System.out.println(sbT1);

		// variant A task 7
		String regex2 = "[^�-��-� ]";
		StringBuilder sbT2 = new StringBuilder("�� ������ ������� ��� �������, ����� ��������, "
				+ "�� ���������� ������� (7,6!*). + ����� �������������������� ������ ������ ���� "
				+ "�������� ���� �� ���� ������.");

		StringAction.deleteNonLetersOrBackspaceSimbols(sbT2, regex2);
		System.out.println(sbT2);

		StringAction.addBackspacesAfterEverySymbol(sbT2);
		System.out.println(sbT2);

		System.out.println();

		// variant A task 9
		StringBuilder sbT3 = new StringBuilder("����������, ������� ��� ����������� � ������ ������ �����, "
				+ "������� ����������� � ���. ����������, ������� ��� �����������. "
				+ "����������, ������� ��� ����������� � ������ ������ �����. "
				+ "����������, ������� ��� ����������� � ������ ������ �����, " + "������� ����������� � ���.");
		System.out.println(sbT3);
		StringAction.showPairsUniqueWordsAndCounts(sbT3);

	}

}
