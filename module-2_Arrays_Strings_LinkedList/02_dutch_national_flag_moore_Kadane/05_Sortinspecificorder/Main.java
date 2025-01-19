class Solution {
    private void merge(Long[] arr, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        
        Long[] left = new Long[n1];
        Long[] right = new Long[n2];
        
        for(int i=0;i<n1;i++) {
            left[i] = arr[i+l];
        }
        
        for(int j=0;j<n2;j++) {
            right[j] = arr[m+1+j];
        }
        
        int k = l;
        int i=0, j=0;
        while(i < n1 && j < n2) {
            if(left[i] % 2 != 0 && right[j] % 2 != 0) {
                if(left[i] < right[j]) 
                    arr[k++] = right[j++];
                else 
                    arr[k++] = left[i++];
            } else if(left[i] % 2 == 0 && right[j] % 2 == 0) {
                if(left[i] < right[j]) 
                    arr[k++] = left[i++];
                else 
                    arr[k++] = right[j++];
            } else {
                if(left[i] % 2 != 0)
                    arr[k++] = left[i++];
                else
                    arr[k++] = right[j++];
            }
        }
        
        while(i < n1) {
            arr[k++] = left[i++];
        }
        
        while(j < n2) {
            arr[k++] = right[j++];
        }
        
    }
    
    private void mergeSort(Long[] arr, int l, int r) {
        if(l < r) {
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
            
        }
    }
    
    public void sortIt(Long arr[]) {
       mergeSort(arr, 0, arr.length-1);
    }
}