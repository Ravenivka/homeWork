package Family_tree.Humans;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;



public class Human implements Endothermal{
    private long innerID;
    private String  name;    
    private Human mother, father;
    private Set<Human> children;
    private LocalDate birthDate, deathDate;
    private Set<Link> links;
    private Vital vital;
    private Gender gender;
    private Human spouse;
    private boolean isInFamily;
    private Set<String> names;
    private int famID;
    private long nameValue;
    
   
    public Human (String name, Gender gender, LocalDate birthDate, Human father, Human mother){
        Instant instant = Instant.now();       
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father; 
        nameValue = 0;
        char[] chars = name.toCharArray();
        for (char iterable_element : chars) {
            nameValue = nameValue + (long) iterable_element;
        }
        this.innerID = instant.toEpochMilli() + nameValue;
    }

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {        
        this(name, gender, birthDate,  father, mother);       
        this.children = new HashSet<>() ;
        this.birthDate = birthDate;
        this.deathDate = deathDate;    
        this.links = new HashSet<>() ;        
        if (deathDate != null){
            this.vital = Vital.dead; 
        } else {
            this.vital = Vital.alive;
        }
        names = new HashSet<String>();
        this.famID = -1;
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate,  null,  null,  null); 
    }
    public Human getMother(){
        return this.mother;
    }
    public void setMother(Human value){
        if (value.gender == Gender.Female){
            this.mother = value;
        } 
    }
    public Human getFather(){
        return this.father;
    }
    public void setFather(Human value){
        if (value.gender == Gender.Male){
            this.father = value;
        } 
    }

    public int getAge(){
        if (birthDate == null){
            return -1;
        }
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now()); 
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){ 
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }
    public void setSpouse(Human spouse) {                
        if (this.gender == spouse.gender){
            this.spouse = null;           
        } else {            
            this.spouse = spouse; 
            boolean flag = false;
            for (Link iterable_element : links) {
                if (spouse.equals(iterable_element.getMale()) || spouse.equals(iterable_element.getFemale())){ //может по ID надёжней?
                    flag = true;
                }
            }
            if (flag == false){
                Link link; 
                if (spouse.gender == Gender.Female){
                    link = new Link(LinkType.Married, this, spouse);
                }else{
                    link = new Link(LinkType.Married, spouse, this);
                }
                links.add(link);
            }            
        }       
                       
    }         
   
    public Human getSpouse(){ return this.spouse; }

    public Set<Human> getChildren() { return children; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setDeathDate(LocalDate deathDate) { 
        if (deathDate == null){
            this.vital = Vital.alive;
        }else{
            this.vital = Vital.dead;
        }
        this.deathDate = deathDate; 
    }
    public Gender getGender(){ return gender; }
    public Vital getVital(){return this.vital;}
    public void setVital (Vital value){ this.vital = value;}

    @Override 
    public String toString(){
        return "name = " + name ;
    }    
    public String getName(){return this.name;}

    public String getlnfo(){
        StringBuilder sb = new StringBuilder(); 
        sb.append("ld: ");
        sb.append(famID); 
        sb.append(", имя: "); 
        sb.append(name);
        sb.append(", non: "); 
        sb.append(getGender()); 
        sb.append(", возраст: ");
        sb.append(getAge()); 
        sb.append(", ");
        sb.append(getSpouselnfo()); 
        sb.append(", ");
        sb.append(getMotherlnfo());
        sb.append(", ");
        sb.append(getFatherlnfo()); 
        sb.append(", ");
        sb. append(getChildrenlnfo()); 
        return sb.toString();
    }

    public String getSpouselnfo(){
         String res = "cynpyr(a): ";
         if (spouse == null){ 
            res += "нет";
        } else { 
            res += spouse.getName();
        }
        return res;
    }
    public String getMotherlnfo(){ 
        String res = "мать: ";
        Human human = getMother(); 
        if (human != null){
            res += human.getName() ;
        } else {
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherlnfo(){ 
        String res = "отец: ";
        Human human = getFather(); 
        if (human != null){
            res += human.getName() ;
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenlnfo(){
        StringBuilder sb = new StringBuilder(); 
        for (Human human : children) {
            sb.append(human);
            sb.append(", мать: ");
            sb.append(human.getMother().getName());
            sb.append(", отец: ");
            sb.append(human.getFather().getName());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String showLinks(){
        StringBuilder sb = new StringBuilder();
        sb.append("Связи: ");
        sb.append("\n");
        for (Link element : links) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();

    }

    public boolean inFamily(){
        return this.isInFamily;
    }
    public void setInFamilyStatus(boolean value){
        this.isInFamily = value;
    }

    public Set<Link> getLinks(){
        return this.links;
    }

    public void changeName(String value){
        this.names.add(this.name);
        this.name = value;
    }

    public void setFamilyID( int value){
        this.famID = value;
    }
    public int getFamilyID(){
        return this.famID;
    }
    public long getInnerID(){return this.innerID;}
    public void setInnerID(long id){this.innerID = id;} 
       
    public boolean addChild(Human child) {
        if (children.contains(child)){
            return false;
        } else {
            children.add(child);
            return true;
        }
    }

    @Override
    public int compareTo(Endothermal o) {
        return Long.compare(this.innerID, o.getInnerID());
       
    }
   
}
