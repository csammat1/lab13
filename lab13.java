import java.util.ArrayList;
import java.util.stream.Stream;

public class lab13 
{
	public java.util.ArrayList<Integer> myList = new java.util.ArrayList<Integer>();
	
	public void readData(String filename)
	{
		try {
			String inn;	
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			while((inn = input.readLine()) != null)
			{
				
				myList.add(Integer.parseInt(inn.trim()));
			}
			input.close();
		}
		
		catch(Exception e){
			
		}
		
	}
	
	public long getTotalCount()
	{
		
		return myList.stream().count();
	}
	
	public long getOddCount()
	{
		
		return myList.stream().filter(n -> n % 2 == 1).count();
	}
	
	public long getEvenCount()
	{
		return myList.stream().filter(n -> n % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		
		return myList.stream().distinct().filter(n -> n > 5).count();
	}
	
	public Integer[] getResult1()
	{
		return (Integer[]) myList.stream().filter(n -> n % 2 == 0).filter(n -> n > 5).filter(n -> n < 50).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		return (Integer[]) myList.stream().limit(50).map(n -> n * n).map(n -> 3*n).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3()
	{
		return (Integer[]) myList.stream().filter(n -> n % 2 == 1).map(n -> n*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}
