
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CsvToJsonConverter {

	String inputFile;
	String outputFile;

	/**
	 * 
	 * 
	 * @param inputFilePath
	 * @param outputFilePath
	 * @throws IOException
	 */
	public CsvToJsonConverter(String inputFilePath, String outputFilePath) throws IOException {
		
		if(inputFilePath!=null && outputFilePath!=null && inputFilePath!="" && outputFilePath!="")
		{	this.inputFile = inputFilePath;
			this.outputFile = outputFilePath; 
		}
		else
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter input text file path");
			this.inputFile = br.readLine();
			System.out.println("Enter output Json file path");
			this.outputFile =   br.readLine();
		}
	}
	/**
	 * Function "convert" converts input text (from file) into json and writes to a Json output file
	 * 
	 * @throws IOException
	 */
	public void convert() throws IOException {
			int rowValCount,rowCount=0;
			FileWriter writer = new FileWriter(outputFile);
			BufferedReader breader = new BufferedReader(new FileReader(inputFile));
			writer.write("\"JSON\": [");
			String keys[] = breader.readLine().split(",");
			String frow,row[];
			while((frow = breader.readLine())!=null)
			{
				if(rowCount++ == 0)
					writer.write("\n{");
				else
					writer.write(",\n{");
				row = frow.split(",");
				rowValCount = 0;
				for(String key:keys)
				{
					if(rowValCount == 0)
						writer.write("\n\""+key+"\":"+"\""+row[rowValCount++]+"\"");
					else
						writer.write(",\n\""+key+"\":"+"\""+row[rowValCount++]+"\"");
				}
				writer.write("\n}");
			}
			writer.write("\n]");
			writer.close();
			breader.close();
	}

	/**
	 * @param args
	 * 
	 * 
	 * Use Main for Test
	 * args 0 = input text file
	 * args 1 = output json file
	 */
	public static void main(String[] args) throws IOException {
		CsvToJsonConverter convertObject = new CsvToJsonConverter(args[0],args[1]);
		}

}
