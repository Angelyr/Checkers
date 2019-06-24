import java.util.Scanner;

public class Checkers
{
    public static void main(String [] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("\f");
        //http://jrgraphix.net/r/Unicode/2600-26FF
        
        String board[][]=new String [8][8];
        
        for(int x=0; x<8; x++)
        {
            for(int y=0; y<8; y++)
            {
                if(x<3)
                {
                    if((y%2==0&&x%2==0)||(x%2!=0&&y%2!=0))
                        board[x][y]=("○");
                    else
                        board[x][y]=("□");
                }
                if(x>4)
                {
                    if((y%2==0&&x%2==0)||(x%2!=0&&y%2!=0))
                        board[x][y]=("●");
                    else
                        board[x][y]=("□");
                }
                if(x==3||x==4)
                {
                    board[x][y]=("□");
                }
            }
        }
        
        printBoard(board);
        
        int bwin=0,wwin=0;
        int oldx=0,oldy=0,newx=0,newy=0;
        
        while(bwin<12||wwin<12)
        {
            System.out.println("Enter the cordinates of the piece you want to move (row the column)");
            oldy=scan.nextInt();
            oldx=scan.nextInt();
            
            System.out.println("Enter the cordinates of where you want to move it to(row the column)");
            newy=scan.nextInt();
            newx=scan.nextInt();
            
            if(newy-oldy==-1&&(newx-oldx==1||newx-oldx==-1)&&board[oldy][oldx].equals("●")&&board[newy][newx].equals("□"))
            {
                board[newy][newx]="●";
                board[oldy][oldx]="□";
            }
            else if(newy-oldy==1&&(newx-oldx==1||newx-oldx==-1)&&board[oldy][oldx].equals("○")&&board[newy][newx].equals("□"))
            {
                board[newy][newx]="○";
                board[oldy][oldx]="□";
            }
            else if(newy-oldy==2&&((newx-oldx)/2==1||(newx-oldx)/2==-1)&&board[oldy][oldx].equals("○")&&board[newy][newx].equals("□")&&(board[oldy+((newy-oldy)/2)][oldx+((newx-oldx))/2].equals("●")||board[(newy-oldy)/2][oldx+((newx-oldx))/2].equals("★")))
            {
                board[newy][newx]="○";
                board[oldy][oldx]="□";
                board[oldy+((newy-oldy)/2)][oldx+((newx-oldx))/2]="□";
                wwin++;
            }
            else if(newy-oldy==-2&&((newx-oldx)/2==1||(newx-oldx)/2==-1)&&board[oldy][oldx].equals("●")&&board[newy][newx].equals("□")&&(board[oldy+((newy-oldy)/2)][oldx+((newx-oldx))/2].equals("○")||board[(newy-oldy)/2][oldx+((newx-oldx))/2].equals("☆")))
            {
                board[newy][newx]="●";
                board[oldy][oldx]="□";
                board[oldy+((newy-oldy)/2)][oldx+((newx-oldx))/2]="□";
                bwin++;
            }
            else if((newy-oldy==1||newy-oldy==-1)&&(newx-oldx==1||newx-oldx==-1)&&board[oldy][oldx].equals("☆")&&board[newy][newx].equals("□"))
            {
                board[newy][newx]="☆";
                board[oldy][oldx]="□";
            }
            else if((newy-oldy==1||newy-oldy==-1)&&(newx-oldx==1||newx-oldx==-1)&&board[oldy][oldx].equals("★")&&board[newy][newx].equals("□"))
            {
                board[newy][newx]="★";
                board[oldy][oldx]="□";
            }
            else if((newy-oldy==-2||newy-oldy==2)&&((newx-oldx)/2==1||(newx-oldx)/2==-1)&&board[oldy][oldx].equals("★")&&board[newy][newx].equals("□")&&(board[oldy+((newy-oldy)/2)][oldx+((newx-oldx))/2].equals("○")||board[(newy-oldy)/2][oldx+((newx-oldx))/2].equals("☆")))
            {
                board[newy][newx]="★";
                board[oldy][oldx]="□";
                board[oldy+((newy-oldy)/2)][oldx+((newx-oldx))/2]="□";
                bwin++;
            }
            else if((newy-oldy==-2||newy-oldy==2)&&((newx-oldx)/2==1||(newx-oldx)/2==-1)&&board[oldy][oldx].equals("☆")&&board[newy][newx].equals("□")&&(board[oldy+((newy-oldy)/2)][oldx+((newx-oldx))/2].equals("●")||board[(newy-oldy)/2][oldx+((newx-oldx))/2].equals("★")))
            {
                board[newy][newx]="☆";
                board[oldy][oldx]="□";
                board[oldy+((newy-oldy)/2)][oldx+((newx-oldx))/2]="□";
                wwin++;
            }
            else
            {
                System.out.println("Invalid move");
                continue;
            }
            
            if(board[0][newx].equals("●"))
                board[0][newx]="★";
            if(board[7][newx].equals("○"))
                board[7][newx]="☆";
                
            printBoard(board);
        }
        
        if(bwin==12)
            System.out.println("Black has won the game");
        if(wwin==12)
            System.out.println("White has won the game");
            
    }
    public static void printBoard(String board[][])
    {
        System.out.println("Welcome to Checkers, the rules are simple:");
        System.out.println("1) You can only move your piece diagonaly fowards");
        System.out.println("2) If there is an enemy piece in the way and an empty space diagonally across it then you may jump it by selecting the empty square");
        System.out.println("3) If you can jump multiple pieces with your then your turn goes on");
        System.out.println("4) Have Fun!!!!");
        
        for(int z=0; z<8; z++)
             System.out.print("\t"+z);
        
        System.out.print("\n");
             
        for(int x=0; x<8; x++)
        {
            System.out.print(x+"\t");
            for(int y=0; y<8; y++)
            {
                System.out.print(board[x][y]+"\t");
            }
            System.out.print("\n");
        }
        
        System.out.print("\n");
    }
}