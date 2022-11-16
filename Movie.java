import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Movie{
	private int id;
	private int numOfViews;
	private double rating;
	private int releaseYear;
	private String movieName;

	public Movie(){
		id = 0;
		numOfViews = 0;
		rating = 0.0;
		releaseYear = 0;
		movieName = null;
	}

	public Movie(int id, String movieName, int releaseYear, double rating, int numOfViews){
		this.id = id;
		this.numOfViews = numOfViews;
		this.rating = rating;
		this.releaseYear = releaseYear;
		this.movieName = movieName;
	}

	// Accessors and mutators
	public void setMovie(int id, String movieName, int releaseYear, double rating, int numOfViews){
		this.id = id;
		this.numOfViews = numOfViews;
		this.rating = rating;
		this.releaseYear = releaseYear;
		this.movieName = movieName;
	}

	public int getReleaseYear(){
		return releaseYear;
	}

	public double getRating(){
		return rating;
	}

	public ArrayList<Movie> readData(ArrayList<Movie> list){
		String delimiter = ",";
		String data[];
		String currentLine;

		try{
			FileReader file = new FileReader("movies.txt");
			BufferedReader br = new BufferedReader(file);
			while ((currentLine = br.readLine()) != null){
				data = currentLine.split(delimiter);
				list.add(new Movie(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]),
					Double.parseDouble(data[3]), Integer.parseInt(data[4])));
			}
			return list;
		}
		catch (Exception e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();;
    	}
    	return list;
	}

	public Movie[] readData(Movie[] array){
		String delimiter = ",";
		String data[];
		String currentLine;

		try{
			FileReader file = new FileReader("movies.txt");
			BufferedReader br = new BufferedReader(file);
			int i = 0;
			while ((currentLine = br.readLine()) != null){
				data = currentLine.split(delimiter);
				array[i] = new Movie(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]),
					Double.parseDouble(data[3]), Integer.parseInt(data[4]));
				i++;
			}
		}
		catch (Exception e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();;
    	}
    	return array;
	}

	public void quickSort(Movie[] array, int lowIndex, int highIndex){
		if(lowIndex >= highIndex){
			return;
		}
		double pivot = array[highIndex].getRating();
		int leftPointer = lowIndex;
		int rightPointer = highIndex;

		while(leftPointer < rightPointer){
			while(array[leftPointer].getRating() <= pivot && leftPointer < rightPointer)
				leftPointer++;
			while (array[rightPointer].getRating() >= pivot && leftPointer < rightPointer)
				rightPointer--;
			swap(array,leftPointer,rightPointer);
		}
		swap(array, leftPointer, highIndex);

		quickSort(array,lowIndex,leftPointer - 1);
		quickSort(array, leftPointer + 1, highIndex);
	}

	public void swap(Movie[] array, int index1, int index2){
		Movie temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public int movieComparatorYear(Movie[] array, int index1, int index2){
		if(array[index1].getReleaseYear() > array[index2].getReleaseYear())
			return 0;
		return 1;
	}

	public int movieComparatorRating(Movie[] array, int index1, int index2){
		if(array[index1].getRating() > array[index2].getRating())
			return 0;
		return 1;
	}

	public String toString(){
		return id + "." + "Movie: " + movieName + " Release Date: " + releaseYear
				+ " Views: " + numOfViews + " Rating: " + rating;
	}
}