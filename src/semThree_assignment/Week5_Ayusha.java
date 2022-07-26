package semThree_assignment;

public class Week5_Ayusha {
	    public static void checkSubset(String target, String[] set) {
	        String visited = "";

	        int ans = 0;

	        for (int i = 0; i < target.length(); i++) {
	            for (int j = 0; j < set.length; j++) {
	                for (int k = 0; k < set[j].length(); k++) {
	                    if (target.charAt(i) == set[j].charAt(k) && !visited.contains(target.charAt(i) + "")) {
	                        visited += target.charAt(i);

	                        if (ans <= j + 1) {
	                            ans++;
	                        }
	                    }
	                }
	            }
	        }
	        System.out.print("Output : ");

	        System.out.println(ans);
	    }

	    public static void main(String[] args) {
	        String target = "frog";
	        String[] set = { "programming", "For", "developers" };
	        checkSubset(target, set);
	    }
}

