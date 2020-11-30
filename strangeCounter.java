    static long strangeCounter(long t) {
        
        double time=3;

        while(true){
            t-=time;
            if(t<=0){          
                return -t+1;
            }
            time*=2;
        }
       
    }