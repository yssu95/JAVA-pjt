package game;

import java.util.Arrays;
import java.util.Scanner;

//송수욱

public class StoryController {
	Scanner sc = new Scanner(System.in);

	String[] sel = { "일찍 등원하기", "제시간에 등원하기", "지각", "결석", "병원가기" };
	String[] sel1 = { "초집중!", "졸음", "엎드려 자기", "딴짓하기", "수업 듣기" };
	String[] sel2 = { "술 마시기", "알바하기", "잠자기", "게임하기", "복습하기" };

	public void store(Data data) {
		System.out.println("====어서오세요 CU입니다====");
		System.out.println("뭘 살까?");
		System.out.println("○ 초코(1000원)\n○ 슬리퍼(4000원)\n○ 참고서(10000원)\n○ 커피(4000원)\n○ 노트북(백만원^^)");
		String a = sc.next();
		int sum = 0;

		for (int i = 0; i < data.item.length; i++)
			sum += data.item[i];
		if (sum >= 3) {
			System.out.println("가방이 꽉 찼다...");
			return;
		}
	
		switch (a) {
		case "초코":
			data.item[0] += 1;
			data.money -= 2000;
			break;
		case "슬리퍼":
			data.item[1] += 1;
			data.money -= 4000;
			break;
		case "참고서":
			data.item[2] += 1;
			data.money -= 10000;
			break;
		case "커피":
			data.item[3] += 1;
			data.money -= 4000;
			break;
		case "노트북":
			data.item[4] += 1;
			data.money -= 2000000;
			break;
			
		default:
			System.out.println("그런건 없다. 다시 고르자!");
			store(data);
			
		}
		
		System.out.println("감사합니다. 안녕히가세요!");
	}

	public void getMoney(Data data) {
		System.out.println();
		System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧");
		System.out.println("✧✦ 돈 10,000원을 주웠다!✧✦");
		System.out.println("✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧");
		System.out.println();
		data.money += 10000;
	}

	public void betting(Data data) {
		boolean isTrue = true;
		while (isTrue) {
			System.out.println("╔〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓╗");
			System.out.println(" 오늘 점심 내기하시죠? 아..뭐 설마 안하시는건아니죠?^^");
			
			int cNum = (int) (Math.random() * 3) + 1;
			System.out.print("  가위, 바위, 보 입력: ");
			String input = sc.next();
			int mNum = 0;
			if (input.equals("가위"))
				mNum = 1;
			else if (input.equals("바위"))
				mNum = 2;
			else if (input.equals("보"))
				mNum = 3;

			System.out.print("  상대방이 ");
			if (cNum == 1) {
				System.out.print("가위");
			} else if (cNum == 2) {
				System.out.print("바위");
			} else {
				System.out.print("보");
			}
			System.out.print("를 냈다.\t");
			System.out.print("나는 ");
			if (mNum == 1) {
				System.out.print("가위");
			} else if (mNum == 2) {
				System.out.print("바위");
			} else if (mNum == 3) {
				System.out.print("보");
			}
			System.out.println("를 냈다.");
			if (cNum == mNum) {
				System.out.println(" 비겼으니 다시! ");
				System.out.println("╚〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓╝");
				continue;
			} else if ((cNum == 1 && mNum == 2) || (cNum == 2 && mNum == 3) || (cNum == 3 && mNum == 1)) {
				System.out.println(" 맨밥만 먹어도 너무맛있어요 잘먹었습니다 ㅎㅎㅎㅎ");
				System.out.println("╚〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓╝");
				data.health++;
				isTrue = false;
			} else {
				System.out.println(" 오늘졌으니...앞으로 4번만 안걸리면 본전이다...");
				System.out.println("╚〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓═〓╝");
				data.health--;
				data.money -= 10000;
				isTrue = false;
			}
		}
	}

	public void morning(int i, Data data) {
		switch (i) {
		case 0:
			System.out.println("======    예습을 하셨습니다.   ======");
			System.out.println("일찍 와서 공부하는 맛이있어 역시 ( ͡❛ ͜ʖ ͡❛)");
			System.out.println("===============================");
			data.health--;
			data.skill++;
			break;
		case 1:
			System.out.println("====== 정상 등원을 하셨습니다. ======");
			System.out.println("늦지않게 도착해서 다행이다 ( ͡◕ ͜ʖ ͡◕)");
			System.out.println("============================");
			data.skill++;
			break;
		case 2:
			System.out.println("========   지각을 하셨습니다.    ========");
			System.out.println("안그래도 늦었는데.. 지각비까지 내야되네  (ꐦ ◣‸◢)");
			System.out.println("=====================================");
			data.health++;
			data.skill--;
			data.money -= 5000;
			break;
		case 3:
			System.out.println("==========   결석을 하셨습니다.  ==========");
			System.out.println("오늘은 너무피곤해서..하루만쉬자 ¯\\_( ͡° ͜ʖ ͡°)_/¯");
			System.out.println("=======================================");
			data.skill -= 3;
			data.health++;
			data.money -= 25000;
			break;
		case 4:
			System.out.println("======  병원에 도착했습니다. ======");
			System.out.println("아..오늘은 몸이 왜이렇지..병원가자  ಢ‸ಢ ");
			System.out.println("==============================");
			data.skill--;
			break;
		}
	}

	public void bitcamp(int i, Data data) {
		switch (i) {
		case 0:
			System.out.println("=====초집중 상태로 공부합니다!=====");
			System.out.println("완전 집중했더니 너무힘들다ㅜㅜ༼◉_◉ ༽ ");
			System.out.println("============================");
			data.health -= 2;
			data.skill += 3;
			break;
		case 1:
			System.out.println("========  잠시 졸았습니다.  =========");
			System.out.println("뭐지..?어디배우고 있는거지??  〣(ºΔº)〣");
			System.out.println("=================================");
			data.health++;
			data.skill--;
			break;
		case 2:
			System.out.println("=========학원 와서 잠을 잡니다.=========");
			System.out.println("오늘 와서 잠잔기억밖에 없네.. _( :⁍ 」 )_");
			System.out.println("=================================");
			data.health += 2;
			data.skill -= 2;
			break;
		case 3:
			System.out.println("========다른것에 호기심을 느꼈습니다.==========");
			System.out.println("어??인터넷에 재밌는게있네! 잠깐만봐볼까 ( ͡> ‿‿ ͡<)");
			System.out.println("=======================================");
			data.skill -= 2;
			break;
		case 4:
			System.out.println("=======진도만 따라가자..!=========");
			System.out.println("열심히 수업 들어야지! (っ ͡◔ ͜ʖ ͡◔)っ");
			System.out.println("==============================");
			data.health--;
			data.skill++;
			break;
		}
	}

	public void night(int i, Data data) {
		switch (i) {
		case 0:
			System.out.println("=============  술을  먹으러갑니다. =============");
			System.out.println("오늘은 고생했으니까 ㅎㅎ한잔정도는 상으로주자 ლ(´ ❥ `ლ)");
			System.out.println("===========================================");
			data.money -= 50000;
			data.health -= 3;
			data.skill -= 3;
			break;
		case 1:
			System.out.println("==========끝나고 일을 하러갑니다.===========");
			System.out.println("공부..알바..공부..알바.. 힘들다 진짜(c\"ತ,_ತ)");
			System.out.println("======================================");
			data.money += 50000;
			data.health -= 2;
			break;
		case 2:
			System.out.println("====== 잠을 잡니다. ======");
			System.out.println("씻고 푹 자야겠다! (¦3ꇤ[▓▓▓]");
			System.out.println("=======================");
			data.health++;
			data.skill++;
			break;
		case 3:
			System.out.println("=======  게임을 선택하였습니다.  =======");
			System.out.println("진짜 딱 한판만 더하고자자.. (っ ͡◭ ‿‿ ͡◭)っ");
			System.out.println("==================================");
			data.health--;
			data.skill--;
			break;
		case 4:
			System.out.println("=========집에 도착해서 복습을 합니다.============");
			System.out.println("아 아까 말씀하신게 이거구나?? 하길잘했다! (ง ͠° ͟ل͜ ͡°)ง");
			System.out.println("=========================================");
			data.health--;
			data.skill += 2;
			break;
			
		}
	}
}
