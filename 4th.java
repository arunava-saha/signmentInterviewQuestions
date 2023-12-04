import java.util.function.Function;
// Java program to find maximum amount of water that can 
// be trapped within given set of bars. 

class Test { 
	static int arr[] 
		= new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; 
	static int findWater(int n) 
	{ 
		int left[] = new int[n]; 
		int right[] = new int[n]; 
		int TotalWater = 0; 
		left[0] = arr[0]; 
		for (int i = 1; i < n; i++) 
			left[i] = Math.max(left[i - 1], arr[i]); 
		right[n - 1] = arr[n - 1]; 
		for (int i = n - 2; i >= 0; i--) 
			right[i] = Math.max(right[i + 1], arr[i]); 
		for (int i = 0; i < n; i++) 
			TotalWater += Math.min(left[i], right[i]) - arr[i]; 

		return TotalWater; 
	} 

    static double smallIncrement = 0.001; // Width of each segment

    static double trapWaterVolume(Function<Double, Double> profileFunction, double start, double end) {
        double TotalWater = 0.0;
        double groundLevel = 0.0;

        for (double x = start; x <= end; x += smallIncrement) {
            double barHeight = profileFunction.apply(x);
            double trappedHeight = Math.max(0, barHeight - groundLevel);
            TotalWater += trappedHeight * smallIncrement;
        }

        return TotalWater;
    }

    public static void main(String[] args) {
        // Test cases as discrete
		System.out.println("TotalWater: " + findWater(arr.length)); 

        // Test cases as analog
        // Test case 1: Linear equation
        Function<Double, Double> linearProfile = x -> 2 * x; // Example: y = 2x
        double linearResult = trapWaterVolume(linearProfile, 0, 5);
        System.out.println("Trapped Water (Linear): " + linearResult);

        // Test case 2: Quadratic equation
        Function<Double, Double> quadraticProfile = x -> -(x - 2) * (x - 4) + 5; // Example: y = -(x-2)(x-4) + 5
        double quadraticResult = trapWaterVolume(quadraticProfile, 1, 5);
        System.out.println("Trapped Water (Quadratic): " + quadraticResult);

    }
}