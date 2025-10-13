import java.util.Scanner;
class Calculator{
	static Scanner sh=new Scanner(System.in);
public static void Addition(){
System.out.print("Enter a = ");
	
	int a = sh.nextInt();
	System.out.print("Enter b = ");
	int b = sh.nextInt();
	int sum=a+b;
	System.out.print(a+" + "+b+" = "+sum);
	return;
}
public static void Substraction(){
System.out.print("Enter a = ");
	
	int a = sh.nextInt();
	System.out.print("Enter b = ");
	int b = sh.nextInt();
	int sub;
	if(a>b)
		sub=a-b;
	else
		sub=b-a;
	System.out.print(a+" - "+b+" = "+sub);
	return;
}
public static void Multiplication(){
System.out.print("Enter a = ");
	
	int a = sh.nextInt();
	System.out.print("Enter b = ");
	int b = sh.nextInt();
	int mul=a*b;
	System.out.print(a+" * "+b+" = "+mul);
	return;
}
public static void division(){
System.out.print("Enter a = ");
	
	int a = sh.nextInt();
	System.out.print("Enter b = ");
	int b = sh.nextInt();
	if(b==0)
	{
		System.out.println("Please enter a number greater than 0");
		return ;
	}
	else{
		float div=a/b;
	System.out.print(a+" / "+b+" = "+div);
	return;
	
	}

}
public static void main(String[] args)
{
	
	
	
	
	System.out.println("Enter 1 for Addition");
	System.out.println("Enter 2 for Substraction");
	System.out.println("Enter 3 for Multiplication");
	System.out.println("Enter 4 for Division");	
	
	int option=sh.nextInt();
	
	if(option==1){
		Addition();		
	}else if(option ==2)
	{
		Substraction();
	}else if(option==3){
		Multiplication();
	}else if(option ==4){
		division();
	}
}		
}