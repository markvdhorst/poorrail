package nl.hu.pafr.view;

import nl.hu.pafr.controller.TrainCompanyController;

public class DslParser {
	TrainCompanyController TCT;
	static String[] commands;
	String output = null;

	public DslParser(TrainCompanyController tct) {
		TCT = tct;
	}

	String parseDSL(String s) throws Exception {
		// Haar de string uit elkaar
		String[] commands = s.split(" ");
		// Kijk naar het 1ste commando
		return parseWord0(commands);
	}

	private String parseWord0(String[] commands) throws Exception {
		// TODO Auto-generated method stub
		if (commands[0].equals("new")) {
			if (commands[1].equals("train")) {
				TCT.addTrain(commands[2]);
				return ("train " + commands[2] + " created");
			}
			if (commands[1].equals("wagon")) {
				if (commands.length > 3) {
					int seats = Integer.parseInt(commands[4]);
					TCT.addRollingComponentType(seats, commands[2]);
					return ("wagon type " + commands[2] + " created with " + commands[4].toString() + "seats");
				} else
					return ("wagon type " + commands[2] + " created with " + "20" + " seats");
			}
		}
		else if (commands[0].equals("add")) {
			TCT.addRollingComponentToTrain(commands[1], commands[3], commands[4]);
			return ("wagon" + commands[4] + " added to " + commands[3]);
		}
		else if (commands[0].equals("getnumseats")) {
			if (commands[1].equals("train")) {
				return ("number of seats in " + commands[2] + ":" + TCT.getSeats(commands[2]));
			}
			if (commands[1].equals("wagon")) {
				return ("number of seats in " + commands[2] + ":" + TCT.getSeats(commands[2]));
			}
		}
		else if (commands[0].equals("delete")) {
			if (TCT.deleteTrain(commands[2])) {
				return ("train " + commands[2] + " deleted");
			}
			else return ("train " + commands[2] + " does not exist.");
		}
		else if (commands[0].equals("remove")) {
			TCT.deleteRollingComponentFromTrain(commands[1], commands[3]);
			return ("wagon " + commands[1] + "removed from train " + commands[3]);
		}
		return ("Command not known");
	}

}
