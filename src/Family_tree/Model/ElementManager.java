package Family_tree.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Humans.Gender;
import Family_tree.Model.Tree.Family_tree;

public abstract class ElementManager<T extends Endothermal> implements ElementManagment<T> { 

    private T activeElement;
    private Family_tree<T> activeTree;
    private String FormateDate = "d.MM.yyyy";
    //private TreeManager<T> treeManager;
    

    public ElementManager (/*TreeManager<T> treeManager*/){       
        this.activeElement = null;
        this.activeTree = null;
        //this.treeManager = treeManager;
    }

    abstract T newSubject(String name, Gender gender, LocalDate bd);

    private Gender strToGender(String value){
        if (value.equalsIgnoreCase("м")){
            return Gender.Male;
        } else if(value.equalsIgnoreCase("ж")){
            return Gender.Female;
        } else {
            return null;
        }
    }

    private LocalDate strToDate(String value){
        try{
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern(value);
            LocalDate d = LocalDate.parse(value, formatter);
            return d;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean addToTree(T subject) {
        if (activeTree == null){
            return false;
        }
        activeTree.add(subject);
        activeElement = subject;
        return true;
    }

    @Override
    public boolean newSubject(String name, String gender, String bd) {
        Gender sex = strToGender(gender);
        LocalDate birthDate = strToDate(bd);
        try{
            T subject = newSubject(name, sex, birthDate);
            this.activeElement = subject;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addToTree(T subject, Family_tree<T> tree) {
        try { 
            tree.add(subject);
            return true;
        }
         catch (Exception e)  {
            return false;
         }
    }

    @Override
    public boolean setActiveSubject(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setActiveSubject'");
    }

    @Override
    public boolean setActiveSubject(long innerID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setActiveSubject'");
    }

    @Override
    public boolean setActiveSubject(T subject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setActiveSubject'");
    }

    @Override
    public String searchSubject(String pattern) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSubject'");
    }

    @Override
    public String searchSubject(String pattern, Family_tree<T> tree) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSubject'");
    }

    @Override
    public String searchSubject(String pattern, long treeInnerID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSubject'");
    }

    @Override
    public String searchSubject(String pattern, int treeIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSubject'");
    }

    @Override
    public boolean setChild(T subject, T father, T mother) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setChild'");
    }

    @Override
    public boolean setChild(int subject, int father, int mother, Family_tree<T> tree) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setChild'");
    }

    @Override
    public boolean setChild(long subject, long father, long mother) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setChild'");
    }

    @Override
    public int getActiveSubjectIndex() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActiveSubjectIndex'");
    }

    @Override
    public long getActiveSubjectInnerID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActiveSubjectInnerID'");
    }

    @Override
    public String getInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInfo'");
    }    

}