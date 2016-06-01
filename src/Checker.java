import java.util.Arrays;

public class Checker {
	int rank1, rank2;
	int[] temp = new int[5];
	int[] temp2 = new int[5];
	boolean ss1 = false, ss2 = false;
	boolean or1 = true, or2 = true;
	String first = "", second = "";

	public Checker(String[] names, int[] hand1, int[] hand2) {
		rank1 = 0; 
		rank2 = 0; 
		int h1[] = hand1;
		int h2[] = hand2;
		String[] n = names;
		checkSuit(n);
		straightFlush(h1, h2);
		h1 = hand1;
		h2 = hand2;
		sameFour(h1, h2);
		tieBreaker(h1, h2);  
	}
	
	public String getHandNames1 (){
		String handName = "";
		
		if (rank1 == 10){
			handName = "Royal Flush";
		}
		else if (rank1 == 9){
			handName = "Straight Flush"; 
		}
		else if (rank1 == 8){
			handName = "Four of A kind";
		}
		else if (rank1 == 7){
			handName = "Full house";
		}
		else if (rank1 == 6){
			handName = "Flush";
		}
		else if (rank1 == 5){
			handName = "Straight"; 
		}
		else if (rank1 == 4){
			handName = "Straight";
		}
		else if (rank1 == 3){
			handName = "Two of a kind";
		}
		else if (rank1 == 2){
			handName = "One of a kind";
		}
		else if (rank1 == 1){
			handName = "High card"; 
		}
		return (handName); 
	}
	
	public String getHandNames2 (){
		String handName = "";
		
		if (rank2 == 10){
			handName = "Royal Flush";
		}
		else if (rank2 == 9){
			handName = "Straight Flush"; 
		}
		else if (rank2 == 8){
			handName = "Four of A kind";
		}
		else if (rank2 == 7){
			handName = "Full house";
		}
		else if (rank2 == 6){
			handName = "Flush";
		}
		else if (rank2 == 5){
			handName = "Straight"; 
		}
		else if (rank2 == 4){
			handName = "Straight";
		}
		else if (rank2 == 3){
			handName = "Two of a kind";
		}
		else if (rank2 == 2){
			handName = "One of a kind";
		}
		else if (rank2 == 1){
			handName = "High card"; 
		}
		return (handName); 
	}

	public void checkSuit(String[] n) {
		for (int i = 0; i < 5; i++) {
			first = first + (n[i].substring(0, 1));
			second = second + (n[i + 5].substring(0, 1));
		}
		first = first.replaceAll(n[0].substring(0, 1), "");
		second = second.replaceAll(n[5].substring(0, 1), "");

		if (first.length() == 0) {
			ss1 = true;
		}
		if (second.length() == 0) {
			ss2 = true;
		}
	}

	public void straightFlush(int h1[], int h2[]) {
		int counter = 0;
		Arrays.sort(h1);
		Arrays.sort(h2);
		for (int n = 0; n < 5; n++) {
			if (h1[n] % 13 == 1 && h1[1] != 2 && h1[n] != h1[4]) {
				h1[n] = ((((h1[n] - 1) / 13) + 1) * 13) + 1;
			} 
			if (h2[n] % 13 == 1 && h2[1] != 2 && h2[n] != h2[4]) {
				h2[n] = ((((h2[n] - 1) / 13) + 1) * 13) + 1;
			}
		}
		Arrays.sort(h1);
		Arrays.sort(h2);
		counter = h1[0];
		for (int n = 0; n < 5; n++) {
			if (counter != h1[n]) {
				or1 = false;
				break;
			}
			counter = counter + 1;
		}
		if (h1[0] % 13 == 10 && ss1 == true && or1 == true) {
			rank1 = 10;
		} else if (h1[0] % 13 > 0 && h1[0] % 13 < 14 && ss1 == true
				&& or1 == true) {
			rank1 = 9;
		}
		if (or1 == true && rank1 == 0) {
			rank1 = 5;
		}
		if (or1 == false && ss1 == true && rank1 == 0) {
			rank1 = 6;
		}
		counter = h2[0];
		for (int n = 0; n < 5; n++) {
			if (counter != h2[n]) {
				or2 = false;
				break;
			}
			counter = counter + 1;
		}
		if (h2[0] % 13 == 10 && ss2 == true && or2 == true) {
			rank2 = 10;
		} else if (h2[0] % 13 > 0 && h2[0] % 13 < 14 && ss2 == true
				&& or2 == true) {
			rank2 = 9;
		}
		if (or2 == true && rank2 == 0) {
			rank2 = 5;
		}
		if (or2 == false && ss2 == true && rank2 == 0) {
			rank2 = 6;
		}
	}

	public void sameFour(int[] h1, int[] h2) {
		int counter = 0;
		for (int n = 0; n < 5; n++) {
			if (h1[n] % 13 == 0) {
				temp[n] = 13;
			} else {
				temp[n] = h1[n] % 13;
			}
			if (h2[n] % 13 == 0) {
				temp2[n] = 13;
			} else {
				temp2[n] = h2[n] % 13;
			}
		}
		Arrays.sort(temp);
		Arrays.sort(temp2);
		for (int n = 0; n < 4; n++) {
			if (temp[n] == temp[n + 1]) {
				counter = counter + 1;
			}
		}
		if (temp[0] != temp[1] || temp[3] != temp[4]) {
			if (counter == 3) {
				rank1 = 8;
			}
		} else if (temp[0] == temp[1] && counter == 3) {
			rank1 = 7;
		}
		if (temp[1] == temp[2] && temp[2] == temp[3] && counter == 2) {
			rank1 = 4;
		}
		if (temp[0] == temp[1] && temp[1] == temp[2] && counter == 2) {
			rank1 = 4;
		}
		if (temp[2] == temp[3] && temp[3] == temp[4] && counter == 2) {
			rank1 = 4;
		}
		if (counter == 2 && rank1 == 0) {
			rank1 = 3;
		}
		if (counter == 1) {
			rank1 = 2;
		}
		if (rank1 == 0) {
			rank1 = 1;
		}

		counter = 0;

		for (int n = 0; n < 4; n++) {
			if (temp2[n] == temp2[n + 1]) {
				counter = counter + 1;
			}
		}
		if (temp2[0] != temp2[1] || temp2[3] != temp2[4]) {
			if (counter == 3) {
				rank2 = 8;
			}
		} else if (temp2[0] == temp2[1] && counter == 3) {
			rank2 = 7;
		}
		if (temp2[1] == temp2[2] && temp2[2] == temp2[3] && counter == 2) {
			rank2 = 4;
		}
		if (temp2[0] == temp2[1] && temp2[1] == temp2[2] && counter == 2) {
			rank2 = 4;
		}
		if (temp2[2] == temp2[3] && temp2[3] == temp2[4] && counter == 2) {
			rank2 = 4;
		}
		if (counter == 2 && rank2 == 0) {
			rank2 = 3;
		}
		if (counter == 1) {
			rank2 = 2;
		}
		if (rank2 == 0) {
			rank2 = 1;
		}
	}

	public String tieBreaker(int[] h1, int[] h2) {
		int t1 = 0, t2 = 0, x1 = 0, x2 = 0, counter = 0;
		int[] y1 = new int[3];
		int[] y2 = new int[3];
		String winner = "";

		for (int n = 0; n < 5; n++) {
			if (temp[n] == 1) {
				temp[n] = 14;
			}
			if (temp2[n] == 1) {
				temp2[n] = 14;
			}
		}
		Arrays.sort(temp);
		Arrays.sort(temp2);
		
		if (rank1 == 10 && rank2 == 10) {
			winner = "Both players are tied!";
		}

		if (rank1 > rank2) {
			winner = "The winner is player #1";
		} else if (rank1 < rank2) {
			winner = "The winner is player #2";
		} else if (rank1 == rank2) {
			if (rank1 == 9 || rank1 == 5 || rank1 == 6) {
				if (temp[4] > temp2[4]) {
					winner = "The winner is player #1";
				} else if (temp[4] < temp2[4]) {
					winner = "The winner is player #2";
				} else if (temp[4] == temp2[4]) {
					winner = "Both players are tied!";
				}
			}

			else if (rank1 == 8) {
				if (temp[1] > temp2[1]) {
					winner = "The winner is player #1";
				} else if (temp[1] < temp2[1]) {
					winner = "The winner is player #2";
				} else if (temp[1] == temp2[1]) {
					if (temp[0] < temp[1]) {
						t1 = temp[0];
					} else if (temp[4] > temp[3]) {
						t1 = temp[4];
					}
					if (temp2[0] < temp2[1]) {
						t2 = temp2[1];
					} else if (temp2[4] > temp2[3]) {
						t2 = temp2[4];
					}
					if (t1 > t2) {
						winner = "The winner is player #1";
					} else if (t1 < t2) {
						winner = "The winner is player #2";
					} else if (t1 == t2) {
						winner = "Both players are tied!";
					}
				}
			}

			else if (rank1 == 7) {
				for (int n = 0; n < 5; n++) {
					if (temp[0] == temp[n]) {
						counter = counter + 1;
					}
				}
				if (counter == 3) {
					t1 = temp[0];
					x1 = temp[4];
				} else {
					t1 = temp[4];
					x1 = temp[0];
				}
				counter = 0;
				for (int n = 0; n < 5; n++) {
					if (temp2[0] == temp2[n]) {
						counter = counter + 1;
					}
				}
				if (counter == 3) {
					t2 = temp2[0];
					x2 = temp2[4];
				} else {
					t2 = temp2[4];
					x2 = temp2[0];
				}
				counter = 0;
				if (t1 > t2) {
					winner = "The winner is player #1";
				} else if (t1 < t2) {
					winner = "The winner is player #2";
				} else {
					if (x1 > x2) {
						winner = "The winner is player #1";
					} else if (x1 < x2) {
						winner = "The winner is player #2";
					} else {
						winner = "Both players are tied!";
					}
				}
			}

			if (rank1 == 4) {
				if (temp[1] == temp[2] && temp[2] == temp[3]) {
					t1 = temp[1];
					temp[1] = 0;
					temp[2] = 0;
					temp[3] = 0;
				} else if (temp[0] == temp[1] && temp[1] == temp[2]) {
					t1 = temp[0];
					temp[0] = 0;
					temp[1] = 0;
					temp[2] = 0;
				} else if (temp[2] == temp[3] && temp[3] == temp[4]) {
					t1 = temp[2];
					temp[2] = 0;
					temp[3] = 0;
					temp[4] = 0;
				}
				if (temp2[1] == temp2[2] && temp2[2] == temp2[3]) {
					t2 = temp2[1];
					temp2[1] = 0;
					temp2[2] = 0;
					temp2[3] = 0;
				} else if (temp2[0] == temp2[1] && temp2[1] == temp2[2]) {
					t2 = temp2[0];
					temp2[0] = 0;
					temp2[1] = 0;
					temp2[2] = 0;
				} else if (temp2[2] == temp2[3] && temp2[3] == temp2[4]) {
					t2 = temp2[2];
					temp2[2] = 0;
					temp2[3] = 0;
					temp2[4] = 0;
				}
				Arrays.sort(temp);
				Arrays.sort(temp2);
				if (t1 > t2) {
					winner = "The winner is player #1";
				} else if (t1 < t2) {
					winner = "The winner is player #2";
				} else {
					if (temp[3] > temp2[3]) {
						winner = "The winner is player #1";
					} else if (temp[3] < temp2[3]) {
						winner = "The winner is player #2";
					} else {
						if (temp[4] > temp2[4]) {
							winner = "The winner is player #1";
						} else if (temp[4] < temp2[4]) {
							winner = "The winner is player #2";
						} else {
							winner = "Both players are tied!";
						}
					}
				}
			}

			else if (rank1 == 3) {
				if (temp[1] > temp[3]) {
					y1[0] = temp[1];
					y1[1] = temp[3];
				} else {
					y1[0] = temp[3];
					y1[1] = temp[1];
				}
				if (temp2[1] > temp2[3]) {
					y2[0] = temp2[1];
					y2[1] = temp2[3];
				} else {
					y2[0] = temp2[3];
					y2[1] = temp2[1];
				}
				for (int n = 0; n < 5; n++) {
					if (temp[n] != y1[0] && temp[n] != y1[1]) {
						y1[2] = temp[n];
					}
					if (temp2[n] != y2[0] && temp2[n] != y2[1]) {
						y2[2] = temp2[n];
					}
				}
				if (y1[0] > y2[0]) {
					winner = "The winner is player #1";
				} else if (y1[0] < y2[0]) {
					winner = "The winner is player #2";
				} else {
					if (y1[1] > y2[1]) {
						winner = "The winner is player #1";
					} else if (y1[1] < y2[1]) {
						winner = "The winner is player #2";
					} else {
						if (y1[2] > y2[2]) {
							winner = "The winner is player #1";
						} else if (y1[2] < y2[2]) {
							winner = "The winner is player #2";
						} else {
							winner = "Both players are tied!";
						}
					}
				}
			}

			if (rank1 == 2) {
				for (int n = 0; n < 5; n++) {
					for (int i = 0; i < 5; i++) {
						if (temp[n] == temp[i]) {
							counter = counter + 1;
						}
						if (counter == 2) {
							t1 = temp[n];
							break;
						}
					}
					counter = 0;
				}
				for (int n = 0; n < 5; n++) {
					for (int i = 0; i < 5; i++) {
						if (temp2[n] == temp2[i]) {
							counter = counter + 1;
						}
						if (counter == 2) {
							t2 = temp2[n];
							break;
						}
					}
					counter = 0;
				}
				for (int n = 0; n < 5; n++) {
					if (temp[n] != t1) {
						y1[counter] = temp[n];
						counter = counter + 1;
					}
				}
				counter = 0;
				for (int n = 0; n < 5; n++) {
					if (temp2[n] != t2) {
						y2[counter] = temp2[n];
						counter = counter + 1;
					}
				}
				Arrays.sort(y1);
				Arrays.sort(y2);
				counter = 0;
				if (t1 > t2) {
					winner = "The winner is player #1";
				} else if (t1 < t2) {
					winner = "The winner is player #2";
				} else {
					if (y1[2] > y2[2]) {
						winner = "The winner is player #1";
					} else if (y1[2] < y2[2]) {
						winner = "The winner is player #2";
					} else {
						if (y1[1] > y2[1]) {
							winner = "The winner is player #1";
						} else if (y1[1] < y2[1]) {
							winner = "The winner is player #2";
						} else {
							if (y1[0] > y2[0]) {
								winner = "The winner is player #1";
							} else if (y1[0] < y2[0]) {
								winner = "The winner is player #2";
							} else {
								winner = "Both players are tied!";
							}
						}
					}
				}
			}

			else if (rank1 == 1) {
				Arrays.sort(temp);
				Arrays.sort(temp2);
				if (temp[4] > temp2[4]) {
					winner = "The winner is player #1";
				} else if (temp[4] < temp2[4]) {
					winner = "The winner is player #2";
				} else {
					if (temp[3] > temp2[3]) {
						winner = "The winner is player #1";
					} else if (temp[3] < temp2[3]) {
						winner = "The winner is player #2";
					} else {
						if (temp[2] > temp2[2]) {
							winner = "The winner is player #1";
						} else if (temp[2] < temp2[2]) {
							winner = "The winner is player #2";
						} else {
							if (temp[1] > temp2[1]) {
								winner = "The winner is player #1";
							} else if (temp[1] < temp2[1]) {
								winner = "The winner is player #2";
							} else {
								if (temp[0] > temp2[0]) {
									winner = "The winner is player #1";
								} else if (temp[0] < temp2[0]) {
									winner = "The winner is player #2";
								} else {
									winner = "Both players are tied!";
								}
							}
						}
					}
				}
			}
		}
		return (winner);
	}
}