package POJO;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class ErrorMessageBox {

	public ErrorMessageBox(Shell shell, String err) {
		int style = SWT.ERROR;
		MessageBox messageBox = new MessageBox(shell, style);
		messageBox.setMessage(err);
		messageBox.setText("Eroare");
		int rc = messageBox.open();
		switch (rc) {
		case SWT.YES:
			System.out.println("OK");
			break;
		}
	}
}