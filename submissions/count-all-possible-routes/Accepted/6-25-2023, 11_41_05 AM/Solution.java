// https://leetcode.com/problems/count-all-possible-routes

class Solution {

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        HashMap<Integer, Integer> mem = new HashMap<Integer, Integer>();
        return countRoutesHelper(locations, start, finish, fuel, mem);
    }

    public int countRoutesHelper(int[] locations, int start, int finish, int fuel, HashMap<Integer, Integer> mem) {
        if(fuel < 0) return 0;

        int num = coordToNum(start, fuel);
        if(mem.getOrDefault(num, null) != null) {
            return mem.get(num); 
        }

        int routes = 0;
        if(start == finish) {
            routes++;
        }
        for(int i = 0; i < locations.length; i++) {
            if(i == start) continue;
            routes += countRoutesHelper(locations, i, finish, fuel - Math.abs(locations[start] - locations[i]), mem);
            routes %= 1e9 + 7;
        } 
        mem.put(num, routes);
        // System.out.println("" + start + " " + fuel + " " + routes);
        return routes;
    }

    public int coordToNum(int loc, int gas) {
        return loc * 201 + gas;
    }

    // public int[] numToCoord(int num) {
    //     int[] coord = {num / 201, num % 201};
    //     return coord;
    // }
}