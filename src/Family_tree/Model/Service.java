package Family_tree.Model;

import java.util.List;
import Family_tree.Model.Tree.*;
import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Recorder.Recorder;


public abstract class Service<T extends Endothermal>  {

    public abstract List<Family_tree<T>> getTreeList();
    public Family_tree<T> getTree(int index){
        return getTreeList().get(index);
    };
    public Family_tree<T> setCurrentTree(int index){
        return getTreeList().get(index);
    };
    public void addTree(String name){
        getTreeList().add(new Family_tree<T>(name));
    };
    public Family_tree<T> getTree(String name){
        for (Family_tree<T> element : getTreeList()) {
            if (element.getFamily().equals(name)){
                return element;
            }
        }
        return null;
    }
    public abstract void setCurrentTree(Family_tree<T> tree);
    public boolean removeTree(int index){
        try{
            getTreeList().remove(index);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    };
    public abstract boolean newChild(T child, T father, T mother);
    public boolean saveTree(String path, int index){
        Family_tree<T> current = getTree(index);
        try{
            current.save(path);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public Family_tree<T> loadTree(String path){
        Recorder recorder = new Recorder();
        Object obj = recorder.read(path);
        @SuppressWarnings("unchecked")
        Family_tree<T> newtree = (Family_tree<T>) obj;
        boolean boo = true;
        for (Family_tree<T> element : getTreeList()) {
            if (newtree.getFamily().equals(element.getFamily())){
                element = newtree;
                boo = false;
            } 
        }
        if(boo){
            getTreeList().add(newtree);
        }
        return newtree;
    }



}
