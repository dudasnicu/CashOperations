import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class AboutWindow {

	// ==================== 2. Instance Fields ============================

	private Shell shell;

	// ==================== 4. Constructors ===============================

	public AboutWindow() {

		Display.getDefault();
		createContents();
		open();

	}

	protected void createContents() {
		shell = new Shell();
		shell.setSize(322, 163);
		shell.setText("Despre");
		shell.setImage(SWTResourceManager.getImage(MainWindow.class,
				"/javax/swing/plaf/basic/icons/JavaCup16.png"));

		Label copyrightLabel = new Label(shell, 16779264);
		copyrightLabel.setFont(SWTResourceManager.getFont("Times New Roman",
				12, SWT.NORMAL));
		copyrightLabel.setAlignment(SWT.CENTER);
		copyrightLabel.setBounds(10, 10, 294, 119);
		copyrightLabel
				.setText("------------ Drepturi de autor -------------  "
						+ '\n'
						+ "Acest software a fost realizat de catre dezvoltatorul Dudas Nicolae"
						+ '\n' + "Nr. de telefon: +40743617589" + '\n'
						+ "Adresa: Avram Iancu 58" + '\n'
						+ "E-mail: dudasnicu@gmail.com" + '\n' + "-------------------------------------------");

	}

	public void open() {
		Display.getDefault();
		createContents();
		shell.open();
		shell.layout();

	}

	public void close() {
		// Don't call shell.close(), because then
		// you'll have to re-create it
		shell.setVisible(true);

	}
}
