
public class Hello {
    public static void main(String[] args){
      //1.1
      System.out.println(checkDifferent("aeiou"));
      //System.out.println(checkDifferent("BarackObama"));
      //1.2
      //System.out.println(reverseString("This is nowcoder"));
      //1.3
      //System.out.println(checkSam("This is nowcoder","is This nowcoder"));
      //System.out.println(checkSam("Here you are","Are you here"));
      //1.4
      //System.out.println(replaceSpace("Mr John Smith"));
      //1.5
      //System.out.println(zipString("aabcccccaaa"));
      
    }
//1.1---------------------------------------------------------------------------------
    public static boolean checkDifferent(String s){
        char temp=s.charAt(0);
        for(int i = 0;i<s.length();i++){
            temp = s.charAt(i);
            for(int j = i+1;j<s.length();j++){
                if(temp==s.charAt(j))
                return false;
            }
        }
        return true;
    }
//1.2---------------------------------------------------------------------------------
    public static String reverseString(String s){
        char[] chars = new char[s.length()];
        for(int i = 0;i<s.length();i++){
            chars[chars.length-i-1] = s.charAt(i);
        }
        return new String(chars);
    }
//1.3------------------------------------------------------------------------------------
    public static boolean checkSam(String stringA,String stringB){
        if(stringA.length()!=stringB.length())
            return false;
        int length = stringA.length();
        if(length==0)
            return true; 
        char[] charsB = stringB.toCharArray();
        for(int i=0;i<length;i++){
            char temp = stringA.charAt(i);
            for(int j = 0;j<length;j++){
                if(temp==charsB[j]){
                    charsB[j] = '\0';
                    break;
                }
            }
        }
        for(int i=0;i<length;i++){
            if(charsB[i]!='\0')
                return false;
        }
        return true;
    }
//1.4----------------------------------------------------------------------------------
    public static String replaceSpace(String s){
        char[] chars = new char[3000];
        int length = s.length();
        int i =0 ;
        for(i=0;i<length;i++){
            chars[i] = s.charAt(i);
        }
        chars[i]='\0';
        for(int j=0;j<length+1;j++){
            if(chars[j]==' '){
                chars = push(chars,j,2);
                chars[j]='%';
                chars[j+1]='2';
                chars[j+2]='0';
            }

        }
        return new String(chars);

    }
    private static char[] push(char[] chars,int index,int count){
        int length=0;
        for(;;length++){
           if( chars[length]=='\0')
                break;
        }
        for(int i=length;i>index;i--){
            chars[i+count]=chars[i];
        }
        return chars;
    }
//1.5------------------------------------------------------------------------------
    public static String zipString(String s){
        char temp = '\0';
        int count =0;
        int length = s.length();
        char[] chars = new char[length];
        int point = 0;
        int i = 0;
        for( i=0;i<length;i++){
            if(count==0)
                temp = s.charAt(i);
            if(s.charAt(i)==temp)
                count++;
            else{
                i--;
                chars[point++] = s.charAt(i); 
                if(point==length)
                    break;         
                char[] charCount = intToCharArray(count);
                int j;
                for(j=0;charCount[j]!='\0';j++){
                    chars[point++]=charCount[j]; 
                    if(point==length)
                        break;
                }
                if(charCount[j]!='\0')
                    break;
                count=0;
            }
            
        }
        if(i<length)
            return s;
        return new String(chars);
    }
    private static char[] intToCharArray(int s){
        char[] chars = new char[6];
        int a =0;
        int b = 0;
        for(int i=0;i<5;i++){
            a = 10*(4-i);
            if(a!=0){
                chars[i]=(char)(s/a+'0');
                s=s%a;
            }
            chars[i]=(char)(s+'0');
        }
        chars[5]='\0';
        while(chars[0]=='0'){
            for(int i=0;chars[i]!='\0';i++){
                chars[i]=chars[i+1];
            }
        }
        return chars;
    }
   
}
