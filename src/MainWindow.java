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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
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
	private String reasonText = "";
	private String tempString = "0.00";
	private Button fprintCheckButton;
	private Button selltextCheckButton;
	private Button txtExtensionCheckButton;
	private Button inpExtensionCheckButton;
	private Button executeButton;
	private Text beadingET;
	private Text reasonET;
	public String dirText;
	public String path;
	public String extension;
	private static final double VERSION = 1.0;
	String p = System.getProperty("user.home") + File.separator;

	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() throws IOException {
		Display display = Display.getDefault();
		createMainContents();
		shell.open();
		shell.layout();
		// loadSettings();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}

	protected void createMainContents() {

		shell = new Shell(224);
		shell.setImage(SWTResourceManager.getImage(MainWindow.class,
				"/javax/swing/plaf/basic/icons/JavaCup16.png"));
		shell.setSize(243, 634);
		shell.setLayout(null);
		shell.setText("Cash Operations");
		shell.setDefaultButton(executeButton);
		// try {
		// loadSettings(path);
		// } catch (IOException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }

		Menu menu = new Menu(shell, 2);
		shell.setMenuBar(menu);

		MenuItem subMenu = new MenuItem(menu, SWT.CASCADE);
		subMenu.setText("Meniu");

		Menu menu_1 = new Menu(subMenu);
		subMenu.setMenu(menu_1);

		MenuItem aboutItemMenu = new MenuItem(menu_1, SWT.NONE);
		aboutItemMenu.setText("Despre");
		open(aboutItemMenu);

		MenuItem saveConfigItemMenu = new MenuItem(menu_1, SWT.NONE);
		saveConfigItemMenu.setText("Salveaza configuratie curenta");

		MenuItem updateItemMenu = new MenuItem(menu_1, SWT.NONE);
		updateItemMenu.setText("Actualizare program");

		Label cashIntroduction = new Label(shell, 16779264);
		cashIntroduction.setFont(SWTResourceManager.getFont("Arial", 12, 1));
		cashIntroduction.setBounds(10, 126, 215, 23);
		cashIntroduction.setText("INTRODUCERE BANI");

		Label cashRemoval = new Label(shell, 16779264);
		cashRemoval.setFont(SWTResourceManager.getFont("Arial", 12, 1));
		cashRemoval.setBounds(10, 231, 215, 23);
		cashRemoval.setText("SCOATERE BANI");

		Label exampleLabel = new Label(shell, 16777216);
		exampleLabel.setTouchEnabled(true);
		exampleLabel.setFont(SWTResourceManager.getFont("Arial", 14, 1));
		exampleLabel.setBounds(14, 53, 211, 66);
		exampleLabel
				.setText("OBLIGATORIU se introduce valoarea cu DOUA ZECIMALE");

		Label beadingLabel = new Label(shell, 16779264);
		beadingLabel.setBounds(10, 334, 215, 23);
		beadingLabel.setText("BACȘIȘ");
		beadingLabel.setFont(SWTResourceManager.getFont("Arial", 12, 1));

		Label reasonLabel = new Label(shell, 16779264);
		reasonLabel.setAlignment(16777216);
		reasonLabel.setBounds(10, 435, 215, 23);
		reasonLabel.setText("MOTIV:");
		reasonLabel.setFont(SWTResourceManager.getFont("Arial", 12, 1));

		executeButton = new Button(shell, 0);
		executeButton.setFont(SWTResourceManager.getFont("Arial", 12, 1));
		executeButton.setTouchEnabled(true);
		executeButton.setBounds(10, 546, 105, 34);
		executeButton.setText("EXECUTA");

		Button closeButton = new Button(shell, 0);
		closeButton.setTouchEnabled(true);
		closeButton.setFont(SWTResourceManager.getFont("Arial", 12, 1));
		closeButton.setBounds(121, 546, 105, 34);
		closeButton.setText("INCHIDE");

		Button rapZ = new Button(shell, SWT.NONE);
		rapZ.setBounds(10, 504, 105, 34);
		rapZ.setText("RAPORT Z");
		rapZ.setFont(SWTResourceManager.getFont("Arial", 12, 1));
		rapZ.setTouchEnabled(true);

		Button rapX = new Button(shell, SWT.NONE);
		rapX.setBounds(121, 504, 104, 34);
		rapX.setText("RAPORT X");
		rapX.setFont(SWTResourceManager.getFont("Arial", 12, 1));
		rapX.setTouchEnabled(true);

		selltextCheckButton = new Button(shell, SWT.RADIO);
		selltextCheckButton.setFont(SWTResourceManager.getFont("Arial", 10, 1));
		selltextCheckButton.setBounds(4, 10, 85, 16);
		selltextCheckButton.setText("SELLTEXT");

		fprintCheckButton = new Button(shell, SWT.RADIO);
		fprintCheckButton.setFont(SWTResourceManager.getFont("Arial", 10, 1));
		fprintCheckButton.setBounds(4, 27, 85, 16);
		fprintCheckButton.setText("FPRINT");
		fprintCheckButton.setSelection(true);

		txtExtensionCheckButton = new Button(shell, SWT.CHECK);
		txtExtensionCheckButton.setFont(SWTResourceManager.getFont("Arial", 10,
				1));
		txtExtensionCheckButton.setBounds(181, 10, 46, 16);
		txtExtensionCheckButton.setText(".txt");
		extension = txtExtensionCheckButton.getText().toString();

		inpExtensionCheckButton = new Button(shell, SWT.CHECK);
		inpExtensionCheckButton.setFont(SWTResourceManager.getFont("Arial", 10,
				1));
		inpExtensionCheckButton.setBounds(181, 27, 46, 16);
		inpExtensionCheckButton.setText(".inp");
		inpExtensionCheckButton.setSelection(true);

		reasonET = new Text(shell, 2048);
		reasonET.setBounds(10, 464, 215, 34);
		reasonET.setFont(SWTResourceManager.getFont("Arial", 15, 1));
		reasonET.setForeground(SWTResourceManager.getColor(4));
		reasonET.setMessage("...");

		beadingET = new Text(shell, 2048);
		beadingET.setBounds(10, 363, 215, 66);
		beadingET.setFont(SWTResourceManager.getFont("Arial", 15, 1));
		beadingET.setForeground(SWTResourceManager.getColor(4));
		beadingET.setMessage(tempString);

		cashIntroET = new Text(shell, 2048);
		cashIntroET.setForeground(SWTResourceManager.getColor(4));
		cashIntroET.setFont(SWTResourceManager.getFont("Arial", 15, 1));
		cashIntroET.setBounds(10, 157, 215, 66);
		cashIntroET.setMessage(tempString);

		cashRemovalET = new Text(shell, 2048);
		cashRemovalET.setForeground(SWTResourceManager.getColor(4));
		cashRemovalET.setFont(SWTResourceManager.getFont("Arial", 15, 1));
		cashRemovalET.setBounds(10, 262, 215, 66);
		cashRemovalET.setMessage(tempString);

		verify();
		doIt(executeButton);
		closeIt(closeButton);
		genZ(rapZ);
		genX(rapX);

		// saveConfigItemMenu.addSelectionListener(new SelectionListener() {
		//
		// @Override
		// public void widgetSelected(SelectionEvent arg0) {
		// try {
		// configSettings(dirText, extension);
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// }
		//
		// @Override
		// public void widgetDefaultSelected(SelectionEvent arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		// });

		// txtExtensionCheckButton.addSelectionListener(new SelectionListener()
		// {
		//
		// @Override
		// public void widgetSelected(SelectionEvent arg0) {
		// if (txtExtensionCheckButton.getSelection() == true) {
		// extension = txtExtensionCheckButton.getText().toString();
		// }
		//
		// }
		//
		// @Override
		// public void widgetDefaultSelected(SelectionEvent arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
	}

	// inpExtensionCheckButton.addSelectionListener(new SelectionListener() {
	//
	// @Override
	// public void widgetSelected(SelectionEvent arg0) {
	// if (inpExtensionCheckButton.getSelection() == true) {
	// extension = inpExtensionCheckButton.getText().toString();
	// }
	//
	// }
	//
	// @Override
	// public void widgetDefaultSelected(SelectionEvent arg0) {
	// // TODO Auto-generated method stub
	//
	// }
	// });

	// selltextCheckButton.addSelectionListener(new SelectionListener() {
	//
	// @Override
	// public void widgetSelected(SelectionEvent arg0) {
	//
	// // path = setFileDir();
	//
	// }
	//
	// @Override
	// public void widgetDefaultSelected(SelectionEvent arg0) {
	// // TODO Auto-generated method stub
	//
	// }
	// });

	// fprintCheckButton.addSelectionListener(new SelectionListener() {
	//
	// @Override
	// public void widgetSelected(SelectionEvent arg0) {
	// path = "C:\\Program Files\\Datecs Applications\\FPrintWIN\\";
	//
	// }
	//
	// @Override
	// public void widgetDefaultSelected(SelectionEvent arg0) {
	// // TODO Auto-generated method stub
	//
	// }
	// });
	// }

	private void genZ(Button rapZ) {
		rapZ.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {

					File inputFile = new File(
							"C:\\Program Files\\Datecs Applications\\FPrintWIN"
									+ "\\cf" + extension);
					inputFile.getParentFile().mkdirs();
					BufferedWriter outputInsert;
					outputInsert = new BufferedWriter(new FileWriter(inputFile));
					outputInsert.write("A,1,______,_,__;;;Z;;;");
					outputInsert.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
	}

	private void genX(Button rapX) {
		rapX.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					File inputFile = new File(
							"C:\\Program Files\\Datecs Applications\\FPrintWIN"
									+ "\\cf" + extension);
					inputFile.getParentFile().mkdirs();
					BufferedWriter outputInsert;
					outputInsert = new BufferedWriter(new FileWriter(inputFile));
					outputInsert.write("A,1,______,_,__;;;X;;;");
					outputInsert.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
	}

	private void open(MenuItem aboutItemMenu) {
		aboutItemMenu.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				try {
					new AboutWindow();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	private void verify() {
		cashRemovalET.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent arg0) {
				onlyDigits(arg0);
			}
		});
		cashIntroET.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent arg0) {
				onlyDigits(arg0);
			}
		});
		beadingET.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent arg0) {
				onlyDigits(arg0);
			}
		});
	}

	private void closeIt(Button closeButton) {
		closeButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				System.exit(1);
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
	}

	private void doIt(Button executeButton) {
		executeButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				try {
					beadingText = "";
					introText = "";
					removalText = "";
					reasonText = "";
					if ((cashIntroET.getText().isEmpty())
							&& (cashRemovalET.getText().isEmpty())) {
						beadingText = beadingET.getText();
					} else if (!cashIntroET.getText().isEmpty()) {
						introText = cashIntroET.getText();
						reasonText = reasonET.getText();
					} else if (!cashRemovalET.getText().isEmpty()) {
						removalText = cashRemovalET.getText();
						reasonText = reasonET.getText();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				// /////////////////// SELLTEXT //////////////////////////
				try {
					if (selltextCheckButton.getSelection() == true) {

						new SellText(shell, introText, reasonText, removalText,
								beadingText, path, extension);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				// /////////////////// FPRINT //////////////////////////
				try {
					if (fprintCheckButton.getSelection() == true) {
						new FPrint(shell, introText, reasonText, removalText,
								beadingText, path, extension);
						new FPrintRUN(path, extension);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
	}

	public void onlyDigits(VerifyEvent event) {
		// Assume we don't allow it
		event.doit = false;

		// Get the character typed
		char myChar = event.character;

		// Only allows digit, dot, backspace and delete
		if (Character.isDigit(myChar) || myChar == '.' || myChar == '\b'
				|| myChar == '\u007F')
			event.doit = true;
	}

	// public String setFileDir() {
	//
	// DirectoryDialog dialog = new DirectoryDialog(shell);
	// dialog.setFilterPath("c:\\"); // Windows specific
	// dialog.open();
	// dirText = dialog.getFilterPath().toString();
	// path = dirText;
	// return path;
	//
	// }

	// public void configSettings(String path, String ext) throws IOException {
	// File f = new File(p + "\\config.ini");
	// f.getParentFile().mkdirs();
	// BufferedWriter bw = new BufferedWriter(new FileWriter(f));
	// bw.write("Cash Operations SETTINGS\n" + "[path]=" + path.toString()
	// + '\\' + "\n" + "[extension]=" + ext.toString());
	// bw.close();
	// }

	// public void loadSettings() throws IOException {
	// File f = new File(p + "\\config.ini");
	// if (f.exists()) {
	// try (BufferedReader br = new BufferedReader(new FileReader(f))) {
	// String line;
	// while ((line = br.readLine()) != null) {
	// System.out.println(line.substring(7, 10));
	// }
	// }
	// BufferedReader br = null;
	// String currentLine;
	// String pathString = "";
	// String extString = "";
	// br = new BufferedReader(new FileReader(f));
	// while ((currentLine = br.readLine()) != null) {
	// pathString = (String) currentLine.subSequence(7, 8);
	// System.out.println(pathString);
	// // extString = currentLine.substring(12);
	//
	// }
	// try {
	// if (br != null)
	// br.close();
	// } catch (IOException ex) {
	// ex.printStackTrace();
	// }

	// } else
	// new ErrorMessageBox(shell,
	// "Fisierul nu exista ! Trebuie sa salvati configuratia curenta.");
	//
	// }

}