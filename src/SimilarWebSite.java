import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SimilarWebSites{
    public static class Tuple{
        String website;
        int user;
        public Tuple(String w, int u) {
            this.website = w;
            this.user = u;
        }

        public String getWebsite() {
            return website;
        }

        public int getUser() {
            return user;
        }
    }
    public static List<String> greatestSim(List<Tuple> webUsers){
        HashMap<String , List<Integer>> mapWebUsers = new HashMap<>();
//       Map<String, List<Tuple>> list = new HashMap<>();
//       list = webUsers.stream().collect(Collectors.groupingBy(Tuple::getWebsite));
        for(Tuple tuple : webUsers){
            if(mapWebUsers.containsKey(tuple.website)){
                mapWebUsers.get(tuple.website).add(tuple.user);
            }
            else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(tuple.user);
                mapWebUsers.put(tuple.website, tmp);
            }
        }
        int similar = 0;
        String[] similarWeb = new String[2];
        for(String web1 : mapWebUsers.keySet()){
            for(String web2 : mapWebUsers.keySet()){
                if(web1.equals(web2)) continue;
                List<Integer> l1 = mapWebUsers.get(web1);
                List<Integer> l2 = mapWebUsers.get(web2);
                int tmpSimilar = 0;
                HashSet<Integer> set = new HashSet<>();
                for(int a : l1){
                    set.add(a);
                }
                for (int a : l2){
                    if(set.contains(a)){
                        tmpSimilar++;
                    }
                }
                if(similar < tmpSimilar){
                    similar = tmpSimilar;
                    similarWeb[0] = web1;
                    similarWeb[1] = web2;
                }
            }
        }
        return Arrays.asList(similarWeb);
    }

    public static void main(String[] args) {
        List<Tuple> tuples = new ArrayList<>();
        tuples.add(new Tuple("a", 1));
        tuples.add(new Tuple("a", 3));
        tuples.add(new Tuple("a", 5));
        tuples.add(new Tuple("b", 2));
        tuples.add(new Tuple("b", 6));
        tuples.add(new Tuple("c", 1));
        tuples.add(new Tuple("c", 2));
        tuples.add(new Tuple("c", 3));
        tuples.add(new Tuple("c", 4));
        tuples.add(new Tuple("c", 5));
        tuples.add(new Tuple("d", 4));
        tuples.add(new Tuple("d", 5));
        tuples.add(new Tuple("d", 6));
        tuples.add(new Tuple("d", 7));
        tuples.add(new Tuple("e", 1));
        tuples.add(new Tuple("e", 3));
        tuples.add(new Tuple("e", 5));
        tuples.add(new Tuple("e", 6));
        List<String> ls = greatestSim(tuples);
        for(String s: ls) {
            System.out.println(s);
        }
        String str = "ahbad";
        char[] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        str = Stream.of(str.split("")).sorted().collect(Collectors.joining());

        System.out.println(str);

    }
}