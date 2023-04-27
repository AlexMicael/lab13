import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class lab13 {
	public ArrayList<Integer> list;

	public lab13() {
		list = new ArrayList<Integer>();
	}
	
	public void readData(String filename) {
		Path path = Paths.get(filename);
		try {
		    list = (ArrayList<Integer>) Files.lines(path)
		            .map(Integer::parseInt)
		            .collect(Collectors.toList());
		    System.out.println(list);
		} catch (IOException e) {
		    System.out.println("File Error");
		    e.printStackTrace();
		}

	}
	
	public long getTotalCount() {
		return list.stream()
				.count();
	}
	
	public long getOddCount() {
		return list.stream()
				.filter(i -> i % 2 != 0)
				.count();
	}
	
	public long getEvenCount() {
		return list.stream()
				.filter(i -> i % 2 == 0)
				.count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return list.stream()
				.filter(i -> i > 5)
				.distinct()
				.count();
	}
	
	public Integer[] getResult1() {
		return list.stream()
                .filter(i -> i > 5 && i < 50 && i % 2 == 0)
                .sorted()
                .toArray(Integer[]::new);
	}
	
	public Integer[] getResult2() {
		return list.stream()
				.mapToInt(i -> i * i * 3)
		        .limit(50)
		        .boxed()
		        .toArray(Integer[]::new);
	}
	
	public Integer[] getResult3() {
		return list.stream()
		        .filter(i -> i % 2 != 0)
		        .mapToInt(i -> i * 2)
		        .sorted()
		        .skip(20)
		        .distinct()
		        .boxed()
		        .toArray(Integer[]::new);
	}
}