import java.util.*;
class TicTacToe
{	
	static HashSet<Integer> ur_set=new HashSet<Integer>();
	static HashSet<Integer> cpu_set=new HashSet<Integer>();
	public static void print_board(char [][]g_boards){
		for(int i=0;i<g_boards.length;i++)
		{
			for(int j=0;j<g_boards[i].length;j++){
				System.out.print(g_boards[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	
	}
	public static void p_holder(char[][] g_boards,int pos,String user){
		char symbol='X';
		if(user.equals("You")){
			symbol='X';
			ur_set.add(pos);
		}
		else if(user.equals("CPU")){
			symbol='O';
			cpu_set.add(pos);
		}
		switch(pos){
			case 1:g_boards[0][0]=symbol;
				break;
			case 2:g_boards[0][2]=symbol;
				break;
			case 3:g_boards[0][4]=symbol;
				break;
			case 4:g_boards[2][0]=symbol;
				break;
			case 5:g_boards[2][2]=symbol;
				break;
			case 6:g_boards[2][4]=symbol;
				break;
			case 7:g_boards[4][0]=symbol;
				break;
			case 8:g_boards[4][2]=symbol;
				break;
			case 9:g_boards[4][4]=symbol;
				break;
			default:
				System.out.println("Enter a number between 1 to 9");
		}
		print_board(g_boards);
	}
	public static int get_random(){
		int max=9;
		int min=1;
		int range=max-min+1;
		int res=(int)(Math.random()*range)+min;
		return res;
	}
	static String check_winner()
	{
		HashSet<Integer> r1=new HashSet<Integer>();
		r1.add(1);r1.add(2);r1.add(3);
		HashSet<Integer> r2=new HashSet<Integer>();
		r2.add(4);r2.add(5);r2.add(6);
		HashSet<Integer> r3=new HashSet<Integer>();
		r3.add(7);r3.add(8);r3.add(9);
		HashSet<Integer> c1=new HashSet<Integer>();
		c1.add(1);c1.add(4);c1.add(7);
		HashSet<Integer> c2=new HashSet<Integer>();
		c2.add(2);c2.add(5);c2.add(8);
		HashSet<Integer> c3=new HashSet<Integer>();
		c3.add(3);c3.add(6);c3.add(9);
		HashSet<Integer> d1=new HashSet<Integer>();
		d1.add(1);d1.add(5);d1.add(9);
		HashSet<Integer> d2=new HashSet<Integer>();
		d2.add(3);d2.add(5);d2.add(7);
		
		HashSet<HashSet> set=new HashSet<HashSet>();
		set.add(r1);set.add(r2);set.add(r3);
		set.add(c1);set.add(c2);set.add(c3);
		set.add(d1);set.add(d2);
		
		for(HashSet c:set){
			if(ur_set.containsAll(c))
				return "YOU WON";
			else if(cpu_set.containsAll(c))
				return "CPU WON";
		}
		if(ur_set.size()+cpu_set.size()==9)
			return "Draw";
		return "";
	}
	public static void main(String []args)
	{
		char g_boards[][]={
			{' ','|',' ','|',' '},
			{'-','|','-','|','-'},
			{' ','|',' ','|',' '},
			{'-','|','-','|','-'},
			{' ','|',' ','|',' '}
		};
		print_board(g_boards);
		Scanner sc=new Scanner(System.in);
		while(true)
		{	
			//user
			System.out.println("Enter a number between 1 to 9:");
			int user_pos=sc.nextInt();
			while(ur_set.contains(user_pos) || cpu_set.contains(user_pos)){
				System.out.println();
				System.out.println("Retry , Enter a number between 1 to 9:");
				user_pos=sc.nextInt();
			}
			p_holder(g_boards,user_pos,"You");
			String res=check_winner();
			if(res.length()>0){
				System.out.println(res);
				break;
			}
			//cpu
			int cpu_pos=get_random();
			while(ur_set.contains(cpu_pos) || cpu_set.contains(cpu_pos)){
				cpu_pos=get_random();
			}
			p_holder(g_boards,cpu_pos,"CPU");
			res=check_winner();
			if(res.length()>0){
				System.out.println(res);
				break;
			}
		}		
	}
}
