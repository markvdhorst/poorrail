package nl.hu.pafr.view;

import nl.hu.pafr.controller.TrainCompanyController;

public class DslParser {
	TrainCompanyController TCT;
	static String[] commands;

	public DslParser(TrainCompanyController tct) {
		TCT = tct;
	}

	static void parseDSL(String s) throws Exception {
		// Haar de string uit elkaar
		String[] commands = s.split(" ");
		// Kijk naar het 1ste commando
		if (inBounds(3, commands)) {
			parseWord3(commands[3]);
		}
		if (inBounds(2, commands)) {
			parseWord2(commands[2]);
		}
		if (inBounds(1, commands)) {
			parseWord1(commands[1]);
		}
		if (inBounds(0, commands)) {
			parseWord0(commands);
		} else
			System.out.println("Commando niet begrepen.");
	}

	private static void parseWord3(String command) {
		// TODO Auto-generated method stub

	}

	private static void parseWord2(String command) {
		// TODO Auto-generated method stub

	}

	private static void parseWord1(String command) {

	}

	private boolean parseWord0(String[] commands) throws Exception {
		// TODO Auto-generated method stub
		if (commands[0].equals("new")) {
			if (commands[1].equals("train")) {
			TCT.addTrain(commands[2], commands[3], commands[4]);
			return true;}
			if (commands[1].equals("wagon")) {
				boolean command = Boolean.valueOf(commands[3]);
				TCT.addRollingComponentType(commands[2], command);
				return true;
			}
			throw new Exception("Onbekend Commando op plek 2");
		}
		if (commands[0].equals("add")) {
			TCT.addRollingComponentToTrain(commands[1], commands[3], commands[4]);
		}
		if (commands[0].equals("getnumseats")) {
		}
		if (commands[0].equals("delete")) {

		}
		if (commands[0].equals("remove")) {
		}
		return false;
	}

	private static boolean inBounds(int i, String[] s) {
		if (i >= 0 && i < s.length) {
			return true;
		}
		return false;
	}

}
