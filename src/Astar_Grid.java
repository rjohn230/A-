import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import java.util.Random;
import java.util.HashMap;

public class Astar_Grid {
	private  Astar_Block[][] Astar_Grid= new Astar_Block[15][15];
	private  String[] name_of_nodes = {"A","B","C","D","E","1","2","3","4","5","Z","X","Y","Y","9"};
	private  Random random= new Random();
	private ArrayList<Astar_Block> path = new ArrayList<Astar_Block>();
	private  HashMap<Integer, String> already_used_name = new HashMap<Integer, String>();
	
	public Astar_Grid()
	{
		
		for (int x=0;x<15;x++)
		{
			for(int y=0;y<15;y++)
			{
				String adding_name;
				boolean adding_boolean=false;
				
				int open_close = random.nextInt(1);
				if(open_close==1)
				{
					adding_boolean=true;
				}
				
				int choice_name = random.nextInt(15);
				adding_name= name_of_nodes[choice_name];
				
				
				while(already_used_name.containsKey(adding_name))
				{
				    choice_name = random.nextInt(15);
					adding_name= name_of_nodes[choice_name];
				}
				
				
				Astar_Block adding_node= new Astar_Block(adding_boolean,adding_name,x,y);
				
				
				Astar_Grid[x][y]=adding_node;
				}
		}
		
		for (int x=0;x<15;x++)
		{
			for(int y=0;y<15;y++)
			{
					if(x!=0 && x!=14 && y!=0 && y!=14)
					{
					Astar_Grid[x][y].getconnected().add(Astar_Grid[x+1][y]);
					Astar_Grid[x][y].getconnected().add(Astar_Grid[x-1][y]);
					Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y+1]);
					Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y-1]);
					}
					else if(x==0 && y!=0 && y!=14)
					{
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x+1][y]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y+1]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y-1]);
						
					}
					else if(x==14 && y!=0 && y!=14) 
					{
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x-1][y]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y+1]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y-1]);
					}
					else if(y==0 && x!=0 && x!=14)
					{
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x-1][y]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x+1][y]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y+1]);
					}
					else if (y==14 && x!=0 && x!=14)
					{
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y-1]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x+1][y]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x-1][y]);
					}
					else if(x==0 && y==0)
					{
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x+1][y]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y+1]);
					}
					else if(x==0 && y==14)
					{
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x+1][y]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y-1]);
					}
					else if(x==14 && y==0)
					{
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x-1][y]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y+1]);
					}
					else if(x==14 && y==14)
					{
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x-1][y]);
						Astar_Grid[x][y].getconnected().add(Astar_Grid[x][y-1]);
					}
					

			}
			
		}
		
		
		
	}
	
	public Astar_Block[][] get_grid()
	{
		return Astar_Grid;
	}
	
	public boolean A_star_search(int x1,int y1, int x2, int y2)
	{
		if(x1==x2 && y1==y2)
		{
			return true;
		}
		else
		{
			Astar_Block current= Astar_Grid[x1][y1];
			
			for(Astar_Block child: current.getconnected())
			{
				if(!child.visted()&& child.unblocked())
				{
					double manhattan_distance=find_distance(child.x,child.y,x2,y2);
					
					child.setHeuristic(manhattan_distance);
				}
			}
			
			current.order_connected_list();

			
			
		}
		
		
		return false;
	}
	
	public double find_distance(int x1, int y1, int x2, int y2) 
	{
		double distance=0;
		double a= Math.pow(x2-x1, 2)+ Math.pow(y2-y1, 2);
		
		distance= Math.sqrt(a);
		
		
		return distance;
		
	}
	
	public String toString()
	{
		StringBuffer Grid = new StringBuffer();
		
	
		
		for (int x=0;x<15;x++)
		{
			for(int y=0;y<15;y++)
			{
				Grid.append(Astar_Grid[x][y].getName()+" ");
			}
			Grid.append("\n");
		}
		
		
			return Grid.toString();
		
	}
}
