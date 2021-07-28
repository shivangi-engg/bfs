//counting the number of connected components in a graph
import java.util.*;
import java.lang.*;
public class Connected_components
{
	public static int connected=0;
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
		System.out.println("output of breadth fist traversal on the given adjacency list is:");
		breadth_first_search__dis_logic(adjacency_list,nodes);
		System.out.println();
		System.out.print("the number of connected components in the given graph are:"+connected);
	}

	public static void breadth_first_search__dis_logic(ArrayList<ArrayList<Integer>> adj, int n)
	{
		boolean[] visited = new boolean[n];
		for(int i=0;i<n;i++)
		{
			visited[i] = false;
		}
		for(int i=0; i<n;i++)
		{
			if(visited[i] == false)
			{
				breadth_first_search_logic(adj,i,visited);
			}
		}
	}
	public static void breadth_first_search_logic(ArrayList<ArrayList<Integer>> adj,int v,boolean[] visited)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		visited[v] = true;
		q.add(v);
		while(q.isEmpty() == false)
		{
			int u = q.poll();
			System.out.print(u+" ");
			for(int x: adj.get(u))
			{
				if(visited[x] == false)
				{
					visited[x] = true;
					q.add(x);
				}
			}
		}
		connected++;
	}
}