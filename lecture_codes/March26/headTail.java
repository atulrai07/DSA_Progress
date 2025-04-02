public class headTail {
    static int count = 0;
    public static void main(String[] args) {
        int n = 3;
        coin (n,"");
        System.out.println("count = "+count);
    }
    public static void coin(int n,String ans){
        if (n == 0){
            System.out.println(ans);
            count++;
            return;
        }
        coin(n-1, ans+"H");
        coin(n-1,ans+"T");
    }
}
