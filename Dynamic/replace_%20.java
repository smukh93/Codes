/*Write a method to replace all spaces in a string with ‘%20’*/
public class ReplaceSpace {
    public static void main(String[] args) {
        String temp = " a b ";
        String outString = replaceSpa(temp);
        System.out.println(outString);
    }
    public static String replaceSpa(String str){
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                strBuffer.append("%20");
            }else {
                strBuffer.append(str.charAt(i));
            }
        }
        return strBuffer.toString();
    }
}