package game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Scanner;

//문창훈 
public class Menu {
	Scanner sc = new Scanner(System.in);
	Data data;
	Data[] save = new Data[5];
	StoryView sv = new StoryView();

	public Menu() {
		sv.setMenuRef(this);
	}

	public void mainMenu() throws IOException {
		int[]item = {0,0,0,0,0}; // 아이템창 선언
		
		System.out.println();
		System.out.println("┌────────────────────┐");
		System.out.println("│      MAIN MENU     │");
		System.out.println("│          -         │");
		System.out.println("│      1. Start      │");
		System.out.println("│      2. Load       │");
		System.out.println("│      3. Exit       │");
		System.out.println("└────────────────────┘");
		System.out.print("SELECT NUMBER >> ");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			System.out.print("\n== 게임을 시작합니다! ==\n내 이름 : ");
			String name = sc.next();
			sv.loop(new Data(name, 30, 400000, 0, 1, 3,item));
			break;
		case 2:
			Data load = load();
			switch (load.when) {
			case 1:
				sv.bitcamp(load);
				sv.night(load);
				sv.loop(load);
				break;
			case 2:
				sv.night(load);
				sv.loop(load);
				break;
			case 3:
				sv.loop(load);
				break;
			}
			break;
		case 3:
			System.out.print("Sure? (Y/N) ");
			String yn = sc.next();
			if (yn.contentEquals("Y")) {
				OutputStream os = new FileOutputStream("bitgame.ser");  //1: 스트림 오픈
				ObjectOutputStream out = new ObjectOutputStream(os);
				out.writeObject(save[0]);
				out.writeObject(save[1]);
				out.writeObject(save[2]);
				out.writeObject(save[3]);
				out.writeObject(save[4]);
				out.close();
				System.exit(0);
				}
			else
				
				mainMenu();
			
		default:
			System.out.println("Try again");
			mainMenu();
		}
	}

	public void middleMenu(Data data) throws IOException {
		System.out.println();
		System.out.println("---MENU---");
		System.out.println("1. 상태 확인");
		System.out.println("2. Save");
		System.out.println("3. Main Menu");
		System.out.println("4. 템 사용하기");
		System.out.print("Select>> ");
		int select = sc.nextInt();

		switch (select) {
		case 1: 
			System.out.println();
			System.out.println("----상태----");
			System.out.println("체력: "+data.health);
			System.out.println("돈: "+data.money);
			System.out.println("------------");
			System.out.print("게임 진행(1->Enter)");
			int i = sc.nextInt();
			switch (data.when) {
			case 1:
				sv.bitcamp(data);
				sv.night(data);
				sv.loop(data);
				break;
			case 2:
				sv.night(data);
				sv.loop(data);
				break;
			case 3:
				sv.loop(data);
				break;
			}
			break;
		case 2:
			save(data);
			mainMenu();
			break;
		case 3:
			mainMenu();
			break;
		case 4:
			sv.remove(data);
			middleMenu(data);
			break;
		default:
			System.out.println("Try again");
			middleMenu(data);
		}

	}

	public void save(Data save) {
		System.out.println();
		System.out.println(this.save[0] == null ? "1. " : "1. " + this.save[0].name);
		System.out.println(this.save[1] == null ? "2. " : "2. " + this.save[1].name);
		System.out.println(this.save[2] == null ? "3. " : "3. " + this.save[2].name);
		System.out.println(this.save[3] == null ? "4. " : "4. " + this.save[3].name);
		System.out.println(this.save[4] == null ? "5. " : "5. " + this.save[4].name);
		System.out.print("Select Slot>> ");
		int i = sc.nextInt();
		this.save[i - 1] = save;
	}

	public Data load() {
		System.out.println();
		System.out.println(this.save[0] == null ? "1. " : "1. " + this.save[0].name);
		System.out.println(this.save[1] == null ? "2. " : "2. " + this.save[1].name);
		System.out.println(this.save[2] == null ? "3. " : "3. " + this.save[2].name);
		System.out.println(this.save[3] == null ? "4. " : "4. " + this.save[3].name);
		System.out.println(this.save[4] == null ? "5. " : "5. " + this.save[4].name);
		System.out.print("Select Slot>> ");
		int i = sc.nextInt();
		while (save[i - 1] == null) {
			System.out.println("저장된 파일이 없습니다");
			System.out.print("Select Slot>> ");
			i = sc.nextInt();
		}
		return save[i - 1];
	}

}