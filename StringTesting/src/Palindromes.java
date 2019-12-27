
public class Palindromes {

	public static void main(String[] args) {
		//String str = "AMANAPLANACANALPANAMA", str2 = "Air an aria";
		String[] palindromes = {"AMANAPLANACANALPANAMA", "Air an aria", "MALAYALAM","not a palindrome", "racecar"};

		for (String string : palindromes) {
			System.out.println(isPalindromeCheck(string));
		}
		
	}
	
	public static Boolean isPalindromeCheck(String str){
		char[] charArr = str.replaceAll(" ", "").toLowerCase().toCharArray();
		
		for(int i = 0; i < charArr.length/2; i++){
			if(charArr[i] != charArr[charArr.length - 1 -i]) return false;
		}
		
		return true;
	}

}
