import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOperators {
    public static <E> List<E> and(List<E>... multipleLists){
        if (multipleLists.length <= 0){
            return null;
        }

        var returnStream = multipleLists[0].parallelStream();

        ArrayList<List<E>> listArrayList = new ArrayList<>();
        for (int i = 1; i < multipleLists.length; i++){
            listArrayList.add(multipleLists[i]);
        }

        if (listArrayList.isEmpty()){
            return returnStream.distinct()
                    .collect(Collectors.toList());
        }else {
            for (var currentList : listArrayList) {
                returnStream = returnStream.distinct()
                        .filter(currentList::contains);
            }
            return returnStream.distinct()
                    .collect(Collectors.toList());
        }
    }

    public static <E> List<E> or (List<E>... multipleLists){
        if (multipleLists.length <= 0){
            return null;
        }else {
            ArrayList<Stream<E>> streamList = new ArrayList<>();

            for (var multipleList : multipleLists) {
                streamList.add(multipleList.stream());
            }
            return streamList
                    .parallelStream()
                    .flatMap(eStream -> eStream)
                    .distinct()
                    .collect(Collectors.toList());
        }
    }
}
