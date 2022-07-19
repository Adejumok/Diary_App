package DiaryM;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;

    ArrayList <Diary> theDiaries = new ArrayList<>();

    public User(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createDiary(Diary diary) {
        int position=isExistDiary(diary.getName());
        if (position>=0){
            System.out.println("Come on.... Diary already exist");
        }
        theDiaries.add(diary);
    }

    public List<Entry> viewDiary(String diaryName) {
        int position=isExistDiary(diaryName);
        if (position>=0){
            return (theDiaries.get(position).printAllEntries());

        }
        throw new DiaryDoesNotExistException("Oops! This diary doesn't exist");

    }

    private int isExistDiary(String diaryName){
        for (int diary=0; diary< theDiaries.size();diary++){
            Diary diaryToLocate=theDiaries.get(diary);
            if (diaryToLocate.getName().equalsIgnoreCase(diaryName)){
                return diary;
            }
        }
        return -1;
    }

    public List<Diary> viewAllDiaries() {
        return theDiaries;
    }

    public int getNumberOfDiaries() {
        return theDiaries.size();
    }

    public void editDiary(String oldDiaryName, Diary newDiary) {
        int position = isExistDiary(oldDiaryName);
        if (position >= 0) {
            theDiaries.set(position,newDiary);
        }
        else{
        System.out.println("This diary does not exist");}
    }


    public void deleteDiary(String diaryName) {
        int position=isExistDiary(diaryName);
        if (position>=0){
            theDiaries.remove(position);
            System.out.println("Diary with the name '"+diaryName+"' deleted");
        }
        else {
            throw new DiaryDoesNotExistException("This diary does not exist");
        }
    }

}
