package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @Test
    void findAll() {
        //given
        Visit visit = new Visit();
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        given(visitRepository.findAll()).willReturn(visits);

        //when
        Set<Visit> foundVisits = service.findAll();

        //then
        then(visitRepository).should().findAll();
        assertThat(foundVisits).hasSize(1);

    }

    @Test
    void findById() {
        //given
        Visit visit = new Visit();
        given(visitRepository.findById(1L)).willReturn(Optional.of(visit));

        //when
        Visit foundVisit = service.findById(1L);

        //then
        then(visitRepository).should().findById(anyLong());
        assertThat(foundVisit).isNotNull();
    }

    @Test
    void save() {
        //given
        Visit object = new Visit();
        given(visitRepository.save(any(Visit.class))).willReturn(object);

        //when
        Visit foundVisit = service.save(object);

        //then
        then(visitRepository).should().save(any(Visit.class));
        assertThat(foundVisit).isNotNull();
    }

    @Test
    void delete() {
        //given
        Visit object = new Visit();

        //when
        service.delete(object);

        //then
        then(visitRepository).should().delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        //given - none

        //when
        service.deleteById(1L);

        //then
        then(visitRepository).should().deleteById(anyLong());
    }

}