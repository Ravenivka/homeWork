package Family_tree.Humans;

import java.util.Comparator;

public class ComparatorByAge<T extends Endothermal> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {        
        return o1.getAge() - o2.getAge();
    }

}
