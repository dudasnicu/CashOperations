import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.widgets.Shell;

import POJO.ErrorMessageBox;

public class FPrint {

	String arch = System.getenv("PROCESSOR_ARCHITECTURE");
	String wow64Arch = System.getenv("PROCESSOR_ARCHITEW6432");

	String realArch = arch.endsWith("64") || wow64Arch != null
			&& wow64Arch.endsWith("64") ? "64" : "32";

	public FPrint(Shell shell, String introText, String reasonText,
			String removalText, String beadingText, String path, String extension)
			throws IOException {
		if (!introText.isEmpty()) {
			if (realArch == "64") {
				File inputFile = new File("C:\\Program Files\\Datecs Applications\\FPrintWIN" + "\\cf" + extension);

				inputFile.getParentFile().mkdirs();
				BufferedWriter outputInsert;
				outputInsert = new BufferedWriter(new FileWriter(inputFile));

				if (!reasonText.isEmpty()) {
					outputInsert.write("H,1,______,_,__;" + '\n'
							+ "I,1,______,_,__;0;" + introText + ";;;;" + '\n'
							+ "P,1,______,_,__;" + reasonText + ";;;;;" + '\n'
							+ "T,1,______,_,__;0;;;;;");
				} else {
					outputInsert.write("H,1,______,_,__;" + '\n'
							+ "I,1,______,_,__;0;" + introText + ";;;;" + '\n'
							+ "T,1,______,_,__;0;;;;;");
				}
				outputInsert.close();
			} else {
				File inputFile = new File("C:\\Program Files\\Datecs Applications\\FPrintWIN" + "\\cf" + extension);
				inputFile.getParentFile().mkdirs();
				BufferedWriter outputInsert;
				outputInsert = new BufferedWriter(new FileWriter(inputFile));

				if (!reasonText.isEmpty()) {
					outputInsert.write("H,1,______,_,__;" + '\n'
							+ "I,1,______,_,__;0;" + introText + ";;;;" + '\n'
							+ "P,1,______,_,__;" + reasonText + ";;;;;" + '\n'
							+ "T,1,______,_,__;0;;;;;");
				} else {
					outputInsert.write("H,1,______,_,__;" + '\n'
							+ "I,1,______,_,__;0;" + introText + ";;;;" + '\n'
							+ "T,1,______,_,__;0;;;;;");
				}
				outputInsert.close();
			}

		} else if (!removalText.isEmpty()) {
			if (realArch.toString() == "64") {
				File outputFile = new File("C:\\Program Files\\Datecs Applications\\FPrintWIN" + "\\cf" + extension);
				outputFile.getParentFile().mkdirs();
				BufferedWriter outputTake;
				outputTake = new BufferedWriter(new FileWriter(outputFile));
				if (!reasonText.isEmpty()) {
					outputTake.write("H,1,______,_,__;" + '\n'
							+ "I,1,______,_,__;1;" + removalText + ";;;;"
							+ '\n' + "P,1,______,_,__;" + reasonText + ";;;;;"
							+ '\n' + "T,1,______,_,__;0;;;;;");
				} else {
					outputTake.write("H,1,______,_,__;" + '\n'
							+ "I,1,______,_,__;1;" + removalText + ";;;;"
							+ '\n' + "T,1,______,_,__;0;;;;;");
				}

				outputTake.close();
			} else {
				File outputFile = new File("C:\\Program Files\\Datecs Applications\\FPrintWIN" + "\\cf" + extension);
				outputFile.getParentFile().mkdirs();
				BufferedWriter outputTake;
				outputTake = new BufferedWriter(new FileWriter(outputFile));
				if (!reasonText.isEmpty()) {
					outputTake.write("H,1,______,_,__;" + '\n'
							+ "I,1,______,_,__;1;" + removalText + ";;;;"
							+ '\n' + "P,1,______,_,__;" + reasonText + ";;;;;"
							+ '\n' + "T,1,______,_,__;0;;;;;");
				} else {
					outputTake.write("H,1,______,_,__;" + '\n'
							+ "I,1,______,_,__;1;" + removalText + ";;;;"
							+ '\n' + "T,1,______,_,__;0;;;;;");
				}

				outputTake.close();

			}
		} else if (!beadingText.isEmpty()) {
			if (realArch.toString() == "64") {
				File outputFile = new File("C:\\Program Files\\Datecs Applications\\FPrintWIN" + "\\cf" + extension);
				outputFile.getParentFile().mkdirs();
				BufferedWriter outputTake;
				outputTake = new BufferedWriter(new FileWriter(outputFile));
				outputTake.write("H,1,______,_,__;" + '\n'
						+ "S,1,______,_,__;BACSIS;" + beadingText + ";1.000;"
						+ "4;1;3;0;0;" + '\n' + "T,1,______,_,__;0;;;;;");
				outputTake.close();
			} else {
				File outputFile = new File("C:\\Program Files\\Datecs Applications\\FPrintWIN" + "\\cf" + extension);
				outputFile.getParentFile().mkdirs();
				BufferedWriter outputTake;
				outputTake = new BufferedWriter(new FileWriter(outputFile));
				outputTake
						.write("H,1,______,_,__;" + '\n'
								+ "S,1,______,_,__;BACSIS;" + beadingText
								+ ";1.000;4;1;3;0;0;" + '\n'
								+ "T,1,______,_,__;0;;;;;");
				outputTake.close();
			}
		} else {
			if (realArch.toString() == "64") {
				new ErrorMessageBox(shell, "Completati un camp !");
			} else {
				new ErrorMessageBox(shell, "Completati un camp !");
			}

		}

	}

}
