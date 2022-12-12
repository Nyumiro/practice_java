//Выполнить попарное суммирование произвольного конечного ряда чисел следующим образом:
// на первом этапе суммируются попарно рядом стоящие числа, на втором этапе суммируются результаты первого этапа и т.д.
// до тех пор, пока не останется одно число.

import java.util.LinkedList;
import java.util.List;

public class task_1 {
    static List<Integer> solution_1(List<Integer> collection){
        //Если суммируем по принципу: [1, 2, 3, 4] -> [3, 7] -> [10]
        while (collection.size() > 1){
            var new_list = new LinkedList<Integer>();
            for (var i = 0; i < collection.size()-1; i=i+2){
                new_list.add(collection.get(i) + collection.get(i+1));
            }
            if (collection.size() % 2 == 1)
                new_list.add(collection.get(collection.size()-1));
             collection = new_list;
        }
        return collection;
    }

    static List<Integer> solution_2(List<Integer> collection){
        // Если суммируем по принципу: [1, 2, 3, 4] -> [3, 5, 7] -> [8, 12] -> [20]
        while (collection.size() > 1){
            var new_list = new LinkedList<Integer>();
            for (var i = 0; i < collection.size()-1; i++){
                new_list.add(collection.get(i) + collection.get(i+1));
            }
            collection = new_list;
        }
        return collection;
    }
}
