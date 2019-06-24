import java.util.Scanner;
import java.awt.Color;
public class Game
{
    public static void main(String []args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("\f");
        System.out.println("Welcome to Checkers");
        String board[][]=new String [9][9];
        int c,r;
        
        //http://www.alanwood.net/unicode/geometric_shapes.html
        
        for(r=0; r<8; r++)
        {
            for(c=0; c<8; c++)
            {
                if((r%2==0&&c%2==0)||(r%2!=0&&c%2!=0))
                {
                        if(r<3){
                            board[r][c]="◎";
                        }
                        else if(r>4)
                            board[r][c]="●";
                           else
                                board[r][c]="□";
                }
                else
                    board[r][c]="□";
            }
        }
        
        printBoard(board);   
        
        int bleft=0,wleft=0;
        int oldx=0,oldy=0,newx=0,newy=0;
        
        while(bleft<13||wleft<13)
        {
            System.out.println("Enter the cordinates of the piece you want to move(x then y)");
            
            oldx=scan.nextInt();
            oldy=scan.nextInt();
            
            
            oldx-=1;
            oldy-=1;
            
            System.out.println("Enter the cordinates of where you want to move it to (x then y)");
            
            newx=scan.nextInt();
            newy=scan.nextInt();
            
            newx-=1;
            newy-=1;
            
            if(board[oldx][oldy].equals("●"))
            {
                board[newx][newy]="●";
                board[oldx][oldy]="□";
            }
            if(board[oldx][oldy].equals("◎"))
            {
                board[newx][newy]="◎";
                board[oldx][oldy]="□";
            }         
            
            printBoard(board);
        }
        
    }
    public static void printBoard(String board[][])
    {
        for(int x=0; x<8; x++)
        {
            for(int y=0; y<8; y++)
                System.out.print(board[x][y]+"\t");
            System.out.print("\n");
        }
    }
}
