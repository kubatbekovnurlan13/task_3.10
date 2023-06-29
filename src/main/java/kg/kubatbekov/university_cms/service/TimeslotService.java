package kg.kubatbekov.university_cms.service;

import kg.kubatbekov.university_cms.model.Timeslot;
import kg.kubatbekov.university_cms.repository.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TimeslotService {
    private final TimeslotRepository timeslotRepository;

    @Autowired
    public TimeslotService(TimeslotRepository timeslotRepository) {
        this.timeslotRepository = timeslotRepository;
    }

    public List<Timeslot> findAll() {
        return timeslotRepository.findAll();
    }
}
