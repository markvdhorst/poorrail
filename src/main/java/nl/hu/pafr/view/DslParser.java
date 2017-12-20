package nl.hu.pafr.view;

import nl.hu.pafr.controller.TrainCompanyController;

public class DslParser {
	TrainCompanyController TCT;
	static String[] commands;

	public DslParser(TrainCompanyController tct) {
		TCT = tct;
	}

	boolean parseDSL(String s) throws Exception {
		// Haar de string uit elkaar
		String[] commands = s.split(" ");
		// Kijk naar het 1ste commando
	if (parseWord0(commands)){
		return true;
		} else
			System.out.println("Commando niet begrepen.");
	return false;
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
				TCT.addTrain(commands[2]);
				return true;
			}
			if (commands[1].equals("wagon")) {
				boolean command = Boolean.valueOf(commands[3]);
				if (commands[4] != null) {
					int seats = Integer.parseInt(commands[4]);
					TCT.addRollingComponentType(seats, commands[2], command);
					return true;
				}
				TCT.addRollingComponentType(commands[2], command);
				return true;
			}
			throw new Exception("Onbekend Commando op plek 2");
		}
		if (commands[0].equals("add")) {
			TCT.addRollingComponentToTrain(commands[1], commands[3], commands[4]);
			return true;
		}
		if (commands[0].equals("getnumseats")) {
			if (commands[1].equals("train")) {
				TCT.getSeats(commands[1]);
				return true;
			}
			if (commands[1].equals("wagon")) {
				TCT.getSeats(commands[1]);
				return true;
			}
		}
		if (commands[0].equals("delete")) {
			TCT.deleteTrain(commands[2]);
		}
		if (commands[0].equals("remove")) {
			TCT.deleteRollingComponentFromTrain(commands[1], commands[3]);
		}
		return false;
	}

}
