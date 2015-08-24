import java.io.IOException;

public class FPrintRUN implements Runnable {

	public FPrintRUN(String path, String extension) {
		Runtime rt = Runtime.getRuntime();
		String[] cmd = {
				"C:\\Program Files\\Datecs Applications\\FPrintWIN" + "\\FPrint.exe",
				"C:\\Program Files\\Datecs Applications\\FPrintWIN" + "\\cf" + extension};
		try {
			rt.exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
