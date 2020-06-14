class DuplicateZeroesSolution {
    public void duplicateZeros(int[] arr) {
        int zeroes = 0;
        for (int i: arr) {
            if (i == 0) {
                zeroes++;
            }
        }
        int i = arr.length - 1, j = arr.length + zeroes - 1;
        
        while (i != j) {
            insert(arr, i, j--);
            if (arr[i] == 0) {
                insert(arr, i, j--);
            }
            i--;
        }
    }
    
    private void insert(int[] arr, int i, int j) {
        if (j < arr.length) {
            arr[j] = arr[i];
        }
    }
}