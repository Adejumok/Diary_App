package DiaryMTest;

import DiaryM.Diary;
import DiaryM.Entry;
import DiaryM.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDiaryETest {
    User DotunU;
    Diary Work;
    Diary Love;
    Entry FirstDay;
    Entry Breakfast;
    Entry Matter;


    @BeforeEach
    void setUp() {
        DotunU = new User();
        Work = new Diary("Work");
        Love = new Diary("Love");
        FirstDay = new Entry(1, "First Day in Semicolon", "The story goes thus...");
        Breakfast = new Entry(2, "Who is Suppose to Serve Breakfast", "The story goes thus...");
        Matter = new Entry(3, "Emi lo kan", "The story goes thus...");

    }

    @Test
    void userExistTest() {
        assertNotNull(DotunU);
    }


    @Test
    void testThatUserCanGetTheNumberOfDiaries() {
        DotunU.createDiary(Work);
        DotunU.createDiary(Love);

        System.out.println(Work);
        assertEquals(2, DotunU.getNumberOfDiaries());
    }

    @Test
    void userCanEditDiaryDetailsTest() {
        DotunU.createDiary(Work);
        assertEquals(Work, DotunU.viewDiary("Work"));
    }


    @Test
    void testThatUserCanDeleteDiaries() {
        DotunU.createDiary(Work);
        DotunU.createDiary(Love);
        DotunU.deleteDiary("Love");
        System.out.println(DotunU.viewDiary("Work"));
        assertEquals(1, DotunU.getNumberOfDiaries());
    }

    @Test
    void testThatUserCanViewDiaries() {
        DotunU.createDiary(Work);
        DotunU.createDiary(Love);
        System.out.println(DotunU.viewAllDiaries());
    }

    @Test
    void testThatUserCanEditDiary() {
        DotunU.createDiary(Work);
        DotunU.editDiary("Work",Love);
        System.out.println(DotunU.viewAllDiaries());
    }

    @Test
    void diaryCanAddEntryTest() {
        Work.addEntry(FirstDay);
        assertEquals(1, Work.getEntriesSize());
    }


    @Test
    void diaryCanGetSingleEntryTest() {
        Work.addEntry(FirstDay);
        Work.addEntry(Breakfast);

        assertEquals(FirstDay, Work.getEntry(1));
    }


    @Test
    void diaryCanGetAllEntriesTest() {
        Work.addEntry(FirstDay);
        Work.addEntry(Breakfast);
        System.out.println(FirstDay);
        System.out.println(Breakfast);
        assertEquals(2, Work.getEntriesSize());
    }


    @Test
    void diaryCanEditEntryTest() {
        Work.addEntry(Breakfast);
        Work.editEntry("Who is Suppose to Serve Breakfast",FirstDay);
        assertEquals("First Day in Semicolon", FirstDay.getTitle());
    }

    @Test
    void diaryCanDeleteEntryTest(){
        Work.addEntry(Breakfast);
        Work.addEntry(FirstDay);
        Work.deleteEntry("First Day in Semicolon");
        assertEquals(1, Work.getEntriesSize());
    }

    @Test
    void diaryCanPrintAllEntriesTest() {
        Work.addEntry(FirstDay);
        Work.addEntry(Breakfast);
        List<Entry> entries=Work.printAllEntries();
        assertEquals("""
                [Id: 1
                Title: First Day in Semicolon
                Body: The story goes thus...
                , Id: 2
                Title: Who is Suppose to Serve Breakfast
                Body: The story goes thus...
                ]""", entries.toString());
    }

    @Test
    void diaryCanPrintAllEntriesTest2() {
        Work.addEntry(FirstDay);
        Work.addEntry(Breakfast);
        System.out.println(Work.printAllEntries());
    }

}
