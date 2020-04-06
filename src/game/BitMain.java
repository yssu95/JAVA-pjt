package game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

// 박수정

public class BitMain {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Menu menu = new Menu();
//		OutputStream os = new FileOutputStream("bitgame.ser");  //1: 스트림 오픈
//		ObjectOutputStream out = new ObjectOutputStream(os);
//		out.writeObject(menu.save[0]);
//		out.writeObject(menu.save[1]);
//		out.writeObject(menu.save[2]);
//		out.writeObject(menu.save[3]);
//		out.writeObject(menu.save[4]);
//		out.close();
		
		StoryView sv = new StoryView();
		InputStream is = new FileInputStream("bitgame.ser");
		ObjectInputStream in = new ObjectInputStream(is);
		menu.save[0] = (Data)in.readObject();
		menu.save[1] = (Data)in.readObject();
		menu.save[2] = (Data)in.readObject();
		menu.save[3] = (Data)in.readObject();
		menu.save[4] = (Data)in.readObject();
		
		in.close();

		menu.mainMenu();
		
	}
}
