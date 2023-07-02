import java.util.*;
public class Hmap{
    public static ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> map= new HashMap<>();
        for(int i=0; i<arr.length; i++){
           if(map.containsKey(arr[i])){
            continue;
           }
           output.add(arr[i]);
           map.put(arr[i], true);
        }
        return output; 
    }



    public static int maxFrequencyNumber(int[] arr){ 
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array is null or empty.");
        }

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }
        // Find the number with the maximum frequency
        int maxFrequencyNum = arr[0];
        for (int num : arr) {
            if (frequencyMap.get(num) > frequencyMap.get(maxFrequencyNum)) {
                maxFrequencyNum = num;
            }
        }

        return maxFrequencyNum;
    }


    
    public static ArrayList<Integer> getIntersection(int[] arr1, int[] arr2) {
        ArrayList<Integer> intersectionList = new ArrayList<>();
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return intersectionList;
        }

        // Create a HashMap to store the frequency of each number in arr1
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr1) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }

        // Find the intersection of arr1 and arr2
        for (int num : arr2) {
            if (frequencyMap.containsKey(num)) {
                intersectionList.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
                if (frequencyMap.get(num) == 0) {
                    frequencyMap.remove(num);
                }
            }
        }

        return intersectionList;
    }
    


    public static void getIntersectionI(int[] arr1, int[] arr2) {
        ArrayList<Integer> intersectionList = new ArrayList<>();
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            System.out.print(intersectionList + " ");
        }

        HashSet<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        TreeSet<Integer> intersectionSet = new TreeSet<>();
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }

        intersectionList.addAll(intersectionSet);
        System.out.print(intersectionList + " ");
    }
    public static void intersection(int[] arr1, int[] arr2) {
	    if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return;
        }

        HashMap<Integer, Integer> freq1 = new HashMap<>();
        for (int num : arr1) {
            freq1.put(num, freq1.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> freq2 = new HashMap<>();
        for (int num : arr2) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int num : freq1.keySet()) {
            if (freq2.containsKey(num)) {
                int count = Math.min(freq1.get(num), freq2.get(num));
                for (int i = 0; i < count; i++) {
                    intersection.add(num);
                }
            }
        }

        intersection.sort(null);
        for (int num : intersection) {
            System.out.print(num + " ");
        }
	}
    public static int getPairsWithDifferenceK(int arr[], int k) {
        int n = arr.length;
       Map<Integer, Integer> map = new HashMap<>();
       int count = 0;
       for (int i = 0; i < n; i++) {
           map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
       }
       for (int i = 0; i < n; i++) {
           int x = arr[i] + k;
           if (map.containsKey(x)) {
               count += map.get(x);
           }
       }
       return count;
   }
   public static void main(String[] args) {
    int arr[]={4,4,4,4};
    HashMap<String,Integer> map = new HashMap<>();
//     {
//     //insert value in map 
//     map.put("Rahul", 1);
//     map.put("Rishikesh", 2);
//     map.put("Shivam", 3);
//     map.putIfAbsent("Amar", 4);
//     System.out.println(map);
//     //check key if key has then print it's value
//     if(map.containsKey("Rahul")){
//         System.out.println("Yes I have Rahul " +map.get("Rahul") );
//     }
//     System.out.println("-----------------------------");
//     // check map size
//     System.out.println(map.size());
//     System.out.println("-----------------------------");
//     //printing how many keys inserted in map
//     Set<String> keys = map.keySet();
//     for(String s:keys){
//         System.out.print(s + ", ");
//     }
//     System.out.println();

//     // using contains Value function
//     System.out.println(map.containsValue(1));
//     int[] arr1 = {6, 9, 8, 5};
//         int[] arr2 = {9, 2, 4, 1, 8};

//     ArrayList<Integer> output = removeDuplicates(arr1);
//     System.out.println(output);
//     System.out.println(maxFrequencyNumber(arr1));
//     getIntersectionI(arr1, arr2);
// }
    System.out.println(getPairsWithDifferenceK(arr, 0));
}
}
