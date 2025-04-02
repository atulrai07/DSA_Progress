public class subsequenceResursion{
    public static void main(String[] args) {
        String str = "abc";
        Sub(str,"");
    }

    public static void Sub (String ques, String ans){
        if (ques.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        Sub(ques.substring(1), ans);
        Sub (ques.substring (1), ans+ch); 
    }
}