package ua.test.project.note;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = NoteService.class)
class NoteServiceTest {
    @Autowired
    private NoteService noteService;

    @Test
    void addNullNoteTest() {
        assertThrows(NullPointerException.class,
                () -> noteService.add(null));
    }

    @Test
    void addEmptyNoteTest() {
        assertThrows(NullPointerException.class,
                () -> noteService.add(new Note()));
    }

    @Test
    void addNoteWithEmptyTitleTest() {
        Note note = new Note();
        note.setContent("content");
        assertThrows(NullPointerException.class,
                () -> noteService.add(note));
    }

    @Test
    void addNoteWithEmptyContentTest() {
        Note note = new Note();
        note.setTitle("title");
        assertThrows(NullPointerException.class,
                () -> noteService.add(note));
    }

    @Test
    void addNoteTest() {
        int size = noteService.listAll().size();
        noteService.add(createValidNote());
        assertEquals(size + 1, noteService.listAll().size());
    }

    @Test
    void deleteByInvalidIdTest() {
        assertThrows(NullPointerException.class,
                () -> noteService.deleteById(-1L));
    }

    @Test
    void deleteByNotExistingIdTest() {
        assertThrows(NullPointerException.class,
                () -> noteService.deleteById(666L));
    }

    @Test
    void deleteByIdTest() {
        Note test = noteService.add(createValidNote());
        assertDoesNotThrow(() -> noteService.deleteById(test.getId()));
    }

    @Test
    void updateNullNoteTest() {
        assertThrows(NullPointerException.class,
                () -> noteService.update(null));
    }

    @Test
    void updateEmptyNoteTest() {
        assertThrows(NullPointerException.class,
                () -> noteService.update(new Note()));
    }

    @Test
    void updateTest() {
        Note expected = noteService.add(createValidNote());
        expected.setTitle("some title");
        expected.setTitle("some content");
        noteService.update(expected);
        assertEquals(expected, noteService.getById(expected.getId()));
    }

    @Test
    void getByInvalidIdTest() {
        assertThrows(NullPointerException.class, () -> noteService.getById(-1L));
    }

    @Test
    void getByIdTest() {
        Note expected = noteService.add(createValidNote());
        assertEquals(expected, noteService.getById(expected.getId()));
    }

    Note createValidNote() {
        Note note = new Note();
        note.setTitle("title");
        note.setContent("content");
        return note;
    }
}