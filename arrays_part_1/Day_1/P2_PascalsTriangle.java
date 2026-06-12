package arrays_part_1.Day_1;

import java.util.ArrayList;
import java.util.List;

public class P2_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascal = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        pascal.add(list);

        for(int i=1; i<numRows; i++){
            List<Integer> al = new ArrayList<>();
            al.add(1);

            for(int j=1; j<i; j++){
                int value = pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j);
                al.add(value);
            }

            al.add(1);
            pascal.add(al);
        }
        return pascal;
    }
}
