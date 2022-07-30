package semThree_assignment;

import java.util.*;

class Week3_Ayusha {

    int parent[];
    int rank[];

    Week3_Ayusha(int data) {
        parent = new int[data];
        rank = new int[data];
        for (int i = 0; i < data; i++)
        {
            parent[i] = -1;
            rank[i] = 1;
        }
    }

    // Utility function to find set of an element v using path compression technique
    int findOperation(int v) {

        // If v is the parent
        if (parent[v] == -1)
            return v;

        // Otherwise, recursively find its parent
        return parent[v] = findOperation(parent[v]);
    }

    // Function to perform union of the sets a and b
    void unionOperation(int a, int b) {

        // Find parent of a and b
        int parent1 = findOperation(a);
        int parent2 = findOperation(b);

        // If parent are different
        if (parent1 != parent2) {

            // Swap Operation
            if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1;
                rank[parent1] += rank[parent2];
            } 
            else {
                parent[parent1] = parent2;
                rank[parent2] += rank[parent1];
            }
        }
    }
}

class GFG {

    // Function to create a Minimum Cost Spanning tree for given houses
    static void MST(int houses[][], int data) {
        int result = 0;
        ArrayList<int[]> edges = new ArrayList<>();

        // Traverse each coordinate
        for (int i = 0; i < data; i++) {
            for (int j = i + 1; j < data; j++) {

                // Find the Manhattan distance
                int path = Math.abs(houses[i][0] -
                        houses[j][0]);

                path += Math.abs(houses[i][1] -
                        houses[j][1]);

                // Add the edges
                edges.add(new int[] { path, i, j });
            }
        }

        // Sorting arraylist using custome comparator
        // on the basis of weight i.e first element in
        // array object stored in Arraylist
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // Calling Week3 class
        Week3_Ayusha distance = new Week3_Ayusha(data);
        for (int i = 0; i < edges.size(); i++) {
            int from = edges.get(i)[1];
            int to = edges.get(i)[2];

            // Checking if they lie in different component
            // or not i.e they have same parent or not in
            // Week3
            if (distance.findOperation(from) != distance.findOperation(to)) {

                // Calling union_sets
            	distance.unionOperation(from, to);
                result += edges.get(i)[0];
            }
        }

        // Printing the minimum cost
        System.out.println("The minimum cost is " + result);
    }

    // Driver code
    public static void main(String args[]) //main method
    {
        // Graph in form of 2D array
        int houses[][] = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 4, 4 }, { 5, 2 }, { 7, 0 } };
        int data = houses.length;

        // Function Call
        MST(houses, data);
    }
}