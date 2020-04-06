package game;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
//강다원
public class StoryView {
	Scanner sc = new Scanner(System.in);
	Data data;
	Menu menu;
	StoryController con = new StoryController();
	Random rd = new Random();
	int a, b, c, d, e; // 난수 발생용

	public void setMenuRef(Menu menu) {
		this.menu = menu;
	}

	public void remove(Data data) {
		int sum = 0;
		for (int i = 0; i < data.item.length; i++) {
			sum += data.item[i];
		}
		if (sum == 0) {
			System.out.println("너 템 없는데?");
			return; // 메서드 끝낼때
		}
		System.out.println("뭐사용할거?");
		String[] tem = { "초코", "슬리퍼", "가방", "커피", "노트북" };
		for (int i = 0; i < data.item.length; i++) {
			if (data.item[i] >= 1)
				System.out.println(tem[i] + " 갯수 " + data.item[i] + "개");
		}
		String answer = sc.next();
		switch (answer) {
		case "초코":
			data.item[0]--;
			data.health++;
			System.out.println("== 초코를 사용했습니다 ==");
			System.out.println(" 달달하니 기분이 좋은데? ");
			break;
		case "슬리퍼":
			data.item[1]--;
			data.health+=2;
			System.out.println("=== 슬리퍼를 사용했습니다 ===");
			System.out.println(" 역시 사람은 발이편해야지 !!");
			break;
		case "참고서":
			data.item[2]--;
			data.skill+=3;
			System.out.println("===== 참고서를 사용하였습니다 =====");
			System.out.println(" 이래서  책이랑 같이하는거구나? ");
			break;
		case "커피":
			data.item[3]--;
			data.skill++;
			data.health--;
			System.out.println("====== 커피를 사용하였습니다 ======");
			System.out.println(" 아 요즘은 진짜 커피없으면 못살겠어 ㅠㅠ ");
			break;
		case "노트북":
			data.item[4]--;
			data.skill+=5;
			System.out.println("===== 노트북을 사용하였습니다 =====");
			System.out.println("이제부터 여기서 들고다니면서 저장해야지!");
			break;
		}

	}

	public Data morning(Data data) throws IOException {
		System.out.println();
		System.out.println("§§ "+ data.day + "일차 " + "아침이 밝았습니다 §§");
		a = rd.nextInt(5);
		b = rd.nextInt(5);
		c = rd.nextInt(5);
		d = rd.nextInt(10);
		e = rd.nextInt(4);

		if (d == 0)
			con.getMoney(data);

		if (e == 0) {
			System.out.println("편의점 들를까? (y/n)");
			String ny = sc.next();
			if (ny.equals("y"))
				con.store(data);
			else if(ny.equals("n"))
				System.out.println("돈없으니까 그냥 가자...");
			else
				System.out.println("y/n중에 하나를 입력하세요");
		}

		while (a == b || b == c || a == c) {
			b = rd.nextInt(5);
			c = rd.nextInt(5);
		}
		System.out.println("───────────────────");
		System.out.println(" Menu→ 0번을 선택하세요.");
		System.out.println(" ①." + con.sel[a]);
		System.out.println(" ②." + con.sel[b]);
		System.out.println(" ③." + con.sel[c]);
		System.out.println("───────────────────");
		
		boolean isTrue = true;
		while(isTrue) {
		System.out.print("Chose: ");
		int i = sc.nextInt();
		switch (i) {
		case 0:
			menu.middleMenu(data);
		case 1:
			con.morning(a, data);
			b = a;
			c = a;
			isTrue = false;
			break;
		case 2:
			con.morning(b, data);
			a = b;
			c = b;
			isTrue = false;
			break;
		case 3:
			con.morning(c, data);
			a = c;
			b = c;
			isTrue = false;
			break;
		default:
			System.out.println("1~3번 중에 골라주세요.");
			break;
		}
		}
		if (a == 3 || a == 4)
			data.when = 2;
		else
			data.when = 1;
		return data;
	}

	public Data bitcamp(Data data) throws IOException {
		System.out.println();
		System.out.println("(" + data.day + "일차) " + "학원 수업시간입니다.");

		a = rd.nextInt(5);
		b = rd.nextInt(5);
		c = rd.nextInt(5);
		d = rd.nextInt(3);

		if (d == 0)
			con.betting(data);

		while (a == b || b == c || a == c) {
			b = rd.nextInt(5);
			c = rd.nextInt(5);
		}

		System.out.println("───────────────────");
		System.out.println(" Menu→ 0번을 선택하세요.");
		System.out.println(" ①." + con.sel1[a]);
		System.out.println(" ②." + con.sel1[b]);
		System.out.println(" ③." + con.sel1[c]);
		System.out.println("───────────────────");
		
		boolean isTrue = true;
		while(isTrue) {
		System.out.print("Chose: ");
		int i = sc.nextInt();
		switch (i) {
		case 0:
			menu.middleMenu(data);
		case 1:
			con.bitcamp(a, data);
			isTrue = false;
			break;
		case 2:
			con.bitcamp(b, data);
			isTrue = false;
			break;
		case 3:
			con.bitcamp(c, data);
			isTrue = false;
			break;
		default :
			System.out.println("1~3번 중에 골라주세요.");
			break;
		}
		
	}
		data.when = 2;
		return data;
	}

	public Data night(Data data) throws IOException {
		System.out.println();
		System.out.println("(" + data.day + "일차) " + "저녁이 되었습니다.");

		a = rd.nextInt(5);
		b = rd.nextInt(5);
		c = rd.nextInt(5);

		while (a == b || b == c || a == c) {
			b = rd.nextInt(5);
			c = rd.nextInt(5);
		}
		System.out.println("───────────────────");
		System.out.println(" Menu→ 0번을 선택하세요.");
		System.out.println(" ①." + con.sel2[a]);
		System.out.println(" ②." + con.sel2[b]);
		System.out.println(" ③." + con.sel2[c]);
		System.out.println("───────────────────");
		
		boolean isTrue = true;
		while(isTrue) {
		System.out.print("Chose: ");
		int i = sc.nextInt();
		switch (i) {
		case 0:
			menu.middleMenu(data);
		case 1:
			con.night(a, data);
			isTrue = false;
			break;
		case 2:
			con.night(b, data);
			isTrue = false;
			break;
		case 3:
			con.night(c, data);
			isTrue = false;
			break;
		default:
			System.out.println("1~3번 중에 골라주세요.");
			break;
		}
		}
		data.when = 3;
		data.day++;

		if (data.day % 7 == 0)
			weekend(data);
		if (data.day == 22) { // 테스트용으로 엔딩일수 조절했음★
			ending(data);
			menu.mainMenu();
		}
		
		return data;
	}

	public void loop(Data data) throws IOException {
		while (true) {
			morning(data);
			if (a == 3 || a == 4)
				night(data);
			else {
				bitcamp(data);
				night(data);
			}
			System.out.println("Zzzz....");

		}
	}

	public void weekend(Data data) throws IOException {
		System.out.println("\n주말이 되었습니다.");
		System.out.printf("<<이번 주의 결과>>\n 체력: %d\t 남은 돈: %d\t 실력: %d\n", data.health, data.money, data.skill);
		if (data.health <= 0 || data.money <= 0) {
			System.out.println("☠☠...당신은 사망하셨습니다...☠☠");
			System.out.println("█▀▀ ▄▀█ █▀▄▀█ █▀▀   █▀█ █░█ █▀▀ █▀█");
			System.out.println("█▄█ █▀█ █░▀░█ ██▄   █▄█ ▀▄▀ ██▄ █▀▄");
			menu.mainMenu();
		}
		con.store(data);
		System.out.println("\n주말인데 뭐할까?");
		System.out.println("1. 자습\n2. 휴식");
		System.out.print("선택: ");
		int a = sc.nextInt();
		if (a == 1) {
			System.out.println("열심히해서 꼭 좋은데 취직해야지 !!");
			data.skill += 2;
		} else {
			System.out.println("오늘은 쉴수도 있지...하루만 쉬자");
			data.health += 2;
		}
		data.day++;

	}

	public void ending(Data data) {
		System.out.println("=====================");
		System.out.println(data.name + "의 점수 :" + data.skill);
		System.out.println("====================");
		if (data.skill > 1000) {
			System.out.println("*:･｡,☆ﾟ’･:*:･｡･:*:･ﾟ’☆,｡･:*");
			System.out.println("★ ~     대기업 취직        ~ ★");
			System.out.println("*:･｡,☆ﾟ’･:*:･｡･:*:･ﾟ’☆,｡･:*");

		} else if (data.skill > 250) {
			System.out.println("==== 중소기업 취직 ====");
			System.out.println("┌──────────────────┐");
			System.out.println("│조금만더 열심히할걸... │");
			System.out.println("└──────────────────┘");
		} else {
			System.out.println("☠☠아무곳에서도 받아주지 않습니다....☠☠");
			System.out.println("█▀▀ ▄▀█ █▀▄▀█ █▀▀   █▀█ █░█ █▀▀ █▀█");
			System.out.println("█▄█ █▀█ █░▀░█ ██▄   █▄█ ▀▄▀ ██▄ █▀▄");
		}
	}
} 