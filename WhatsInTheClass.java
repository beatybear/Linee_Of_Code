package beaty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class WhatsInTheClass {

	public static void main(String[] args) throws IOException {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".java") || f.isDirectory();
			}
			public String getDescription() {
				return "Java Files";
			}
		});

		int r = chooser.showOpenDialog(new JFrame());
		
		if (r == JFileChooser.APPROVE_OPTION) {
			Reader l = new FileReader(chooser.getSelectedFile());
			Scanner s = new Scanner(chooser.getSelectedFile());
			BufferedReader br = new BufferedReader(l);
			
			// Number of Lines
			LineCounter soc = new LineCounter();
			String name = chooser.getSelectedFile().getName();
			System.out.println("Number of lines (without comments) of " + name + " is " + soc.getNumberOfLines(br));
			
			// Number of Structures
			String w = "while";
			String f = "for";
			String i = "if";
			int wC = 0;
			int fC = 0;
			int iC = 0;
			while (s.hasNext()) {
				String word = s.next();
				if (word.equals(w)) {
					wC++;
				}
				if (word.equals(f)) {
					fC++;
				}
				if (word.equals(i)) {
					iC++;
				}

			}
			
			System.out.println("Number of if statements: " + iC);
			System.out.println("Number of while loops: " + wC);
			System.out.println("Number of for loops: " + fC);
		}
	}
}