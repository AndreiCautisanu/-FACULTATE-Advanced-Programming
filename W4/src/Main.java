import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        var r = IntStream.rangeClosed(0, 3).mapToObj(i -> new Resident("R" + i)).toArray(Resident[]::new);
        List<Resident> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(r));

        Collections.sort(residentList, ((r1, r2) -> r1.getName().compareTo(r2.getName())));


        var h = IntStream.rangeClosed(0, 2).mapToObj(i -> new Hospital("H" + i)).toArray(Hospital[]::new);
        Set<Hospital> hospitalSet = new TreeSet<>();
        hospitalSet.addAll(Arrays.asList(h));

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        resPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
        resPrefMap.put(r[3], Arrays.asList(h[0], h[2]));

        Map<Hospital, List<Resident>> hosPrefMap = new TreeMap<>();
        hosPrefMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hosPrefMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hosPrefMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));

        for (Map.Entry<Resident, List<Hospital>> entry : resPrefMap.entrySet()) {
            System.out.println(entry.getKey().toString() + " : " + entry.getValue().toString());
        }

        for (Map.Entry<Hospital, List<Resident>> entry : hosPrefMap.entrySet()) {
            System.out.println(entry.getKey().toString() + " : " + entry.getValue().toString());
        }

        System.out.println("Residents who accept H0 and H2: ");
        List<Hospital> target = Arrays.asList(h[0], h[2]);
        residentList.stream().filter(res -> resPrefMap.get(res).containsAll(target)).forEach(System.out::println);

        System.out.println("Hospitals that have R0 as their top preference: ");
        hospitalSet.stream().filter(hos -> hosPrefMap.get(hos).get(0) == r[0]).forEach(System.out::println);

    }

}


