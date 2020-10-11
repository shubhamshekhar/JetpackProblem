class Jetpack {

	private static boolean validateData(int number_of_compartments, int[] threshold, int compartment_with_thesis){
		if(compartment_with_thesis < 1) 
			return false;
		if(threshold.length!=number_of_compartments)
			return false;
		if(compartment_with_thesis>number_of_compartments)
			return false;
		return true; 
	}

	private static void instructionToPassArgument(){
		System.out.println("* Invalid command line argument passed. Please pass valid values as a command line argument");
		System.out.println("\t* Example: If you need to pass number of compartment as 5 and \n\tthreshold value of each of the compartment as 2,3,1,1,3 and \n\tcompartment number with thesis as 5, \n\tthen pass command line argument as following:");
		System.out.println("\tjava Jetpack 5 {2,3,1,1,3} 5 \n\tor \n\tjava Jetpack 5 2 3 1 1 3 5");
	}

	private static int minHops(int number_of_compartments, int[] threshold, int compartment_with_thesis) { 
		int hops[] = new int[compartment_with_thesis]; 

		hops[0] = 0; 

		for (int i = 1; i < compartment_with_thesis; i++) { 
			hops[i] = number_of_compartments; 
			for (int j = 0; j < i; j++) { 
				if (i <= j + threshold[j] && hops[j] != number_of_compartments) { 
					hops[i] = Math.min(hops[i], hops[j] + 1); 
					break; 
				} 
			} 
		} 
		return hops[compartment_with_thesis - 1]; 
	} 

	public static void main(String[] args) { 
		try{
			int number_of_compartments = Integer.parseInt(args[0]);
			int compartment_with_thesis = Integer.parseInt(args[args.length-1]);
			int[] threshold = new int[args.length-2];
			for(int i=1;i<args.length-1;i++){
				threshold[i-1] = Integer.parseInt(args[i]);
			}
			if(validateData(number_of_compartments, threshold, compartment_with_thesis))
				System.out.println("Minimum number of hops to reach the compartment with thesis is : " + minHops(number_of_compartments, threshold, compartment_with_thesis)); 
			else{
				instructionToPassArgument();
			}
		}
		catch(ArrayIndexOutOfBoundsException aiob){
			instructionToPassArgument();
		}
		catch(NumberFormatException nfe){
			System.out.println("Minimum number of hops to reach the compartment with thesis is : 0"); 
		}
				
		
	} 
} 

