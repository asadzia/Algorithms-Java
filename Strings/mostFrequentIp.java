// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Most Frequent IP!");
        
        String[] logs = {"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20", "10.0.0.2 - GET 2020-08-21"};
        System.out.println(findMostFrequentIP(logs)); 
        System.out.println(findMostFrequentAddress(logs)); 
    }
    
    public static String findMostFrequentAddress(String[] logs) {
        
        Map<String, Integer> mp = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        
        for (String s : logs) {
            
            String address = s.split(" ")[0];
            mp.put(address, mp.getOrDefault(address, 0) + 1);
        }
        
        int max = Collections.max(mp.values());
        
        for (String value : mp.keySet()) {
            if (mp.get(value) == max) {
                result.add(value);
            }
        }
        
        return String.join(",", result);
    }
