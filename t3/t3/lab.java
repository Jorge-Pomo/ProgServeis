package t3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class lab {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\src\\t3\\arxiuCaragol3\\resultat.txt"));
			String str = br.readLine();
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
