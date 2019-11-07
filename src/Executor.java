import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.sun.bean.Employee;
import org.sun.test.annotations.Validations;

public class Executor {

	public static void main(String[] args) 
	{
		Employee employee = new Employee(101);
		employee.setName("Sunil");
		employee.setLastName("");
		
		checkValidations(employee);
	}
	
	private static void checkValidations(Employee employee)
	{
		if(employee != null)
		{
			Class<? extends Employee> myclass = employee.getClass();
			
			int validatableMethods  = 0;
			int passed,failed,ignored =0;
			
			
			for(Method method : myclass.getDeclaredMethods())
			{
				Validations validation = method.getAnnotation(Validations.class);
				
				
				if(validation != null)
				{
					Type returnType = method.getGenericReturnType();
//					System.out.print(" ~ " +method.getName());
					
					validatableMethods++;
					System.out.print(" ~ Validation : '" + validation.name()+"' ");
					
					
					try {
							Object returnedValue =  method.invoke(employee);
						
							
							if(returnType == String.class)
							{
								testStringvalue((String)returnedValue, validation.required().value(), validation.minLength(), validation.maxLength());
							}
							else if(returnType == int.class)
							{
								testNumericvalue((int)returnedValue, validation.required().value(), validation.min(), validation.max());
							}
							else
							{
								testCustomvalue(returnedValue, validation);
							}
//							else
//							{
//								System.out.printf("This type '%s' of validation not supported yet " ,returnType);
//							}
							
							
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
					System.out.println();
					
				
				}
				
			}
			
			
		}
		else
		{
			System.out.println("Employee is not populated !!");
		}
		
	}
	
	
	private static void testStringvalue(String value,boolean required,int minlength,int maxLength)
	{
		if(required && (value == null || value.length() < minlength || value.length() > maxLength))
		{
			System.out.print(" ~~ failed @testStringvalue ~~ . Supplied value was : " + value);
		}
		else
		{
			System.out.print("~~ Passed !!");
		}
	}
	
	private static void testNumericvalue(int value,boolean required,int min,int max)
	{
		if(required && (value < min || value > max))
		{
			System.out.print(" ~~ failed @testNumericvalue ~~ . Supplied value was : " + value);
		}
		else
		{
			System.out.print("~~ Passed !!");
		}
	}
	
	private static void testCustomvalue(Object value,Validations validation)
	{
		if(validation.required().value() && (value == null))
		{
			System.out.print(" ~~ failed @testCustomvalue ~~ . Supplied value was : " + value);
		}
		else
		{
			System.out.print("~~ Passed !!");
		}
	}
	

}
