import java.awt.*;
import java.awt.event.*;
import java.io.*;

@SuppressWarnings("serial")
public class Exercise15_9 extends Frame{
	String fileName;
	TextArea content;
	MenuBar mb;
	Menu mFile;
	MenuItem miNew, miOpen, miSaveAs, miExit;
	
	Exercise15_9(String title){
		super(title);
		content = new TextArea();
		add(content);
		
		mb = new MenuBar();
		mFile = new Menu("File");
		
		miNew = new MenuItem("New");
		miOpen = new MenuItem("Open");
		miSaveAs = new MenuItem("Save As...");
		miExit = new MenuItem("Exit");
		
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSaveAs);
		mFile.addSeparator();
		mFile.add(miExit);
		
		mb.add(mFile);
		setMenuBar(mb);
		
		MyHandler handler = new MyHandler();
		miNew.addActionListener(handler);
		miOpen.addActionListener(handler);
		miSaveAs.addActionListener(handler);
		miExit.addActionListener(handler);
		
		setSize(300, 200);
		setVisible(true);
	}
	
	void fileOpen(String fileName) {
		String separator = System.getProperty("line.separator");
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName));
			StringWriter sw = new StringWriter()){
			
			String line = "";
			
			while((line = br.readLine())!=null) {
				sw.write(line);
				sw.write(separator);
			}
			
			content.append(sw.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	void saveAs(String fileName) {
		File f = new File(fileName);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
			
			if(!f.exists()) f.createNewFile();
			String line = content.getText();
			
			bw.write(line);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Exercise15_9 mainWin = new Exercise15_9("Text Editor");

	}

	class MyHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			String command = ae.getActionCommand();
			
			if(command.equals("New")) {
				content.setText("");
			} else if(command.equals("Open")) {
				FileDialog fileOpen = new FileDialog(Exercise15_9.this, "파일 열기");
				fileOpen.setVisible(true);
				fileName = fileOpen.getDirectory()+fileOpen.getFile();
				System.out.println(fileName);
				fileOpen(fileName);
			} else if(command.equals("Save As...")) {
				FileDialog fileSave = new FileDialog(Exercise15_9.this, "파일 저장", FileDialog.SAVE);
				fileSave.setVisible(true);
				fileName = fileSave.getDirectory()+fileSave.getFile();
				System.out.println(fileName);
				saveAs(fileName);
			} else if(command.equals("Exit")) {
				System.exit(0);
			}
			
		}
		
	}
}
