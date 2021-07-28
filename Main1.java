//int htis case given: undirected graph, source vertex , adjacency list
import java.util.*;
import java.lang.*;
public class Main1
{
	public static void main(String[] args) 
	{
		ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<ArrayList<Integer>>();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the no of nodes in the graph:");
		int nodes = sc.nextInt();
		for(int i=0; i< nodes; i++)
		{
			adjacency_list.add(new ArrayList<Integer>());
		}
		System.out.println("enter the adjacency list values:");
		for(int i=0; i<nodes; i++)
		{
			System.out.println("enter the no of adjacent nodes of "+i);
			int adjacents = sc.nextInt();
			System.out.println("enter the adjacent nodes of "+i);
			for(int j=0; j<adjacents; j++)
			{
				int value = sc.nextInt();
				adjacency_list.get(i).add(j,value);
			}
		}
		System.out.println("the adjacency list is as follows:");
		for(int i=0;i<nodes;i++)
		{
			System.out.print(i);
			Iterator<Integer> it = adjacency_list.get(i).iterator();
			while(it.hasNext())
			{
				System.out.print("-->"+it.next());
			}
			System.out.println();
		}

		System.out.println("enter the source vertex:");
		int source = sc.nextInt();
		breadth_first_search_logic(adjacency_list,source,nodes);
	}

	public static void breadth_first_search_logic(ArrayList<ArrayList<Integer>> adj, int s , int n)
	{
		boolean visited[] = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[s] = true;
		q.add(s);
		System.out.println("output of breadth fist traversal on the given adjacency list is:");
		while(q.isEmpty() == false)
		{
			int u = q.poll();
			System.out.print(u+" ");
			for(int v: adj.get(u))
			{
				if(visited[v] == false)
				{
					visited[v] = true;
					q.add(v);
				}
			}
		}
	}
}