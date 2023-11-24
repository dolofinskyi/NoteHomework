package ua.test.project.note;

import org.springframework.stereotype.Service;
import ua.test.project.crud.CRUDService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class NoteService implements CRUDService<Note> {
    private final List<Note> notes = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public List<Note> listAll() {
        return notes;
    }

    @Override
    public Note add(Note element) {
        Objects.requireNonNull(element, "Note can not be a null");
        Objects.requireNonNull(element.getTitle(), "Note title can not be a null");
        Objects.requireNonNull(element.getContent(), "Note content can not be a null");
        element.setId(createRandomId());
        notes.add(element);
        return element;
    }

    @Override
    public void deleteById(long id) {
       notes.remove(getById(id));
    }

    @Override
    public void update(Note element) {
        Note edited = getById(element.getId());
        edited.setTitle(element.getTitle());
        edited.setContent(element.getContent());
    }

    @Override
    public Note getById(long id) {
        for (Note note: notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        throw new NullPointerException("Note does not exist");
    }

    private long createRandomId() {
        // there is a chance to reach end of all possible random values
        long randId = random.nextLong(0, Long.MAX_VALUE);

        try {
            getById(randId);
            return createRandomId();
        } catch (NullPointerException e) {
            return randId;
        }
    }
}
