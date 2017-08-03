import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class Mainparser {
	
	public static void main(String[] args) throws IOException{
	        
		   /* Copy file path to String BELOW */
		   String filepath="";
		   
	       Parser pdfManager = new Parser();
	       pdfManager.setFilePath(filepath);
		   //Prints Text on Console
	       System.out.println(pdfManager.ToText());       
	     
		   // Prinwriter to write text to text File
		   // Set 'savefileas' the name of text file you want to save as with .txt extension
		   String savefileas ="output.txt";
	       PrintWriter out = new PrintWriter(savefileas);
	       out.println(pdfManager.ToText());
	       out.close();
	    
	}    
	
	
public class Parser {
	private PDFParser parser;
	   private PDFTextStripper stripper;
	   private PDDocument pdDoc ;
	   private COSDocument cosDoc ;
	   
	   private String Text ; // Store text converted from pdf to text
	   private String filePath; // Stores File Path
	   private File filename; // Stores File Name

	    public Parser() {
	        
	    }
	   public String ToText() throws IOException
	   {
	       this.stripper = null;
	       this.pdDoc = null;
	       this.cosDoc = null;
	       file = new File(filePath);
	       parser = new PDFParser(new RandomAccessFile(filename,"r")); // Parser to readfile
	       parser.parse();
	       cosDoc = parser.getDocument();
	       stripper = new PDFTextStripper();
	       pdDoc = new PDDocument(cosDoc);
	       pdDoc.getNumberOfPages();
	       stripper.setStartPage(1); // starting Page from where PDF file will be parsed.
	       stripper.setEndPage(pdDoc.getNumberOfPages()); // End Page to which PDF file will be parsed.
	       Text = stripper.getText(pdDoc); // Storing text to TEXT variable
	       return Text; // returnes Text to MAIN()
	   }

	    public void setFilePath(String filePath) {
	        this.filePath = filePath;
	    }
}

}
