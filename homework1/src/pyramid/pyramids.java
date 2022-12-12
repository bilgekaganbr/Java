package pyramid;

public class pyramids {

	public static void main(String[] args) 
	{
		left_aligned(8);
		right_aligned(8);
	}
	
	public static void left_aligned(int height)
	{
		for (int i = 1; i <= height; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void right_aligned(int height)
	{
		for (int i = 1; i <= height; i++)
		{
			for (int j = 1; j <= height - i; j++)
			{
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
