import java.util.Scanner;

public class Astart_Runner {


	public static void main(String[]args)
	{
		Astar_Grid new_grid = new Astar_Grid();
		
		Scanner input = new Scanner(System.in);
		
		// add nodes to the grid	
			
			
		Astar_Block current= new_grid.get_grid()[0][0];
		
		
		
		for(Astar_Block child: current.getconnected())
		{
			if(!child.visted()&& child.unblocked())
			{
				double manhattan_distance=new_grid.find_distance(child.x,child.y,14,14);
				
				child.setHeuristic(manhattan_distance);
			}
		}
		
		current.order_connected_list();
		
		System.out.println(current.toString());
				
				
				
				
				
				
			}
			
		
		
		
		
	
}
