# CarbonEdit

## Synopsis
This project is a text editor application similar to Notepad. I will be adding many new features in the future as the project is still a work in progress.

## Motivation
I decided to build this application because I found that many text editors were not as useful to me as they could have been. For example, notepad lacks several text manipulation features, including several
text manipulation features like settings for italic text, bold text, changing fonts, and more. Additionally, applications like Microsoft Word do not offer an good experience for developers. I hope to
create an application that is both useful for developers and regular users. I will implement these features in the future.

## How to Run
- Recomended Java Version: Java 8
<ol>
  <li>Download on Github page or clone with Git/Github Client</li>
  <li>Execute the Editor class as the main class or execute Editor.java</li>
</ol>

[This is what the output will look like](https://github.com/TweakyTurnip875/CarbonEdit/assets/44481502/3ad4f3b4-c63b-437d-bed0-7ca093c2a444)

## Code Example
The following code snippet is called when the user clicks the open option in the file dropdown menu. This piece of code illustrates the fundamentals for the other features in the file dropdown (e.g. save, save as, new).
```
	public void open(JTextArea textArea) {
		JFileChooser fileChooser = new JFileChooser("f:");
		
		int option = fileChooser.showOpenDialog(null); // Display the open menu.
		
		if(option == JFileChooser.APPROVE_OPTION) { // If/when the user selects a file to open.
			currentFile = fileChooser.getSelectedFile();
			Path filePath = Paths.get(currentFile.getAbsolutePath());
			
			String content = ""; // Variable for storing the data of the selected file.
			try {
				List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8); // Read all lines of the selected file and store them in a list variable.
				
				for(String line : lines) { // Parse through each line (the list) and add each line to the content vaiable.
					content += (line + "\n");
				}
				
				textArea.setText(content); // Set the contents of the text area to the data in the content variable.
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
```
