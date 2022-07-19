package DiaryM;

import java.util.Scanner;

public class UserInterface {
    private static Scanner input = new Scanner(System.in);
    private static int userInput;
    private static String prompt;
    private static User user = new User();
    private static Diary diary=new Diary("Diary Name");
    private static Entry entry;


    public static void main(String[] args) {
        userLogin();

        boolean exit = false;
        while (!exit) {
            userMenu();
            System.out.println("Kindly enter a number: ");
            userInput = input.nextInt();
            input.nextLine();

            switch (userInput) {
                case 1 -> createDiary();
                case 2 -> viewDiary();
                case 3 -> viewAllDiaries();
                case 4 -> editDiary();
                case 5 -> deleteDiary();
                case 6 -> exit = true;
            }
        }

    }

    private static void userLogin(){
        System.out.println("*** W E L C O M E ***");
        System.out.println("Enter your name: ");
        String username=input.nextLine();
        user.setName(username);
        System.out.println("Logging in "+user.getName()+"....");
    }

    private static void userMenu() {
        prompt = """
                     M E N U
                =====================
                1. Create Diary
                2. View Diary
                3. View All Diaries
                4. Edit Details of a Diary
                5. Delete a Diary
                6. Exit
                =====================
                """;
        System.out.println(prompt);

    }

    private static void diaryMenu() {
        prompt = """
                 D I A R Y  M E N U
                =====================
                1. Add Entry
                2. View Entry
                3. View All Entries
                4. Edit Details of an Entry
                5. Delete an Entry
                6. Back to Main Menu
                =====================
                """;
        System.out.println(prompt);

    }
    private static void createDiary() {

        System.out.println("Enter your diary name: ");
        String diaryName=input.nextLine();
        diary.setName(diaryName);
        diary=new Diary(diaryName);
        user.createDiary(diary);

        diaryModification();

    }

    private static void diaryModification(){
        boolean mainMenu=false;
        while (!mainMenu){
            diaryMenu();

            System.out.println("Kindly enter a number: ");
            userInput=input.nextInt();
            input.nextLine();

            switch (userInput){
                case 1 -> addEntry();
                case 2 -> viewEntry();
                case 3 -> viewAllEntries();
                case 4 -> editEntry();
                case 5 -> deleteEntry();
                case 6 -> mainMenu=true;
            }
        }
    }


    private static void deleteEntry() {
        System.out.println("Enter your entry title: ");
        String entryTitle = input.nextLine();
        diary.deleteEntry(entryTitle);
        System.out.println("Entry with "+entryTitle+" title is now deleted.");
    }

    private static void editEntry() {
        System.out.println("Enter the entry title: ");
        String oldEntryTitle = input.nextLine();

        System.out.println("Enter new entry title: ");
        String entryTitle = input.nextLine();
        entry.setTitle(entryTitle);

        System.out.print("Do you want to edit the body as well? Enter letter B if you don't want to:");
        String editBody=input.nextLine();

        if (!editBody.equalsIgnoreCase("b")){
            System.out.println("Enter new entry body: ");
            String entryBody = input.nextLine();
            entry.setBody(entryBody);
        }

        diary.editEntry(oldEntryTitle,entry);
        System.out.println("Entry with "+oldEntryTitle+" title is now \n"+entry);
    }

    private static void viewAllEntries() {
        System.out.println(diary.printAllEntries());
    }

    private static void viewEntry() {
        System.out.println("Enter your entry id: ");
        int entryId = input.nextInt();
        System.out.println(diary.getEntry(entryId));
    }

    private static void addEntry(){
        System.out.println("Enter your entry id: ");
        int entryId = input.nextInt();
        input.nextLine();
        System.out.println("Enter your entry title: ");
        String entryTitle = input.nextLine();
        System.out.println("Enter your entry body: ");
        String entryBody = input.nextLine();
        entry = new Entry(entryId, entryTitle, entryBody);
        System.out.println("Entry " + entry);
        diary.addEntry(entry);
    }

    
    private static void viewDiary() {
        System.out.println("Enter your diary name: ");
        String diaryName = input.nextLine();
        System.out.println(user.viewDiary(diaryName));
    }

    private static void viewAllDiaries() {
        System.out.println(diary.printAllEntries());
    }

    private static void editDiary() {
        System.out.println("Enter the diary name: ");
        String diaryName = input.nextLine();
        System.out.println("Enter the new diary name: ");
        String newDiaryName = input.nextLine();
        diary.setName(newDiaryName);
        user.editDiary(diaryName,diary);
        diaryModification();
    }

    private static void deleteDiary() {
        System.out.println("Enter the diary name: ");
        String diaryName = input.nextLine();
        user.deleteDiary(diaryName);
    }
}
