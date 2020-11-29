static int sockMerchant(int n, int[] ar) {
        Hashtable<Integer, Integer> mypairs = new Hashtable<Integer, Integer>();

        for(int s : ar){           
            if (mypairs.get(s)==null){
                mypairs.put(s,1);
            }
            else{
                mypairs.put(s,mypairs.get(s)+1);
            }
        }
        int count=0;
        for(int s : mypairs.keySet()){
            count+=mypairs.get(s)/2; 

        }
        return count;
    
S