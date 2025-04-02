public class findpath{
    static int count = 0;
    public static void main(String[] args) {
        int r = 3; //row
        int c = 4; 
        PrintPath(0, 0, 2, 2, "");
        System.out.println("count" + count);
    }
    public static void PrintPath(int cr, int cc, int er, int ec, String path){

        if (cr == er && cc == ec){
            System.out.println(path);
            count++;
            return;
        }

        if (cr>er || cc > ec){
            return;
        }

        PrintPath(cr + 1, cc, er , ec, path+"V");
        PrintPath(cr, cc+1, er, ec, path+"H");
    }

}