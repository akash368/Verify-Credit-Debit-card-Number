import java.util.*;
class generateCardNumber    // used to verify credit card numbers by LUHN ALGORITHM
{
	public static void main(String args[])
	{
		System.out.print("How many Credit/Debit Card number you want:");
		Scanner sc = new Scanner(System.in);
		int z = sc.nextInt();
		while(z>0)
		{
			long min = 1000000000000000L;
			long max = 9999999999999999L;
			long ran = (long)(Math.random()*(max-min+1)+min);
			//System.out.println("r"+ran);
			
			//System.out.print("Enter the card number for verification:");
			String num = String.valueOf(ran);
			int evenResult=0;
			for(int i=num.length()-2;i>=0;i=i-2)
			{
				int numOne = Character.getNumericValue(num.charAt(i));
				int res = numOne*2;
				//evenResult = evenResult+(numOne*2);
				if(res>9)
				{
					int sum=0;
					while(res>0)
					{
						int r = res%10;
						sum = sum + r;
						res=res/10;
					}
					evenResult=evenResult + sum;
				}
				else
				{
					evenResult =evenResult + res;
				}
				//System.out.println(numOne+" "+evenResult);
			}
			for(int i=num.length()-1;i>=0;i=i-2)
			{
				int numTwo = Character.getNumericValue(num.charAt(i));
				evenResult = evenResult+numTwo;
				//System.out.println(numTwo+" "+evenResult);
			}
			if(evenResult%10==0)
			{
				int master=Character.getNumericValue(num.charAt(0));
				//System.out.println(master);
				if(master==3 || master==5)
				{
					System.out.println("16 Digit Master Credit/Debit card number:"+num);
					z--;
				}
				else if(master==4)
				{
					System.out.println("16 Digit Visa Credit/Debit card number:"+num);
					z--;
				}
				
				
			}
			
			
		}
		System.out.println("**********These Card number is verified by Luhn's Algorithm**********");
		
		
		
		
	}

}