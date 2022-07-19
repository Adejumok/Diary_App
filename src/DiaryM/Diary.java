package DiaryM;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String name;
    private int id;
    private ArrayList<Entry> theEntries= new ArrayList<>();
    public Diary(String name){
        this.name=name;
    }

    public void setName(String name){
        this.name= name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return String.format("""
                Name: %s
                """, name);
    }

    public void addEntry(Entry entry) {
        if (theEntries.contains(entry)){
            throw new RuntimeException("Huush! Entry already exist");
        }else {
            theEntries.add(entry);
        }
    }

    public int getEntriesSize() {
        return theEntries.size();
    }

    public Entry getEntry(int id) {
        return theEntries.get(id-1);
    }
    
    private int isEntryExist(String entryTitle){
        for (int entry=0;entry< theEntries.size();entry++) {
            Entry theEntry=theEntries.get(entry);
            if (theEntry.getTitle().equalsIgnoreCase(entryTitle)){
                return entry;
            }
        }
        return -1;
    }

    public void editEntry(String entryTitle,Entry newEntry) {
        int position=isEntryExist(entryTitle);
        if (position>=0){
            theEntries.set(position,newEntry);
        }
        else{
        System.out.println("This entry does not exist!");}
    }

    public void deleteEntry(String entryTitle) {
        int position=isEntryExist(entryTitle);
        if (position>=0){
            theEntries.remove(position);
        }
        else{
        System.out.println("This entry does not exist!");}
    }
    public List<Entry> printAllEntries() {
        if (theEntries.isEmpty()){
            System.out.println("There is no entry in this diary!");
        }
        return theEntries;
    }
}
