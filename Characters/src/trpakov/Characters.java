package trpakov;

public class Characters {

	public static void main(String[] args) {
		var s = "My String";
		System.out.println(s);
		var result = convertCharToASCII(s.toCharArray());
		for (int i = 0; i < result.length; i++) {
			System.out.print(i != result.length - 1 ? result[i] + ", " : result[i]);
		}
		System.out.println();
		
		var newOldString = new String(convertASCIItoChar(result));
		System.out.println(newOldString);
		System.out.println('\u00ae');

	}
	
	static int[] convertCharToASCII(char...charArr){
		int[] intArr = new int[charArr.length];
		
		for (int i = 0; i < charArr.length; i++) {
			intArr[i] = (int)charArr[i];
		}
		
		return intArr;
	}
	
	static char[] convertASCIItoChar(int...intArr) {
		char[] charArr = new char[intArr.length];
		
		for (int i = 0; i < intArr.length; i++) {
			charArr[i] = (char)intArr[i];
		}
		
		return charArr;
	}

}
