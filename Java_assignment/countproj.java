public class countproj {
    public static void main(String[] args) {
        String name="My name is charu srivastava";
        char[] ch= name.toCharArray();
        for (int i = 0; i < name.length(); i++){
                int count=0;
                for(int j=0;j<name.length();j++){
                    if(j<i && (ch[i]==ch[j])){
                        break;
                    }
                    if(ch[i]==ch[j]){
                        count++;
                    }
                }
          if(count>0)  {
              System.out.println(name.charAt(i) + " is present "  + count + " times ");
          }
    }}}

