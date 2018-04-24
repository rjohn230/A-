import java.util.Arrays;
import java.util.*;

public class Astar_Block {
	private ArrayList<Astar_Block> connected_nodes = new ArrayList<Astar_Block>();
	private String name;
	private boolean unblocked;
	private boolean visted =false;
	public int x,y;
	private double heuristic= Double.POSITIVE_INFINITY;

	public Astar_Block (boolean op, String n, int xx, int yy)
	{
		unblocked=op;
		name=n;
		x=xx;
		y=yy;
	}
	
	public void setHeuristic(double r)
	{
		heuristic=r;
	}
	public double getHeuristic() 
	{
		return heuristic;
	}
	public ArrayList<Astar_Block> getconnected()
	{
		return connected_nodes;
	}
	public boolean visted()
	{
		return visted;
	}
	public boolean unblocked()
	{
		return unblocked;
	}
	public String toString()
	{
		StringBuffer AstarBuff = new StringBuffer();
		AstarBuff.append("Name: "+name+" ("+x+","+y+")\nConnected: ");
		
		for (Astar_Block node :connected_nodes)
		{
			AstarBuff.append(node.getName()+" ");
		}
		
		return AstarBuff.toString();
		
	}
	public String getName()
	{
		return name;
	}
	public void order_connected_list()
	{
		 Astar_Block min= connected_nodes.get(0);
		 Astar_Blo
		 Astar_Block temp= connected_nodes.get(0);
		 int came_from=0;
	
		 
		 for (int x=0;x<connected_nodes.size();x++)
		 {
			 for(int y=0;y<connected_nodes.size();y++)
			 {
				 if(min.heuristic>connected_nodes.get(y).heuristic)
				 {
					 min=connected_nodes.get(y);
					 came_from=y;
					 
				 }
			 }
			// temp=connected_nodes.get(x);
			 //connected_nodes.add(x, min);
			// connected_nodes.add(came_from, temp);
			 
			 
		 }

		
	}
}
