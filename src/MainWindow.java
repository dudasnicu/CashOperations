import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainWindow {

	protected Shell shell;
	private Text cashIntroET;
	private Text cashRemovalET;
	private String introText = "";
	private String removalText = "";
	private String beadingText = "";
	private String tempString = "0.00";
	private Button fprintCheckButton;
	private Button selltextCheckButton;
	private Text beadingET;
	private AboutWindow aboutShell;

	// Launch the application
	public static void main(String[] args) {

		try {
			MainWindow window = new MainWindow();
			window.open();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Open the window
	public void open() throws IOException {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		// layout-ul aplicatiei ↓

		shell = new Shell(SWT.CLOSE | SWT.TITLE | SWT.MIN);
		shell.setImage(SWTResourceManager.getImage(MainWindow.class,
				"/javax/swing/plaf/basic/icons/JavaCup16.png"));
		shell.setSize(243, 550);
		shell.setLayout(null);
		shell.setText("Cash Operations");

		Menu menu = new Menu(shell, SWT.BAR); // menu bar
		shell.setMenuBar(menu);

		MenuItem aboutItem = new MenuItem(menu, SWT.CASCADE);
		aboutItem.setText("Despre");

		// open about shell function
		aboutItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					AboutWindow about_window = new AboutWindow();
					about_window.open();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		Label cashIntroduction = new Label(shell, SWT.BORDER | SWT.CENTER);
		cashIntroduction.setFont(SWTResourceManager.getFont("Arial", 12,
				SWT.BOLD));
		cashIntroduction.setBounds(10, 126, 215, 23);
		cashIntroduction.setText("INTRODUCERE BANI");

		Label cashRemoval = new Label(shell, SWT.BORDER | SWT.CENTER);
		cashRemoval.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		cashRemoval.setBounds(10, 231, 215, 23);
		cashRemoval.setText("SCOATERE BANI");

		Label exampleLabel = new Label(shell, SWT.CENTER);
		exampleLabel.setFont(SWTResourceManager.getFont("Arial", 14, SWT.BOLD));
		exampleLabel.setBounds(14, 53, 211, 66);
		exampleLabel
				.setText("OBLIGATORIU se introduce valoarea cu DOUA ZECIMALE");

		Label beadingLabel = new Label(shell, SWT.BORDER | SWT.CENTER);
		beadingLabel.setBounds(10, 334, 215, 23);
		beadingLabel.setText("BACŞIŞ");
		beadingLabel.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));

		Button executeButton = new Button(shell, SWT.NONE);
		executeButton
				.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		executeButton.setTouchEnabled(true);
		executeButton.setBounds(10, 448, 105, 34);
		executeButton.setText("EXECUTA");

		Button closeButton = new Button(shell, SWT.NONE);
		closeButton.setTouchEnabled(true);
		closeButton.setFont(SWTResourceManager.getFont("Arial", 12, SWT.BOLD));
		closeButton.setBounds(120, 448, 105, 34);
		closeButton.setText("INCHIDE");

		selltextCheckButton = new Button(shell, SWT.RADIO);
		selltextCheckButton.setFont(SWTResourceManager.getFont("Arial", 10,
				SWT.BOLD));
		selltextCheckButton.setBounds(4, 10, 85, 16);
		selltextCheckButton.setText("SELLTEXT");
		selltextCheckButton.setSelection(true);

		fprintCheckButton = new Button(shell, SWT.RADIO);
		fprintCheckButton.setFont(SWTResourceManager.getFont("Arial", 10,
				SWT.BOLD));
		fprintCheckButton.setBounds(4, 27, 85, 16);
		fprintCheckButton.setText("FPRINT");

		beadingET = new Text(shell, SWT.BORDER);
		beadingET.setBounds(10, 363, 215, 66);
		beadingET.setFont(SWTResourceManager.getFont("Arial", 15, SWT.BOLD));
		beadingET
				.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		beadingET.setMessage(tempString);

		// functia de verificare a keypress-ului ↓
		beadingET.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {

				// Assume we don't allow it
				event.doit = false;

				// Get the character typed
				char myChar = event.character;

				// Only allows digit, dot, backspace and delete
				if (Character.isDigit(myChar) || myChar == '.'
						|| myChar == '\b' || myChar == '\u007F')
					event.doit = true;
			}

		});

		cashIntroET = new Text(shell, SWT.BORDER);
		cashIntroET.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_DARK_RED));
		cashIntroET.setFont(SWTResourceManager.getFont("Arial", 15, SWT.BOLD));
		cashIntroET.setBounds(10, 157, 215, 66);
		cashIntroET.setMessage(tempString);

		// functia de verificare a keypress-ului ↓
		cashIntroET.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {

				// Assume we don't allow it
				event.doit = false;

				// Get the character typed
				char myChar = event.character;

				// Only allows digit, dot, backspace and delete
				if (Character.isDigit(myChar) || myChar == '.'
						|| myChar == '\b' || myChar == '\u007F')
					event.doit = true;
			}

		});

		cashRemovalET = new Text(shell, SWT.BORDER);
		cashRemovalET.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_DARK_RED));
		cashRemovalET
				.setFont(SWTResourceManager.getFont("Arial", 15, SWT.BOLD));
		cashRemovalET.setBounds(10, 262, 215, 66);
		cashRemovalET.setMessage(tempString);

		cashRemovalET.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {

				// Assume we don't allow it
				event.doit = false;

				// Get the character typed
				char myChar = event.character;

				// Only allows digit, dot, backspace and delete
				if (Character.isDigit(myChar) || myChar == '.'
						|| myChar == '\b' || myChar == '\u007F')
					event.doit = true;
			}

		});
		// end of layout ↑

		// functia butonului de a copia textele din casute si de a
		// creea fisierele cu textul adaugat in ele depinzand de programul
		// selectat cu care lucreaza casa de marcat.
		// start of execution button ↓
		executeButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {

				try {
					beadingText = "";
					introText = "";
					removalText = "";
					if (cashIntroET.getText().isEmpty()
							&& cashRemovalET.getText().isEmpty())
						beadingText = beadingET.getText();
					else if (!cashIntroET.getText().isEmpty()) {
						introText = cashIntroET.getText();
					} else if (!cashRemovalET.getText().isEmpty()) {
						removalText = cashRemovalET.getText();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/*
				 * H,1,______,_,__; //blocare tastatura
				 * I,1,______,_,__;0;100;;;; //inserare valoarea 100
				 * F,1,______,_,__; //deblocare tastatura
				 * 
				 * H,1,______,_,__; //blocare tastatura
				 * I,0,______,_,__;0;100;;;; //scoatere valoarea 100
				 * F,1,______,_,__; //deblocare tastatura
				 * P,1,______,_,__;cainele se joaca;;; //printeaza un mesajul
				 * "cainele se joaca" MAX 18 caractere pe un rand
				 */

				String arch = System.getenv("PROCESSOR_ARCHITECTURE");
				String wow64Arch = System.getenv("PROCESSOR_ARCHITEW6432");

				String realArch = arch.endsWith("64") || wow64Arch != null
						&& wow64Arch.endsWith("64") ? "64" : "32";

				// ///////////// SELLTEXT ///////////////
				try {
					if (selltextCheckButton.getSelection() == true) {

						if (!introText.isEmpty()) {
							File inputFile = new File("C:\\CaSyst\\cf.inp");
							inputFile.getParentFile().mkdirs();
							BufferedWriter outputInsert;
							outputInsert = new BufferedWriter(new FileWriter(
									inputFile));
							outputInsert.write("I,1,______,_,__;0;" + introText
									+ ";;;;" + '\n' + "T,1,______,_,__;0;;;;;");

							outputInsert.close();

						} else if (!removalText.isEmpty()) {
							File outputFile = new File("C:\\CaSyst\\cf.inp");
							outputFile.getParentFile().mkdirs();
							BufferedWriter outputTake;
							outputTake = new BufferedWriter(new FileWriter(
									outputFile));
							outputTake.write("I,1,______,_,__;1;" + removalText
									+ ";;;;" + '\n' + "T,1,______,_,__;0;;;;;");
							outputTake.close();
						}

						else if (!beadingText.isEmpty()) {
							File outputFile = new File("C:\\CaSyst\\cf.inp");
							outputFile.getParentFile().mkdirs();
							BufferedWriter outputTake;
							outputTake = new BufferedWriter(new FileWriter(
									outputFile));
							outputTake.write("S,1,______,_,__;BACSIS;"
									+ beadingText + ";1.000;" + "4;1;3;0;0;"
									+ '\n' + "T,1,______,_,__;0;;;;;");

							outputTake.close();
						} else {
							int style = SWT.ERROR;

							MessageBox messageBox = new MessageBox(shell, style);
							messageBox
									.setMessage("Nu exista directorul C:\\Casyst\\");
							messageBox.setText("Eroare");
							int rc = messageBox.open();
							switch (rc) {
							case SWT.YES:
								System.out.println("OK");
								break;
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();

				}

				// ///////////// FPRINT //////////////
				try {
					if (fprintCheckButton.getSelection() == true) {

						if (!introText.isEmpty()) {
							if (realArch.toString() == "64") {
								File inputFile = new File(
										"C:\\Program Files (x86)\\Datecs Applications\\FPrintWIN\\cf.inp");

								inputFile.getParentFile().mkdirs();
								BufferedWriter outputInsert;
								outputInsert = new BufferedWriter(
										new FileWriter(inputFile));

								outputInsert.write("I,1,______,_,__;0;"
										+ introText + ";;;;" + '\n'
										+ "T,1,______,_,__;0;;;;;");
								outputInsert.close();
							} else {
								File inputFile = new File(
										"C:\\Program Files\\Datecs Applications\\FPrintWIN\\cf.inp");
								inputFile.getParentFile().mkdirs();
								BufferedWriter outputInsert;
								outputInsert = new BufferedWriter(
										new FileWriter(inputFile));

								outputInsert.write("I,1,______,_,__;0;"
										+ introText + ";;;;" + '\n'
										+ "T,1,______,_,__;0;;;;;");

								outputInsert.close();
							}

						} else if (!removalText.isEmpty()) {
							if (realArch.toString() == "64") {
								File outputFile = new File(
										"C:\\Program Files (x86)\\Datecs Applications\\FPrintWIN\\cf.inp");
								outputFile.getParentFile().mkdirs();
								BufferedWriter outputTake;
								outputTake = new BufferedWriter(new FileWriter(
										outputFile));

								outputTake.write("I,1,______,_,__;1;"
										+ removalText + ";;;;" + '\n'
										+ "T,1,______,_,__;0;;;;;");

								outputTake.close();
							} else {
								File outputFile = new File(
										"C:\\Program Files\\Datecs Applications\\FPrintWIN\\cf.inp");
								outputFile.getParentFile().mkdirs();
								BufferedWriter outputTake;
								outputTake = new BufferedWriter(new FileWriter(
										outputFile));

								outputTake.write("I,1,______,_,__;1;"
										+ removalText + ";;;;" + '\n'
										+ "T,1,______,_,__;0;;;;;");

								outputTake.close();
							}
						} else if (!beadingText.isEmpty()) {
							if (realArch.toString() == "64") {
								File outputFile = new File(
										"C:\\Program Files (x86)\\Datecs Applications\\FPrintWIN\\cf.inp");
								outputFile.getParentFile().mkdirs();
								BufferedWriter outputTake;
								outputTake = new BufferedWriter(new FileWriter(
										outputFile));
								outputTake.write("S,1,______,_,__;BACSIS;"
										+ beadingText + ";1.000;"
										+ "4;1;3;0;0;" + '\n'
										+ "T,1,______,_,__;0;;;;;");
								outputTake.close();
							} else {
								File outputFile = new File(
										"C:\\Program Files\\Datecs Applications\\FPrintWIN\\cf.inp");
								outputFile.getParentFile().mkdirs();
								BufferedWriter outputTake;
								outputTake = new BufferedWriter(new FileWriter(
										outputFile));
								outputTake.write("S,1,______,_,__;BACSIS;"
										+ beadingText + ";1.000;"
										+ "4;1;3;0;0;" + '\n'
										+ "T,1,______,_,__;0;;;;;");
								outputTake.close();
							}
						} else {
							int style = SWT.ERROR;

							MessageBox messageBox = new MessageBox(shell, style);
							if (realArch.toString() == "64") {
								messageBox
										.setMessage("Nu exista directorul C:\\Program Files (x86)\\Datecs Applications\\FPrintWIN\\");
							} else {
								messageBox
										.setMessage("Nu exista directorul C:\\Program Files\\Datecs Applications\\FPrintWIN\\");
							}
							messageBox.setText("Eroare");
							int rc = messageBox.open();
							switch (rc) {
							case SWT.YES:
								System.out.println("OK");
								break;
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();

				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		// end of "execution button" ↑

		// functia butonului de inchidere a aplicatiei

		closeButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent arg0) {
				System.exit(1);
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
	}

	// crearea unui ferestre noi pentru vizualizarea ofertelor
	public void createViewContents(final Composite parent) {
		Display display = new Display();
		Shell shell = new Shell(display);
		aboutShell = new AboutWindow();

		shell.pack();
		shell.open();
	}
}
