package idham_CRUD_UAS;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Random rand = new Random();
	Vector<Member> vecMember = new Vector<Member>();
	Scanner scan = new Scanner(System.in);

	int menu, level;
	String username, id, role;

	Member mem;

	public Main() {
		do {
			System.out.println("1. Add New Member");
			System.out.println("2. Remove Member");
			System.out.println("3. Edit Member");
			System.out.println("4. View Squad Member");
			System.out.println("5. exit");
			System.out.println("Choose >> ");
			menu = scan.nextInt();
			scan.nextLine();
			if (menu == 1) {
				do {
					System.out.print("Insert Member Username [3-20 characters]: ");
					username = scan.nextLine();
				} while (username.length() < 3 || username.length() > 20);

				do {
					System.out.print("Insert Member Role [Member|Elder|CoLeader]: ");
					role = scan.nextLine();
				} while (!role.equals("Member") && !role.equals("Elder") && !role.equals("CoLeader")
						&& !role.equals("member") && !role.equals("elder") && !role.equals("coleader")
						&& !role.equals("m") && !role.equals("e") && !role.equals("c"));

				do {
					System.out.print("Input Member Levels [10-60]: ");
					level = scan.nextInt();
					scan.nextLine();
				} while (level < 10 || level > 60);

				id = "" + Math.abs(rand.nextInt() % 10) + Math.abs(rand.nextInt() % 10) + Math.abs(rand.nextInt() % 10);

				String newRole = "";
				if (role.equals("Member") || role.equals("member") || role.equals("m")) {
					newRole = "Member";
				}
				if (role.equals("Elder") || role.equals("elder") || role.equals("e")) {
					newRole = "Elder";
				}
				if (role.equals("CoLeader") || role.equals("coleader") || role.equals("c")) {
					newRole = "CoLeader";
				}

				mem = new Member(username, level, id, newRole);
				vecMember.add(mem);
			} else if (menu == 2) {

				if (vecMember.size() == 0) {
					System.out.println("No Member");
					System.out.println("Press Enter to Continue");
					scan.nextLine();
				} else {
					showData();
					int index = 0, flag = 0;
					System.out.println("Insert Member Id to Remove : ");
					id = scan.nextLine();
					for (Member ber : vecMember) {
						if (ber.getId().equals(id)) {
							flag = 1;
							vecMember.remove(index);
							break;
						}
						index++;
					}
					if (flag == 0) {
						System.out.println("Member Not Found");
						System.out.println("Press Enter to Continue");
						scan.nextLine();
					}
				}

			} else if (menu == 3) {
				if (vecMember.size() == 0) {
					System.out.println("No Member");
					System.out.println("Press Enter to Continue");
					scan.nextLine();
				} else {
					System.out.println("");
					showData();
					System.out.println("");

					int index = 0, flag = 0;
					System.out.println("Insert Member Id to Edit : ");
					id = scan.nextLine();

					for (Member ber : vecMember) {
						if (ber.getId().equals(id)) {
							flag = 1;
							if (index == 0) {
								System.out.println("1st Member");
							} else if (index == 1) {
								System.out.println("2nd Member");
							} else if (index == 2) {
								System.out.println("3rd Member");
							} else {
								System.out.println(String.valueOf(index + 1) + "th Member");
							}

							do {
								System.out.print("Insert Member Username [3-20 characters]: ");
								username = scan.nextLine();
							} while (username.length() < 3 || username.length() > 20);

							do {
								System.out.print("Insert Member Role [Member|Elder|CoLeader]: ");
								role = scan.nextLine();
							} while (!role.equals("Member") && !role.equals("Elder") && !role.equals("CoLeader")
									&& !role.equals("member") && !role.equals("elder") && !role.equals("coleader")
									&& !role.equals("m") && !role.equals("e") && !role.equals("c"));

							do {
								System.out.print("Input Member Levels [10-60]: ");
								level = scan.nextInt();
								scan.nextLine();
							} while (level < 10 || level > 60);

							String newRole = "";
							if (role.equals("Member") || role.equals("member") || role.equals("m")) {
								newRole = "Member";
							}
							if (role.equals("Elder") || role.equals("elder") || role.equals("e")) {
								newRole = "Elder";
							}
							if (role.equals("CoLeader") || role.equals("coleader") || role.equals("c")) {
								newRole = "CoLeader";
							}

							Member newMember = new Member(username, level, ber.getId().toString(), newRole);
							vecMember.set(index, newMember);
						}
						index++;
					}
					if (flag == 0) {
						System.out.println("Member Not Found");
						System.out.println("Press Enter to Continue");
						scan.nextLine();
					}
				}

			} else if (menu == 4) {
				if (vecMember.size() == 0) {
					System.out.println("No Member");
					System.out.println("Press Enter to Continue");
					scan.nextLine();
				} else {
					showData();
				}
			}
		} while (menu != 5);
	}

	private void showData() {
		System.out.println("Member List");
		for (Member ber : vecMember) {
			System.out.println(ber.getId() + " " + ber.getUsername() + " " + ber.getRole() + " " + ber.getLevel());
		}
	}

	public static void main(String[] args) {
		new Main();

	}

}
