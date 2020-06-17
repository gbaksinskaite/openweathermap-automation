package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class OpenReport {

	public static void main(String[] args) throws IOException {
        File htmlFile = new File("target/surefire-reports/emailable-report.html");
        Desktop.getDesktop().browse(htmlFile.toURI());
        OpenReport.class.getProtectionDomain().getCodeSource().getLocation();
    }
}
