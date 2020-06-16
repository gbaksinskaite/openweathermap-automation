package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

	public static void writeApiKeyToFile(String filePath, String apiKey) throws IOException {

		File file = new File(filePath);
		if(!file.exists()) {
			file.createNewFile(); 
		}
		
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(apiKey);
		fileWriter.close();
	}

	public static String readApiKeyFromFile(String filePath) {
		
		String apiKey = null;
		
		File file = new File(filePath);

		try (FileReader fileReader = new FileReader(file)) {
			char[] chars = new char[(int) file.length()];
			fileReader.read(chars);
			apiKey = new String(chars);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return apiKey;
	}
}
