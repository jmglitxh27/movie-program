import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class TestMovie{
	public static void main(String[] args){
		Movie object1 = new Movie();
		Movie object2 = new Movie();
		ArrayList<Movie> list = new ArrayList<>();
		Movie[] array = new Movie[100];
		array = object1.readData(array);
		System.out.println(object1.movieComparatorRating(array, 1, 6));
		object1.quickSort(array, 0, array.length - 1);
		for(Movie movie : array)
			System.out.println(movie.toString());
		list = object2.readData(list);
	}
}