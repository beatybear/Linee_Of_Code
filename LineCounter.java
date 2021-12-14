package beaty;

import java.io.BufferedReader;
import java.io.IOException;

public class LineCounter {
	public static int getNumberOfLines(BufferedReader bReader) throws IOException {
		int count = 0;
		boolean isComment = false;
		String line = null;

		while ((line = bReader.readLine()) != null) {
			line = line.trim();
			if ("".equals(line) || line.startsWith("//")) {
				continue;
			}
			if (isComment) {
				if (commentEnded(line)) {
					line = line.substring(line.indexOf("*/") + 2).trim();
					isComment = false;
					if ("".equals(line) || line.startsWith("//")) {
						continue;
					}
				} else
					continue;
			}
			if (isLine(line)) {
				count++;
			}
			if (isComment(line)) {
				isComment = true;
			}
		}
		return count;
	}

	//This method checks if in the given line a comment has begun and has not ended

	private static boolean isComment(String line) {
		int index = line.indexOf("/*");
		if (index < 0) {
			return false;
		}
		int quoteStartIndex = line.indexOf("\"");
		if (quoteStartIndex != -1 && quoteStartIndex < index) {
			while (quoteStartIndex > -1) {
				line = line.substring(quoteStartIndex + 1);
				int quoteEndIndex = line.indexOf("\"");
				line = line.substring(quoteEndIndex + 1);
				quoteStartIndex = line.indexOf("\"");
			}
			return isComment(line);
		}
		return !commentEnded(line.substring(index + 2));
	}

//This method checks if in the given line a comment has ended and no new comment has not begun

	private static boolean commentEnded(String line) {
		// If line = */ /* , this method will return false
		// If line = */ /* */, this method will return true
		int index = line.indexOf("*/");
		if (index < 0) {
			return false;
		} else {
			String subString = line.substring(index + 2).trim();
			if ("".equals(subString) || subString.startsWith("//")) {
				return true;
			}
			if (isComment(subString)) {
				return false;
			} else {
				return true;
			}
		}
	}

	private static boolean isLine(String line) {
		boolean isLine = false;
		line = line.trim();
		if ("".equals(line) || line.startsWith("//")) {
			return isLine;
		}
		if (line.length() == 1) {
			return true;
		}
		int index = line.indexOf("/*");
		if (index != 0) {
			return true;
		} else {
			while (line.length() > 0) {
				line = line.substring(index + 2);
				int endCommentPosition = line.indexOf("*/");
				if (endCommentPosition < 0) {
					return false;
				}
				if (endCommentPosition == line.length() - 2) {
					return false;
				} else {
					String subString = line.substring(endCommentPosition + 2).trim();
					if ("".equals(subString) || subString.indexOf("//") == 0) {
						return false;
					} else {
						if (subString.startsWith("/*")) {
							line = subString;
							continue;
						}
						return true;
					}
				}

			}
		}
		return isLine;
	}
}