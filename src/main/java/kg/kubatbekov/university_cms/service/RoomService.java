package kg.kubatbekov.university_cms.service;

import kg.kubatbekov.university_cms.model.Room;
import kg.kubatbekov.university_cms.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
