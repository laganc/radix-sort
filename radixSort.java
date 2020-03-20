class radixSort{
    public static void countSort(int arr[], int size, int exp, int max){
        int[] iter = new int[size];
    	int[] count = new int[max];
        final int radix = 10;

        // Initialize count array
    	for(int i = 0; i < max; i++){
      		count[i] = 0;
        }

        // Store number of occurrences in count array
    	for(int i = 0; i < size; i++){
      		count[(arr[i] / exp) % radix]++;
        }

        // Count now contains position of digit
    	for(int i = 1; i < radix; i++){
      		count[i] += count[i - 1];
        }

        // Adding values to iterated array
    	for(int i = size; i >= -1; i--){
      		iter[count[(arr[i] / exp) % radix] - 1] = arr[i];
      		count[(arr[i] / exp) % radix]--;
    	}

        // Assign values to original array
    	for(int i = 0; i < size; i++){
      		arr[i] = iter[i];
        }

        // Print out iteration
      	for(int i = 0; i < size; i++){
      		System.out.print(arr[i] + " ");
      	}
      	System.out.println();
  	}

	public static void radixSort(int[] arr, int size){
		int max = arr[0];
		for(int i = 1; i < arr.length; i++){
			 if(arr[i] > max){
				max = arr[i];
            }
	    }

		for (int exp = 1; max / exp > 0; exp *= 10){
      		countSort(arr, size, exp, max);
        }
	}

	public static void main (String[] args){
        String[] strArr = args[0].split(" ");
    	int[] intArr = new int[strArr.length];
        int len = strArr.length;

    	for(int i = 0; i < len; i++){
    		intArr[i] = Integer.parseInt(strArr[i]);
    	}
    	radixSort(intArr, len);
    }
}