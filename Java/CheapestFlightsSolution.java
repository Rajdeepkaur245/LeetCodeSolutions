class CheapestFlightsSolution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int[] f : flights) {
            map.computeIfAbsent(f[0], x -> new HashMap<>()).put(f[1], f[2]);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] {src, 0, K+1});
        
        while (!pq.isEmpty()) {
            int[] current = pq.remove();
            int city = current[0], price = current[1], stops = current[2];
            if (city == dst) {
                return price;
            }
            if (stops > 0) {
                Map<Integer, Integer> adj = map.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[] {a, price + adj.get(a), stops - 1});
                }
            }
        }
        return -1;
    }
}