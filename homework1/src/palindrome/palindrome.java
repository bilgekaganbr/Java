package palindrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class palindrome {

	public static void main(String[] args) 
	{
		List<Integer> numbers = new ArrayList<>();
		List<Integer> steps = new ArrayList<>();
		
		
		for (int i = 10; i <= 100; i++)
		{
			numbers.add(i);
			steps.add(steps(i));
		}
		int maximum_step = Collections.max(steps);
		String step = String.format("Maximum number of step: %d", maximum_step);
		System.out.println(step);
		
		int index_max_step = steps.indexOf(maximum_step);
		
		long number_maximum = numbers.get(index_max_step);
		String numb = String.format("Number that has maximum step: %d", number_maximum);
		System.out.println(numb);
		
		while (number_maximum != reverse(number_maximum))
		{
			String left = String.format("%d + %d = ", number_maximum, reverse(number_maximum));
			System.out.print(left);
			
			number_maximum += reverse(number_maximum);
			
			String right = String.format("%d", number_maximum);
			System.out.println(right);
			
		}
	}
	
	public static long reverse (long number)
	{
		List<Integer> digits = new ArrayList<>();
		long reverse_number = 0;
		
		while (number != 0)
		{
			int digit = (int) (number % 10);
			digits.add(digit);
			number /= 10;
		}
		for (int j = 0; j < digits.size(); j++)
		{
			reverse_number += digits.get(j) * Math.pow(10, digits.size() - 1 - j);
		}
		return reverse_number;
		
	}
	
	public static int steps(long number)
	{
		int step = 0;
		
		while (number != reverse(number))
		{	
			number += reverse(number);
			step++;
		}
		return step;
	}
	
	

}
