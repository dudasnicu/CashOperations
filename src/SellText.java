import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.widgets.Shell;

import POJO.ErrorMessageBox;

public class SellText {

	public SellText(Shell shell, String introText, String reasonText,
			String removalText, String beadingText, String path, String extension)
			throws IOException {
		if (!introText.isEmpty()) {
			File inputFile = new File(path + "\\cf" + extension);
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

		} else if (!removalText.isEmpty()) {
			File outputFile = new File(path + "\\cf" + extension);
			outputFile.getParentFile().mkdirs();
			BufferedWriter outputTake;
			outputTake = new BufferedWriter(new FileWriter(outputFile));
			if (!reasonText.isEmpty()) {
				outputTake.write("H,1,______,_,__;" + '\n'
						+ "I,1,______,_,__;1;" + removalText + ";;;;" + '\n'
						+ "P,1,______,_,__;" + reasonText + ";;;;;" + '\n'
						+ "T,1,______,_,__;0;;;;;");
			} else {
				outputTake.write("H,1,______,_,__;" + '\n'
						+ "I,1,______,_,__;1;" + removalText + ";;;;" + '\n'
						+ "T,1,______,_,__;0;;;;;");
			}
			outputTake.close();
		}

		else if (!beadingText.isEmpty()) {
			File outputFile = new File(path + "\\cf" + extension);
			outputFile.getParentFile().mkdirs();
			BufferedWriter outputTake;
			outputTake = new BufferedWriter(new FileWriter(outputFile));
			outputTake.write("H,1,______,_,__;" + '\n'
					+ "S,1,______,_,__;BACSIS;" + beadingText
					+ ";1.000;4;1;3;0;0;" + '\n' + "T,1,______,_,__;0;;;;;");

			outputTake.close();
		} else {
			new ErrorMessageBox(shell, "Completati un camp !");
		}

	}

}