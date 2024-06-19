package Family_tree.Presenter;

import Family_tree.Model.HumanModel;
import Family_tree.Model.Model;

import Family_tree.Model.Humans.Human;
import Family_tree.Model.Tree.Family_tree;
import Family_tree.View.ActionLevel;
import Family_tree.View.HumanView;


public class HumanPresenter extends Presenter {
    
    private Family_tree<Human> activeTree;
    private HumanView view;
    private ActionLevel level;
    private Human activeSubject;
    private Model model;


    public HumanPresenter(HumanView humanView){
        this.view = humanView;
        this.activeTree = null;
        this.level = ActionLevel.NoLevel;
        this.activeSubject = null;
        this.model = new HumanModel();        
        
    }




    public String setMarriage(int maleID, int femaleID){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectTree'");
    }

    public String delMarriage(int maleID, int femaleID){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectTree'");
    }

    @Override
    public String selectTree(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectTree'");
    }

    @Override
    public String setDeathDate(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDeathDate'");
    }

    @Override
    public String saveTree(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveTree'");
    }

    @Override
    public String addToTree(String name, String gender, String birhday) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToTree'");
    }

    @Override
    public String newChild(String name, String gender, String birhday, int IDFather, int IDMother) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'newChild'");
    }

    @Override
    public String searchByPattern(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByPattern'");
    }

    @Override
    public String createActiveTree(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createActiveTree'");
    }

    @Override
    public String loadTree(String text) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadTree'");
    }

    @Override
    public String showActiveSubjectInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showActiveSubjectInfo'");
    }

    @Override
    public String removeMember() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMember'");
    }

    @Override
    public String removeTree() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeTree'");
    }

    @Override
    public String showSubjectList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showSubjectList'");
    }

    @Override
    public String getTreeList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTreeList'");
    }

    @Override
    public Model getModel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getModel'");
    }

    @Override
    public void setModel(Model value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setModel'");
    }

    

}
