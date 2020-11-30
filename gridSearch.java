static String gridSearch(String[] G, String[] P) {

               for (int i=0; i<G.length - P.length+1;i++){
                   for (int j=0; j<G[0].length() - P[0].length()+1;j++){
                       boolean found = true;
                           for (int x=0; x<P.length;x++){
                               for (int y=0; y<P[0].length();y++){
                                   if(G[i+x].charAt(j+y) != P[x].charAt(y)){
                                       found = false;
                                       break;
                                   }

                               }
                           }
                           if (found) return "YES";
                   }

               }
               return "NO";


           }
