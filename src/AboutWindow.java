import java.awt.Label;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class AboutWindow {

	private Label lblDrepturiDeAutor;
	// ==================== 2. Instance Fields ============================

	private Shell shell;

	// ==================== 4. Constructors ===============================

	public AboutWindow() {

		shell = new Shell(Display.getCurrent());
		shell.setSize(322, 159);
		shell.setText("Despre");
//
//		lblDrepturiDeAutor = new Label();
//		lblDrepturiDeAutor.setBounds(10, 10, 294, 119);
//		lblDrepturiDeAutor
//				.setText("- Drepturi de autor -  "
//						+ '\n'
//						+ "Acest software a fost realizat de catre dezvoltatorul Dudas Nicolae"
//						+ '\n' + "Nr. de telefon: +40743617589" + '\n'
//						+ "Adresa: Avram Iancu 58" + '\n'
//						+ "E-mail: dudasnicu@gmail.com");

	}

	public void open() {
		shell.open();

	}

	public void close() {
		// Don't call shell.close(), because then
		// you'll have to re-create it
		shell.setVisible(false);

	}
}
