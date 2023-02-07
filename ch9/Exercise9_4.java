
public class Exercise9_4 {
	static void printGraph(int[] dataArr, char ch) {
		for(int arr : dataArr) {
			char[] graph = new char[arr];
			for(int i=0; i<arr; i++) 
				graph[i] = ch;			
			System.out.print(graph);
			System.out.println(arr);
		}
		
	}
	public static void main(String[] args) {
		printGraph(new int[] {3,7,1,4}, '*');

	}

}
