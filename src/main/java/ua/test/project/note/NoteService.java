package ua.test.project.note;

import org.springframework.stereotype.Service;
import ua.test.project.dao.DAOService;

import java.util.List;

@Service
public class NoteService implements DAOService<Note> {
    @Override
    public List<Note> listAll() {
        return null;
    }

    @Override
    public Note add(Note element) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void update(Note element) {

    }

    @Override
    public Note getById(long id) {
        return null;
    }
}
